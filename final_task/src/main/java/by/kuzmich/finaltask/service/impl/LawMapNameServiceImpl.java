package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.LawMapNameService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class LawMapNameServiceImpl implements LawMapNameService {
    private DAO<LawMapName, LawMapName> dao;
    private DAO<LawMapName, LawMapName> nameDAOSelectByName;
    private final boolean MAP_IS_READY_FLAG = true;

    public LawMapNameServiceImpl(DAO<LawMapName, LawMapName> dao, DAO<LawMapName, LawMapName> nameDAOSelectByName) {
        this.dao = dao;
        this.nameDAOSelectByName = nameDAOSelectByName;
    }

    public boolean isNameFree (String name) throws ServiceException {
        try {
            return nameDAOSelectByName.select(name).getId() == 0;
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    public List<LawMapName> getAll() throws ServiceException {
        try {
            return dao.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    public int add (LawMapName name) throws ServiceException {
        try {
            return dao.insert(name);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    @Override
    public void delete(int key) throws ServiceException {
        try {
            dao.delete(key);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    @Override
    public void realise(String key) throws ServiceException {
        try {
            LawMapName name = dao.select(key);
            name.setReadiness(MAP_IS_READY_FLAG);
            dao.update(name);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }
}
