package com.voicemailbox.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * VoicemailAccount is an entity mapping of voicemail_account table.
 * 
 * @author      Daniel Ramirez
 * @since       0.0.1
 */
@Entity(name = "voicemail_account")
@EntityListeners(AuditingEntityListener.class)
public class VoicemailAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "account_id")
	private String accountId;

	private String name;

	@JsonIgnore
	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@JsonIgnore
	@CreatedDate
	@Column(name = "created_date")
	private Timestamp createdDate;

	@JsonIgnore
	@LastModifiedBy
	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	@JsonIgnore
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Timestamp lastModifiedDate;

	public VoicemailAccount() {
		super();
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
