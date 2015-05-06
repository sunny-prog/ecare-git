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

@Entity
@Table(name = "contracts")
public class Contract {
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Tariff getTariff() {
		return tariff;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Boolean getBlockedBySalesman() {
		return blockedBySalesman;
	}

	public void setBlockedBySalesman(Boolean blockedBySalesman) {
		this.blockedBySalesman = blockedBySalesman;
	}

	public Boolean getBlockedByClient() {
		return blockedByClient;
	}

	public void setBlockedByClient(Boolean blockedByClient) {
		this.blockedByClient = blockedByClient;
	}


}
