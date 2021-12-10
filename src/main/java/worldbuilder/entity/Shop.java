package worldbuilder.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Shops.
 */
@Entity(name = "Shop")
@Table(name = "shops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
