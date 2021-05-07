import java.util.TreeMap;

public class Main2 {
	public static void main(String[] args) {
		//student_list.csvからマップを構築する
		TreeMap<String, Student> students = StudentMapFactory.create("student_list.csv");
		//マップのキー（学籍番号id)のそれぞれから
		for (String id : students.keySet()) {
			Student s = students.get(id); //学生を取り出し，
			System.out.println(s); //表示してみる
		}
	}
}
