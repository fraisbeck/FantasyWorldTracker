package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Locations.
 */
@Entity(name = "Location")
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "idlocations")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Region region;

    /**
     * Instantiates a new Locations.
     */
    public Location() {
    }

    /**
     * Instantiates a new Locations.
     *
     * @param id     the id
     * @param name   the name
     * @param region the region
     */
    public Location(int id, String name, Region region) {
        this.id = id;
        this.name = name;
        this.region = region;
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
     * Gets region.
     *
     * @return the region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
