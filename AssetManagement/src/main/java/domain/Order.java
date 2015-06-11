package domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="getOrdersByPrice", query="FROM Order o WHERE o.price = :price"),
	@NamedQuery(name="getOrdersBySupplierName", query="FROM Order o WHERE o.supplierName = :supplierName"),
	@NamedQuery(name="getOrdersByPurchaseDate", query="FROM Order o WHERE o.purchaseDate = :purchaseDate"),
	@NamedQuery(name="getOrdersByIsReceived", query="FROM Order o WHERE o.isReceived = :isReceived")
})
@Table(name = "ORDERS")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idOrder;
	private String price;
	private String supplierName;
	private Date purchaseDate;
	private boolean isReceived;

	private List<Asset> assets;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ORDER")
	public long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}

	@Column(name = "PRICE")
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "SUPPLIER_NAME")
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Column(name = "PURCHASE_DATE")
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name = "IS_RECEIVED")
	public boolean getIsReceived() {
		return isReceived;
	}

	public void setIsReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}

	@OneToMany(mappedBy = "order")
	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idOrder ^ (idOrder >>> 32));
		result = prime * result + (isReceived ? 1231 : 1237);
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
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
		Order other = (Order) obj;
		if (idOrder != other.idOrder)
			return false;
		if (isReceived != other.isReceived)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [price=" + price + ", supplierName=" + supplierName + ", purchaseDate=" + purchaseDate + ", isReceived=" + isReceived + ", idOrder=" + idOrder + "]";
	}

}
