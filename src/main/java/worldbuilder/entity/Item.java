package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Items.
 */
@Entity(name = "Item")
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "iditems")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "itemcategory")
    private String category;

    /**
     * Instantiates a new Items.
     */
    public Item() {
    }

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
     * Gets rarity.
     *
     * @return the rarity
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * Sets rarity.
     *
     * @param rarity the rarity
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
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
}
