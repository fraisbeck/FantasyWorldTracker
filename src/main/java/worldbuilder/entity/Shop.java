package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Shops.
 */
@Entity(name = "Shop")
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "idshops")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "shopcategory")
    private String shopCategory;

    @ManyToOne
    private Location locationId;

    @ManyToOne
    private Owner ownerId;

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
     * @param locationId   the location id
     * @param ownerId      the owner id
     */
    public Shop(int id, String name, String shopCategory, Location locationId, Owner ownerId) {
        this.id = id;
        this.name = name;
        this.shopCategory = shopCategory;
        this.locationId = locationId;
        this.ownerId = ownerId;
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
    public Location getLocationId() {
        return locationId;
    }

    /**
     * Sets location id.
     *
     * @param locationId the location id
     */
    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    /**
     * Gets owner id.
     *
     * @return the owner id
     */
    public Owner getOwnerId() {
        return ownerId;
    }

    /**
     * Sets owner id.
     *
     * @param ownerId the owner id
     */
    public void setOwnerId(Owner ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Shops{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shopCategory='" + shopCategory + '\'' +
                ", locationId=" + locationId +
                ", ownerId=" + ownerId +
                '}';
    }
}
