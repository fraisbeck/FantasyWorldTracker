package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Locations.
 */
@Entity(name = "Location")
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "region_id", foreignKey = @ForeignKey(name = "region_id"))
    private Region region;
    @ManyToOne
    @JoinColumn(name = "world_id", foreignKey = @ForeignKey(name = "world_id_location"))
    private World world;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Shop> shopsLocated = new HashSet<>();

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
     * @param world  the world id
     */
    public Location(int id, String name, Region region, World world) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.world = world;
    }

    /**
     * Instantiates a new Location.
     *
     * @param name   the name
     * @param region the region
     * @param world  the world id
     */
    public Location(String name, Region region, World world) {
        this.name = name;
        this.region = region;
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
     * Gets shops located.
     *
     * @return the shops located
     */
    public Set<Shop> getShopsLocated() {
        return shopsLocated;
    }

    /**
     * Sets shops located.
     *
     * @param shopsLocated the shops located
     */
    public void setShopsLocated(Set<Shop> shopsLocated) {
        this.shopsLocated = shopsLocated;
    }

    /**
     * Add shop.
     *
     * @param shop the shop
     */
    public void addShop (Shop shop) {
        shopsLocated.add(shop);
        shop.setLocation(this);
    }

    /**
     * Remove shop.
     *
     * @param shop the shop
     */
    public void removeShop (Shop shop) {
        shopsLocated.remove(shop);
        shop.setLocation(null);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region=" + region +
                ", world=" + world +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id && name.equals(location.name) && region.equals(location.region) && world.equals(location.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, region, world);
    }
}
