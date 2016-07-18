package com.oocl.mnlbc.hw1no1.entity;

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
 * @author KANENCH
 *
 */
@Entity
@Table(name = "T_TEACHER")

public class Teachers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1067930083972838391L;
	@Id
	// (strategy = GenerationType.AUTO)
	@Column(name = "TEACHER_ID")
	private String teacherId;
	@Column(name = "TEACHER_NAME")
	private String teacherName;
	@Column(name = "TEACHER_SCHOOL_NAME")
	private String teacherSchoolName;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId", fetch = FetchType.LAZY)
	private List<Students> studentList;

	/**
	 * 
	 * @param teacherId
	 * @param teacherName
	 * @param teacherSchoolName
	 */
	public Teachers(String teacherId, String teacherName, String teacherSchoolName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherSchoolName = teacherSchoolName;
	}

	/**
	 * 
	 * @param teacherId
	 * @param teacherName
	 */
	public Teachers(String teacherId, String teacherName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	/**
	 * 
	 * @param teacherId
	 */
	public Teachers(String teacherId) {
		this.teacherId = teacherId;
	}

	public Teachers() {
	}

	/**
	 * 
	 * @return
	 */
	public String getTeacherId() {
		return teacherId;
	}

	/**
	 * 
	 * @return
	 */
	public String getTeacherSchoolName() {
		return teacherSchoolName;
	}

	/**
	 * 
	 * @param teacherSchoolName
	 */
	public void setTeacherSchoolName(String teacherSchoolName) {
		this.teacherSchoolName = teacherSchoolName;
	}

	/**
	 * 
	 * @param teacherId
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * 
	 * @return
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * 
	 * @param teacherName
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * 
	 * @return
	 */
	public List<Students> getStudentList() {
		return studentList;
	}

	/**
	 * 
	 * @param studentList
	 */
	public void setStudentList(List<Students> studentList) {
		this.studentList = studentList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentList == null) ? 0 : studentList.hashCode());
		result = prime * result + ((teacherId == null) ? 0 : teacherId.hashCode());
		result = prime * result + ((teacherName == null) ? 0 : teacherName.hashCode());
		result = prime * result + ((teacherSchoolName == null) ? 0 : teacherSchoolName.hashCode());
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
		Teachers other = (Teachers) obj;
		if (studentList == null) {
			if (other.studentList != null)
				return false;
		} else if (!studentList.equals(other.studentList))
			return false;
		if (teacherId == null) {
			if (other.teacherId != null)
				return false;
		} else if (!teacherId.equals(other.teacherId))
			return false;
		if (teacherName == null) {
			if (other.teacherName != null)
				return false;
		} else if (!teacherName.equals(other.teacherName))
			return false;
		if (teacherSchoolName == null) {
			if (other.teacherSchoolName != null)
				return false;
		} else if (!teacherSchoolName.equals(other.teacherSchoolName))
			return false;
		return true;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "T_Teacher {" + "Teacher Id=" + teacherId + ", Teacher Name='" + teacherName + '\'' + '}';
	}
}
