package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Shops.
 */
@Entity(name = "Shop")
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "shopcategory")
    private String shopCategory;
    @ManyToOne
    @JoinColumn(name = "location_id", foreignKey = @ForeignKey(name = "location_id"))
    private Location location;
    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "owner_id"))
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "world_id", foreignKey = @ForeignKey(name = "world_id_shops"))
    private World world;

    /**
     * Instantiates a new Shops.
     */
    public Shop() {
    }

    /**
     * Instantiates a new Shops.
     *
     * @param id           the id
     * @param name         the name
     * @param shopCategory the shop category
     * @param location     the location id
     * @param owner        the owner id
     * @param world        the world id
     */
    public Shop(int id, String name, String shopCategory, Location location, Owner owner, World world) {
        this.id = id;
        this.name = name;
        this.shopCategory = shopCategory;
        this.location = location;
        this.owner = owner;
        this.world = world;
    }

    /**
     * Instantiates a new Shop.
     *
     * @param name         the name
     * @param shopCategory the shop category
     * @param location     the location
     * @param owner        the owner
     * @param world        the world id
     */
    public Shop(String name, String shopCategory, Location location, Owner owner, World world) {
        this.name = name;
        this.shopCategory = shopCategory;
        this.location = location;
        this.owner = owner;
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
     * Gets shop category.
     *
     * @return the shop category
     */
    public String getShopCategory() {
        return shopCategory;
    }

    /**
     * Sets shop category.
     *
     * @param shopCategory the shop category
     */
    public void setShopCategory(String shopCategory) {
        this.shopCategory = shopCategory;
    }

    /**
     * Gets location id.
     *
     * @return the location id
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets location id.
     *
     * @param location the location id
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets owner id.
     *
     * @return the owner id
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Sets owner id.
     *
     * @param owner the owner id
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shopCategory='" + shopCategory + '\'' +
                ", location=" + location +
                ", owner=" + owner +
                ", world=" + world +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id == shop.id && name.equals(shop.name) && shopCategory.equals(shop.shopCategory) && location.equals(shop.location) && owner.equals(shop.owner) && world.equals(shop.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shopCategory, location, owner, world);
    }
}
