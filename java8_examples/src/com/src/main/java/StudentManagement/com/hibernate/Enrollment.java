package StudentManagement.com.hibernate;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enrollment {	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer enrollmentId;
	private Integer studentId;
	private String name; 
	private int age;
	private Integer courseId;
	private String nameCourse;
	private LocalDate starCourse;
	private LocalDate endCourse;
	private int availability;
	private double marks;
	
	public Integer getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	public Enrollment(Integer enrollmentId, Integer studentId, String name, int age, Integer courseId,
			String nameCourse, LocalDate starCourse, LocalDate endCourse, int availability, double marks) {
		this.enrollmentId = enrollmentId;
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.courseId = courseId;
		this.nameCourse = nameCourse;
		this.starCourse = starCourse;
		this.endCourse = endCourse;
		this.availability = availability;
		this.marks = marks;
	}
	
	public Enrollment() {
	}
	
	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", studentId=" + studentId + ", name=" + name + ", age="
				+ age + ", courseId=" + courseId + ", nameCourse=" + nameCourse + ", starCourse=" + starCourse
				+ ", endCourse=" + endCourse + ", availability=" + availability + ", marks=" + marks + "]";
	}
}