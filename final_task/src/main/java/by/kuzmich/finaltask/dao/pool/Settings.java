package by.kuzmich.finaltask.dao.pool;

final public class Settings {
    public final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public final String DB_URL = "jdbc:mysql://localhost/lawmapsdb?useLegacyDatetimeCode=false&serverTimezone=UTC";
    public final String DB_USER = "root";
    public final String DB_PASSWORD = "root";
    public final int DB_POOL_START_SIZE = 10;
    public final int DB_POOL_MAX_SIZE = 1000;
    public final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;
}
