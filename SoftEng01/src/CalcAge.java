import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CalcAge {

	public static void main(String[] args)  {


		String callName = "ジョーチ";
		System.out.println("こんにちは！!!!!私は" + callName + "です．");

		/*-------- 入力の準備 --------*/
		// キーボード（標準入力）の読み取り機（リーダー）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line; // 読み取り用の文字列バッファ

		/*-------- 名前の入力 --------*/
		String name;
		try {
			System.out.print("●あなたの名前を入力してください：");
			line = br.readLine(); // 1行読み込む．エラーの例外処理が必要
			System.out.println("名前は「" + line + "」ですね．");
			name = line;
		} catch (IOException e) { // readLine()からの入出力例外を拾う．
			System.err.println("入出力例外：名前を「名無し」で進めます．");
			name = "名無し";
		}
		/*-------- 生まれ年の入力 --------*/
		int nowYear =2020;
		int birthYear = 0;
		try {
			System.out.print("●生まれた年を西暦で入力してください：");
			line = br.readLine(); // 1行読み込む
			birthYear = Integer.parseInt(line);// 文字列を整数に変換する．
			System.out.println(name + "さんは，" + birthYear + "年に生まれたんですね．");
		} catch (NumberFormatException e) { // parseInt()からの例外を拾う．
			System.err.println("フォーマット例外：計算ができません．終了します．");
			System.exit(1); // 強制終了
		} catch (IOException e) { // readLine()からの例外を拾う．
			System.err.println("フォーマット例外：計算ができません．終了します．");
			System.exit(1); // 強制終了
		}

if (nowYear>birthYear) {
	System.out.printf("あなたの年齢は%dです．",(nowYear-birthYear));
}else {
	System.out.printf("あなたの年齢が%d才となってしまいます...入力を間違えていませんか？",(nowYear-birthYear));
}








	}


}
