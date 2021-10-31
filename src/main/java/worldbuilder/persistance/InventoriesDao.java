package worldbuilder.persistance;

import worldbuilder.entity.Inventories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Inventories dao.
 */
public class InventoriesDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all.
     *
     * @return all items in inventories
     */
    public List<Inventories> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Inventories> query = builder.createQuery(Inventories.class);
        Root<Inventories> root = query.from(Inventories.class);
        List<Inventories> inventories = session.createQuery(query).getResultList();
        logger.debug("The list of inventories", inventories);
        session.close();
        return inventories;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the inventory by id
     */
    public Inventories getById(int id) {
        Session session = sessionFactory.openSession();
        Inventories inventories = session.get(Inventories.class, id);
        logger.debug("The inventory item by id: ", id);
        session.close();
        return inventories;
    }

    /**
     * Save or update.
     *
     * @param inventories the inventories to be saved or updated
     */
    public void saveOrUpdate(Inventories inventories) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(inventories);
        transaction.commit();
        session.close();
    }

    /**
     * Insert into the inventories table.
     *
     * @param inventories the inventories
     * @return the id of the added inventory
     */
    public int insert(Inventories inventories) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(inventories);
        transaction.commit();
        logger.debug("Inventory to be added: ", inventories);
        session.close();
        return id;
    }

    /**
     * Delete.
     *
     * @param inventories the inventories to be deleted
     */
    public void delete(Inventories inventories) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(inventories);
        transaction.commit();
        logger.debug("Inventory to be deleted: ", inventories);
        session.close();
    }

    /**
     * Gets by shop id.
     *
     * @param id the id of the shop in relation
     * @return the by shop id inventories
     */
    public List<Inventories> getByShopId(int id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Inventories> query = builder.createQuery(Inventories.class);
        Root<Inventories> root = query.from(Inventories.class);
        List<Inventories> inventories = session.createQuery(query).getResultList();
        logger.debug("List of inventory in shop id: " + id);
        session.close();
        return inventories;
    }

}
