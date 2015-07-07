package entity;

import org.hibernate.validator.constraints.Email;
import utils.CONSTANT;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Provides the model implementation for the User entity. Represents a row
 * in the &quot;User_&quot; database table, with each column mapped to a property of this class.
 *
 * @author Tatiana
 * @version 1.0
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * The primary key of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the user.
     */
    @Column(name = "name")
    @NotNull
    @Size(max = CONSTANT.USER_NAME_MAX_LENGTH, message = "Name cannot be longer than {max} characters")
    private String name;

    /**
     * The surname of the user.
     */
    @Column(name = "surname")
    @NotNull
    @Size(max = CONSTANT.USER_SURNAME_MAX_LENGTH, message = "Surname cannot be longer than {max} characters")
    private String surname;

    /**
     * The birthday of the user.
     * <p>
     * Temporal:To store it java.util.Date is used not java.sql.Date, that is why <code>@Temporal</code>
     * annotation is used (we have to specify Temporal types to map the appropriate database types when persisting to the database).
     * Here to store birthday TemporalType.DATE is used, not TemporalType.TIMESTAMP, because we do not need to store additional info
     * such as fractional seconds (11 bytes) and fractional seconds with timezone (13 bytes).
     * <p>
     * Past: value should precede the current date.
     */
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @Past(message = "Day of birth should precede the current date")
    @NotNull
    private Date birthDay;

    /**
     * Passport number of the user.
     */
    @Column(name = "passport")
    @Size(max = CONSTANT.USER_PASSPORT_MAX_LENGTH, message = "Passport number length cannot be longer than {max} characters")
    @NotNull
    private String passport;

    /**
     * Address of the user. Could contain any information that will be left by user.
     */
    @Column(name = "address")
    @Size(max = CONSTANT.USER_ADDRESS_MAX_LENGTH, message = "Address length cannot be longer than {max} characters")
    @NotNull
    private String address;

    /**
     * Email of the user.
     */
    @Email
    @Column(name = "email")
    @NotNull
    private String email;

    /**
     * Password of the user. In future type should be changes into char[] if needed.
     */
    @Column(name = "password")
    @Size(max = CONSTANT.USER_PASSWORD_MAX_LENGTH, message = "Password length cannot be longer than {max} characters")
    @NotNull
    private String password;

    /**
     * Role of the user (salesman, client or admin).
     */
    @Column(name = "role")
    @NotNull
    private String role;

    /**
     * Constructor of this class.
     */
    public User() {
        super();
    }

    /**
     * Constructs a User with the id, name, surname, email, password and so on.
     *
     * @param id        generated id
     * @param name      the name of the user
     * @param surname   the surname of the user
     * @param birthDay the day of birth
     * @param passport  the passport of the user
     * @param address   the address of the user
     * @param email     the email of the user
     * @param password  the password of the user
     * @param role      the role of the user
     */
    public User(final Long id, final String name, final String surname, final Date birthDay,
                final String passport, final String address, final String email, final String password,
                final String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.passport = passport;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getEmail() {
        return email;
    }

    public final void setEmail(final String email) {
        this.email = email;
    }

    public final Long getId() {
        return id;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    public final String getSurname() {
        return surname;
    }

    public final void setSurname(final String surname) {
        this.surname = surname;
    }

    public final Date getBirthDay() {
        return birthDay;
    }

    public final void setBirthDay(final Date birthDay) {
        this.birthDay = birthDay;
    }

    public final String getPassport() {
        return passport;
    }

    public final void setPassport(final String passport) {
        this.passport = passport;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(final String address) {
        this.address = address;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    public final String getRole() {
        return role;
    }

    public final void setRole(final String role) {
        this.role = role;
    }
}
