package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Worlds.
 */
@Entity(name = "World")
@Table(name = "worlds")
public class World {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "idworlds")
    private int id;

    @Column(name = "name")
    private String name;

    /**
     * Instantiates a new Worlds.
     */
    public World() {
    }

    /**
     * Instantiates a new Worlds.
     *
     * @param id   the id
     * @param name the name
     */
    public World(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Worlds{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
