package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.dao.DAOMySQL;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LawMapNameSelectByNameDAOMySql extends LawMapNameDAOMySql {
    private static Logger logger = Logger.getLogger(LawMapNameSelectByNameDAOMySql.class);

    private static final String SELECT = "SELECT * FROM lawmapsdb.law_map_name WHERE name = ?";
    public LawMapNameSelectByNameDAOMySql(Connection connection) {
        super(connection);
    }

    @Override
    public LawMapName select(String str) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setString(1, str);
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
}
