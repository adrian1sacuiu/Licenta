package domain;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Adrian on 02-Aug-14.
 */
@Entity
@Table(name = "Transactions")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 3L;
	private Long id;
	private User user;
	private Asset asset;
	private Date date;
	private String status;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_transaction")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "id_asset")
	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transaction Id: " + id + "    Date: " + date + "     Status: " + status + "\n    User: " + user + "\n    Asset: " + "Asset Id: " + asset.getId() + "    Name: " + asset.getName()
				+ "    Type: " + asset.getType() + "    available: " + asset.isAvailable() + "\n        User: " + asset.getUser();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Transaction that = (Transaction) o;

		if (id != null ? !id.equals(that.id) : that.id != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
