import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * ArrayListを用いて，入力された任意の個数の整数の平均を計算する．
 * 入力は，ユーザが0を入力するまで，繰り返す．
 *
 * @author masa-n
 *
 */
public class AverageCalculator2 {
	ArrayList<Integer> numbers = new ArrayList<Integer>(); // 配列の代わりにArrayList

	/**
	 * ユーザに整数を1つ入力してもらい，返り値として返す．
	 * 正しい入力が得られるまで繰り返す．
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
			number = inputNumber(); // 再起呼び出し
		} catch (IOException e) {
			System.err.println("入出力例外です．もう一度．");
			number = inputNumber(); // 再起呼び出し
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
				numbers.add(input);
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
		for (i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i) + " "); // i番目の要素を取得して表示．

		}
	}

	/**
	 * 格納された要素の平均値を計算する
	 *
	 * @return 平均値
	 */
	public double calculateAverage() {
		double sum = 0.0;

		if (numbers.isEmpty()) {
			// 要素がない場合0を返しておく．
			return 0.0;
		} else {
			for (int n : numbers) { // 拡張for文で簡単に数えあげ
				sum = sum + n;
			}
			return sum / numbers.size();
		}

	}

	/**
	 * メイン関数
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		AverageCalculator2 ac = new AverageCalculator2();
		ac.inputNumbers();
		System.out.println("入力された整数は，");
		ac.showNumbers();
		System.out.println("です．");
		System.out.println("平均値は，" + ac.calculateAverage() + "です．");
	}

}
