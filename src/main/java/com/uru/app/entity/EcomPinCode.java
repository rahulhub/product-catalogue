package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

@Entity
@Table(name="ecom_pin_code")
@NamedQueries(value={
@NamedQuery(name="EcomPinCode.findAll", query="SELECT p from EcomPinCode p ", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name="EcomPinCode.findByPincode", query="SELECT p from EcomPinCode p where p.buyerPincode=:n", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name="EcomPinCode.findById", query="SELECT p from EcomPinCode p where p.id=:n", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
})
public class EcomPinCode implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BUYER_ID")
	private Long buyerId;
	
	@Column(name="BUYER_PINCODE")
	private int buyerPincode;
	
	@Column(name="BUYER_HUB")
	private String buyerHub;
	
	@Column(name="BUYER_STATE")
	private String buyerState;
	
	@Column(name="BUYER_VILLAGE_NAME")
	private String buyerVillageName;
	
	@Column(name="BUYER_AREA_DIVISION",length=800)
	private String buyerAreaDividion;
	
	@Column(name="BUYER_TALUKA")
	private String buyerTaluka;
	
	@Column(name="BUYER_DISTRIC")
	private String buyerDistric;
	
	@Column(name="CATEGORY_ID")
	private long categoryId;
	
	/*@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="CATEGORY_ID")
	private EcomCategory ecomCategory;*/
	
	public EcomPinCode()
	{}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public int getBuyerPincode() {
		return buyerPincode;
	}

	public void setBuyerPincode(int buyerPincode) {
		this.buyerPincode = buyerPincode;
	}

	public String getBuyerHub() {
		return buyerHub;
	}

	public void setBuyerHub(String buyerHub) {
		this.buyerHub = buyerHub;
	}

	public String getBuyerState() {
		return buyerState;
	}

	public void setBuyerState(String buyerState) {
		this.buyerState = buyerState;
	}

	public String getBuyerVillageName() {
		return buyerVillageName;
	}

	public void setBuyerVillageName(String buyerVillageName) {
		this.buyerVillageName = buyerVillageName;
	}

	public String getBuyerAreaDividion() {
		return buyerAreaDividion;
	}

	public void setBuyerAreaDividion(String buyerAreaDividion) {
		this.buyerAreaDividion = buyerAreaDividion;
	}

	public String getBuyerTaluka() {
		return buyerTaluka;
	}

	public void setBuyerTaluka(String buyerTaluka) {
		this.buyerTaluka = buyerTaluka;
	}

	public String getBuyerDistric() {
		return buyerDistric;
	}

	public void setBuyerDistric(String buyerDistric) {
		this.buyerDistric = buyerDistric;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	
		
}
