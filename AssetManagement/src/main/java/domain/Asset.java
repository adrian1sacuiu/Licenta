package domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ASSETS")
public class Asset implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idAsset;
	private String name;
	private String type;
	private boolean available;
	private boolean onStock;

	private User user;
	private Order order;

	private List<Complaint> complaints;
	private List<Request> requests;
	private List<Transaction> transactions;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ASSET")
	public Long getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(Long idAsset) {
		this.idAsset = idAsset;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "AVAILABLE")
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Column(name = "ON_STOCK")
	public boolean isOnStock() {
		return onStock;
	}

	public void setOnStock(boolean onStock) {
		this.onStock = onStock;
	}

	@ManyToOne
	@JoinColumn(name = "ID_USER")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "ID_ORDER")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "asset")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "asset")
	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "asset")
	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((idAsset == null) ? 0 : idAsset.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (onStock ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asset other = (Asset) obj;
		if (available != other.available)
			return false;
		if (idAsset == null) {
			if (other.idAsset != null)
				return false;
		} else if (!idAsset.equals(other.idAsset))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (onStock != other.onStock)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asset [idAsset=" + idAsset + ", name=" + name + ", type=" + type + ", available=" + available + ", onStock=" + onStock + "]";
	}

}
