/**
 * 学生クラス．学番，名前，単位数を持つ
 */
public class Person {
	/*------ 人物の状態を決めるフィールド群 -----*/
	String name; // 名前
	String birthday; // 誕生日
	double height; // 身長
	double weight; // 体重

	/* 静的フィールド．全インスタンスで共通．finalは代入不可能にする修飾子 */
	static int numberOfPersons=0; // 人数を記録

	/**
	 * デフォルトコンストラクタ．空のPersonインスタンスを生成する
	 */
	public Person() {

	}

	/**
	 * コンストラクタ．学番，名前，単位数を指定して，Personインスタンスを生成する．
	 */
	public Person(String name, String birthday, double height,double weight) {
		this.name = name;
		this.birthday = birthday;
		this.height = height;
		this.weight = weight;
		numberOfPersons++;
	}

	
	/** 個人の情報を画面に表示する */
	public void showPerson() {
		System.out.println(name+"さんの生年月日は"+birthday+"、身長は"+height+"cm、体重は"+weight+"kgです.");
	}

	/** 個人のBMIを計算して返す */
	public double getBMI() {
		return this.weight/Math.pow(this.height*0.01, 2);//身長をmに直すため0.01をかける
	}
	public void showObesity() {
		double BMI=this.getBMI();
		String status="";
		if(BMI<18.5) {
			status="低体重（やせ）";
		}else if(BMI>=18.5&&BMI<25) {
			status="普通体重";
		}else if(BMI>=25&&BMI<30) {
			status="肥満（1度）";
		}else if(BMI>=30&&BMI<35) {
			status="肥満（2度）";
		}else if(BMI>=35&&BMI<40) {
			status="肥満（3度）";
		}else if(BMI>=40) {
			status="肥満（4度）";
		}

		System.out.println(name+"さんのBMI値は"+BMI+"、"+status+"です.");
	}



	/** 合計人数を返す (静的メソッド)*/
	public static int getNumberOfPersons() {
		return numberOfPersons;
	}

}