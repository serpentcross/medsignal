package ru.medsignal.webstore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shoporder")
public class ShopOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	public ShopOrder() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer")
	@Getter @Setter
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address")
	@Getter @Setter
	private Address address;

	@Column(name = "order_date")
	@Getter @Setter
	private Date orderDate;

	@ManyToMany(mappedBy="shopOrders")
	private List<Item> items;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ShopOrder shopOrder = (ShopOrder) o;

		if (!id.equals(shopOrder.id)) return false;
		if (!customer.equals(shopOrder.customer)) return false;
		if (!address.equals(shopOrder.address)) return false;
		return orderDate.equals(shopOrder.orderDate);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + customer.hashCode();
		result = 31 * result + address.hashCode();
		result = 31 * result + orderDate.hashCode();
		return result;
	}
}
