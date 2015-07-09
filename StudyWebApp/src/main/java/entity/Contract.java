package entity;

import utils.CONSTANT;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


/**
 * Provides the model implementation for the Contract entity. Represents a row
 * in the &quot;Contract_&quot; database table, with each column mapped to a property of this class.
 *
 * @author Tatiana
 * @version 1.0
 */
@Entity
@Table(name = "contracts")
public class Contract {
    /**
     * The primary key of the contract.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * The number of the contract.
     */
    @Column(name = "number")
    @NotNull
    @Size(max = CONSTANT.CONTRACT_NUMBER_MAX_LENGTH, message = "Cannot be longer than {max} characters")
    private String number;

    /**
     * The tariff of the contract. Many contracts can have the same tariff.
     * This is bi-directional relationship. Contract side owns the relation.
     * It has additional column to store tariff's id.
     */
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariff_id")
    @NotNull
    private Tariff tariff;

    /**
     * The client of the contract. Many contracts can have the same client. Or one client can have several contracts.
     * This is bi-directional relationship. Contract side owns the relation.
     * It has additional column to store clients's id.
     */
    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotNull
    private User client;

    /**
     * The flag showing that contract is blocked by salesman.
     */
    @Column(name = "blocked_by_salesman", columnDefinition = "BIT", length = 1)
    @NotNull
    private Boolean blockedBySalesman;

    /**
     * The flag showing that contract is blocked by client. 1 means it is blocked.
     */
    @Column(name = "blocked_by_client", columnDefinition = "BIT", length = 1)
    @NotNull
    private Boolean blockedByClient;

    /**
     * Gets the id of the contract.
     *
     * @return {@link Long }
     */
    public final Long getId() {
        return id;
    }

    /**
     * Sets the id of the contract. Should not be used, as DB generate ids. May be will  be deleted in future.
     *
     * @param id allowed object is {@link Long}
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the number of the contract.
     *
     * @return {@link String}
     */
    public final String getNumber() {
        return number;
    }

    /**
     * Sets the number of the contract.
     *
     * @param number allowed object is {@link String}
     */
    public final void setNumber(final String number) {
        this.number = number;
    }

    /**
     * Gets the tariff of the contract.
     *
     * @return {@link Tariff }
     */
    public final Tariff getTariff() {
        return tariff;
    }

    /**
     * Sets the tariff of the contract.
     *
     * @param tariff allowed object is {@link Tariff}
     */
    public final void setTariff(final Tariff tariff) {
        this.tariff = tariff;
    }

    /**
     * Gets the client of the contract.
     *
     * @return {@link User}
     */
    public final User getClient() {
        return client;
    }

    /**
     * Sets the client of the contract.
     *
     * @param client allowed object is {@link User}
     */
    public final void setClient(final User client) {
        this.client = client;
    }

    /**
     * Gets the flag value. Shows if contract blocked by salesman or not.
     *
     * @return {@link Boolean }
     */
    public final Boolean getBlockedBySalesman() {
        return blockedBySalesman;
    }

    /**
     * Sets the flag, that indicate if contract was blocked by salesman or not.
     *
     * @param blockedBySalesman allowed object is {@link Boolean}
     */
    public final void setBlockedBySalesman(final Boolean blockedBySalesman) {
        this.blockedBySalesman = blockedBySalesman;
    }

    /**
     * Gets the flag value. Shows if contract blocked by client or not.
     *
     * @return {@link Boolean }
     */
    public final Boolean getBlockedByClient() {
        return blockedByClient;
    }

    /**
     * Sets the flag, that indicate if contract was blocked by client or not.
     *
     * @param blockedByClient allowed object is {@link Boolean}
     */
    public final void setBlockedByClient(final Boolean blockedByClient) {
        this.blockedByClient = blockedByClient;
    }
}
