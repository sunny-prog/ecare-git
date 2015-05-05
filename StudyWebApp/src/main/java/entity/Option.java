package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	Long id;

	@Column(name = "price")
	Integer price;

	@Column(name = "title")
	String title;
	
	@Column(name = "activation_cost")
	Integer activationCost;
	
}
