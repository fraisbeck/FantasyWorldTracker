package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoriesDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;
    GenericDao shopDao;
    GenericDao itemDao;

    /**
     * Creating the dao
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Inventory.class);
        shopDao = new GenericDao(Shop.class);
        itemDao = new GenericDao(Item.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * gets all success.
     */
    @Test
    void getAllSuccess () {
        List<Inventory> inventories = (List<Inventory>) dao.getAll();
        assertEquals(19, inventories.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess () {
        Inventory retrievedInventory = (Inventory) dao.getById(8);
        assertNotNull(retrievedInventory);
        Shop expectedShop = (Shop) shopDao.getById(2);
        assertEquals(expectedShop , retrievedInventory.getShop());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        Shop newShop = (Shop) shopDao.getById(2);
        Item newItem = (Item) itemDao.getById(2);
        Inventory newInventory = new Inventory(newShop, newItem, 3, 375);
        int id = dao.insert(newInventory);
        assertNotEquals(0, id);
        Inventory insertedInventory = (Inventory) dao.getById(id);
        newInventory.equals(insertedInventory);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(12));
        assertNull(dao.getById(12));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess () {
        Shop newShop = (Shop) shopDao.getById(9);
        Inventory inventoryToUpdate = (Inventory) dao.getById(11);
        inventoryToUpdate.setShop(newShop);
        dao.saveOrUpdate(inventoryToUpdate);
        Inventory retrievedInventory = (Inventory) dao.getById(11);
        assertEquals(inventoryToUpdate, retrievedInventory);
    }
}
