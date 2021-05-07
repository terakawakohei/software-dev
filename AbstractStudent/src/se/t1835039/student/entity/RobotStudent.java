package se.t1835039.student.entity;

/**
 * ロボット学生を表すクラス.開発元、アルゴリズムを持つ.
 * @author Kohei Terakawa
 *
 */
public class RobotStudent extends Student {

	/**開発元 */
	private String vendor;
	/** 動かしているアルゴリズム*/
	private String algorithm;

	/**
	 * 空のロボット学生インスタンスを作成する
	 */
	public RobotStudent() {

		super();

	}

	/**
	 * 学籍番号，名前，単位数、開発元、アルゴリズムを指定して，ロボット学生インスタンスを生成する．
	 * @param id　学籍番号
	 * @param name　名前
	 * @param credit　単位数
	 * @param vendor　開発元
	 * @param algorithm　アルゴリズム
	 */
	public RobotStudent(String id, String name, int credit,
			String vendor, String algorithm) {

		super(id, name, credit);

		this.setVendor(vendor);
		this.setAlgorithm(algorithm);

	}

	/**
	 *ロボット学生であることを説明する
	 */
	@Override
	public void explain() {
		System.out.println("私" + getName() + "は，" + vendor + "製のロボット学生です." + algorithm + "で動いています.");
		/*↑getName()は，親クラスのメソッド(nameのgetter)を呼び出している．
		 * super.getName()と書くこともできる．
		 * ※親クラスの属性 nameはprivateなので直接参照できない */

	}

	/**
	 * 開発元を取得する
	 *
	 * @return 開発元
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * 開発元をセットする
	 *
	 * @param vendor　開発元
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * アルゴリズムを取得する
	 *
	 * @return アルゴリズム
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * アルゴリズムをセットする
	 *
	 * @param algorithm　アルゴリズム
	 */
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

}
