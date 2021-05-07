package se.t999999.student.app;

import se.t1835039.student.entity.InternationalStudent;
import se.t1835039.student.entity.RegularStudent;
import se.t1835039.student.entity.RobotStudent;
import se.t1835039.student.entity.Student;
import se.t1835039.student.entity.WorkingStudent;
import se.t1835039.student.util.KeyBoard;

public class StudentManagement {
	public StudentManagement() {

	}

	private StudentList list = new StudentList();
	private int command = -1;

	public void showMenu() {
		list.load();
		while (command != 6) {
			System.out.println("■ 学生のリストを管理します．コマンドを入れてください．");
			System.out
					.println("[1: リストを見る，2: 学生を見る，3:単位を修正する, 4:学生を追加する，5:学生を削除する，6:終了する] ");
			System.out.print("(ユーザ入力) : ");

			command = KeyBoard.inputNumber(); // キーボードから読み込み

			switch (command) {
			case 1:
				showStudentList();
				break;
			case 2:
				showStudent();
				break;
			case 3:
				updateCredit();

				break;
			case 4:
				addStudent();

				break;
			case 5:
				deleteStudent();
				break;
			case 6:
				System.out.println("終了します.");
				break;

			default: {
				System.out.println("上記の番号を入力してください");
				this.showMenu();
			}
			}
		}
	}

	public void showStudentList() {

		System.out.println("[リスト]全学生を表示します.");
		System.out.println("----------------------------------------------------------");
		System.out.println("学籍番号\t\t名前\t\t\t単位数\t\t学生種類");
		System.out.println("----------------------------------------------------------");
		for (Student s : list.getAllStudents().values()) {
			System.out.println(s.getId() + "\t" + s.getName() + "\t\t" + s.getCredit() + "単位\t\t"
					+ this.showStudentClassString(s));
		}

	}

	public void showStudent() {

		System.out.println("[照会] 学生の情報を見ます.");
		System.out.print("学籍番号: ");
		String id = KeyBoard.inputString();
		Student s = list.getStudent(id);

		System.out.println("----------------------------------------------------------");
		System.out.println("学籍番号 : " + id);
		System.out.println("氏名 : " + s.getName());
		System.out.println("取得単位 : " + s.getCredit());
		System.out.println("学生区分 : " + this.showStudentClassString(s));
		if (s instanceof InternationalStudent) { //留学生の時，
			InternationalStudent is = (InternationalStudent) s;
			System.out.println("出身国 : " + is.getCountry());
			System.out.println("国費留学である : " + is.isKokuhi());
		} else if (s instanceof WorkingStudent) { //社会人学生の時，
			WorkingStudent ws = (WorkingStudent) s;
			System.out.println("勤務先 : " + ws.getCompany());

		} else if (s instanceof RobotStudent) { //ロボット学生の時，
			RobotStudent rs = (RobotStudent) s;
			System.out.println("ベンダ : " + rs.getVendor());
			System.out.println("アルゴリズム : " + rs.getAlgorithm());

		}
		System.out.println("----------------------------------------------------------");

	}

	public void updateCredit() {

		System.out.println("[単位修正]学生の単位数を修正します.");
		System.out.print("学籍番号: ");
		String id = KeyBoard.inputString();
		Student s = list.getStudent(id);
		System.out.println("[変更前]" + id + "\t\t" + s.getName() + "\t\t\t" + s.getCredit() + "\t\t"
				+ this.showStudentClassString(s));

		System.out.print("修正単位数（-1:やめる）:");
		int credit = KeyBoard.inputNumber();

		if (credit == -1) {
			this.showMenu();
		}

		if (list.updateCredit(id, credit)) {
			System.out.println("単位を修正しました.");
			System.out.print("[変更後]" + id + "\t\t" + s.getName() + "\t\t\t" + s.getCredit() + "\t\t"
					+ this.showStudentClassString(s));
			list.save();
		} else {
			System.out.println("登録できませんでした. ");
		}

	}

