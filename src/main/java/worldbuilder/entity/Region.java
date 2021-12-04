package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Regions.
 */
@Entity(name = "Region")
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "continent_id", foreignKey = @ForeignKey(name = "continent_id"))
    private Continent continent;
    @ManyToOne
    @JoinColumn(name = "world_id", foreignKey = @ForeignKey(name = "world_id_regions"))
    private World world;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Location> regionLocations = new HashSet<>();

    /**
     * Instantiates a new Regions.
     */
    public Region() {
    }

    /**
     * Instantiates a new Regions.
     *
     * @param id        the id
     * @param name      the name
     * @param continent continent id
     * @param world     the world id
     */
    public Region(int id, String name, Continent continent, World world) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.world = world;
    }

    /**
     * Instantiates a new Region.
     *
     * @param name      the name
     * @param continent the continent
     * @param world     the world id
     */
    public Region(String name, Continent continent, World world) {
        this.name = name;
        this.continent = continent;
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
     * Gets continent id.
     *
     * @return the continent id
     */
    public Continent getContinent() {
        return continent;
    }

    /**
     * Sets continent id.
     *
     * @param continent the continent id
     */
    public void setContinent(Continent continent) {
        this.continent = continent;
    }


    /**
     * Gets world.
     *
     * @return the world
     */
    public World getWorld() {
        return world;
    }

    /**
     * Sets world.
     *
     * @param world the world
     */
    public void setWorld(World world) {
        this.world = world;
    }


    /**
     * Gets region locations.
     *
     * @return the region locations
     */
    public Set<Location> getRegionLocations() {
        return regionLocations;
    }

    /**
     * Sets region locations.
     *
     * @param regionLocations the region locations
     */
    public void setRegionLocations(Set<Location> regionLocations) {
        this.regionLocations = regionLocations;
    }

    /**
     * Add location.
     *
     * @param location the location
     */
    public void addLocation (Location location) {
        regionLocations.add(location);
        location.setRegion(this);
    }

    /**
     * Remove location.
     *
     * @param location the location
     */
    public void removeLocation (Location location) {
        regionLocations.remove(location);
        location.setRegion(null);
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                ", world=" + world +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return id == region.id && name.equals(region.name) && continent.equals(region.continent) && world.equals(region.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, continent, world);
    }
}
