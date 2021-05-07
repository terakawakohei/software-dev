package se.t1835039.student.entity;

/**
 * 社会人学生を表すクラス.勤務先を持つ.
 * @author Kohei Terakawa
 *
 */
public class WorkingStudent extends Student {
	/**勤務先*/
	private String company;

	/**
	 * 空の社会人学生インスタンスを作成
	 */

	public WorkingStudent() {
		super();

	}

	/**
	 * 学籍番号，名前，単位数、勤務先を指定して，社会人学生インスタンスを生成する．
	 * @param id 学籍番号
	 * @param name　名前
	 * @param credit　単位数
	 * @param company　勤務先
	 */
	public WorkingStudent(String id, String name, int credit,
			String company) {

		super(id, name, credit);

		this.setCompany(company);

	}

	/**
	 *社会人学生であることを説明
	 */
	@Override
	public void explain() {
		System.out.print("私" + getName() + "は，" + company + "に勤務する");
		/*↑getName()は，親クラスのメソッド(nameのgetter)を呼び出している．
		 * super.getName()と書くこともできる．
		 * ※親クラスの属性 nameはprivateなので直接参照できない */
		System.out.println("社会人学生です．");
	}

	/**
	 * 勤務先を取得する
	 * @return 勤務先
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 勤務先をセットする
	 * @param company　勤務先
	 */
	public void setCompany(String company) {
		this.company = company;
	}

}
