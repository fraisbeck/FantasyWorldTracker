package worldbuilder.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Owners.
 */
@Entity(name = "Owner")
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "idowners")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profession")
    private String profession;

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
     */
    public Owner(int id, String firstName, String lastName, String profession) {
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
