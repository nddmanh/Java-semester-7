package model;

public class Book {
	protected String name;
	protected int quantity;
	protected float price;
	protected String publisher;
	protected String discount;
	
	public Book() {
	}

	public Book(String name, int quantity, float price, String publisher, String discount) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.publisher = publisher;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

}
