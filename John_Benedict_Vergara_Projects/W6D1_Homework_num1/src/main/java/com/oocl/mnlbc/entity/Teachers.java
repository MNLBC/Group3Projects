package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "TEACHER")
@Table(name = "TEACHERS")
public class Teachers{

	@Id
	@Column(name = "TEACHER_ID")
	private String tid;
	@Column(name = "TEACHER_NAME")
	private String tname;
	@Column(name = "TEACHER_SCHOOL_NAME")
	private String tschoolname;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stteacherid", fetch = FetchType.LAZY)
    private List<Students> studentList;
	
	public List<Students> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Students> studentList) {
		this.studentList = studentList;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTschoolname() {
		return tschoolname;
	}
	public void setTschoolname(String tschoolname) {
		this.tschoolname = tschoolname;
	}
}
