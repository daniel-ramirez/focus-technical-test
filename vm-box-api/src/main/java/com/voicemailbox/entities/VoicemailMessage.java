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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * VoicemailMessage is an entity mapping of voicemail_message table.
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@Entity(name = "voicemail_message")
@EntityListeners(AuditingEntityListener.class)
public class VoicemailMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "media_id")
	@Id
	@Column(name = "media_id")
	private String mediaId;

	@JsonIgnore
	@Column(name = "vm_box_id")
	private String vmBoxId;

	@JsonProperty(value = "from")
	private String fromValue;

	@JsonProperty(value = "to")
	private String toValue;

	@JsonProperty(value = "caller_id_number")
	@Column(name = "caller_id_number")
	private String callerIdNumber;

	@JsonProperty(value = "caller_id_name")
	@Column(name = "caller_id_name")
	private String callerIdName;

	@JsonProperty(value = "call_id")
	@Column(name = "call_id")
	private String callId;

	private String folder;

	private Integer length;

	@JsonProperty(value = "timestamp")
	private Long timestampValue;

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

	public VoicemailMessage() {
		super();
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getVmBoxId() {
		return vmBoxId;
	}

	public void setVmBoxId(String vmBoxId) {
		this.vmBoxId = vmBoxId;
	}

	public String getFromValue() {
		return fromValue;
	}

	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}

	public String getToValue() {
		return toValue;
	}

	public void setToValue(String toValue) {
		this.toValue = toValue;
	}

	public String getCallerIdNumber() {
		return callerIdNumber;
	}

	public void setCallerIdNumber(String callerIdNumber) {
		this.callerIdNumber = callerIdNumber;
	}

	public String getCallerIdName() {
		return callerIdName;
	}

	public void setCallerIdName(String callerIdName) {
		this.callerIdName = callerIdName;
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Long getTimestampValue() {
		return timestampValue;
	}

	public void setTimestampValue(Long timestampValue) {
		this.timestampValue = timestampValue;
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
