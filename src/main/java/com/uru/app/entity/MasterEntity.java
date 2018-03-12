package com.uru.app.entity;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Rahul dev
 *
 */
@MappedSuperclass
public class MasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	private Date modifiedDate;
	@Column(name = "created_by", nullable = true)
	private String createdBy;
	@Column(name = "modified_by", nullable = true)
	private String modifiedBy;

	@Version
	private Long version;

	@PreUpdate
	public void setDefaultUpdates() {
		this.setModifiedDate(new Date());
	}

	@PrePersist
	public void setDefaultPersist() {
		this.setCreatedDate(new Date());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createDate) {
		this.createdDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MasterEntity other = (MasterEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
			else if (other.id == null) {
				return false;
			}
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}