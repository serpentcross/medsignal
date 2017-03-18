package ru.medsignal.webstore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	public Item() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	private Integer id;

	@Column(name = "name")
	@Getter @Setter
	private String name;

	@Column(name = "price")
	@Getter @Setter
	private int price;

	@Column(name = "description")
	@Getter @Setter
	private String description;

	@Column(name = "artikul")
	@Getter @Setter
	private String artikul;

	@ManyToMany
	@JoinTable(name="shoporder_item", joinColumns=@JoinColumn(name="item", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="shoporder", referencedColumnName="id"))
	@Getter @Setter
	private List<ShopOrder> shopOrders;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Item item = (Item) o;

		if (price != item.price) return false;
		if (id != null ? !id.equals(item.id) : item.id != null) return false;
		if (name != null ? !name.equals(item.name) : item.name != null) return false;
		if (!description.equals(item.description)) return false;
		return artikul.equals(item.artikul);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + price;
		result = 31 * result + description.hashCode();
		result = 31 * result + artikul.hashCode();
		return result;
	}
}
