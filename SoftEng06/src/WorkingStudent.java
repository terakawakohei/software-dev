
public class WorkingStudent extends Student{
	/* 社会人学生用のフィールド */
	private String company;  //勤務先


	/*
	 * デフォルトコンストラクタ．空の社会人学生を作成する．
	 */
	public WorkingStudent() {
		//コンストラクタでは，必ず最初に親クラスのコンストラクタを
		//呼び出してから，自前の前処理を書く．

		//↓super()は親クラスのデフォルト・コンストラクタを呼び出すという意味．
		super();

		//後は，特に何もしていない．
	}

	public WorkingStudent(String id, String name, int credit,
			String company) {

		//↓super(....) は親クラスの引数付きコンストラクタを呼び出すという意味．
		//Studentの引数付きコンストラクタに学版，名前，単位数を渡す．
		super(id, name, credit);

		//その後，社会人学生用のフィールドに勤務先をセット
		this.setCompany(company); //thisは省略可能

	}


	/* (4) 社会人学生であることを説明する． */
	public void explain() {
		System.out.print("私" + getName() + "は，" + company + "勤務の");
		/*↑getName()は，親クラスのメソッド(nameのgetter)を呼び出している．
		 * super.getName()と書くこともできる．
		 * ※親クラスの属性 nameはprivateなので直接参照できない */
		System.out.println("社会人学生です．");
	}
	/* (5) 社会人学生のあいさつの仕方 */
	@Override
	public void hello() {
		super.hello(); //普通の学生のあいさつの後に，
		this.explain(); //留学生の説明をする．
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 学生区分を返す
	 */
	@Override
	public int showStudentClass() {
		return 2;
	}

	@Override
	public String toString() {
		return String.format("学籍番号:%s\t 氏名:%s\t 取得単位数:%4d\t 勤務先:%s", getId(), getName(), getCredit(),getCompany());
	}
	/**
	 * csvファイル書き出し用
	 */
	@Override
	public String toCSV() {
		//String.format() はSystem.out.printf()とほぼ同じだが文字列として返すメソッド．
		return String.format("%s,%s,%d,%d,%s,", getId(), getName(), getCredit(),showStudentClass(),getCompany() );
	}



}
