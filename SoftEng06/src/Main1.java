import java.util.ArrayList;

public class Main1 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();

		Student s1 = new Student("1842957T", "寺川", 144);
		Student s2 = new Student("1812945A", "西田", 40);
		Student s3 = new Student("1889653A", "荒巻", 79);

		InternationalStudent is1 = new InternationalStudent("1894332T", "john", 79, "イギリス", true);
		InternationalStudent is2 = new InternationalStudent("1877812T", "lee", 140, "韓国", false);

		WorkingStudent ws1 = new WorkingStudent("1844658T", "佐藤", 101, "中村建築");

		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(is1);
		list.add(is2);
		list.add(ws1);

		// まとめて表示してみる
		for (Student s : list) {

			s.hello();
			s.addCredit(2);
			s.graduate();

		}

		System.out.println("-----------------------");

		for (Student s : list) {
			s.hello();

		}
	}

}
