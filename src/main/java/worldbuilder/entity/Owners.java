package worldbuilder.entity;

/**
 * The type Owners.
 */
public class Owners {

    private int id;
    private String firstName;
    private String lastName;
    private String profession;

    /**
     * Instantiates a new Owners.
     */
    public Owners() {
    }

    /**
     * Instantiates a new Owners.
     *
     * @param id         the id
     * @param firstName  the first name
     * @param lastName   the last name
     * @param profession the profession
     */
    public Owners(int id, String firstName, String lastName, String profession) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
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

    @Override
    public String toString() {
        return "Owners{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
