package se.nakamura.student.entity;

/**
 * 「学生たるもの」を表す抽象クラス．学番，名前，単位数を持つ．あらゆる種類の学生はこのクラスを継承すること．
 *
 * @author Masahide Nakamura
 * @version 0.1, 2018-05-01
 * @since JDK1.8
 * @see http;//www27.cs.kobe-u.ac.jp/~masa-n/lecure/newse/07/index.html
 */
public abstract class Student {
	/** 学籍番号 */
	protected String id;
	/** 名前 */
	protected String name;
	/** 単位数 */
	protected int credit;
	/** 卒業要件単位数 */
	private static final int REQUIREMENT_OF_GRADUATION = 130;

	/**
	 * 空の学生インスタンスを作る
	 */
	public Student() {

	}

	/**
	 * 学籍番号，名前，単位数を指定して，学生インスタンスを生成する．
	 *
	 * @param id
	 *            学籍番号
	 * @param name
	 *            名前
	 * @param credit
	 *            単位数
	 */
	public Student(String id, String name, int credit) {
		// 無効な値に備えて，setterを呼び出す．
		this.setId(id);
		this.setName(name);
		this.setCredit(credit);
	}

	/**
	 * 自己紹介をする
	 */
	public void hello() {
		System.out.println("こんにちは．学籍番号" + id + "の" + name + "です．" + "よろしくお願いします．");
		this.explain();
	}

	/**
	 * 卒業報告をする
	 */
	public void graduate() {
		System.out.print(name + "の単位数は，" + credit + "です．");
		if (credit >= REQUIREMENT_OF_GRADUATION) {
			System.out.println("卒業要件を超えているので，卒業できます．");
		} else {
			System.out.println("卒業要件に足りないので，卒業できません．");
		}
	}

	/**
	 * 単位数を追加する
	 *
	 * @param amount
	 *            追加する単位数
	 */
	public void addCredit(int amount) {
		System.out.println(name + "の単位数を " + amount + "追加します．");
		credit = credit + amount;
	}

	/**
	 * 学生の身分を説明する抽象メソッド．具体的な実装はサブクラスに任せる．
	 */
	public abstract void explain();

	/**
	 * 卒業要件単位数を取得する
	 *
	 * @return 卒業要件単位数
	 */
	public static int getRequirementOfGraduation() {
		return REQUIREMENT_OF_GRADUATION;
	}

	/**
	 * 学籍番号を取得する
	 *
	 * @return 学籍番号
	 */
	public String getId() {
		return id;
	}

	/**
	 * 学籍番号をセットする．空文字列の場合には，"99999999X"をセットする
	 *
	 * @param id
	 *            学籍番号
	 */
	public void setId(String id) {
		if (id.equals("") || id == null) {
			System.out.println("無効なIDです．99999999Xをセットします．");
			this.id = "99999999X";
		} else {
			this.id = id;
		}
	}

	/**
	 * 名前を取得する
	 *
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名前をセットする．空文字列の場合には，"名無し"をセットする．
	 *
	 * @param name
	 *            名前
	 */
	public void setName(String name) {
		if (name.equals("") || name == null) {
			System.out.println("無効な名前です．「名無し」をセットします．");
			this.name = "名無し";
		} else {
			this.name = name;
		}
	}

	/**
	 * 単位数を取得する
	 *
	 * @return 単位数
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * 単位数をセットする．負の場合は0に補正する．
	 *
	 * @param credit
	 *            単位数
	 */
	public void setCredit(int credit) {
		if (credit < 0) {
			System.out.println("負の単位数は認められません．0にセットします．");
			this.credit = 0;
		} else {
			this.credit = credit;
		}
	}

	/**
	 * 学生の文字列表現を返す抽象メソッド．具体的な実装はサブクラスに任せる．
	 */
	public abstract String toString();

}