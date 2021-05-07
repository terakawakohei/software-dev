import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * フィボナッチ数列　A_n = A_n-1 + A_n-2 (n>=3, A_2=A_1=1)を表示する
 */
public class Fibonacci {

	public static void main(String[] args) {

		String callName = "ジョーチ";

		System.out.println(callName + "：今日は，フィボナッチ数列を表示しましょう．");

		/*--- 項数の入力．例外処理をきっちりする． --- */
		int n = 0;
		do {
			System.out.print(callName + "：何項まで表示しますか？");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String line = br.readLine();
				n = Integer.parseInt(line);
				if (n<=2) {
					System.out.println("3以上の整数を指定してください．");
				}
			} catch (NumberFormatException e) {
				System.err.println("line: フォーマットエラー．再入力．");
			} catch (IOException e) {
				System.err.println("line: 入出力エラー．再入力．");
			}
		} while (n <= 2);


		//配列の宣言．long型
		long [] A = new long[n];

		//要素の参照．インデクスは0から
		A[0] = 1;
		A[1] = 1;

		//配列名.lengthで長さがとれる
		for (int i=2; i<A.length; i++) {
			A[i] = A[i-1] + A[i-2];
		}

		/* 普通のfor文での数え上げ
		for (int i=0; i<A.length; i++) {
			System.out.printf("%20d\n",A[i]);
		}
		*/

		//拡張for文による数え上げ．こちらの方がスマート
		for (long a: A) {
			System.out.printf("%20d\n",a);
		}

		System.out.println(callName + "：完了しました．");

		// ↓コメントを外して，配列外参照してみる
		 System.out.println(callName + "：" + (n+1) + "番目の配列要素を見てみましょう．");
		 System.out.println(A[n+1]);

	}

}