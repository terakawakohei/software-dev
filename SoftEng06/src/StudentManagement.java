public class StudentManagement {
	public StudentManagement() {

	}

	private StudentList list = new StudentList();
	private int command = -1;

	public void showMenu() {
		list.load();
		while (command != 0) {
			System.out.println("■ 学生のリストを管理します．コマンドを入れてください．");
			System.out
					.println("[1: リストを見る，2: 学生を見る，3:単位を修正する, 4:学生を追加する，5:学生を削除する，0:終了する] ");

			command = KeyBoard.inputNumber(); // キーボードから読み込み

			switch (command) {
			case 1:
				showAllStudents();
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
			case 0:
				System.out.println("終了します.");
				break;

			default: {
				System.out.println("上記の番号を入力してください");
				this.showMenu();
			}
			}
		}
	}

	public void showAllStudents() {

		System.out.println("生徒を全員表示します.");
		for (Student s : list.getAllStudents().values()) {
			System.out.println(s.getId() + "\t" + s.getName());
		}

	}

	public void showStudent() {

		System.out.println("生徒の詳細を表示します.");
		System.out.println("表示したい学生の学籍番号を入力してください. : ");
		String number = KeyBoard.inputString();
		System.out.println(list.getStudent(number));

	}

	public void updateCredit() {

		System.out.println("生徒の単位数を変更します.");
		System.out.println("単位数を編集したい学生の学籍番号を入力してください. : ");
		String id = KeyBoard.inputString();

		System.out.println("登録する単位の数を入力してください. : ");
		int credit = KeyBoard.inputNumber();

		if (list.updateCredit(id, credit)) {
			System.out.println(list.getStudent(id).getId() + "の生徒の単位数を" + list.getStudent(id).getCredit() + "に変更しました.");
		} else {
			System.out.println("登録できませんでした. ");
		}

		list.save();

	}

	public void addStudent() {

		System.out.println("新たに生徒を追加します.  ");
		System.out.println("学籍番号を入力してください. : ");
		String id = KeyBoard.inputString();

		System.out.println("氏名を入力してください. : ");
		String name = KeyBoard.inputString();

		System.out.println("取得単位数を入力してください. : ");
		int credit = KeyBoard.inputNumber();

		System.out.println("学生区分を入力してください. 0:通常学生, 1:留学生, 2:社会人学生 ");
		int select = KeyBoard.inputNumber();

		switch (select) {
		case 1:
			System.out.println("出身国を入力してください. : ");
			String country = KeyBoard.inputString();
			System.out.println("どちらかを入力してください	0:私費留学, 1:国費留学  ");
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
			System.out.println(is.getName() + "がリストに追加されました.");
			break;
		case 2:
			System.out.println("勤務先を入力してください. : ");
			String company = KeyBoard.inputString();
			WorkingStudent ws = new WorkingStudent(id, name, credit, company);
			list.addStudent(ws);
			System.out.println(ws.getName() + "がリストに追加されました.");

			break;
		case 0:
			Student s = new Student(id, name, credit);
			list.addStudent(s);
			System.out.println(s.getName() + "がリストに追加されました.");
			break;

		default: {
			System.out.println("上記の番号を入力してください");
			this.addStudent();
		}
		}

		list.save();

	}

	public void deleteStudent() {

		System.out.println("生徒を削除します.");
		System.out.println("学籍番号を入力してください.  : ");
		String id = KeyBoard.inputString();
		if (list.deleteStudent(id) == false) {//学籍番号が存在しない場合、falseを返す
			System.out.println("削除できませんでした.");
		}
		list.save();
	}

	public void setStudentList(StudentList studentList) {
		this.list = studentList;
	}
}
