/**
 * 学生クラス．学番，名前，単位数を持つ
 */
public class Student {
	/*------ 学生の状態を決めるフィールド群 -----*/
	String id; // 学籍番号
	String name; // 名前
	int credit; // 単位数

	/* 静的フィールド．全インスタンスで共通．finalは代入不可能にする修飾子 */
	static final int REQUIREMENT_OF_GRADUATION = 130; // 卒業要件単位数（定数）

	/**
	 * デフォルトコンストラクタ．空の学生インスタンスを生成する
	 */
	public Student() {

	}

	/**
	 * コンストラクタ．学番，名前，単位数を指定して，学生インスタンスを生成する．
	 */
	public Student(String id, String name, int credit) {
		this.id = id;
		this.name = name;
		this.credit = credit;
	}

	/*------------------ 主要な学生の振る舞い ---------------------*/
	/** (1) 自己紹介をする */
	public void hello() {
		System.out.println("こんにちは．学籍番号" + id + "の" + name + "です．"
				+ "よろしくお願いします．");
	}

	/** (2) 卒業報告をする */
	public void graduate() {
		System.out.print(name + "の単位数は，" + credit + "です．");
		if (credit >= REQUIREMENT_OF_GRADUATION) {
			System.out.println("卒業要件を超えているので，卒業できます．");
		} else {
			System.out.println("卒業要件に足りないので，卒業できません．");
		}
	}

	/** (3) 単位数を追加する */
	public void addCredit(int amount) {
		System.out.println(name + "の単位数を " + amount + "追加します．");
		credit = credit + amount;
	}

	/** 卒業要件数を取得する (静的メソッド)*/
	public static int getRequirement() {
		return REQUIREMENT_OF_GRADUATION;
	}

}