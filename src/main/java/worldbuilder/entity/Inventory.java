package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Inventories.
 */
@Entity(name = "Inventory")
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "idinventories")
    private int id;

    @Column(name = "shopsid")
    private int shopId;

    @ManyToOne
    private Item itemId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    /**
     * Instantiates a new Inventories.
     */
    public Inventory() {
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
    public Inventory(int id, int shopId, Item itemId, int quantity, int price) {
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
    public Item getItemId() {
        return itemId;
    }

    /**
     * Sets item id.
     *
     * @param itemId the item id
     */
    public void setItemId(Item itemId) {
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
