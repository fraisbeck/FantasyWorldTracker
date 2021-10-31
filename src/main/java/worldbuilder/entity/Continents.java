package worldbuilder.entity;

/**
 * The type Continents.
 */
public class Continents {

    private int id;
    private String name;
    private int worldId;

    /**
     * Instantiates a new Continents.
     */
    public Continents() {
    }

    /**
     * Instantiates a new Continents.
     *
     * @param id      the id
     * @param name    the name
     * @param worldId the world id
     */
    public Continents(int id, String name, int worldId) {
        this.id = id;
        this.name = name;
        this.worldId = worldId;
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
     * Gets world id.
     *
     * @return the world id
     */
    public int getWorldId() {
        return worldId;
    }

    /**
     * Sets world id.
     *
     * @param worldId the world id
     */
    public void setWorldId(int worldId) {
        this.worldId = worldId;
    }

    @Override
    public String toString() {
        return "Continents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", worldId=" + worldId +
                '}';
    }
}
