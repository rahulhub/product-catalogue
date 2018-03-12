package com.uru.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uru.app.constants.UruAppConstants;
import com.uru.app.model.EcomProductModel;
import com.uru.app.model.HomePageProductModel;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="HomePageProduct")
@Table(name="homepage_product")
@NamedQuery(name="HomePageProduct.findAll", query="SELECT e FROM HomePageProduct e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})

public class HomePageProduct implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HPPRODUCT_ID")
	private Long hpproductId;
	
	@Column(name="CATEGORY_ID")
	private Long categoryId;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToOne
	@JoinColumn (name="PRODUCT_ID")
    private EcomProduct product;

	public Long getHpproductId() {
		return hpproductId;
	}

	public void setHpproductId(Long hpproductId) {
		this.hpproductId = hpproductId;
	}

	public EcomProduct getProduct() {
		return product;
	}

	public void setProduct(EcomProduct product) {
		this.product = product;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	
}
