import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 配列を用いて，入力された任意の個数の整数の平均を計算する．
 * 入力は，ユーザが0を入力するまで，繰り返す．
 *
 * @author masa-n
 *
 */
public class AverageCalculator {
	int[] numbers = new int[10]; // 大きさ10の配列
	int lastIndex = 0; // 最終要素のインデクス

	/**
	 * ユーザに整数を1つ入力してもらい，返り値として返す． 正しい入力が得られるまで繰り返す．
	 *
	 */
	public int inputNumber() {
		int number;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			number = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.err.println("フォーマット例外です．もう一度．");
			number = inputNumber(); // 再帰呼び出し
		} catch (IOException e) {
			System.err.println("入出力例外です．もう一度．");
			number = inputNumber(); // 再帰呼び出し
		}

		return number;
	}

	/**
	 * 複数の整数をキーボードから入力してもらう．
	 */
	public void inputNumbers() {
		int input = 0;

		do {
			System.out.print("整数を入力してください(0で終了)：");
			input = inputNumber(); // キーボードから読み込み

			// 入力が0でない場合には，末尾に入れる．
			if (input != 0) {
				numbers[lastIndex] = input;
				lastIndex++;
			} else {
				System.out.println("入力終了");
				input = 0;
			}
		} while (input != 0);
	}

	/**
	 * 入力された整数の一覧を表示する．
	 */
	public void showNumbers() {
		int i;
		for (i = 0; i < lastIndex; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

	/**
	 * 格納された要素の平均値を計算する
	 *
	 * @return 平均値
	 */
	public double calculateAverage() {
		double sum = 0.0;
		int i;

		if (lastIndex == 0) {
			// 要素がない場合0を返しておく．
			return 0.0;
		} else {
			for (i = 0; i < lastIndex; i++) {
				sum = sum + numbers[i];
			}
			return sum / i;
		}

	}

	/**
	 * メイン関数
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		AverageCalculator ac = new AverageCalculator();
		ac.inputNumbers();
		System.out.println("入力された整数は，");
		ac.showNumbers();
		System.out.println("です．");
		System.out.println("平均値は，" + ac.calculateAverage() + "です．");
	}

}