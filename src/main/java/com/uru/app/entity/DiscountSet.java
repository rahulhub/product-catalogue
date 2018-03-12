package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.List;


/**
 * The persistent class for the discount_set database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="DiscountSet")
@Table(name="discount_set")
@NamedQuery(name="DiscountSet.findAll", query="SELECT d FROM DiscountSet d", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class DiscountSet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DISCOUNT_SET_ID")
	private Long discountSetId;

	@Column(name="DISCOUNT_SET_NAME")
	private String discountSetName;

	@Lob
	@Column(name="XML_DEFINITION")
	private byte[] xmlDefinition;

	//bi-directional many-to-one association to Discount
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="discountSet")
	private List<Discount> discounts;

	//bi-directional many-to-one association to DiscountAssociation
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="discountSet")
	private List<DiscountAssociation> discountAssociations;

	public DiscountSet() {
	}

	public Long getDiscountSetId() {
		return this.discountSetId;
	}

	public void setDiscountSetId(Long discountSetId) {
		this.discountSetId = discountSetId;
	}

	public String getDiscountSetName() {
		return this.discountSetName;
	}

	public void setDiscountSetName(String discountSetName) {
		this.discountSetName = discountSetName;
	}

	public byte[] getXmlDefinition() {
		return this.xmlDefinition;
	}

	public void setXmlDefinition(byte[] xmlDefinition) {
		this.xmlDefinition = xmlDefinition;
	}

	public List<Discount> getDiscounts() {
		return this.discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public Discount addDiscount(Discount discount) {
		getDiscounts().add(discount);
		discount.setDiscountSet(this);

		return discount;
	}

	public Discount removeDiscount(Discount discount) {
		getDiscounts().remove(discount);
		discount.setDiscountSet(null);

		return discount;
	}

	public List<DiscountAssociation> getDiscountAssociations() {
		return this.discountAssociations;
	}

	public void setDiscountAssociations(List<DiscountAssociation> discountAssociations) {
		this.discountAssociations = discountAssociations;
	}

	public DiscountAssociation addDiscountAssociations(DiscountAssociation discountAssociations) {
		getDiscountAssociations().add(discountAssociations);
		discountAssociations.setDiscountSet(this);

		return discountAssociations;
	}

	public DiscountAssociation removeDiscountAssociations(DiscountAssociation discountAssociations) {
		getDiscountAssociations().remove(discountAssociations);
		discountAssociations.setDiscountSet(null);

		return discountAssociations;
	}		

}