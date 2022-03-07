package StudentManagement.com.hibernate;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course{
	@Id
	private Integer courseId;
	private String nameCourse;
	private LocalDate starCourse;
	private LocalDate endCourse;
	private int availability;
	
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public LocalDate getStarCourse() {
		return starCourse;
	}
	public void setStarCourse(LocalDate starCourse) {
		this.starCourse = starCourse;
	}
	public LocalDate getEndCourse() {
		return endCourse;
	}
	public void setEndCourse(LocalDate endCourse) {
		this.endCourse = endCourse;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getNameCourse() {
		return nameCourse;
	}
	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}
	
	public Course(Integer courseId, String nameCourse, LocalDate starCourse, LocalDate endCourse, Integer availability) {
		this.courseId = courseId;
		this.nameCourse = nameCourse;
		this.starCourse = starCourse;
		this.endCourse = endCourse;
		this.availability = availability;
	}
	
	public Course() {
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", nameCourse=" + nameCourse + ", starCourse=" + starCourse
				+ ", endCourse=" + endCourse + ", availability=" + availability+ "]";
	}
}