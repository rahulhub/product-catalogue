package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the discount database table.
 * 
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="Discount")
@NamedQuery(name="Discount.findAll", query="SELECT d FROM Discount d", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class Discount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DISCOUNT_ID")
	private Long discountId;

	@Column(name="ALLOWED_USERS")
	private int allowedUsers;
	
	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="DISCOUNT_NAME")
	private String discountName;

	@Lob
	@Column(name="DISCOUNT_RULE")
	private byte[] discountRule;

	@Column(name="DISCOUNT_TYPE")
	private String discountType;

	@Column(name="DISPLAY_DESCRIPTION")
	private String displayDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="IS_ACTIVE")
	private int isActive;

	@Column(name="IS_GLOBAL")
	private int isGlobal;

	@Column(name="MODIFIER")
	private String modifier;

	@Column(name="PRIORITY")
	private int priority;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	//bi-directional many-to-one association to DiscountSet
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="DISCOUNT_SET_ID")
	private DiscountSet discountSet;

	//bi-directional many-to-one association to EcomOrderLineAdjustment
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="discount")
	private List<EcomOrderLineAdjustment> ecomOrderLineAdjustments;

	public Discount() {
	}

	public Long getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Long string) {
		this.discountId = string;
	}

	public int getAllowedUsers() {
		return this.allowedUsers;
	}

	public void setAllowedUsers(int allowedUsers) {
		this.allowedUsers = allowedUsers;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public byte[] getDiscountRule() {
		return this.discountRule;
	}

	public void setDiscountRule(byte[] discountRule) {
		this.discountRule = discountRule;
	}

	public String getDiscountType() {
		return this.discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getDisplayDescription() {
		return this.displayDescription;
	}

	public void setDisplayDescription(String displayDescription) {
		this.displayDescription = displayDescription;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsGlobal() {
		return this.isGlobal;
	}

	public void setIsGlobal(int isGlobal) {
		this.isGlobal = isGlobal;
	}

	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public DiscountSet getDiscountSet() {
		return this.discountSet;
	}

	public void setDiscountSet(DiscountSet discountSet) {
		this.discountSet = discountSet;
	}

	public List<EcomOrderLineAdjustment> getEcomOrderLineAdjustments() {
		return this.ecomOrderLineAdjustments;
	}

	public void setEcomOrderLineAdjustments(List<EcomOrderLineAdjustment> ecomOrderLineAdjustments) {
		this.ecomOrderLineAdjustments = ecomOrderLineAdjustments;
	}

	public EcomOrderLineAdjustment addEcomOrderLineAdjustment(EcomOrderLineAdjustment ecomOrderLineAdjustment) {
		getEcomOrderLineAdjustments().add(ecomOrderLineAdjustment);
		ecomOrderLineAdjustment.setDiscount(this);

		return ecomOrderLineAdjustment;
	}

	public EcomOrderLineAdjustment removeEcomOrderLineAdjustment(EcomOrderLineAdjustment ecomOrderLineAdjustment) {
		getEcomOrderLineAdjustments().remove(ecomOrderLineAdjustment);
		ecomOrderLineAdjustment.setDiscount(null);

		return ecomOrderLineAdjustment;
	}

	

	

}