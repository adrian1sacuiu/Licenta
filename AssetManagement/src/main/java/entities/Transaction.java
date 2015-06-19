package entities;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQueries({
	@NamedQuery(name="getTransactionsByDate", query="FROM Transaction t WHERE t.date = :date"),
	@NamedQuery(name="getTransactionsByStatus", query="FROM Transaction t WHERE t.status = :status"),
	@NamedQuery(name="getTransactionsByUser", query="SELECT t FROM Transaction t INNER JOIN t.user u WHERE u.username=:username"),
	@NamedQuery(name="getTransactionsByAsset", query="FROM Transaction t WHERE t.asset.idAsset = :idAsset")
})
@Table(name = "TRANSACTIONS")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idTransaction;
	private Date date;
	private String status;

	private User user;
	private Asset asset;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_transaction")
	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
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

	@ManyToOne
	@JoinColumn(name = "id_user")
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "id_asset")
	@JsonIgnore
	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((idTransaction == null) ? 0 : idTransaction.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Transaction other = (Transaction) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idTransaction == null) {
			if (other.idTransaction != null)
				return false;
		} else if (!idTransaction.equals(other.idTransaction))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [idTransaction=" + idTransaction + ", date=" + date + ", status=" + status + "]";
	}

}
