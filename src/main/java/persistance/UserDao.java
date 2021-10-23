package persistance;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();

        logger.debug("The list of users " + users);
        session.close();

        return users;
    }

    /**
     * Gets users by username.
     *
     * @param userName the username
     * @return the users by username
     */
    public List<User> getUsersByUserName(String userName) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<String> propertyPath = root.get("userName");
        query.where(builder.like(propertyPath, "%" + userName + "%"));
        List<User> users = session.createQuery(query).getResultList();

        logger.debug("Searching for: {}",  users);
        session.close();

        return users;
    }

    /**
     * Gets a user by id.
     *
     * @param id the id to search by
     * @return the user
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        logger.debug("Searching for: {}", user);
        session.close();
        return user;
    }

    /**
     * Save or update a user.
     *
     * @param user the user to be inserted or updated
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        logger.debug("Saved or updated: ", user);
        session.close();
    }

    /**
     * update user.
     *
     * @param user the user to be inserted or updated
     * @return the id of the inserted user
     */
    public int insert (User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        logger.debug("Inserted User Id: ", id);
        session.close();
        return id;
    }

    /**
     * Delete a user.
     *
     * @param user the user to be deleted
     */
    public void delete (User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        logger.debug("Author to delete: ", user);
        session.close();
    }
}
