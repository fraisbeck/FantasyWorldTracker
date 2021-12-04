package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Worlds.
 */
@Entity(name = "World")
@Table(name = "worlds")
public class World {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    private User user;

    @OneToMany(mappedBy = "world", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Continent> worldContinents = new HashSet<>();

    /**
     * Instantiates a new Worlds.
     */
    public World() {
    }

    /**
     * Instantiates a new World.
     *
     * @param id   the id
     * @param name the name
     * @param user the user
     */
    public World(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    /**
     * Instantiates a new World.
     *
     * @param name the name
     * @param user the user
     */
    public World(String name, User user) {
        this.name = name;
        this.user = user;
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
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets world continents.
     *
     * @return the world continents
     */
    public Set<Continent> getWorldContinents() {
        return worldContinents;
    }

    /**
     * Sets world continents.
     *
     * @param worldContinents the world continents
     */
    public void setWorldContinents(Set<Continent> worldContinents) {
        this.worldContinents = worldContinents;
    }

    /**
     * Add continent.
     *
     * @param continent the continent
     */
    public void addContinent (Continent continent) {
        worldContinents.add(continent);
        continent.setWorld(this);
    }

    /**
     * Remove continent.
     *
     * @param continent the continent
     */
    public void removeContinent (Continent continent) {
        worldContinents.remove(continent);
        continent.setWorld(null);
    }

    @Override
    public String toString() {
        return "World{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        World world = (World) o;
        return id == world.id && name.equals(world.name) && user.equals(world.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, user);
    }
}
