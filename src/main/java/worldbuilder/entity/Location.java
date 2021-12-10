package worldbuilder.entity;

import lombok.*;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
