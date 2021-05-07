
public class Main {

	public static void main(String[] args) {
		StudentList sl = new StudentList("student_list.csv");
		StudentManagement sm = new StudentManagement();
		sm.setStudentList(sl);
		sm.showMenu();

	}
}