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
public class LibrarySearch {
	/* フィールド群 */
	String callName = "ジョーチ";

	/* 蔵書を登録するマップ．キーをISBN，値を書名で持つ． */
	HashMap<String, String> books = new HashMap<String, String>();

	/**
	 *  システムを初期化する．蔵書ファイル名を与える．
	 */
	public void initialize(String filename) {
		System.out.println("■蔵書検索システム「ジョーチ」");
		System.out.print(callName + ": 蔵書データをロードします．．．");

		// 何冊か蔵書を登録する．ファイルから読み込む．
		try {
			//渡された蔵書ファイルを開いて，読み取り機を作成．
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine())!=null) {
				String [] data = line.split("\t"); //1行のデータをタブで分割
				books.put(data[0], data[1]);       //ISBN, 書名のペアをマップに登録
			}
			br.close(); //使い終わったら閉じる．ファイル入出力では重要．
			System.out.println("完了．");
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
	public void searchBooks() {
		String isbn, bookName;

		while (true) {
			System.out.println(callName + "：検索したい図書のISBNを入力してください(0000で終了)");
			isbn = inputString(); // ISBNを入力

			if (isbn.equals("0000")) { // 終了コマンドが入力された
				System.out.println(callName + "：終了します");
				break;
			}

			//入力されたISBNがマップに登録されているか？
			if (books.containsKey(isbn)) {
				bookName = books.get(isbn); //書名を取り出して表示する．
				System.out.println("○「" + bookName + "」"
				+ "(ISBN-" + isbn + ")は図書館にあります．");
			} else {
				System.out.println("×ISBN=" + isbn + "の蔵書はありません．");
			}
		}
	}
	/**
	 * メイン関数
	 */
	public static void main(String[] args) {
		LibrarySearch ls = new LibrarySearch();
		ls.initialize("library-data.txt");  //初期化して
		ls.searchBooks(); //蔵書検索

	}

}