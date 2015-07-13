package entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import utils.CONSTANT;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Provides the model implementation for the Option entity. Represents a row
 * in the &quot;Option_&quot; database table, with each column mapped to a property of this class.
 *
 * @author Tatiana
 * @version 1.0
 */
@Entity
@Table(name = "options")
public class Option {
    /**
     * The primary key of the option.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * The price of the option.
     */
    @Column(name = "price")
    @NotNull
    @Min(CONSTANT.OPTION_PRICE_MIN_VALUE)
    @Max(CONSTANT.OPTION_PRICE_MAX_VALUE)
    private Integer price;

    /**
     * The title of the option.
     */
    @Column(name = "title")
    @NotNull
    @Size(max = CONSTANT.OPTION_TITLE_MAX_LENGTH, message = "Cannot be longer than {max} characters")
    private String title;

    /**
     * The activation cost of the option.
     */
    @Column(name = "activation_cost")
    @NotNull
    @Max(CONSTANT.OPTION_ACTIVATION_COST_MAX_VALUE)
    private Integer activationCost;

    /**
     * Stores required options for this option. Client will be forced to choose these required options if he want to connect this option.
     */
    @ManyToMany(fetch = FetchType.EAGER)//TO REMEMBER what cascadeType by default? Is needed here (CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)// In DB population script "ON DELETE CASCADE ON UPDATE RESTRICT"
    @JoinTable(
            name = "required_options",
            joinColumns = {@JoinColumn(name = "source_opt_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "required_opt_id", referencedColumnName = "id")})
    private List<Option> requiredOptions;

    /**
     * Stores incompatible options for this option. Client should before hand exclude these incompatible options to connect to this option.
     * Otherwise this option will not be connected.
     */
    @ManyToMany(fetch = FetchType.EAGER)//TO REMEMBER what cascadeType by default? Is needed here (CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    // In DB population script "ON DELETE CASCADE ON UPDATE RESTRICT"
    @JoinTable(
            name = "incompatible_options",
            joinColumns = {@JoinColumn(name = "source_opt_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "incompatible_opt_id", referencedColumnName = "id")})
    private List<Option> incompatibleOptions;

    /**
     * Gets the price of the option.
     *
     * @return {@link Integer}
     */
    public final Integer getPrice() {
        return price;
    }

    /**
     * Sets the price of the option.
     *
     * @param price allowed object is {@link Integer}
     */
    public final void setPrice(final Integer price) {
        this.price = price;
    }

    /**
     * Gets the id of the option.
     *
     * @return {@link Long }
     */
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id of the option. Should not be used, as DB generate ids. May be will  be deleted in future.
     *
     * @param id allowed object is {@link Long}
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the title of the option.
     *
     * @return {@link String}
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Sets the title of the option.
     *
     * @param title allowed object is {@link String}
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the activation cost of the option.
     *
     * @return {@link Integer}
     */
    public final Integer getActivationCost() {
        return activationCost;
    }

    /**
     * Sets the activation cost of the option.
     *
     * @param activationCost allowed object is {@link Integer }
     */
    public final void setActivationCost(final Integer activationCost) {
        this.activationCost = activationCost;
    }
    /**
     * Gets incompatible options of the option.
     *
     * @return {@link List<Option>}
     */
    public final List<Option> getIncompatibleOptions() {
        return incompatibleOptions;
    }
    /**
     * Sets the incompatible options to the option.
     *
     * @param incompatibleOptions allowed object is {@link List<Option> }
     */
    public final void setIncompatibleOptions(final List<Option> incompatibleOptions) {
        this.incompatibleOptions = incompatibleOptions;
    }
    /**
     * Gets required options of the option.
     *
     * @return {@link List<Option>}
     */
    public final List<Option> getRequiredOptions() {
        return requiredOptions;
    }
    /**
     * Sets the required options of the option.
     *
     * @param requiredOptions allowed object is {@link List<Option> }
     */
    public final void setRequiredOptions(final List<Option> requiredOptions) {
        this.requiredOptions = requiredOptions;
    }
}
