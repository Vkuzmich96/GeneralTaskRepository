package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.utils.MySQLConnection;
import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDAOMySqlTest {
    private UserDAOMySql dao = new UserDAOMySql(MySQLConnection.getConnection());
    private User user = new User(11,"11", "password", Role.USER,"11","1",11);

    private User findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int sizeBefore = dao.selectAll().size();
        dao.insert(user);
        int sizeAfter = dao.selectAll().size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    public void selectAll() throws SQLException {
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws SQLException {
        int id = findFirst().getId();
        User user = dao.select(id);
        assertEquals(id, user.getId());
    }

    @Test(expected = SQLException.class)
    public void delete() throws SQLException {
        int id  = findFirst().getId();
        dao.delete(id);
        dao.select(id);
    }

    @Test
    public void updateEmail() throws SQLException {
        int id  = findFirst().getId();
        dao.updateEmail("just a test", id);
        User user = dao.select(id);
        assertEquals("just a test", user.getEmail());
    }

    @Test
    public void updatePassword() throws SQLException {
        int id  = findFirst().getId();
        dao.updatePassword("just a test", id);
        User user = dao.select(id);
        assertEquals("just a test", user.getPassword());
    }

    //todo найти почему не работает
    @Ignore
    @Test
    public void updateRole() throws SQLException {
        int id  = findFirst().getId();
        dao.updateRole(3, id);
        User user = dao.select(id);
        assertEquals(3, user.getRole().getNumber());
    }


    @Test
    public void updateName() throws SQLException {
        int id  = findFirst().getId();
        dao.updateName("just a test", id);
        User user = dao.select(id);
        assertEquals("just a test", user.getName());
    }

    @Test
    public void updateAddress() throws SQLException {
        int id  = findFirst().getId();
        dao.updateAddress("just a test", id);
        User user = dao.select(id);
        assertEquals("just a test", user.getAddress());
    }

    @Test
    public void updatePhone() throws SQLException {
        int id  = findFirst().getId();
        dao.updatePhone(123456L, id);
        User user = dao.select(id);
        assertEquals(123456L, user.getNumber());
    }
}