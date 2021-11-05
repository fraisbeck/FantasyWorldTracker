package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Regions.
 */
@Entity(name = "Region")
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "idregions")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Continent continentId;

    /**
     * Instantiates a new Regions.
     */
    public Region() {
    }

    /**
     * Instantiates a new Regions.
     *
     * @param id          the id
     * @param name        the name
     * @param continentId the continent id
     */
    public Region(int id, String name, Continent continentId) {
        this.id = id;
        this.name = name;
        this.continentId = continentId;
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
     * Gets continent id.
     *
     * @return the continent id
     */
    public Continent getContinentId() {
        return continentId;
    }

    /**
     * Sets continent id.
     *
     * @param continentId the continent id
     */
    public void setContinentId(Continent continentId) {
        this.continentId = continentId;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continentId=" + continentId +
                '}';
    }
}
