/**
 * 正規学生クラス (抽象クラスを継承して定義)
 */
public class RegularStudent extends Student {
	/* -------     コンストラクタ-------------------*/
	public RegularStudent(){
		super();
	}
	public RegularStudent(String id, String name, int credit) {
		super(id, name, credit);
	}

	//抽象メソッドをオーバーライド．しないとエラーになる．
	@Override
	public void explain() {
		System.out.println("私" + getName() + "は，正規の学生です．");
	}




}
