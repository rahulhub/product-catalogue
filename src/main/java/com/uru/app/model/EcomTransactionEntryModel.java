package com.uru.app.model;

import java.util.Date;
/**
 * @author Girish.Yadav
 *
 */
public class EcomTransactionEntryModel {
	
	private String transactionEntryId;

	private double tranEntryAmount;

	private String tranEntryCurrency;

	private Date tranEntryDate;

	private String tranEntrySequence;

	private String tranEntryStatus;

	private EcomTransactionModel ecomTransaction;

	public String getTransactionEntryId() {
		return transactionEntryId;
	}

	public void setTransactionEntryId(String transactionEntryId) {
		this.transactionEntryId = transactionEntryId;
	}

	public double getTranEntryAmount() {
		return tranEntryAmount;
	}

	public void setTranEntryAmount(double tranEntryAmount) {
		this.tranEntryAmount = tranEntryAmount;
	}

	public String getTranEntryCurrency() {
		return tranEntryCurrency;
	}

	public void setTranEntryCurrency(String tranEntryCurrency) {
		this.tranEntryCurrency = tranEntryCurrency;
	}

	public Date getTranEntryDate() {
		return tranEntryDate;
	}

	public void setTranEntryDate(Date tranEntryDate) {
		this.tranEntryDate = tranEntryDate;
	}

	public String getTranEntrySequence() {
		return tranEntrySequence;
	}

	public void setTranEntrySequence(String tranEntrySequence) {
		this.tranEntrySequence = tranEntrySequence;
	}

	public String getTranEntryStatus() {
		return tranEntryStatus;
	}

	public void setTranEntryStatus(String tranEntryStatus) {
		this.tranEntryStatus = tranEntryStatus;
	}

	public EcomTransactionModel getEcomTransaction() {
		return ecomTransaction;
	}

	public void setEcomTransaction(EcomTransactionModel ecomTransaction) {
		this.ecomTransaction = ecomTransaction;
	}
	
}
