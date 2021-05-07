
public class Friend {
	/*------ 人物の状態を決めるフィールド群 -----*/
	private String name; // 名前
	private String phone; // 電話番号
	private String email; // メールアドレス



	/**
	 * デフォルトコンストラクタ．空のPersonインスタンスを生成する
	 */
	public Friend() {

	}

	/**
	 * コンストラクタ．学番，名前，単位数を指定して，Personインスタンスを生成する．
	 */
	public Friend(String name, String phone, String email ) {
		this.name = name;
		this.phone = phone;
		this.email=email;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}




}
