import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class StudentList {
	private TreeMap<String, Student> students = new TreeMap<String, Student>();
	private String fileName;

	public StudentList() {

	}

	public StudentList(String fileName) {
		this.fileName = fileName;
	}

	public void addStudent(Student student) {
		this.students.put(student.getId(), student);
	}

	public Student getStudent(String id) {
		return students.get(id);
	}

	public TreeMap<String, Student> getAllStudents() {
		return this.students;
	}

	public boolean deleteStudent(String id) {//学籍番号が存在しない場合、falseを返す
		if (this.students.containsKey(id)) {
			this.students.remove(id);
			return true;
		}
		return false;
	}

	public boolean updateCredit(String id, int credit) {//学籍番号が存在しない場合、falseを返す
		if (this.students.containsKey(id)) {
			students.get(id).setCredit(credit);
			return true;
		}
		return false;
	}

	public void load() {
		this.students = StudentMapFactory.create(fileName);

	}

	public void save() {

		try {

			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

			for (Student s : students.values()) {
				pw.println(s.toCSV());

			}

			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
