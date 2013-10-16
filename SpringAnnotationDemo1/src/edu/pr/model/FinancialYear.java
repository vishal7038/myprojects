
package edu.pr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Proxy;


/**

 */

@Entity
@Table(name="financialyear")
@Proxy(lazy=true)
public class FinancialYear implements Serializable
{
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequenceGenerator")
	@javax.persistence.SequenceGenerator(name="sequenceGenerator", sequenceName="seqidfinancialyear", allocationSize=1)
	private long id;
	
	@Version
	private int version;
	
	@Basic
	private String label;
	
	@Basic
	private Date yearstartdate;
	
	@Basic
	private Date yearenddate;

	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the yearstartdate
	 */
	public Date getYearstartdate() {
		return yearstartdate;
	}

	/**
	 * @param yearstartdate the yearstartdate to set
	 */
	public void setYearstartdate(Date yearstartdate) {
		this.yearstartdate = yearstartdate;
	}

	/**
	 * @return the yearenddate
	 */
	public Date getYearenddate() {
		return yearenddate;
	}

	/**
	 * @param yearenddate the yearenddate to set
	 */
	public void setYearenddate(Date yearenddate) {
		this.yearenddate = yearenddate;
	}
	
}
