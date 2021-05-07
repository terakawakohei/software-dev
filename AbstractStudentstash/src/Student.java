/**
 * 学生クラス．学番，名前，単位数を持つ．カプセル化後
 */
public abstract class Student {
	/*------ 学生の状態を決めるフィールド群 -----*/
	//フィールドはprivateにする．
	protected String id; // 学籍番号
	protected String name; // 名前
	protected int credit; // 単位数

	/* 静的フィールド．全インスタンスで共通 */
	private static final int REQUIREMENT_OF_GRADUATION = 130; // 卒業要件単位数

	/**
	 * デフォルトコンストラクタ．空の学生オブジェクトを作る
	 */
	public Student() {

	}

	/**
	 * コンストラクタ．学番，名前，単位数を指定して，学生インスタンスを生成する．
	 */
	public Student(String id, String name, int credit) {
		//無効な値に備えて，setterを呼び出す．
		this.setId(id);
		this.setName(name);
		this.setCredit(credit);
	}

	/*------------------ 主要な学生の振る舞い ---------------------*/
	/** (1) 自己紹介をする */
	public final void hello() {
		System.out.println("こんにちは．学籍番号" + id + "の" + name + "です．"
				+ "よろしくお願いします．");
		explain();
	}

	/** (2) 卒業報告をする */
	public final void graduate() {
		System.out.print(name + "の単位数は，" + credit + "です．");
		if (credit >= REQUIREMENT_OF_GRADUATION) {
			System.out.println("卒業要件を超えているので，卒業できます．");
		} else {
			System.out.println("卒業要件に足りないので，卒業できません．");
		}
	}

	/** (3) 単位数を追加する */
	public final void addCredit(int amount) {
		System.out.println(name + "の単位数を " + amount + "追加します．");
		credit = credit + amount;
	}
	/** (4) 【抽象メソッド】自分の身分を説明する */
	public abstract void explain(); //定義は子クラスに任せる

	/* --------------- 以下，アクセサ (getter/setter)-----------*/

	/**
	 * 卒業要件単位数を取得する（getterの命名法に伴って，メソッド名変更）
	 * (REQUIREMENT_OF_GRADUATIONのgetter)
	 */
	public static int getRequirementOfGraduation() {
		return REQUIREMENT_OF_GRADUATION;
	}


	/**
	 * 学籍番号を取得する．
	 * (フィールドidのgetter)
	 */
	public String getId() {
		return id;
	}

	/**
	 * 学籍番号をセットする．空文字列の場合には，"99999999X"をセットする．
	 * (フィールドidのsetter)
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
	 * 名前を取得する(フィールドnameのgetter)
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名前をセットする．空文字列の場合には，"名無し"をセットする．
	 * (フィールドnameのsetter)
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
	 * 単位数を取得する（フィールドcreditのgetter）
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * 単位数をセットする．負の場合は0に補正する．
	 */
	public void setCredit(int credit) {
		if (credit < 0 ) {
			System.out.println("負の単位数は認められません．0にセットします．");
			this.credit = 0;
		} else {
			this.credit = credit;
		}
	}


	/**
	 * 文字列表現． "12345678X(タブ)中村(タブ)146単位"のような感じで表現する
	 */
	@Override
	public String toString() {
		//String.format() はSystem.out.printf()とほぼ同じだが文字列として返すメソッド．
		return String.format("%s\t%s\t%4d単位", getId(), getName(), getCredit());
	}

}