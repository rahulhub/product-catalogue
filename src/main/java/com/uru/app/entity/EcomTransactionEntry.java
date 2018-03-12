package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.uru.app.constants.UruAppConstants;

import java.util.Date;


/**
 * The persistent class for the ecom_transaction_entry database table.
 * 
 */
@Entity

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="EcomTransactionEntry")
@Table(name="ecom_transaction_entry")
@NamedQuery(name="EcomTransactionEntry.findAll", query="SELECT e FROM EcomTransactionEntry e", hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class EcomTransactionEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_ENTRY_ID")
	private Long transactionEntryId;

	@Column(name="TRAN_ENTRY_AMOUNT")
	private double tranEntryAmount;

	@Column(name="TRAN_ENTRY_CURRENCY")
	private String tranEntryCurrency;

	@Temporal(TemporalType.DATE)
	@Column(name="TRAN_ENTRY_DATE")
	private Date tranEntryDate;

	@Column(name="TRAN_ENTRY_SEQUENCE")
	private String tranEntrySequence;

	@Column(name="TRAN_ENTRY_STATUS")
	private String tranEntryStatus;

	//bi-directional many-to-one association to EcomTransaction
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToOne
	@JoinColumn(name="TRANSACTION_ID")
	private EcomTransaction ecomTransaction;

	public EcomTransactionEntry() {
	}

	public Long getTransactionEntryId() {
		return this.transactionEntryId;
	}

	public void setTransactionEntryId(Long transactionEntryId) {
		this.transactionEntryId = transactionEntryId;
	}

	public double getTranEntryAmount() {
		return this.tranEntryAmount;
	}

	public void setTranEntryAmount(double tranEntryAmount) {
		this.tranEntryAmount = tranEntryAmount;
	}

	public String getTranEntryCurrency() {
		return this.tranEntryCurrency;
	}

	public void setTranEntryCurrency(String tranEntryCurrency) {
		this.tranEntryCurrency = tranEntryCurrency;
	}

	public Date getTranEntryDate() {
		return this.tranEntryDate;
	}

	public void setTranEntryDate(Date tranEntryDate) {
		this.tranEntryDate = tranEntryDate;
	}

	public String getTranEntrySequence() {
		return this.tranEntrySequence;
	}

	public void setTranEntrySequence(String tranEntrySequence) {
		this.tranEntrySequence = tranEntrySequence;
	}

	public String getTranEntryStatus() {
		return this.tranEntryStatus;
	}

	public void setTranEntryStatus(String tranEntryStatus) {
		this.tranEntryStatus = tranEntryStatus;
	}

	public EcomTransaction getEcomTransaction() {
		return this.ecomTransaction;
	}

	public void setEcomTransaction(EcomTransaction ecomTransaction) {
		this.ecomTransaction = ecomTransaction;
	}

}