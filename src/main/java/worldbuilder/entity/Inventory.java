package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Inventories.
 */
@Entity(name = "Inventory")
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "shop_id", foreignKey = @ForeignKey(name = "shop_id"))
    private Shop shop;
    @ManyToOne
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "item_id"))
    private Item item;
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
     * @param shop     the shop id
     * @param item     the item id
     * @param quantity the quantity
     * @param price    the price
     */
    public Inventory(int id, Shop shop, Item item, int quantity, int price) {
        this.id = id;
        this.shop = shop;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Instantiates a new Inventory.
     *
     * @param shop     the shop
     * @param item     the item
     * @param quantity the quantity
     * @param price    the price
     */
    public Inventory(Shop shop, Item item, int quantity, int price) {
        this.shop = shop;
        this.item = item;
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
    public Shop getShop() {
        return shop;
    }

    /**
     * Sets shop id.
     *
     * @param shop the shop id
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /**
     * Gets item id.
     *
     * @return the item id
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets item id.
     *
     * @param item the item id
     */
    public void setItem(Item item) {
        this.item = item;
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
                ", shopId=" + shop +
                ", itemId=" + item +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return id == inventory.id && quantity == inventory.quantity && price == inventory.price && shop.equals(inventory.shop) && item.equals(inventory.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shop, item, quantity, price);
    }
}
