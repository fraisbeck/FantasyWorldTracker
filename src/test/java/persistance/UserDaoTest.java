package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
public class UserDaoTest {

    /**
     * The Dao.
     */
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

    /**
     * gets all success.
     */
    @Test
    void getAllSuccess () {
        List<User> users = (List<User>) dao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess () {
        User retrievedUser = (User) dao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Katie", retrievedUser.getFirstName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Frank", "Raisbeck", "fraisbeck", "password");
        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        User insertedUser = (User) dao.getById(id);
        newUser.equals(insertedUser);
    }

    /**
     * Delete success.
     */
    @Test
     void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess () {
        String newLastName = "Raisbeck";
        User userToUpdate = (User) dao.getById(2);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) dao.getById(2);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Gets user by last name success.
     */
    @Test
    void getUserByLastNameSuccess() {
        List<User> users = (List<User>) dao.getByIdentifierEqual("lastName", "Scott");
        assertEquals(1, users.size());
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByIdentifierEqual("lastName", "Louise");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByIdentifierLike("firstName", "j");
        assertEquals(2, users.size());
    }
}
