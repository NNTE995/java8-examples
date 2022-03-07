package StudentManagement.com.hibernate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class ControllerQeries {

public static void main(String[] args) {
	SessionFactory miFactory = new Configuration().configure("hibernateConfig.xml")
			.addAnnotatedClass(Students.class)
			.addAnnotatedClass(Course.class)
			.buildSessionFactory() ;
	
		Session miSession = miFactory.openSession();
		miSession.beginTransaction();
		String Querry="FROM Students";
		List<Students> listStudents= miSession.createQuery(Querry).getResultList();
		String Querry2="FROM Course";
		List<Course> listCourse= miSession.createQuery(Querry2).getResultList();
		miSession.getTransaction().commit();
		miSession.close();
		
		SessionFactory miFactory2 = new Configuration().configure("hibernateConfig2.xml")
				.addAnnotatedClass(Enrollment.class)
				.buildSessionFactory() ;
		
		for(int i=0; i<listStudents.size(); i++) {
			
			int ite= (int) Math.floor(Math.random()*4+1);
			for(int j=0; j<ite;j++) {
				
				Session miSessionF = miFactory.openSession();
				miSessionF.beginTransaction();
				listStudents= miSessionF.createQuery(Querry).getResultList();
				listCourse= miSessionF.createQuery(Querry2).getResultList();
				miSessionF.getTransaction().commit();
				miSessionF.close();
				
				int CourseId= (int) Math.floor(Math.random()*listCourse.size());
				
				if(listCourse.get(CourseId).getAvailability()>0) {
					Enrollment e1 = new Enrollment();
					e1.setStudentId(listStudents.get(i).getStudentId());
					e1.setName(listStudents.get(i).getName());
					e1.setAge(listStudents.get(i).getAge());
					e1.setCourseId(listCourse.get(CourseId).getCourseId());
					e1.setNameCourse(listCourse.get(CourseId).getNameCourse());
					e1.setStarCourse(listCourse.get(CourseId).getStarCourse());
					e1.setEndCourse(listCourse.get(CourseId).getEndCourse());
					e1.setAvailability(listCourse.get(CourseId).getAvailability());
					e1.setMarks(Math.random()*100);
					
					Session miSession2 = miFactory2.openSession();
					miSession2.beginTransaction();
					miSession2.save(e1);
					e1.setAvailability(listCourse.get(CourseId).getAvailability()-1);
					miSession2.getTransaction().commit();
					System.out.println("Registro Insertado con Exito");
					miSession2.close();
					
					Course updateAv = new Course();
					updateAv.setCourseId(e1.getCourseId());
					updateAv.setNameCourse(e1.getNameCourse());
					updateAv.setStarCourse(e1.getStarCourse());
					updateAv.setEndCourse(e1.getEndCourse());
					updateAv.setAvailability(listCourse.get(CourseId).getAvailability()-1);
					
					Session miSession3 = miFactory.openSession();
					miSession3.beginTransaction();
					miSession3.update(updateAv);
					miSession3.getTransaction().commit();
					miSession3.close();
				}
				else {
					System.out.println("no se puede registrar un nuevo estudiante. Curso lleno!");
				}		
			}
		}
		
		Session miSessionEnrollment = miFactory2.openSession();
		miSessionEnrollment.beginTransaction();
		String QuerryEnrollment="FROM Enrollment";
		String QuerryEnrollmentForCourse="FROM Enrollment Where nameCourse='Artificial Intelligence'";
		List<Enrollment> listEnrollment= miSessionEnrollment.createQuery(QuerryEnrollment).getResultList();
		List<Enrollment> listEnrollmentForCourse= miSessionEnrollment.createQuery(QuerryEnrollmentForCourse).getResultList();
		miSessionEnrollment.getTransaction().commit();
		miSessionEnrollment.close();
		System.out.println("DATA OF ALL STUDENTS OF ALL COURSES");
		System.out.println(listEnrollment);
		System.out.println("DATA OF ALL STUDENTS FOR A COURSE NAME");
		System.out.println(listEnrollmentForCourse);
		
		double average=0;
		for(int k=0;k<listEnrollmentForCourse.size();k++) {
			average +=(listEnrollmentForCourse.get(k).getMarks())/listEnrollmentForCourse.size();
		}
		System.out.println("AVERAGE FOR THIS COURSE ");
		System.out.println(average);
		
		System.out.println("LIST OF COURSES FOR THE NEXT WEEK");
		for(int l=0;l<listCourse.size();l++) {
			if(ChronoUnit.DAYS.between(LocalDate.now(),listCourse.get(l).getStarCourse())>=7 &&
					ChronoUnit.DAYS.between(LocalDate.now(),listCourse.get(l).getStarCourse())<31) {
				System.out.println("--> "+ listCourse.get(l).getNameCourse());
			}
		}
		
		System.out.println("LIST OF COURSES FOR THE NEXT MONTH");
		for(int l2=0;l2<listCourse.size();l2++) {
			if(ChronoUnit.DAYS.between(LocalDate.now(),listCourse.get(l2).getStarCourse())>=30) {
				System.out.println("--> "+ listCourse.get(l2).getNameCourse());
			}			
		}
	}
}