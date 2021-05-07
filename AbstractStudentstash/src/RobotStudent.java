
public class RobotStudent extends Student{
	/* 社会人学生用のフィールド */
	private String vendor;  //開発元
	private String algorithm;


	/*
	 * デフォルトコンストラクタ．空の社会人学生を作成する．
	 */
	public RobotStudent() {
		//コンストラクタでは，必ず最初に親クラスのコンストラクタを
		//呼び出してから，自前の前処理を書く．

		//↓super()は親クラスのデフォルト・コンストラクタを呼び出すという意味．
		super();

		//後は，特に何もしていない．
	}

	public RobotStudent(String id, String name, int credit,
			String vendor,String algorithm) {

		//↓super(....) は親クラスの引数付きコンストラクタを呼び出すという意味．
		//Studentの引数付きコンストラクタに学版，名前，単位数を渡す．
		super(id, name, credit);


		this.setVendor(vendor); //thisは省略可能
		this.setAlgorithm(algorithm); //thisは省略可能

	}


	/* (4) 社会人学生であることを説明する． */
	@Override
	public void explain() {
		System.out.println("私" + getName() + "は，" + vendor + "製のロボット学生です."+algorithm+"で動いています.");
		/*↑getName()は，親クラスのメソッド(nameのgetter)を呼び出している．
		 * super.getName()と書くこともできる．
		 * ※親クラスの属性 nameはprivateなので直接参照できない */

	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}







}
