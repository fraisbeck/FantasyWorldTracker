package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    GenericDao dao;

    /**
     * Creating the dao
     */
    @BeforeEach
     void setUp() {
        dao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");


    }

    @Test
    void getAllSuccess () {
        List<User> users = (List<User>) dao.getAll();
        assertEquals(3, users.size());
    }

    @Test
    void getByIdSuccess () {
        User retrievedUser = (User) dao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Katie", retrievedUser.getFirstName());
    }

    @Test
    void insertSuccess() {
        User newUser = new User(4,"Frank", "Raisbeck", "fraisbeck", "password");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User) dao.getById(id);
        newUser.equals(insertedUser);
    }

    @Test
     void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    @Test
    void updateSuccess () {
        String newLastName = "Raisbeck";
        User userToUpdate = (User) dao.getById(2);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) dao.getById(2);
        assertEquals(userToUpdate, retrievedUser);
    }
}
