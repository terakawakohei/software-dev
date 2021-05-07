import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  今日のジョーチの仕事を関数化したクラス
 */
public class CalcSign {

	/* フィールド群*/
	String callName = "ジョーチ";
	String name = "名無し"; // ユーザの名前
	int birthMonth = -1; // ユーザの生まれ月
	int birthDay = -1; // ユーザの生まれ日

	String sign="該当なし";//ユーザーの星座

	/* メソッド：あいさつをする */
	public void hello() {
		System.out.println("こんにちは！私は" + callName + "と申します．");
	}

	/* メソッド：ユーザに名前を聞く */
	public void askName() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("●あなたのお名前を入力してください：");
			String line = br.readLine(); // 1行読み込む．エラーの例外処理が必要
			System.out.println("お名前は「" + line + "」さんですね．");
			name = line;
			/*---- if文の練習．文字列比較 ----*/
			if (name.equals(callName)) {
				System.out.println("え，私と同じ名前ですね！");
			}
		} catch (IOException e) {
			System.err.println("入出力例外：名前を「名無し」で進めます．");
			name = "名無し";
		}
	}

	/* メソッド：ユーザに整数を入力してもらい，返り値として返す */
	public int inputNumber() {
		int number;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			number = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.err.println("フォーマット例外です．もう一度．");
			number = this.inputNumber(); // 再起呼び出し．this.は省略可能．
		} catch (IOException e) {
			System.err.println("入出力例外です．もう一度．");
			number = this.inputNumber(); // 再起呼び出し．this.は省略可能．
		}

		return number;
	}


	/* メソッド：ユーザに誕生日を聞く,正しい日付を受け取る場合1を、そうでない場合0を返す */
	public int askBirthday() {
		while (birthMonth < 0 ||birthMonth>12) { // 正しい入力を受けるまで繰り返す
			System.out.print("●" + name + "さんの誕生日の月を教えてください　：");
			birthMonth = this.inputNumber(); //整数をユーザに入力してもらう．this.は省略可能．
			if (birthMonth < 0||birthMonth>12) {
				System.out.println("月は1以上12以下の数です．もう一度．");
			}
		}
		while ( birthDay < 0||birthDay>31) { // 正しい入力を受けるまで繰り返す
			System.out.print("●" + name + "さんの誕生日の日にちを教えてください　：");
			birthDay = this.inputNumber(); //整数をユーザに入力してもらう．this.は省略可能．
			if (birthDay < 0||birthDay>31) {
				System.out.println("日にちは1以上31以下の数です．もう一度．");
			}
		}

		int smallMonth[] = { 4, 6, 9, 11};

		for (int month: smallMonth) {
			if(birthMonth==month&&birthDay==31) {
				System.out.println(birthMonth+"月にその日は存在しません,,,");

return 0;
			}

		}
		if(birthMonth==2&&birthDay>28) {
			System.out.println(birthMonth+"月にその日は存在しません,,,");
return 0;
		}

		System.out.println(name + "さんの誕生日は，" + birthMonth + "月"+birthDay+"日なんですね.");
		return 1;

	}

	public void showSign() {
		switch (birthMonth){
		  case 1:
		 if(birthDay<20) {sign="山羊座";}else sign="水瓶座";
		    break;
		  case 2:
			  if(birthDay<19) {sign="水瓶座";}else sign="魚座";
		    break;
		  case 3:
			  if(birthDay<21) {sign="魚座";}else sign="牡羊座";
		    break;
		  case 4:
			  if(birthDay<20) {sign="牡羊座";}else sign="牡牛座";
		    break;
		  case 5:
			  if(birthDay<21) {sign="牡牛座";}else sign="双子座";
		    break;
		  case 6:
			  if(birthDay<22) {sign="双子座";}else sign="蟹座";
		    break;
		  case 7:
			  if(birthDay<23) {sign="蟹座";}else sign="獅子座";
		    break;
		  case 8:
			  if(birthDay<23) {sign="獅子座";}else sign="乙女座";
		    break;
		  case 9:
			  if(birthDay<23) {sign="乙女座";}else sign="天秤座";
		    break;
		  case 10:
			  if(birthDay<24) {sign="天秤座";}else sign="蠍座";
		    break;
		  case 11:
			  if(birthDay<23) {sign="蠍座";}else sign="射手座";
		    break;
		  case 12:
			  if(birthDay<22) {sign="射手座";}else sign="山羊座";
		    break;
		  default:
		    System.out.println("そのような誕生月は存在しません、、");
		}

		System.out.println(name + "さんの星座は，" + sign +"です.");

	}









	/* メイン関数 */
	public static void main(String[] args) {
		CalcSign j = new CalcSign(); // ，ジョーチの実体（インスタンス）を作成．

		j.hello(); // あいさつ
		j.askName(); // 名前を聞く
		if(j.askBirthday()==1) {/* 正しい日付を受け取る場合1を、そうでない場合0を返す */
			j.showSign();//星座を表示
		}




	}

}