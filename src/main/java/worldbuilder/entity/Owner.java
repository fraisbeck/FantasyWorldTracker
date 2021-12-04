package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Owners.
 */
@Entity(name = "Owner")
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "profession")
    private String profession;
    @ManyToOne
    @JoinColumn(name = "world_id", foreignKey = @ForeignKey(name = "world_id_owner"))
    private World world;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Shop> shopsOwned = new HashSet<>();

    /**
     * Instantiates a new Owners.
     */
    public Owner() {
    }

    /**
     * Instantiates a new Owners.
     *
     * @param id         the id
     * @param firstName  the first name
     * @param lastName   the last name
     * @param profession the profession
     * @param world      the world
     */
    public Owner(int id, String firstName, String lastName, String profession, World world) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.world = world;
    }

    /**
     * Instantiates a new Owner.
     *
     * @param firstName  the first name
     * @param lastName   the last name
     * @param profession the profession
     * @param world      the world
     */
    public Owner(String firstName, String lastName, String profession, World world) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.world = world;
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
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets profession.
     *
     * @return the profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * Sets profession.
     *
     * @param profession the profession
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }


    /**
     * Gets world.
     *
     * @return the world
     */
    public World getWorld() {
        return world;
    }

    /**
     * Sets world.
     *
     * @param world the world
     */
    public void setWorld(World world) {
        this.world = world;
    }


    /**
     * Gets shops owned.
     *
     * @return the shops owned
     */
    public Set<Shop> getShopsOwned() {
        return shopsOwned;
    }

    /**
     * Sets shops owned.
     *
     * @param shopsOwned the shops owned
     */
    public void setShopsOwned(Set<Shop> shopsOwned) {
        this.shopsOwned = shopsOwned;
    }

    /**
     * Add shop.
     *
     * @param shop the shop
     */
    public void addShop (Shop shop) {
        shopsOwned.add(shop);
        shop.setOwner(this);
    }

    /**
     * Remove shop.
     *
     * @param shop the shop
     */
    public void removeShop (Shop shop) {
        shopsOwned.remove(shop);
        shop.setOwner(null);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profession='" + profession + '\'' +
                ", world=" + world +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id && firstName.equals(owner.firstName) && lastName.equals(owner.lastName) && profession.equals(owner.profession) && world.equals(owner.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, profession, world);
    }
}
