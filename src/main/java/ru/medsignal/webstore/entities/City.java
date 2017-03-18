package ru.medsignal.webstore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "city")
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	public City() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	private Integer id;

	@Column(name = "code")
	@Getter @Setter
	private int code;

	@Column(name = "name")
	@Getter @Setter
	private String name;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		City city = (City) o;

		if (code != city.code) return false;
		if (!id.equals(city.id)) return false;
		return name.equals(city.name);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + code;
		result = 31 * result + name.hashCode();
		return result;
	}
}
