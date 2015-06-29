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

@Entity
@Table(name = "options")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Long id;


	@Column(name = "price")
	@NotNull
	@Min(2)
	Integer price;

	@Column(name = "title")
	@NotNull
	@Size(max = 3, message = "Cannot be longer than {max} characters")
	String title;
	
	@Column(name = "activation_cost")
	@NotNull
	Integer activationCost;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getActivationCost() {
		return activationCost;
	}

	public void setActivationCost(Integer activationCost) {
		this.activationCost = activationCost;
	}

}
