package com.oocl.mnlbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
/**
 * 
 * @author CUNTAAL
 *
 */


@Entity
@Table(name = "A_STUDENT")
public class Student implements Serializable {

	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_score")
	private Integer studentScore;
	@JoinColumn(name = "student_teacher_id", referencedColumnName = "student_teacher_id")
	
	private Teacher student_teacher_id;
	
	
	public Student() {
		
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getStudentScore() {
		return studentScore;
	}
	public void setStudentScore(Integer studentScore) {
		this.studentScore = studentScore;
	}
	public Teacher getStudent_teacher_id() {
		return student_teacher_id;
	}
	public void setStudent_teacher_id(Teacher student_teacher_id) {
		this.student_teacher_id = student_teacher_id;
	}

	
}