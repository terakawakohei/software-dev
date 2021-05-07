package se.t999999.student.app;

public class Main {

	public static void main(String[] args) throws Exception {
		StudentManagement sm = new StudentManagement();
		StudentList sl = new StudentList("student_list2.csv");

		sm.setStudentList(sl);
		sm.showMenu();

	}

}
