package entity;

/**
 * The type Regions.
 */
public class Regions {

    private int id;
    private String name;
    private int continentId;

    /**
     * Instantiates a new Regions.
     */
    public Regions() {
    }

    /**
     * Instantiates a new Regions.
     *
     * @param id          the id
     * @param name        the name
     * @param continentId the continent id
     */
    public Regions(int id, String name, int continentId) {
        this.id = id;
        this.name = name;
        this.continentId = continentId;
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
     * Gets continent id.
     *
     * @return the continent id
     */
    public int getContinentId() {
        return continentId;
    }

    /**
     * Sets continent id.
     *
     * @param continentId the continent id
     */
    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continentId=" + continentId +
                '}';
    }
}
