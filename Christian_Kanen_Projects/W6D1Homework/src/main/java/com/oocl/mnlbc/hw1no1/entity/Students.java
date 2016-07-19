package com.oocl.mnlbc.hw1no1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author KANENCH
 *
 */

@Entity
@Table(name = "T_STUDENT")
public class Students implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private String studentId;
	@Column(name = "STUDENT_NAME")
	private String studentName;
	@Column(name = "STUDENT_SCORE")
	private Integer studentScore;

	@JoinColumn(name = "STUDENT_TEACHERID", referencedColumnName = "TEACHER_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Teachers teacherId;

	/**
	 * 
	 * @param studentId
	 * @param studentName
	 * @param studentScore
	 * @param teacherId
	 */
	public Students(String studentId, String studentName, Integer studentScore, Teachers teacherId) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
		this.teacherId = teacherId;
	}

	/**
	 * 
	 * @param studentId
	 */
	public Students(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * 
	 * @param studentId
	 * @param studentName
	 */
	public Students(String studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}

	/**
	 * 
	 * @param studentId
	 * @param studentName
	 * @param studentScore
	 */
	public Students(String studentId, String studentName, Integer studentScore) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
	}

	public Students() {

	}

	/**
	 * 
	 * @return studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * 
	 * @param studentId
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * 
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * 
	 * @param studentName
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getStudentScore() {
		return studentScore;
	}

	/**
	 * 
	 * @param studentScore
	 */
	public void setStudentScore(Integer studentScore) {
		this.studentScore = studentScore;
	}

	/**
	 * 
	 * @return
	 */
	public Teachers getTeacherId() {
		return teacherId;
	}

	/**
	 * 
	 * @param teacherId
	 */
	public void setTeacherId(Teachers teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + ((studentScore == null) ? 0 : studentScore.hashCode());
		result = prime * result + ((teacherId == null) ? 0 : teacherId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (studentScore == null) {
			if (other.studentScore != null)
				return false;
		} else if (!studentScore.equals(other.studentScore))
			return false;
		if (teacherId == null) {
			if (other.teacherId != null)
				return false;
		} else if (!teacherId.equals(other.teacherId))
			return false;
		return true;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Student Name =" + studentName + " ]";
	}
}
