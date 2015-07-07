package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @Column(name = "contract_number")
    private String contractNumber;

    @OneToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Column(name = "blocked_by_salesman", columnDefinition = "BIT", length = 1)
    private Boolean blockedBySalesman;

    @Column(name = "blocked_by_client", columnDefinition = "BIT", length = 1)
    private Boolean blockedByClient;

    public final Long getId() {
        return id;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    public final String getContractNumber() {
        return contractNumber;
    }

    public final void setContractNumber(final String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public final Tariff getTariff() {
        return tariff;
    }

    public final void setTariff(final Tariff tariff) {
        this.tariff = tariff;
    }

    public final User getClient() {
        return client;
    }

    public final void setClient(final User client) {
        this.client = client;
    }

    public final Boolean getBlockedBySalesman() {
        return blockedBySalesman;
    }

    public final void setBlockedBySalesman(final Boolean blockedBySalesman) {
        this.blockedBySalesman = blockedBySalesman;
    }

    public final Boolean getBlockedByClient() {
        return blockedByClient;
    }

    public final void setBlockedByClient(final Boolean blockedByClient) {
        this.blockedByClient = blockedByClient;
    }
}
