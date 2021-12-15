package worldbuilder.persistance;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.Root;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.List;

public class ItemDao<T> {
    private Class<T> type;
    ObjectMapper mapper = new ObjectMapper();
    Client client = ClientBuilder.newClient();
    private final Logger logger = LogManager.getLogger(this.getClass());
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }


}
