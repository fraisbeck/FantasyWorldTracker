package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Continents.
 */
@Entity(name = "Continent")
@Table(name = "continents")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "world_id", foreignKey = @ForeignKey(name = "world_id"))
    private World world;

    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Region> continentalRegions = new HashSet<>();

    /**
     * Instantiates a new Continents.
     */
    public Continent() {
    }

    /**
     * Instantiates a new Continents.
     *
     * @param id    the id
     * @param name  the name
     * @param world the world id
     */
    public Continent(int id, String name, World world) {
        this.id = id;
        this.name = name;
        this.world = world;
    }

    /**
     * Instantiates a new Continent.
     *
     * @param name  the name
     * @param world the world
     */
    public Continent(String name, World world) {
        this.name = name;
        this.world = world;
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
    public World getWorld() {
        return world;
    }

    /**
     * Sets world id.
     *
     * @param world the world id
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     * Gets continental regions.
     *
     * @return the continental regions
     */
    public Set<Region> getContinentalRegions() {
        return continentalRegions;
    }

    /**
     * Sets continental regions.
     *
     * @param continentalRegions the continental regions
     */
    public void setContinentalRegions(Set<Region> continentalRegions) {
        this.continentalRegions = continentalRegions;
    }

    /**
     * Add region.
     *
     * @param region the region
     */
    public void addRegion (Region region) {
        continentalRegions.add(region);
        region.setContinent(this);
    }

    /**
     * Remove region.
     *
     * @param region the region
     */
    public void removeRegion (Region region) {
        continentalRegions.remove(region);
        region.setContinent(null);
    }

    @Override
    public String toString() {
        return "Continents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", worldId=" + world +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return id == continent.id && name.equals(continent.name) && world.equals(continent.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, world);
    }
}
