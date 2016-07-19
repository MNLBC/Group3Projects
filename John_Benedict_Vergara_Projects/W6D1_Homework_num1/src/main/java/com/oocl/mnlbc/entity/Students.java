package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity (name = "STUDENT")
@Table(name = "STUDENTS")
public class Students {
	@Id
	@Column(name = "STUDENT_ID")
	private String stid;
	@Column(name = "STUDENT_NAME")
	private String stname;
	@Column(name = "STUDENT_SCORE")
	private int stscore;
	@JoinColumn(name = "TEACHER_ID", referencedColumnName = "TEACHER_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Teachers stteacherid;

	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public int getStscore() {
		return stscore;
	}

	public void setStscore(int stscore) {
		this.stscore = stscore;
	}

	public Teachers getStteacherid() {
		return stteacherid;
	}

	public void setStteacherid(Teachers stteacherid) {
		this.stteacherid = stteacherid;
	}

}
