package worldbuilder.persistance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public GenericDao(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();

        logger.debug("The list of entities " + list);
        session.close();

        return list;
    }

    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        logger.debug("Searching for: {}", entity);
        session.close();
        return entity;
    }

    public void delete (T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        logger.debug("Entity to delete: " + entity);
        session.close();
    }

    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        logger.debug("Saved or updated: " + entity);
        session.close();
    }

    public int insert (T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        logger.debug("Inserted Entity Id: " + id);
        session.close();
        return id;
    }

    public List<T> getByIdentifierEqual(String identifier, String searchTerm) {
        logger.debug("Searching for entity with " + identifier + " = " + searchTerm);
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(identifier);
        query.where(builder.equal(propertyPath, searchTerm));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public List<T> getByIdentifierIntEqual(String identifier, int searchId) {
        logger.debug("Searching for entity with " + identifier + " = " + searchId);
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(identifier);
        query.where(builder.equal(propertyPath, searchId));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public List<T> getByIdentifierLike(String identifier, String searchTerm) {
        logger.debug("Searching for entity with " + identifier + " like " + searchTerm);
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(identifier);
        query.where(builder.like(propertyPath, "%" + searchTerm + "%"));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }
}
