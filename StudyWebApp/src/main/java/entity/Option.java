package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 Provides the model implementation for the Option entity. Represents a row
 in the &quot;Option_&quot; database table, with each column mapped to a property of this class.
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


    @Column(name = "price")
    @NotNull
    @Min(2)
    private Integer price;

    @Column(name = "title")
    @NotNull
    @Size(max = 3, message = "Cannot be longer than {max} characters")
    private String title;

    @Column(name = "activation_cost")
    @NotNull
    private Integer activationCost;

    public final Integer getPrice() {
        return price;
    }

    public final void setPrice(final Integer price) {
        this.price = price;
    }

    public final Long getId() {
        return id;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final Integer getActivationCost() {
        return activationCost;
    }

    public final void setActivationCost(final Integer activationCost) {
        this.activationCost = activationCost;
    }

}
