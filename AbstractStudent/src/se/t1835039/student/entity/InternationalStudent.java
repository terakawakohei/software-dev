package se.t1835039.student.entity;

/**
 * 留学生を表すクラス.出身国、国費留学かどうかの真偽値を持つ.
 * @author odayakalife
 *
 */
public class InternationalStudent extends Student {

	/**出身国*/
	private String country;
	/**国費での留学かどうか*/
	private boolean kokuhi;

	/**
	 * 空の留学生インスタンスを生成する
	 */
	public InternationalStudent() {
		super();

	}

	/**
	 * 学籍番号，名前，単位数、出身国、国費留学生かどうかの真偽値を指定して，留学生インスタンスを生成する．
	 * @param id 学籍番号
	 * @param name　名前
	 * @param credit　単位数
	 * @param country　出身国
	 * @param kokuhi　国費留学かどうか
	 */
	public InternationalStudent(String id, String name, int credit,
			String country, boolean kokuhi) {

		super(id, name, credit);

		this.setCountry(country);
		this.setKokuhi(kokuhi);
	}

	/**
	 *留学生であることを説明する
	 */
	@Override
	public void explain() {
		System.out.print("私" + getName() + "は，" + country + "から来た");

		if (kokuhi == true) {
			System.out.println("国費留学生です．");
		} else {
			System.out.println("私費留学生です．");
		}
	}

	/**
	 * 出身国を取得する
	 *
	 * @return　出身国
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 国費留学かどうかの真偽値を取得する
	 *
	 * @return　国費留学かどうかの真偽値
	 */
	public boolean isKokuhi() {
		return kokuhi;
	}

	/**
	 * 出身国をセットする
	 *
	 * @param country　出身国
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 国費留学かどうかの真偽値をセットする
	 *
	 * @param kokuhi　国費留学かどうかの真偽値
	 */
	public void setKokuhi(boolean kokuhi) {
		this.kokuhi = kokuhi;
	}

	/**
	 * boooleanをintにパースする
	 *
	 * @param kokuhi　国費留学生かどうかの真偽値
	 * @return　真偽値を0か1で表現したもの
	 */
	public int perseBool(boolean kokuhi) {
		if (kokuhi == true) {
			return 1;
		} else {
			return 0;
		}
	}

}