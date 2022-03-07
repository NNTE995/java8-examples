package StudentManagement.com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {
	
	@Id
	private Integer studentId;
	private String name; 
	private int age;
	
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
	
	public Students(Integer studentId, String name, int age) {
		this.studentId = studentId;
		this.name = name;
		this.age = age;
	}
	
	public Students() {
	}
	
	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", name=" + name + ", age=" + age + "]";
	}
}