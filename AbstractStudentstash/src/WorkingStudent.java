
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
	@Override
	public void explain() {
		System.out.print("私" + getName() + "は，" + company + "に勤務する");
		/*↑getName()は，親クラスのメソッド(nameのgetter)を呼び出している．
		 * super.getName()と書くこともできる．
		 * ※親クラスの属性 nameはprivateなので直接参照できない */
		System.out.println("社会人学生です．");
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}





}
