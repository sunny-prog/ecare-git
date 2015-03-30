package entity;

public class Tariff {
	Long id;
	Integer price;
	String title;

	public Tariff() {
		super();
	}

	public Tariff(Long id, Integer price, String title) {
		this.id = id;
		this.price = price;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
