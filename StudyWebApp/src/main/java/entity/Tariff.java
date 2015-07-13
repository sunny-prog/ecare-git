package entity;

import utils.CONSTANT;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Provides the model implementation for the Tariff entity. Represents a row
 * in the &quot;Tariff_&quot; database table, with each column mapped to a property of this class.
 *
 * @author Tatiana
 * @version 1.0
 */
@Entity
@Table(name = "tariffs")
public class Tariff {
    /**
     * The primary key of the tariff.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * The price of the tariff.
     */
    @Column(name = "price")
    @NotNull
    private Integer price;

    /**
     * The title of the tariff.
     */
    @Column(name = "title")
    @NotNull
    @Size(max = CONSTANT.TARIFF_TITLE_MAX_LENGTH, message = "Cannot be longer than {max} characters")
    private String title;

    /**
     * Stores options available for this tariff. Client can choose one of these options to connect to.
     * If make this property to have lazy initialization = true, then Hibernate exception will be thrown,
     * because session is being closed before we access Tariff's member variables. When the following line is executed:
     * Tariff tariff= (Tariff) super.find(Tariff.class, id)
     * Hibernate opens a sessions, retrieves what we're looking for, then closes then session.
     * Any fields that have lazy=true are not retrieved at this time; instead, these fields are populated by proxies.
     * When we try to retrieve the actual value of proxied object, it will attempt to go back to the database
     * using the active session to retrieve the data. If no session can be found, we get the exception.
     * Setting lazy=true has advantages because it prevents the entire object graph from being loaded immediately;
     * nested objects are left alone until we specifically ask for them.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    //(fetch = FetchType.LAZY, optional = false)
//TO REMEMBER what cascadeType by default? Is needed here (CascadeType.ALL)
    // In DB population script "ON DELETE CASCADE ON UPDATE RESTRICT"
    @JoinTable(
            name = "tariffs_options",
            joinColumns = {@JoinColumn(name = "tariff_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "id")})
    private List<Option> options;

    /**
     * Constructor of this class.
     */
    public Tariff() {
        super();
    }

    /**
     * Constructs a Tariff with the id, price, title.
     *
     * @param id    generated id
     * @param price the price of the tariff
     * @param title the title of the tariff
     */
    public Tariff(final Long id, final Integer price, final String title) {
        this.id = id;
        this.price = price;
        this.title = title;
    }

    /**
     * Gets the id of the tariff.
     *
     * @return {@link Long}
     */
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id of the tariff.
     *
     * @param id allowed object is {@link Long}
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the price of the tariff.
     *
     * @return {@link Integer}
     */
    public final Integer getPrice() {
        return price;
    }

    /**
     * Sets the price of the tariff.
     *
     * @param price allowed object is {@link Integer}
     */
    public final void setPrice(final Integer price) {
        this.price = price;
    }

    /**
     * Gets the title of the tariff.
     *
     * @return {@link String}
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Sets the title of the tariff.
     *
     * @param title allowed object is {@link String}
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets options available for this tariff.
     *
     * @return {@link List, Option}
     */
    public final List<Option> getOptions() {
        return options;
    }

    /**
     * Sets the options available for this tariff.
     *
     * @param options allowed object is {@link List<Option> }
     */
    public final void setOptions(final List<Option> options) {
        this.options = options;
    }

}
