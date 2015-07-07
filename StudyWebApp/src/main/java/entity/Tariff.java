package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 Provides the model implementation for the Tariff entity. Represents a row
 in the &quot;Tariff_&quot; database table, with each column mapped to a property of this class.
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

	@Column(name = "price")
	private Integer price;

	@Column(name = "title")
	private String title;

	public Tariff() {
		super();
	}

	public Tariff(final Long id, final Integer price, final String title) {
		this.id = id;
		this.price = price;
		this.title = title;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(final Long id) {
		this.id = id;
	}

	public final Integer getPrice() {
		return price;
	}

	public final void setPrice(final Integer price) {
		this.price = price;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(final String title) {
		this.title = title;
	}
}
