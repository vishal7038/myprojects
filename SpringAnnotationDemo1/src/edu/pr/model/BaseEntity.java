package edu.pr.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class BaseEntity implements Serializable 
{
	@Basic protected String createdBy;
	@Basic protected Timestamp createdTime = new Timestamp(new java.util.Date().getTime());
	@Basic protected String editedBy;
	@Basic protected Timestamp editedTime = new Timestamp(new java.util.Date().getTime());;
	@Basic protected boolean isEditable =true;
	@Basic protected boolean isDeleted = false;
	@Basic protected boolean isSystem = false;
	@Basic protected long companyId;
	
	
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdTime
	 */
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * @return the editedBy
	 */
	public String getEditedBy() {
		return editedBy;
	}
	/**
	 * @param editedBy the editedBy to set
	 */
	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}
	/**
	 * @return the editedTime
	 */
	public Timestamp getEditedTime() {
		return editedTime;
	}
	/**
	 * @param editedTime the editedTime to set
	 */
	public void setEditedTime(Timestamp editedTime) {
		this.editedTime = editedTime;
	}
		
	/**
	 * @return the companyId
	 */
	public long getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the isEditable
	 */
	public boolean isEditable() {
		return isEditable;
	}
	/**
	 * @param isEditable the isEditable to set
	 */
	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}
	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}
	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * @return the isSystem
	 */
	public boolean isSystem() {
		return isSystem;
	}
	/**
	 * @param isSystem the isSystem to set
	 */
	public void setSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}
	
	
}
