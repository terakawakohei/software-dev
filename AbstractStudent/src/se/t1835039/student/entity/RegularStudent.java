package se.t1835039.student.entity;

/**
 * 正規の学生を表すクラス.
 * @author Kohei Terakawa
 *
 */
public class RegularStudent extends Student {

	/**
	 * 空の正規学生インスタンスを生成する
	 */
	public RegularStudent() {
		super();
	}

	/**
	 * 学籍番号，名前，単位数を指定して，正規学生インスタンスを生成する．
	 * @param id　学籍番号
	 * @param name　名前
	 * @param credit　単位数
	 */
	public RegularStudent(String id, String name, int credit) {
		super(id, name, credit);
	}

	/**
	 *正規の学生であることを説明する
	 */
	@Override
	public void explain() {
		System.out.println("私" + getName() + "は，正規の学生です．");
	}

}
