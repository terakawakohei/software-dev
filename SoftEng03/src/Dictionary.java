import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 蔵書検索プログラム．ユーザがISBNを伝えると，システムが蔵書を検索し，
 * あれば書名を表示する．
 */
public class Dictionary {
	/* フィールド群 */


	/* 蔵書を登録するマップ．キーをISBN，値を書名で持つ． */
	HashMap<String, String> dictionary = new HashMap<String, String>();

	/**
	 *  システムを初期化する．蔵書ファイル名を与える．
	 */
	public void initialize(String filename) {
		System.out.println("■簡易英和辞典：");


		// 何冊か蔵書を登録する．ファイルから読み込む．
		try {
			//渡された蔵書ファイルを開いて，読み取り機を作成．
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine())!=null) {
				String [] data = line.split("\t"); //1行のデータをタブで分割
				dictionary.put(data[0], data[1]);       //英単語,日本語訳 のペアをマップに登録
			}
			br.close(); //使い終わったら閉じる．ファイル入出力では重要．

		} catch (FileNotFoundException e) {
			System.err.println("エラー：蔵書ファイルが見つかりません．終了します．");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("入出力例外．スキップします．");
		}
	}

	/**
	 * キーボードから1行読み取る．エラーがあれば再入力させる．
	 *
	 * @return 読み込んだ文字列
	 */
	public String inputString() {
		String line;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (IOException e) {
			System.err.println("エラー：入出力例外です．もう一度入力．");
			line = inputString();
		}

		return line;

	}

	/**
	 * 蔵書検索のメインルーチン
	 */
	public void searchWord() {
		String engWord,translated;

		while (true) {
			System.out.println("◎単語入力？(空行で終了)： ");
			engWord = inputString(); //

			if (engWord.equals("\t")) { // 終了コマンドが入力された
				System.out.println("：終了します");
				break;
			}

			//入力された単語が辞書に登録されているなら？
			if (dictionary.containsKey(engWord)) {
				translated = dictionary.get(engWord); //書名を取り出して表示する．
				System.out.println(engWord);
				System.out.println(" "+translated);
			} else {
				System.out.println("そのような単語はありません.");
			}
		}
	}
	/**
	 * メイン関数
	 */
	public static void main(String[] args) {
		Dictionary d = new Dictionary();
		d.initialize("eiwa.txt");  //初期化して
		d.searchWord(); //検索

	}

}