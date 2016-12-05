# Grades-calculator

###Agile Project: Grades Calculaftor (D3)

###Background:	
For this project, you must develop a simple tool called GradesCalculator. Given a database with various data about the students in a class, GradesCalculator allows the instructors to get information about the students and compute their final grade. You will develop the GradesCalculator application by following a test-driven development approach such as the one we saw in P4L4, in which development happens in iterations and according to the following cycle: (1) select story cards to implement, (2) define task cards for the selected story cards, (3) write test cases for the classes in the task cards, (4) write code that makes the test cases pass. Specifically, this project will consist of three deliverables.


###Goals:	
Develop a Java application for assessing students information and compute  students’ final grades.
Get experience with an agile, test-driven process.

###Story and Task Cards:
####Story Card #1 (revised): 
“The instructor/TA launches the GradesCalculator tool to get information about the students and the class. In this scenario, the application allows the user to output, for a given student, its average assignments grade, average projects grade, and overall grade based on a user-provided formula.”

####Story Card #2 (new):
“The instructor/TA launches the GradesCalculator tool in editing mode to enter information about the class. In particular, the application allows its users to add students, assignment, and projects, and to add/update grades and individual contribution grades.”

####Task Card #1.1 (old):
Develop a Student class that holds the information about a student, such as name and GT ID.

####Task Card #1.2 (old):
Develop a Students class that is able to access the database with the students information. Add to the class methods to extract and make available the relevant data in the students database.

####Task Card #1.3 (old):
Develop a Grades class that is able to access the database with the grades information. Add to the class methods to extract and make available the relevant data in the grades database.

####Task Card #1.4 (old): 
Develop a Course class that is able to access both the students and grades data through the corresponding classes. The Course class shall be the interface between the GradesCalculator tool and the underlying databases.

####Task Task Card #1.5 (new):
Extend the Course class so that it provides a way to compute the average assignments grade.

####Task Card #1.6 (new):
Extend the Course class so that it provides a way to compute the average projects grade, taking into account the individual contribution grades.

####Task Card #1.7 (new):
Add to class Course two methods, one to get the overall grade for a student, and the other to set the (user defined) formula to be used for computing the grade:
  public int getOverallGrade(Student student)
  public void setFormula(String formula)
* The formula’s format is:
  - Operands:
    AT (attendance)
    AA (average assignments grade)
    AP (average projects grade)
  - Operators:
    +, -, *, /, with their obvious meaning
* The default formula, if none is set by the user, should be the following:
  “AT * 0.2 + AA * 0.4 + AP * 0.4”
* Method getOverallGrade should throw a GradeFormulaException
 (provided) in case of malformed formulas.
 
####Task Card #2.1 (new):
Extend the Course class so that it provides a way to add an assignment.

####Task Card #2.2 (new): 
Extend the Course class so that it provides a way to add/update grades for an assignment (if there is already a grade value, the value gets suitably updated with the new one).

####Task Card #2.3 (new):
Extend the Course class so that it provides a way to add/update individual contribution grades (if there is already an individual contribution value, the value gets suitably updated with the new one).
