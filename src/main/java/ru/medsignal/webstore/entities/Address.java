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

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	public Address() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	private Integer id;

	@Column(name = "zipcode")
	@Getter @Setter
	private String zipcode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country")
	@Getter @Setter
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region")
	@Getter @Setter
	private Region region;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city")
	@Getter @Setter
	private City city;

	@Column(name = "street")
	@Getter @Setter
	private String street;

	@Column(name = "building")
	@Getter @Setter
	private int building;

	@Column(name = "house")
	@Getter @Setter
	private int house;

	@Column(name = "flat")
	@Getter @Setter
	private int flat;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Address address = (Address) o;

		if (building != address.building) return false;
		if (house != address.house) return false;
		if (flat != address.flat) return false;
		if (!id.equals(address.id)) return false;
		if (zipcode != null ? !zipcode.equals(address.zipcode) : address.zipcode != null) return false;
		if (!country.equals(address.country)) return false;
		if (!region.equals(address.region)) return false;
		if (!city.equals(address.city)) return false;
		return street.equals(address.street);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
		result = 31 * result + country.hashCode();
		result = 31 * result + region.hashCode();
		result = 31 * result + city.hashCode();
		result = 31 * result + street.hashCode();
		result = 31 * result + building;
		result = 31 * result + house;
		result = 31 * result + flat;
		return result;
	}
}