	public void addStudent() {

		System.out.println("[追加] 学生を追加します.");
		System.out.print("学籍番号 : ");
		String id = KeyBoard.inputString();

		System.out.print("名前 : ");
		String name = KeyBoard.inputString();

		System.out.print("単位数 : ");
		int credit = KeyBoard.inputNumber();

		System.out.print("学生種別 ( 0:通常学生, 1:留学生, 2:社会人学生,3:ロボット学生 ) :");
		int select = KeyBoard.inputNumber();

		switch (select) {
		case 1:
			System.out.print("出身国 : ");
			String country = KeyBoard.inputString();
			System.out.print("どちらかを入力してください	0:私費留学, 1:国費留学  :");
			int iskokuhiNum = KeyBoard.inputNumber();
			if (iskokuhiNum != 1 && iskokuhiNum != 0) {
				System.out.println("上記の番号を入力してください");
				this.addStudent();
			}
			boolean iskokuhi;
			if (iskokuhiNum == 1) {
				iskokuhi = true;
			} else {
				iskokuhi = false;
			}

			InternationalStudent is = new InternationalStudent(id, name, credit, country, iskokuhi);
			list.addStudent(is);
			System.out.println(is.getName() + "さんを留学生として登録しました.");
			break;
		case 2:
			System.out.println("勤務先を入力してください. : ");
			String company = KeyBoard.inputString();
			WorkingStudent ws = new WorkingStudent(id, name, credit, company);
			list.addStudent(ws);
			System.out.println(ws.getName() + "さんを社会人学生として登録しました.");

			break;
		case 3:
			System.out.println("ベンダーを入力してください. : ");
			String vendor = KeyBoard.inputString();
			System.out.println("アルゴリズムを入力してください. : ");
			String algorithm = KeyBoard.inputString();
			RobotStudent rs = new RobotStudent(id, name, credit, vendor, algorithm);
			list.addStudent(rs);
			System.out.println(rs.getName() + "さんをロボット学生として登録しました.");

			break;
		case 0:
			RegularStudent s = new RegularStudent(id, name, credit);
			list.addStudent(s);
			System.out.println(s.getName() + "さんを正規学生として登録しました.");
			break;

		default: {
			System.out.println("上記の番号を入力してください");
			this.addStudent();
		}
		}
		list.save();

	}

	public void deleteStudent() {

		System.out.println("[削除]学生を削除します.");
		System.out.print("学籍番号 : ");
		String id = KeyBoard.inputString();
		Student s = list.getStudent(id);

		System.out.println("----------------------------------------------------------");
		System.out.println("学籍番号 : " + id);
		System.out.println("氏名 : " + s.getName());
		System.out.println("取得単位 : " + s.getCredit());
		System.out.println("学生区分 : " + this.showStudentClassString(s));
		if (s instanceof InternationalStudent) { //留学生の時，
			InternationalStudent is = (InternationalStudent) s;
			System.out.println("出身国 : " + is.getCountry());
			System.out.println("国費留学である : " + is.isKokuhi());
		} else if (s instanceof WorkingStudent) { //社会人学生の時，
			WorkingStudent ws = (WorkingStudent) s;
			System.out.println("勤務先 : " + ws.getCompany());

		} else if (s instanceof RobotStudent) { //ロボット学生の時，
			RobotStudent rs = (RobotStudent) s;
			System.out.println("ベンダ : " + rs.getVendor());
			System.out.println("アルゴリズム : " + rs.getAlgorithm());

		}
		System.out.println("----------------------------------------------------------");

		System.out.print("この学生を削除しますか？ (0 : いいえ / 1 : はい) :");
		int select = KeyBoard.inputNumber();

		if (select == 1) {
			if (list.deleteStudent(id) == false) {//学籍番号が存在しない場合、falseを返す
				System.out.println("削除できませんでした.");
				return;
			}
			System.out.println(s.getName() + "さんを削除しました.");
		} else if (select == 0) {
			return;//メニューへ戻る
		} else if (select != 1 && select != 0) {
			System.out.println("0か1を入力してください.");
			return;
		}

		list.save();

	}

	public String showStudentClassString(Student s) {

		String result;

		if (s instanceof RegularStudent) { //正規学生の時
			result = "正規学生";
			return result;
		} else if (s instanceof InternationalStudent) { //留学生の時，
			InternationalStudent is = (InternationalStudent) s;
			String iskokuhi;
			if (is.isKokuhi()) {
				iskokuhi = "国費";
			} else {
				iskokuhi = "私費";
			}
			result = "留学生\t(" + is.getCountry() + "," + iskokuhi + ")";
			return result;
		} else if (s instanceof WorkingStudent) { //社会人学生の時，
			WorkingStudent ws = (WorkingStudent) s;
			result = "社会人学生\t(" + ws.getCompany() + ")";
			return result;
		} else if (s instanceof RobotStudent) { //ロボット学生の時，
			RobotStudent rs = (RobotStudent) s;
			result = "ロボット学生\t(" + rs.getVendor() + "," + rs.getAlgorithm() + ")";
			return result;
		}

		return "該当なし";

	}

	public void setStudentList(StudentList studentList) {
		this.list = studentList;
	}
}
