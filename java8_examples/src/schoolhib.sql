DROP database IF EXISTS schoolhib;
CREATE database schoolhib;
USE schoolhib;
-- ------------------------------------
DROP table IF EXISTS Students;
CREATE table Students (
studentId int not null auto_increment,
name varchar(255) not null,
age int,
primary key(studentId)
);

DROP table IF EXISTS Course;
CREATE table Course (
courseId int not null auto_increment,
nameCourse varchar(255) not null,
starCourse Date,
endCourse Date,
availability int,
primary key(courseId)
);
-- ---------------------------------------
INSERT INTO Students(studentId, name, age) VALUES(1, 'Noe Torres', 20);
INSERT INTO Students(studentId, name, age) VALUES(2, 'Marco Garcia', 25);
INSERT INTO Students(studentId, name, age) VALUES(3, 'Adrian Sanchez', 24);
INSERT INTO Students(studentId, name, age) VALUES(4, 'Mariana Torres', 20);
INSERT INTO Students(studentId, name, age) VALUES(5, 'ALberto Ortiz', 25);
INSERT INTO Students(studentId, name, age) VALUES(6, 'Pedro Perez', 24);
 
INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(1, 'Tensor Calculus', '2022-04-21', '2022-05-01', 3);
INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(2, 'Manifold', '2022-04-21', '2022-05-01', 2);
INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(3, 'Artificial Intelligence', '2022-03-14', '2022-05-01', 4);
INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(4, 'Electronic PEM', '2022-03-14', '2022-05-01', 3);
#INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(5, 'Atomic Theory', '2022-03-01', '2022-05-01',2);
#INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(6, 'Quantum Physics', '2022-03-01', '2022-05-01',4);
#INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(7, 'Electrodynamics', '2022-03-01', '2022-05-01',2);
#INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(8, 'Mechanical Statistics', '2022-03-01', '2022-05-01',1);
#INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(9, 'Nuclear Chemistry', '2022-03-01', '2022-05-01',2);
#INSERT INTO Course(courseId, nameCourse, starCourse, endCourse, availability) VALUES(10, 'General Relativity', '2022-03-01', '2022-05-01',4);
#INSERT INTO Course(courseId, nameCourse, starCourse, endCourse ,availability) VALUES(11, 'Weapon Design', '2022-03-01', '2022-05-01',3);
 
 Select * From Students;
 Select * From Course;
 Select * from enrollment;