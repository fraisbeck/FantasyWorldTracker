package worldbuilder.entity;

/**
 * The type Worlds.
 */
public class Worlds {

    private int id;
    private String name;

    /**
     * Instantiates a new Worlds.
     */
    public Worlds() {
    }

    /**
     * Instantiates a new Worlds.
     *
     * @param id   the id
     * @param name the name
     */
    public Worlds(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Worlds{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
