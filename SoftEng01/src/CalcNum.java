import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcNum {


	public static void main(String[] args)  {



		/*-------- 入力の準備 --------*/
		// キーボード（標準入力）の読み取り機（リーダー）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line1; // 読み取り用の文字列バッファ
		String line2; // 読み取り用の文字列バッファ


		/*-------- 計算に用いる数字の読みこみ --------*/
		int a =0;
		int b= 0;
		try {
			System.out.println("●計算に使用する数を二つ入力してください");
			System.out.print("a=");

			line1 = br.readLine(); // 1行読み込む
			a = Integer.parseInt(line1);// 文字列を整数に変換する．


			System.out.print("b=");

			line2 = br.readLine(); // 1行読み込む
			b = Integer.parseInt(line2);// 文字列を整数に変換する．

		} catch (NumberFormatException e) { //
			System.err.println("フォーマット例外：数字のみを入力してください.終了します");
			System.exit(1); // 強制終了
		} catch (IOException e) { // readLine()からの例外を拾う．
			System.err.println("入出力例外：計算ができません．終了します．");
			System.exit(1); // 強制終了
		}

		System.out.println("●計算結果");
		System.out.printf("a+b=%d\n",a+b);
		System.out.printf("a-b=%d\n",a-b);
		System.out.printf("a×b=%d\n",a*b);
		System.out.printf("a÷b=%d\n",a/b);








	}


}
