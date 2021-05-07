import se.t1835039.student.entity.InternationalStudent;
import se.t1835039.student.entity.RegularStudent;
import se.t1835039.student.entity.RobotStudent;
import se.t1835039.student.entity.Student;
import se.t1835039.student.entity.WorkingStudent;

public class Main {
	public static void main(String[] args) {


		Student s1 = new RegularStudent("1842957T", "寺川", 144);
		Student s2 = new InternationalStudent("1812945A", "リー", 90,"中国",true);
		Student s3 = new WorkingStudent("1889653A", "荒巻", 79,"日本生命");
		Student s4 = new RobotStudent("1889653A", "ジョーチェック", 112,"デンソー","ニューラルネット");

		System.out.println("-----------------------");
		System.out.println("○自己紹介をします");
		s1.hello();
		s2.hello();
		s3.hello();
		s4.hello();
		System.out.println("-----------------------");
		System.out.println("○卒業要件を確認します");
		s1.graduate();
		s2.graduate();
		s3.graduate();
		s4.graduate();
		System.out.println("-----------------------");
		System.out.println("○50単位足します");
		s1.addCredit(50);
		s2.addCredit(50);
		s3.addCredit(50);
		s4.addCredit(50);
		System.out.println("-----------------------");
		System.out.println("○卒業要件を確認します");
		s1.graduate();
		s2.graduate();
		s3.graduate();
		s4.graduate();


		}
	}

