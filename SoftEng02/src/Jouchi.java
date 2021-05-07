import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/**
 *  今日のジョーチの仕事を関数化したクラス
 */
public class Jouchi {

	/* フィールド群*/
	String callName = "ジョーチ";
	String name = "名無し"; // ユーザの名前
	int age = -1; // ユーザの年齢

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


	/* メソッド：ユーザに年齢を聞く */
	public void askAge() {
		while (age < 0) { // 年齢が負の間繰り返す
			System.out.print("●" + name + "さんの年齢を教えてください：");
			age = this.inputNumber(); //整数をユーザに入力してもらう．this.は省略可能．
			if (age < 0) {
				System.out.println("年齢は0以上の数です．もう一度．");
			}
		}
		System.out.println(name + "さんの年齢は，" + age + "歳なんですね．");

	}


	/* メソッド：年男・年女判定 */
	public void checkZodiac() {
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

	/* メソッド：フィボナッチ数列を計算して配列で返す*/
	public long [] fibonacci(int n) {
		long [] F = new long[n]; //配列を作成

		//数列計算
		F[0] = F[1] = 1;
		for(int i=2; i<n; i++) {
			F[i] = F[i-1] + F[i-2];
		}

		//配列を返す． (※Cではできなかった)
		return F;
	}


	/* メソッド：フィボナッチ数列を表示する*/
	public void showFibonacci() {
		System.out.println(callName + "：今日は，フィボナッチ数列を表示しましょう．");

		/*--- 項数の入力 --- */
		int n = 0;
		do {
			System.out.print(callName + "：何項まで表示しますか？");
			n = this.inputNumber(); // this.は省略可能．
		} while (n <= 2);

		//関数を呼び出して，フィボナッチ数列を受け取る
		long [] A = this.fibonacci(n); // this.は省略可能．

		//拡張for文による数え上げ．
		for (long a: A) {
			System.out.printf("%20d\n",a);
		}

		System.out.println(callName + "：完了しました．");

	}


	/* メイン関数 */
	public static void main(String[] args) {
		Jouchi j = new Jouchi(); // Jouchiクラスから，ジョーチの実体（インスタンス）を作成．

		j.hello(); // あいさつ
		j.askName(); // 名前を聞く
		j.askAge(); // 年齢を聞く
		j.checkZodiac(); // 年男・年女判定
		j.showFibonacci(); //フィボナッチを表示

	}

}