package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;


/**
 * The persistent class for the ecom_cart database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomCart")
@Table(name="ecom_cart")
@NamedQueries(value={
	@NamedQuery(name="EcomCart.findAll", query="SELECT e FROM EcomCart e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
	@NamedQuery(name="EcomCart.removeItemForUser", query="DELETE FROM EcomCart e WHERE e.ecomCustomer.customerId=:n and e.itemId=:m", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
	@NamedQuery(name="EcomCart.deleteAllItemsForUser", query="DELETE FROM EcomCart e WHERE e.ecomCustomer.customerId=:n", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
	@NamedQuery(name="EcomCart.findAllByCustId", query="SELECT e FROM EcomCart e WHERE e.ecomCustomer.customerId=:n", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
	@NamedQuery(name="EcomCart.getCartItem", query="SELECT e FROM EcomCart e WHERE e.ecomCustomer.customerId=:n and e.itemId=:m" , hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
})

public class EcomCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	//bi-directional many-to-one association to EcomCustomer
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private EcomCustomer ecomCustomer;

	@Column(name="SKU")
	private Long itemId;
	
	@Column(name="quantity")
	private Long qty;
	
	@Column(name="json_data",length = 4000)
	private String json_data;
	
	@Column(name="rootCategory")
	private String rootCategory;
	
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	public EcomCart() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EcomCustomer getEcomCustomer() {
		return this.ecomCustomer;
	}

	public void setEcomCustomer(EcomCustomer ecomCustomer) {
		this.ecomCustomer = ecomCustomer;
	}

	/**
	 * @return the itemId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the qty
	 */
	public Long getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(Long qty) {
		this.qty = qty;
	}

	/**
	 * @return the json_data
	 */
	public String getJson_data() {
		return json_data;
	}

	/**
	 * @param json_data the json_data to set
	 */
	public void setJson_data(String json_data) {
		this.json_data = json_data;
	}

	public String getRootCategory() {
		return rootCategory;
	}

	public void setRootCategory(String rootCategory) {
		this.rootCategory = rootCategory;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	


}