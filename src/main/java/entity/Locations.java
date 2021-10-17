package entity;

/**
 * The type Locations.
 */
public class Locations {

    private int id;
    private String name;
    private String region;

    /**
     * Instantiates a new Locations.
     */
    public Locations() {
    }

    /**
     * Instantiates a new Locations.
     *
     * @param id     the id
     * @param name   the name
     * @param region the region
     */
    public Locations(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
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
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
