package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GRADEBOOK database table.
 * 
 */
@Entity
@NamedQuery(name="Gradebook.findAll", query="SELECT g FROM Gradebook g")
public class Gradebook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long gradeid;

	private String assignment;

	@Temporal(TemporalType.DATE)
	private Date dategraded;

	private BigDecimal grade;

	private String name;

	@Column(name="\"TYPE\"")
	private String type;

	public Gradebook() {
	}

	public long getGradeid() {
		return this.gradeid;
	}

	public void setGradeid(long gradeid) {
		this.gradeid = gradeid;
	}

	public String getAssignment() {
		return this.assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public Date getDategraded() {
		return this.dategraded;
	}

	public void setDategraded(Date dategraded) {
		this.dategraded = dategraded;
	}

	public BigDecimal getGrade() {
		return this.grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}