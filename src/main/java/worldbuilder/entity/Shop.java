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
     */
    public Shop(int id, String name, String shopCategory, Location location, Owner owner) {
        this.id = id;
        this.name = name;
        this.shopCategory = shopCategory;
        this.location = location;
        this.owner = owner;
    }

    /**
     * Instantiates a new Shop.
     *
     * @param name         the name
     * @param shopCategory the shop category
     * @param location     the location
     * @param owner        the owner
     */
    public Shop(String name, String shopCategory, Location location, Owner owner) {
        this.name = name;
        this.shopCategory = shopCategory;
        this.location = location;
        this.owner = owner;
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

    @Override
    public String toString() {
        return "Shops{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shopCategory='" + shopCategory + '\'' +
                ", locationId=" + location +
                ", ownerId=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id == shop.id && Objects.equals(name, shop.name) && Objects.equals(shopCategory, shop.shopCategory) && Objects.equals(location, shop.location) && Objects.equals(owner, shop.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shopCategory, location, owner);
    }
}
