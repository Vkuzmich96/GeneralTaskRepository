package by.kuzmich.finaltask.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import by.kuzmich.finaltask.exception.DAOException;
import org.apache.log4j.Logger;

final public class ConnectionPool {
	private static Logger logger = Logger.getLogger(ConnectionPool.class);

	private String url;
	private String user;
	private String password;
	private int maxSize;
	private int checkConnectionTimeout;

	private ReentrantLock locker = new ReentrantLock();
	private BlockingQueue<WrapedConnection> freeConnections = new LinkedBlockingQueue<>();
	private Set<WrapedConnection> usedConnections = new ConcurrentSkipListSet<>();

	private ConnectionPool() {
			Settings settings = new Settings();
			try {
				destroy();
				Class.forName(settings.DB_DRIVER_CLASS);
				this.url = settings.DB_URL;
				this.user = settings.DB_USER;
				this.password = settings.DB_PASSWORD;
				this.maxSize = settings.DB_POOL_MAX_SIZE;
				this.checkConnectionTimeout = settings.DB_POOL_CHECK_CONNECTION_TIMEOUT;
				for (int counter = 0; counter < settings.DB_POOL_START_SIZE; counter++) {
					freeConnections.put(createConnection());
				}
			} catch (ClassNotFoundException | SQLException | InterruptedException e) {
				logger.fatal("It is impossible to initialize connection pool", e);
			}
	}

	public Connection getConnection() throws DAOException {
		locker.lock();
		WrapedConnection connection = null;
		while(connection == null) {
			try {
				if(!freeConnections.isEmpty()) {
					connection = freeConnections.take();
					if(!connection.isValid(checkConnectionTimeout)) {
						try {
							connection.getConnection().close();
						} catch(SQLException e) {}
						connection = null;
					}
				} else if(usedConnections.size() < maxSize) {
					connection = createConnection();
				} else {
					logger.error("The limit of number of database connections is exceeded");
					throw new DAOException();
				}
				usedConnections.add(connection);
				logger.debug(String.format("Connection was received from pool. Current pool size: %d used connections; %d free connection", usedConnections.size(), freeConnections.size()));
			} catch(InterruptedException | SQLException e) {
				logger.error("It is impossible to connect to a database", e);
				throw new DAOException(e);
			}
			finally {
				locker.unlock();
			}
		}
		return connection;
	}

	void freeConnection(WrapedConnection connection) {
		locker.lock();
		try {
			if(connection.isValid(checkConnectionTimeout)) {
				connection.clearWarnings();
				connection.setAutoCommit(true);
				usedConnections.remove(connection);
				freeConnections.put(connection);
				logger.debug(String.format("Connection was returned into pool. Current pool size: %d used connections; %d free connection", usedConnections.size(), freeConnections.size()));
			}
		} catch(SQLException | InterruptedException e1) {
			logger.warn("It is impossible to return database connection into pool", e1);
			try {
				connection.getConnection().close();
			} catch(SQLException e2) {}
		} finally {
			locker.unlock();

		}
	}

	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getInstance() {
		return instance;
	}

	private WrapedConnection createConnection() throws SQLException {
		return new WrapedConnection(DriverManager.getConnection(url, user, password));
	}

	public void destroy() {
		locker.lock();
		usedConnections.addAll(freeConnections);
		freeConnections.clear();
		for(WrapedConnection connection : usedConnections) {
			try {
				connection.getConnection().close();
			} catch(SQLException e) {}
		}
		usedConnections.clear();
		locker.unlock();
	}

	@Override
	protected void finalize() throws Throwable {
		destroy();
	}
}
