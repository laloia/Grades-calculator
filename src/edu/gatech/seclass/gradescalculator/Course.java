package edu.gatech.seclass.gradescalculator;

import java.util.HashMap;
import java.util.HashSet;




public class Course {
	
	Students students;
	Grades grades;
	

	public Course(Students students, Grades grades){
		this.students=students;
		this.grades=grades;
		
		
	}

	public int getNumStudents() {
		
		int numStudents= students.getLastRowNum();
		return numStudents;
	}

	public int getNumAssignments() {
		int numAssignments = grades.getAssignmentsCount();
		return numAssignments;
	}

	public int getNumProjects() {
		int numProjects = grades.getProjectCount();
		return numProjects;
	}

	public HashSet<Student> getStudents() {
		HashSet<Student> studentsSet =students.getAllStudents();
		grades.addAttendance(studentsSet);
		return studentsSet;
	}

	public Student getStudentByName(String name) {
		Student student = students.getStudentbyName(name);
		grades.addAttendanceToStudent(student);
		return student;
	}

	public Student getStudentByID(String gtid) {
		Student student = students.getStudentbyID(gtid);
		return student;
	}

	
	
	public String getEmail(Student student){
		String email =student.getEmail();
		return email;
	}
	
	public int getAttendance(Student student){
		int attendance = student.getAttendance();
		return attendance;
	}

	public int getAverageAssignmentsGrade(Student student) {
		int averageGrade = grades.getAverageAssignmentsGrade(student);
		return averageGrade;
	}

	public int getAverageProjectsGrade(Student student) {
		int average_projects_grade = grades.getAverageProjectsGrade(student);
		return average_projects_grade;
	}

	public String getOverallGrade(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFormula(String text) {
		// TODO Auto-generated method stub
		
	}

	public String getFormula() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTeam(Student student) {
		String team = student.getTeam();
		return team;
	}

	public void addAssignment(String string) {
		grades.addAssignment(string);	
	}

	public void updateGrades(Grades grade_value) {
		// TODO Auto-generated method stub
		
	}

	public void addGradesForAssignment(String assignmentName, HashMap<Student, Integer> grades2) {
		grades.addGradesForAssignment(assignmentName,grades2);
		
	}

	public void addIndividualContributions(String projectName1, HashMap<Student, Integer> contributions1) {
		// TODO Auto-generated method stub
		
	}
	
	
}