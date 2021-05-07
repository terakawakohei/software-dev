/*
 * 留学生クラス．学生クラスを継承している．
 */

public class InternationalStudent extends Student {

	/* 留学生用のフィールド */
	private String country; //出身国
	private boolean kokuhi; //国費かどうか

	/*
	 * デフォルトコンストラクタ．空の留学生を作成する．
	 */
	public InternationalStudent() {
		//コンストラクタでは，必ず最初に親クラスのコンストラクタを
		//呼び出してから，自前の前処理を書く．

		//↓super()は親クラスのデフォルト・コンストラクタを呼び出すという意味．
		super();

		//後は，特に何もしていない．
	}

	/*
	 * 引数付きコンストラクタ．
	 * Studentのコンストラクタを呼び出して，値をセットしている．
	 */
	public InternationalStudent(String id, String name, int credit,
			String country, boolean kokuhi) {

		//↓super(....) は親クラスの引数付きコンストラクタを呼び出すという意味．
		//Studentの引数付きコンストラクタに学版，名前，単位数を渡す．
		super(id, name, credit);

		//その後，留学生用のフィールドに出身国，国費・私費区分をセット．
		this.setCountry(country); //thisは省略可能
		this.setKokuhi(kokuhi); //thisは省略可能
	}

	/* (4) 留学生であること（出身国と国費・私費区分）を説明する． */
	public void explain() {
		System.out.print("私" + getName() + "は，" + country + "から来た");
		/*↑getName()は，親クラスのメソッド(nameのgetter)を呼び出している．
		 * super.getName()と書くこともできる．
		 * ※親クラスの属性 nameはprivateなので直接参照できない */

		if (kokuhi == true) {
			System.out.println("国費留学生です．");
		} else {
			System.out.println("私費留学生です．");
		}
	}

	/* (5) 留学生のあいさつの仕方 */
	@Override
	public void hello() {
		super.hello(); //普通の学生のあいさつの後に，
		this.explain(); //留学生の説明をする．
	}

	/* ----------------- 留学生用のsetter/getter ----------------------*/
	public String getCountry() {
		return country;
	}

	public boolean isKokuhi() {
		return kokuhi;
	}

	//↓setter．厳密には値チェックをしたいところ
	public void setCountry(String country) {
		this.country = country;
	}

	public void setKokuhi(boolean kokuhi) {
		this.kokuhi = kokuhi;
	}

	public int perseBool(boolean kokuhi) {
		if (kokuhi == true) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 学生区分を返す
	 */
	@Override
	public int showStudentClass() {
		return 1;
	}

	@Override
	public String toString() {
		return String.format("学籍番号:%s\t 氏名:%s\t 取得単位数:%4d\t 出身国:%s\t 国費である:%b", getId(), getName(), getCredit(),
				getCountry(), isKokuhi());
	}

	/**
	 * csvファイル書き出し用
	 */
	@Override
	public String toCSV() {
		//String.format() はSystem.out.printf()とほぼ同じだが文字列として返すメソッド．
		return String.format("%s,%s,%d,%d,%s,%d", getId(), getName(), getCredit(), showStudentClass(), getCountry(),
				perseBool(isKokuhi()));
	}

}