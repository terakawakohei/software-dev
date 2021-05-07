
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/**
 * 制御フローの練習をするクラス． while, if, for を使ってみよう．
 */
public class ControlFlow {

	public static void main(String[] args) {
		String callName = "ジョーチ";
		System.out.println("こんにちは！私は" + callName + "と申します．");

		/*-------- 標準入力，例外処理の復習  --------*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		// 名前をキーボードから入力する
		String name;
		try {
			System.out.print("●あなたのお名前を入力してください：");
			line = br.readLine(); // 1行読み込む．エラーの例外処理が必要
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

		/*-------- while文を使って年齢入力を保証--------*/
		int age = -1;
		while (age < 0) { // 年齢が負の間繰り返す
			try {
				System.out.print("●" + name + "さんの年齢を教えてください：");
				line = br.readLine();
				age = Integer.parseInt(line);

				if (age < 0) {
					System.out.println("年齢は0以上の数です．もう一度．");
				}

			} catch (NumberFormatException e) {
				System.err.println("フォーマット例外です．もう一度．");
			} catch (IOException e) {
				System.err.println("入出力例外です．もう一度．");
			}
		}
		System.out.println(name + "さんの年齢は，" + age + "歳なんですね．");

		/*--------  年男・年女の判定．  --------*/
		if (age % 12 == 0) { // 12で割り切れると年男・年女
			System.out.println("何と" + name + "さん！ 今年，年男・年女ですね！");
		} else {
			int y = 12 - age % 12; // 年男・年女までの年数
			System.out.println(name + "さんが年男・年女になるまで，あと" + y + "年かかります．");
		}

		/*-------- 年齢カレンダーの出力  --------*/
		System.out.println("年齢カレンダーを出力します．");
		System.out.println("==============================");

		// Javaのカレンダークラスを使って，今年の西暦を取得する．（発展）
		Calendar now = Calendar.getInstance();
		int thisYear = now.get(Calendar.YEAR);

		// 基本for文はC言語と同じ．
		for (int i = 0; i < 12; i++) {
			System.out.printf("  %4d年    %3d歳", thisYear + i, age + i);
			if ((age + i) % 12 == 0) {
				System.out.println(" (年男・年女)");
			} else {
				System.out.println();
			}
		}
		System.out.println("==============================");

	}
}

