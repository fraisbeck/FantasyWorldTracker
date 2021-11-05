package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Continents.
 */
@Entity(name = "Continent")
@Table(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "idcontinents")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private World worldId;

    /**
     * Instantiates a new Continents.
     */
    public Continent() {
    }

    /**
     * Instantiates a new Continents.
     *
     * @param id      the id
     * @param name    the name
     * @param worldId the world id
     */
    public Continent(int id, String name, World worldId) {
        this.id = id;
        this.name = name;
        this.worldId = worldId;
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

    /**
     * Gets world id.
     *
     * @return the world id
     */
    public World getWorldId() {
        return worldId;
    }

    /**
     * Sets world id.
     *
     * @param worldId the world id
     */
    public void setWorldId(World worldId) {
        this.worldId = worldId;
    }

    @Override
    public String toString() {
        return "Continents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", worldId=" + worldId +
                '}';
    }
}
