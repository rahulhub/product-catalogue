package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;


/**
 * The persistent class for the discount_association database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="DiscountAssociation")
@Table(name="discount_association")
@NamedQuery(name="DiscountAssociation.findAll", query="SELECT d FROM DiscountAssociation d", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class DiscountAssociation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DISCOUNT_ASSOCIATION_ID")
	private Long discountAssociationId;

	@Column(name="DISPLAY_DESCRIPTION")
	private String displayDescription;

	@Column(name="USE_COUNT")
	private int useCount;

/*	//bi-directional many-to-one association to DiscountSet
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private DiscountSet discountSet1;*/

	//bi-directional many-to-one association to DiscountSet
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="DISCOUNT_ID")
	private DiscountSet discountSet;

	//bi-directional many-to-one association to EcomCustomer
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID" )
	private EcomCustomer ecomCustomer;

	public DiscountAssociation() {
	}

	public Long getDiscountAssociationId() {
		return this.discountAssociationId;
	}

	public void setDiscountAssociationId(Long discountAssociationId) {
		this.discountAssociationId = discountAssociationId;
	}

	public String getDisplayDescription() {
		return this.displayDescription;
	}

	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}

	public int getUseCount() {
		return this.useCount;
	}

	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}

/*	public DiscountSet getDiscountSet1() {
		return this.discountSet1;
	}

	public void setDiscountSet1(DiscountSet discountSet1) {
		this.discountSet1 = discountSet1;
	}*/

	public DiscountSet getDiscountSet() {
		return this.discountSet;
	}

	public void setDiscountSet(DiscountSet discountSet) {
		this.discountSet = discountSet;
	}

	public EcomCustomer getEcomCustomer() {
		return this.ecomCustomer;
	}

	public void setEcomCustomer(EcomCustomer ecomCustomer) {
		this.ecomCustomer = ecomCustomer;
	}

}