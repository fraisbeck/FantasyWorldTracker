package entity;

/**
 * The type Shops.
 */
public class Shops {

    private int id;
    private String name;
    private String shopCategory;
    private int locationId;
    private int ownerId;

    /**
     * Instantiates a new Shops.
     */
    public Shops() {
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
    public Shops(int id, String name, String shopCategory, int locationId, int ownerId) {
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
    public int getLocationId() {
        return locationId;
    }

    /**
     * Sets location id.
     *
     * @param locationId the location id
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * Gets owner id.
     *
     * @return the owner id
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Sets owner id.
     *
     * @param ownerId the owner id
     */
    public void setOwnerId(int ownerId) {
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
