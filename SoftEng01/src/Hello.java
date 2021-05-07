

/**
 * はじめてのJavaクラス．
 *
 */
// ↓Helloという名前のクラスを自分で宣言している．クラス名は大文字で始める．
public class Hello {
	// ↓Helloクラスの中のmainという名前のメソッド(関数)
	// public, static, argsは今は気にしない．
	//↓Helloクラスの中のmainという名前のメソッド(関数)
		// public, static, argsは今は気にしない．
		public static void main(String[] args) {
			/* --- 1. 標準出力(画面コンソール）の練習 --- */
			System.out.println("Hello World!");

			/* --- 2. 文字列変数の練習 --- */
			/* Javaでは String型を使う (C言語ではcharの配列だった)．
			 * 変数名は小文字で始めること．
			 * 2語以上の時は，つなぎ目を大文字に．call_name等としない．
			 */
			String callName = "ジョーチ";
			//文字列同士は，+ で連結できる．
			System.out.println("こんにちは！私は" + callName + "と申します．");


			/* --- 3. 計算の練習 --- */
			System.out.println("計算をしましょう．");

			System.out.println("●定数同士の場合");
			//()内の計算結果を文字列として+で連結する
			System.out.println("123 + 456 = " + (123+456));
			System.out.println("123 - 456 = " + (123-456));
			System.out.println("123 * 456 = " + (123*456));
			System.out.println("123 / 456 = " + (123/456));

			System.out.println("●変数を使ってみましょう");
			int x = 123;
			//変数の値を文字列として+で連結する．
			System.out.println(" x = " + x);
			//以下，定数の場合と同様．
			System.out.println(" x + 456 = " + (x+456));
			System.out.println(" x - 456 = " + (x-456));
			System.out.println(" x * 456 = " + (x*456));
			System.out.println(" x / 456 = " + (x/456));

			//浮動小数点にキャスト(型変換)
			double z = (double) x / 456;
			System.out.println(" z = x / 456 = " + z);

			/* --- 4. 他のprint系命令の練習 --- */
			System.out.println("●print()は改行しません");
			System.out.print("これは，ソフトウェア工学の");
			System.out.print("授業です．");
			System.out.print("改行文字を入れます．\n");


			System.out.println("●printf()はC言語でおなじみですね．");
			System.out.printf(" x + 456 = %6d\n", (x+456));
			System.out.printf(" x - 456 = %6d\n", (x-456));
			System.out.printf(" x * 456 = %6d\n", (x*456));
			System.out.printf(" x / 456 = %6d\n", (x/456));

			System.out.printf(" x / 456 = %.4f\n", ((double)x/456));

			/* --- 5. 標準エラー出力の練習 --- */
			System.err.println("●System.errは標準エラー出力に出します．");
			System.err.println("エラーメッセージのテストです．");
			System.err.println("エラー１：" + x);
			System.err.println("エラー２：テストテスト");


}}