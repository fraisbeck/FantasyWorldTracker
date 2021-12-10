package worldbuilder.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Inventories.
 */
@Entity(name = "Inventory")
@Table(name = "inventories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
