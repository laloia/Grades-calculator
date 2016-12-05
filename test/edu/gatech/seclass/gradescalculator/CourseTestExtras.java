package edu.gatech.seclass.gradescalculator;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseTestExtras {

	Students students = null;
	Grades grades = null;
	Course course = null;
	static final String STUDENTS_DB = "DB/GradesDatabase6300-students.xlsx";
	static final String GRADES_DB = "DB/GradesDatabase6300-grades.xlsx";

	@Before
	public void setUp() throws Exception {
		students = new Students(STUDENTS_DB);
		grades = new Grades(GRADES_DB);
		course = new Course(students, grades);
	}

	@After
	public void tearDown() throws Exception {
		students = null;
		grades = null;
		course = null;
	}

	@Test
	public void testGetAttendanceByID() {
		Student student = null;
		student = course.getStudentByID("901234505");
		String name = student.getName();
		student = course.getStudentByName(name);
		assertEquals(100, student.getAttendance());
	}

	@Test
	public void testGetTeamByID() {
		Student student = course.getStudentByID("901234507");
		String name = student.getName();
		student = course.getStudentByName(name);
		assertEquals("Team 1", student.getTeam());
	}

	@Test
	public void testNonExistantStudent() {
		HashSet<Student> studentsRoster = null;
		studentsRoster = course.getStudents();
		Student student = null;
		for (Student s : studentsRoster) {
			if (s.getName().compareTo("Lauren Aloia") == 0) {
				student = s;
				break;
			}
		}
		assertNull(student);
	}

	@Test
	public void testStudentsOnSameTeam1() {
		Student student1 = course.getStudentByName("Grier Nehling");
		Student student2 = course.getStudentByName("Caileigh Raybould");
		String team1 = student1.getTeam();
		String team2 = student2.getTeam();
		assertEquals(team1, team2);
	}

	@Test
	public void testStudentsOnSameTeam2() {
		Student student1 = course.getStudentByName("Wilfrid Eastwood");
		Student student2 = course.getStudentByName("Shevon Wise");
		String team1 = student1.getTeam();
		String team2 = student2.getTeam();
		assertNotEquals(team1, team2);

	}

	@Test
	public void testAttendanceLowerThan85_1() {
		Student student = course.getStudentByName("Caileigh Raybould");
		int attendance = student.getAttendance();
		assertTrue(attendance < 85);

	}
	
	@Test
	public void testAttendanceLowerThan85_2() {
		Student student = course.getStudentByName("Sheree Gadow");
		int attendance = student.getAttendance();
		assertFalse(attendance < 85);

	}
	

}