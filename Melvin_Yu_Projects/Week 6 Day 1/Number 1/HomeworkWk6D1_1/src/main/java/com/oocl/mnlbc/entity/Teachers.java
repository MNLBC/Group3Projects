package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "teacher")
@Table(name = "teachers")
public class Teachers implements Serializable {

    @Id
    @Column(name = "teacher_id")
    private String teacherId;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "teacher_school_name")
    private String teacherSchoolName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId", fetch = FetchType.EAGER)
    private List<Student> studentList;

    public Teachers() {
    }

    public Teachers(String teacherId) {
        this.teacherId = teacherId;
    }



    public Teachers(String teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Teachers(String teacherId, String teacherName, String teacherSchoolName) {
    	this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSchoolName=teacherSchoolName;
	}

	public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    
    public String getTeacherSchoolName() {
		return teacherSchoolName;
	}

	public void setTeacherSchoolName(String teacherSchoolName) {
		this.teacherSchoolName = teacherSchoolName;
	}

	public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherId != null ? teacherId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teachers)) {
            return false;
        }
        Teachers other = (Teachers) object;
        if ((this.teacherId == null && other.teacherId != null) || (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
            return false;
        }
        return true;
    }    

	@Override
    public String toString() {
		int average=0;
		int count=0;
		for(Student stud : studentList){
			count++;
			average+=stud.getStudentScore();
		}
		
		average= average/count;
        return "Teacher id:" + teacherId +"Teacher Name: "+ teacherName + " Students Average: "+ average;
    }
}
