package se.t999999.student.app;

import java.util.TreeMap;

import se.t1835039.student.entity.Student;
import se.t1835039.student.util.StudentMapFactory;

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
		StudentMapFactory.store(students, fileName);

	}

}
