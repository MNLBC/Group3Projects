package com.oocl.mnlbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Entity Class student
 * 
 * @author BRIONSE
 *
 */
@Entity(name = "STUDENT")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STUDENT_ID", nullable = false)
	@GeneratedValue(generator = "STUDENT_ID_SEQ")
	@SequenceGenerator(name = "STUDENT_ID_SEQ", sequenceName = "STUDENT_ID_SEQ", allocationSize = 111)
	private long studentId;

	@Column(name = "STUDENT_NAME")
	private String studentName;

	@Column(name = "STUDENT_SCORE")
	private int studentScore;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "STUDENT_TEACHERID", referencedColumnName = "TEACHER_ID")
	private Teacher teacher;

	public Student() {

	}

	public Student(long studentId, String studentName, int studentScore, Teacher teacher) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
		this.teacher = teacher;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(int studentScore) {
		this.studentScore = studentScore;
	}

	

}
