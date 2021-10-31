package worldbuilder.entity;

/**
 * The type Inventories.
 */
public class Inventories {

    private int id;
    private int shopId;
    private int itemId;
    private int quantity;
    private int price;

    /**
     * Instantiates a new Inventories.
     */
    public Inventories() {
    }

    /**
     * Instantiates a new Inventories.
     *
     * @param id       the id
     * @param shopId   the shop id
     * @param itemId   the item id
     * @param quantity the quantity
     * @param price    the price
     */
    public Inventories(int id, int shopId, int itemId, int quantity, int price) {
        this.id = id;
        this.shopId = shopId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
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
     * Gets shop id.
     *
     * @return the shop id
     */
    public int getShopId() {
        return shopId;
    }

    /**
     * Sets shop id.
     *
     * @param shopId the shop id
     */
    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    /**
     * Gets item id.
     *
     * @return the item id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets item id.
     *
     * @param itemId the item id
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Inventories{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
