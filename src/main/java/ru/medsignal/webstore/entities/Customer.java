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
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	public Customer() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter
	private Integer id;

	@Column(name = "frst_name")
	@Getter @Setter
	private String firstName;

	@Column(name = "last_name")
	@Getter @Setter
	private String lastName;

	@Column(name = "midd_name")
	@Getter @Setter
	private String middleName;

	@Column(name = "email")
	@Getter @Setter
	private String email;

	@Column(name = "phone")
	@Getter @Setter
	private String phone;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Customer customer = (Customer) o;

		if (!id.equals(customer.id)) return false;
		if (!firstName.equals(customer.firstName)) return false;
		if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
		if (middleName != null ? !middleName.equals(customer.middleName) : customer.middleName != null) return false;
		if (!email.equals(customer.email)) return false;
		return phone != null ? phone.equals(customer.phone) : customer.phone == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + firstName.hashCode();
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
		result = 31 * result + email.hashCode();
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		return result;
	}
}
