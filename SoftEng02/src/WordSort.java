import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 *  今日のジョーチの仕事を関数化したクラス
 */
public class WordSort {

	/* フィールド群*/

	String line = "default"; // ユーザの名前




	/* メソッド：ユーザに名前を聞く */
	public void askWord() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("単語を辞書順にソートします");
			System.out.print("●コンマ区切りで単語を入力してください：");
			 line = br.readLine(); // 1行読み込む．エラーの例外処理が必要

		} catch (IOException e) {
			System.err.println("入力例外：終了します．");
			System.exit(1); // 強制終了
		}
		 if (line.contains(","))
	        {


					System.out.println("ソートします");
					String [] words = line.split(",");

					 Arrays.sort(words);

					  for(String w : words) {
				            System.out.println(w);
				        }


	        }else {System.out.println("コンマが含まれていません");}

	}






	/* メイン関数 */
	public static void main(String[] args) {
		WordSort j = new WordSort(); // Jouchiクラスから，ジョーチの実体（インスタンス）を作成．

		j.askWord(); // 単語の入力

	}

}