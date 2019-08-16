package by.kuzmich.finaltask.dao;

import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DAOMySQL <T, S> implements DAO <T, S>  {
    private static Logger logger = Logger.getLogger(DAOMySQL.class);
    protected Connection connection;
    private String INSERT;
    private String SELECT_ALL;
    private String SELECT_BY_ID;
    private String DELETE;
    private String UPDATE;
    protected final String ID = "id";
    protected final String NAME = "name";
    private final int EMPTY_RESULT_SET = 0;

    /**
     * Receives connection, and sql query statements.
     */
    public DAOMySQL(Connection connection, String INSERT, String SELECT_ALL, String SELECT_BY_ID, String DELETE, String UPDATE) {
        this.connection = connection;
        this.INSERT = INSERT;
        this.SELECT_ALL = SELECT_ALL;
        this.SELECT_BY_ID = SELECT_BY_ID;
        this.DELETE = DELETE;
        this.UPDATE = UPDATE;
    }

    /**
     * Inserts a generalized object in the data base
     */
    @Override
    public int insert(T object) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            prepareStatementInsert(statement, object);
            statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            if (set.next()) {
                return set.getInt(1);
            } else {
                return EMPTY_RESULT_SET;
            }
        } catch (SQLException e){
            throw new DAOException(ExceptionMessageList.UNABLE_TO_UPDATE, e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(ExceptionMessageList.UNABLE_TO_CLOSE);
            }
        }
    }

    /**
     * Selects all objects
     */
    @Override
    public List<T> selectAll() throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            return buildList(resultSet);
        } catch (SQLException e){
            throw new DAOException(ExceptionMessageList.UNABLE_TO_SELECT, e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(ExceptionMessageList.UNABLE_TO_CLOSE);
            }
        }
    }

    /**
     * selects an specific object by id
     */
    @Override
    public S select(String str) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, Integer.parseInt(str));
            ResultSet set = statement.executeQuery();
            return prepareSelectResult(set);
        } catch (SQLException e){
            throw new DAOException(ExceptionMessageList.UNABLE_TO_SELECT, e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(ExceptionMessageList.UNABLE_TO_CLOSE);
            }
        }
    }
    /**
     * deletes an specific object by id
     */
    @Override
    public void delete(int id) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e){
            throw new DAOException(ExceptionMessageList.UNABLE_TO_DELETE, e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(ExceptionMessageList.UNABLE_TO_CLOSE);
            }
        }
    }

    /**
     * updates an specific object by id
     */
    @Override
    public void update(T object) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            prepareStatementUpdate(statement, object);
            statement.execute();
        } catch (SQLException e){
            throw new DAOException(ExceptionMessageList.UNABLE_TO_UPDATE, e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(ExceptionMessageList.UNABLE_TO_CLOSE);
            }
        }
    }

    /**
     * Close a data base connection
     */
    @Override
    public void finalize() throws SQLException {
        connection.close();
    }

    protected abstract void prepareStatementInsert(PreparedStatement statement, T object)  throws SQLException;

    protected abstract void prepareStatementUpdate(PreparedStatement statement, T object)  throws SQLException;

    /**
     * Builds a list of objects
     */
    protected List<T> buildList (ResultSet set) throws SQLException{
        List<T> materials = new ArrayList<>();
        while (set.next()){
            T object = build(set);
            materials.add(object);
        }
        return materials;
    }

    /**
     * Builds an object with ResultSet data
     * */
    protected abstract T build(ResultSet set) throws SQLException;

    protected abstract S prepareSelectResult(ResultSet set) throws SQLException;

}
