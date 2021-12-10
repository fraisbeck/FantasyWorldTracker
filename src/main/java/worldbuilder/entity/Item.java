package worldbuilder.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Items.
 */
@Entity(name = "Item")
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "rarity")
    private String rarity;
    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Inventory> inventoriesContainingItem = new HashSet<>();

    /**
     * Instantiates a new Items.
     *
     * @param id       the id
     * @param name     the name
     * @param rarity   the rarity
     * @param category the category
     */
    public Item(int id, String name, String rarity, String category) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.category = category;
    }

    /**
     * Instantiates a new Item.
     *
     * @param name     the name
     * @param rarity   the rarity
     * @param category the category
     */
    public Item(String name, String rarity, String category) {
        this.name = name;
        this.rarity = rarity;
        this.category = category;
    }


    /**
     * Add inventory.
     *
     * @param inventory the inventory
     */
    public void addInventory (Inventory inventory) {
        inventoriesContainingItem.add(inventory);
        inventory.setItem(this);
    }

    /**
     * Remove inventory.
     *
     * @param inventory the inventory
     */
    public void removeInventory (Inventory inventory) {
        inventoriesContainingItem.remove(inventory);
        inventory.setItem(this);
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rarity='" + rarity + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && name.equals(item.name) && rarity.equals(item.rarity) && category.equals(item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rarity, category);
    }
}
