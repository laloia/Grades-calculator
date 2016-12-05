package edu.gatech.seclass.gradescalculator;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Grades {

	private XSSFWorkbook wb;
	private XSSFSheet grades;
	private XSSFSheet teamGrades;
	private XSSFSheet attend;

	public Grades(String excelPath) {

		try {
			File src = new File(excelPath);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

			grades = wb.getSheet("IndividualGrades");
			teamGrades = wb.getSheet("TeamGrades");
			attend = wb.getSheet("Attendance");
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	public int getAssignmentsCount() {
		int count = grades.getRow(0).getLastCellNum();
		return count - 1;
	}

	public int getProjectCount() {
		int count = teamGrades.getRow(0).getLastCellNum();
		return count - 1;
	}

	public void addAttendance(HashSet<Student> studentsSet) {

		double attendance = 0;
		int rowcount = attend.getLastRowNum() + 1;

		for (Iterator<Student> studentIter = studentsSet.iterator(); studentIter.hasNext();) {
			Student student = studentIter.next();

			for (int a = 1; a < rowcount; a++) {
				double id = attend.getRow(a).getCell(0).getNumericCellValue();
				if (student.getGtid().equals(String.valueOf((int) Math.round(id)))) {
					attendance = attend.getRow(a).getCell(1).getNumericCellValue();
					student.setAttendance((int) Math.round(attendance));
					break;
				}
			}
		}

	}

	public void addAttendanceToStudent(Student student) {
		double attendance = 0;
		int rowcount = attend.getLastRowNum() + 1;

		for (int a = 1; a < rowcount; a++) {
			double id = attend.getRow(a).getCell(0).getNumericCellValue();
			if (student.getGtid().equals(String.valueOf((int) Math.round(id)))) {
				attendance = attend.getRow(a).getCell(1).getNumericCellValue();
				student.setAttendance((int) Math.round(attendance));
				break;
			}
		}
	}

	public void addAssignment(String string) {
		int c = grades.getRow(0).getLastCellNum();
		Cell cell = grades.getRow(0).createCell(c);
		cell.setCellValue(string);
	}

	public int getAverageAssignmentsGrade(Student student) {
		int assignment_total = 0;
		String gtid = student.getGtid();
		for (int d = 1; d < grades.getLastRowNum(); d++) {
			double check_gtid = grades.getRow(d).getCell(0).getNumericCellValue();
			if (gtid.equals(String.valueOf((int) Math.round(check_gtid)))) {

				for (int e = 1; e < grades.getRow(d).getLastCellNum(); e++) {

					double grade = grades.getRow(d).getCell(e).getNumericCellValue();
					assignment_total += grade;

				}
				break;
			}

		}

		int average_grade = assignment_total / (grades.getRow(0).getLastCellNum() - 1);
		return average_grade;
	}

	public int getAverageProjectsGrade(Student student) {
		// multiply each project grade by the individual grade (which is a
		// percentage)
		// for each project. Then take the average of all the grades.

		return average_projects_grade;
	}

	public void addGradesForAssignment(String assignmentName, HashMap<Student, Integer> grades2) {
		int assignIndex=0; 
		for ( int a = 1; a < grades.getRow(0).getLastCellNum(); a++){
			if(assignmentName.equals(grades.getRow(0).getCell(a).getStringCellValue())){
				assignIndex = a;
				break;
				
			}
			
		}
		
	
		for (int s = 1; s < grades.getLastRowNum(); s++){
			
			double gtid = grades.getRow(s).getCell(0).getNumericCellValue();
			
			Student student= new Student();
			student.setGtid(String.valueOf((int) Math.round(gtid)));
			if(grades2.containsKey(student)){
				int grade = grades2.get(student).intValue();
				grades.getRow(s).createCell(assignIndex).setCellValue(grade);
				
			}
		}
		
	}

}
