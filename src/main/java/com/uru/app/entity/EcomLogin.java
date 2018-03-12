package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.uru.app.constants.UruAppConstants;

/**
 * The persistent class for the ecom_login database table.
 * 
 */

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomLogin")
@Table(name = "ecom_login")
@NamedQueries({
@NamedQuery(name = "EcomLogin.findAll", query = "SELECT e FROM EcomLogin e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name = "EcomLogin.findByLoginName", query = "SELECT e FROM EcomLogin e where e.loginName = :n", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")}),
@NamedQuery(name = "EcomLogin.findByLoginId", query = "SELECT e FROM EcomLogin e where e.id = :n", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
})
public class EcomLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "login_name",unique=true)
	private String loginName;

	@Column(name = "password",length=500)
	private String password;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne(cascade = {CascadeType.ALL})
	private EcomCustomer ecomCustomer;

	public EcomLogin() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the ecomCustomer
	 */
	public EcomCustomer getEcomCustomer() {
		return ecomCustomer;
	}

	/**
	 * @param ecomCustomer the ecomCustomer to set
	 */
	public void setEcomCustomer(EcomCustomer ecomCustomer) {
		this.ecomCustomer = ecomCustomer;
	}
	


}