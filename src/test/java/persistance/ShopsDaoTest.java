package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopsDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;
    GenericDao locationDao;
    GenericDao ownerDao;

    /**
     * Creating the dao
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Shop.class);
        locationDao = new GenericDao(Location.class);
        ownerDao = new GenericDao(Owner.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * gets all success.
     */
    @Test
    void getAllSuccess () {
        List<Shop> shops = (List<Shop>) dao.getAll();
        assertEquals(12, shops.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess () {
        Shop retrievedShop = (Shop) dao.getById(7);
        assertNotNull(retrievedShop);
        assertEquals("Patches and Buttons", retrievedShop.getName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        Location newLocation = (Location) locationDao.getById(7);
        Owner newOwner = (Owner) ownerDao.getById(4);
        Shop newShop = new Shop("New Shop Name", "Tailor", newLocation, newOwner);
        int id = dao.insert(newShop);
        assertNotEquals(0, id);
        Shop insertedShop = (Shop) dao.getById(id);
        newShop.equals(insertedShop);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(10));
        assertNull(dao.getById(10));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess () {
        String newName = "New Name of Shop";
        Shop shopToUpdate = (Shop) dao.getById(6);
        shopToUpdate.setName(newName);
        dao.saveOrUpdate(shopToUpdate);
        Shop retrievedShop = (Shop) dao.getById(6);
        assertEquals(shopToUpdate, retrievedShop);
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Shop> shops = dao.getByIdentifierEqual("shopCategory", "Armory");
        assertEquals(3, shops.size());
        assertEquals(11, shops.get(2).getId());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Shop> shops = dao.getByIdentifierLike("shopCategory", "ry");
        assertEquals(6, shops.size());
    }
}
