package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Adrian on 02-Aug-14.
 */
@Entity
@Table(name = "Assets")
public class Asset implements Serializable {
	private static final long serialVersionUID = 2L;
	private Long id;
	private String name;
	private String type;
	private boolean available = true;
	private User user;
	private List<Transaction> transactions;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_asset")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "available")
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@ManyToOne
	@JoinColumn(name = "id_user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "asset")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Asset Id: " + id + "    Name: " + name + "    Type: " + type + "    available: " + available + "\n    User: " + user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Asset asset = (Asset) o;

		if (id != null ? !id.equals(asset.id) : asset.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
