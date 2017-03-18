package ru.medsignal.webstore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "country")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	public Country() {

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

		Country country = (Country) o;

		if (code != country.code) return false;
		if (!id.equals(country.id)) return false;
		return name.equals(country.name);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + code;
		result = 31 * result + name.hashCode();
		return result;
	}
}
