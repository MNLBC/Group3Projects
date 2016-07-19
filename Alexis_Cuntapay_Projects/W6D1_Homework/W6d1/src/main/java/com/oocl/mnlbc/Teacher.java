package com.oocl.mnlbc;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author CUNTAAL
 *
 */
@Entity
@Table(name = "A_TEACHER")
public class Teacher implements Serializable {

	@Id
	// (strategy = GenerationType.AUTO)
	@Column(name = "teacher_id")
	private Integer teacherId;
	@Column(name = "teacher_name")
	private String teacherName;
	@Column(name = "teacher_school_name")
	private String teacherSchool;

	public Teacher() {

	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSchool() {
		return teacherSchool;
	}

	public void setTeacherSchool(String teacherSchool) {
		this.teacherSchool = teacherSchool;
	}

}
	