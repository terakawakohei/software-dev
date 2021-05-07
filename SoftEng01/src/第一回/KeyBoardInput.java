package 第一回;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * キーボードからの入力を練習するクラス
 *
 */
// ↓KeyBoardInputという名前のクラスを宣言．大文字で始める．単語のつなぎ目は大文字に
public class KeyBoardInput {

	// KeyBoardInputクラスのmainメソッド．
	// throws Exception: 例外（エラー）が起きたら，外に投げるという意味．
	public static void main(String[] args) throws Exception {

		/*-------- 文字列変数の復習 -------- */
		/*
		 * Javaでは String型を使う (C言語ではcharの配列だった)．
		 * 変数名は小文字で始める．2語以上の単語で構成するとき時は，
		 * つなぎ目を大文字に．call_name等としない．
		 */
		String callName = "ジョーチ";
		System.out.println("こんにちは！私は" + callName + "と申します．");

		/*-------- 入力の準備 --------*/
		// キーボード（標準入力）の読み取り機（リーダー）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line; // 読み取り用の文字列バッファ

		/*-------- 文字列の入力の練習 --------*/
		System.out.print("●あなたのお名前を入力してください：");
		line = br.readLine(); // 1行読み込む．エラーの例外処理が必要
		System.out.println("お名前は「" + line + "」さんですね．");
		String name = line; // 名前として保持

		/*-------- 整数の入力の練習 --------*/
		System.out.print("●年齢を入力してください：");
		line = br.readLine(); // 1行読み込む
		int age = Integer.parseInt(line); // 文字列を整数に変換する．
		System.out.println(name + "さんは，" + age + "歳なんですね．");

		/*-------- 小数の入力の練習 --------*/
		System.out.print("●身長は何cmですか？：");
		line = br.readLine(); // 1行読み込む
		double height = Double.parseDouble(line); // 文字列を浮動小数に変換する．
		System.out.print("●体重は何kgですか？：");
		line = br.readLine(); // 1行読み込む
		double weight = Double.parseDouble(line); // 文字列を浮動小数に変換する．

		/*-------- 計算と出力の復習 --------*/
		height = height * 0.01; // 身長をmになおす
		double BMI = weight / (height * height); // Body-Mass Index
		System.out.print(name + "さん（" + age + "歳）のBMI値は，");
		System.out.printf("%.2fです．\n", BMI);

	}

}

