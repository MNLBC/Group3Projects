package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Entity class Teacher
 * 
 * @author BRIONSE
 *
 */

@Entity(name = "TEACHER")
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1575683914179942753L;

	@Id // signifies the primary key
	@Column(name = "TEACHER_ID", nullable = false)
	@GeneratedValue(generator = "TEACHER_ID_SEQ")
	@SequenceGenerator(name = "TEACHER_ID_SEQ", sequenceName = "TEACHER_ID_SEQ", allocationSize = 123)
	private long teacherId;

	@Column(name = "TEACHER_NAME")
	private String name;

	@Column(name = "TEACHER_SCHOOL_NAME")
	private String school_name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.EAGER)
	private List<Student> students;

	public Teacher() {
	}

	public Teacher(long teacherId) {
		this.teacherId = teacherId;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public long getId() {
		return teacherId;
	}

	public void setId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}