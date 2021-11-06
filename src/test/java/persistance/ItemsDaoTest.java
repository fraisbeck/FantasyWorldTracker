package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Items dao test.
 */
public class ItemsDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;

    /**
     * Creating the dao
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Item.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * gets all success.
     */
    @Test
    void getAllSuccess () {
        List<Item> items = (List<Item>) dao.getAll();
        assertEquals(9, items.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess () {
        Item retrievedItem = (Item) dao.getById(6);
        assertNotNull(retrievedItem);
        assertEquals("Spike", retrievedItem.getName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        Item newItem = new Item("BattleAxe", "Uncommon", "Axe");
        int id = dao.insert(newItem);
        assertNotEquals(0, id);
        Item insertedItem = (Item) dao.getById(id);
        newItem.equals(insertedItem);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(4));
        assertNull(dao.getById(4));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess () {
        String newName = "BattleAxe + 2";
        Item itemToUpdate = (Item) dao.getById(2);
        itemToUpdate.setName(newName);
        dao.saveOrUpdate(itemToUpdate);
        Item retrievedItem = (Item) dao.getById(2);
        assertEquals(itemToUpdate, retrievedItem);
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Item> items = dao.getByIdentifierEqual("rarity", "Rare");
        assertEquals(2, items.size());
        assertEquals(3, items.get(1).getId());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Item> items = dao.getByIdentifierLike("category", "sword");
        assertEquals(3, items.size());
    }

}
