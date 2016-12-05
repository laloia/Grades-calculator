package edu.gatech.seclass.gradescalculator;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Students {

	private XSSFSheet studentsInfo;
	private XSSFSheet teams;
	

	public Students(String excelPath) {

		try {
			File src = new File(excelPath);

			FileInputStream fis = new FileInputStream(src);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			studentsInfo = wb.getSheet("StudentsInfo");
			teams = wb.getSheet("Teams");
			

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	public int getLastRowNum() {
		int num = studentsInfo.getLastRowNum();
		return num;
	}

	public HashSet<Student> getAllStudents() {
		HashSet<Student> studentsSet = new HashSet<Student>();
		int rowcount = studentsInfo.getLastRowNum() + 1;

		for (int i = 1; i < rowcount; i++) {
			String name = studentsInfo.getRow(i).getCell(0).getStringCellValue();
			double id = studentsInfo.getRow(i).getCell(1).getNumericCellValue();
			String email= studentsInfo.getRow(i).getCell(2).getStringCellValue();
			Student student = new Student();
			student.setName(name);
			student.setGtid(String.valueOf((int)Math.round(id)));
			student.setEmail(email);

			// find team

			int teamCount = teams.getLastRowNum();
			String team = null;

			for (int y = 1; y < teamCount; y++) {
				for (int x = 1; x < 4; x++) {
					if (id == teams.getRow(y).getCell(x).getNumericCellValue()) {
						team = teams.getRow(y).getCell(0).getStringCellValue();
						break;

					}
				}
			}
			student.setTeam(team);

		
			studentsSet.add(student);

		}

		return studentsSet;

	}

	public Student getStudentbyName(String name) {

		HashSet<Student> studentSet = getAllStudents();

		for (Iterator<Student> studentIter = studentSet.iterator(); studentIter.hasNext();) {
			Student student = studentIter.next();
			if (student.getName().equals(name)) {
				return student;

			}
		}
		return null;

	}

	public Student getStudentbyID(String gtid) {
		HashSet<Student> studentSet = getAllStudents();

		for (Iterator<Student> studentIter = studentSet.iterator(); studentIter.hasNext();) {
			Student student = studentIter.next();
			if (student.getGtid().equals(gtid)) {
				return student;

			}
		}
		return null;

	}
}
