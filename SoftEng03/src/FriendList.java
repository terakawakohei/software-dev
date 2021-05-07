import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *友達リストを作成する
 *
 */
public class FriendList {
	/* フィールド群 */
	String callName = "ジョーチ";
	int command=1;

	/* 友達を登録するList．キーを数字（no.），値を名前で持つ． */
	ArrayList<String> List = new ArrayList<String>();

	/**
	 *  操作を選択
	 */
	public void menu() {
		while(command!=0) {
		System.out.println(callName + ": 友達リストを管理します.コマンドを入れてください.");
		System.out.print("[1: 友達リストを見る，2: 友達を追加する，3:友達を削除する, 0:終了する]		");



		command = inputNumber(); // キーボードから読み込み

		switch (command){
		case 1: showFriends(); break;
		case 2: addFriend(); break;
		case 3: deleteFriend(); break;
		case 0:  break;

		default : System.out.println("上記の番号を入力してください");
		}
	}


	}

	/**
	 *  友達リストを表示する
	 */
	public void showFriends() {
		System.out.println( "友達リストを表示します.");
		System.out.println( "---------------------------------");
		System.out.println( "no: 名前" );
		System.out.println( "---------------------------------");
		int i;
		for (i = 0; i < List.size(); i++) {

			System.out.print(i+ " : "+List.get(i) +"\n"); // i番目の要素を取得して表示．

		}
		System.out.println( "---------------------------------");
	}
	/**
	 *  友達リストに追加する
	 */
	public void addFriend() {
		System.out.print( "[追加]　追加する友達の名前を入れてください : ");
		String name;
		name=inputString();
		List.add(name);
		System.out.println( name+"さんを追加しました");



	}
	public void deleteFriend() {
		System.out.print( "[削除]　何番の友達を削除しますか？（-1でキャンセル） : ");
		int selectNum=0;

		selectNum=inputNumber();
		if(selectNum!=-1) {
		List.remove(selectNum);
		System.out.println( selectNum+"番の友達を削除しました");

		}
	}


	public void selectFileInput() {//友達リストを読み込むか選択

		 System.out.println("友達リストをファイルから読み込見ますか？");
		 System.out.print("はい : 1を入力　/いいえ : 0を入力		");
		 int filecommand=0;
		 filecommand=inputNumber();


			switch (filecommand){
			case 1: readFriendList(); break;
			case 0:  break;

			default : {System.out.println("上記の番号を入力してください");this.selectFileInput();};
			}
	}
	public void selectFileOutput() {//書き出して保存するかどうか選択

		 System.out.println("友達リストをファイルに書き出しますか？");
		 System.out.print("はい : 1を入力　/いいえ : 0を入力		");
		 int filecommand=0;
		 filecommand=inputNumber();


			switch (filecommand){
			case 1: writeFriendList(); break;
			case 0:  System.out.println("終了します"); break;

			default : {System.out.println("上記の番号を入力してください");this.selectFileOutput();};
			}
	}


	public void readFriendList() {//友達リストを読み込む


			 System.out.print("読み込むファイルの名前を入力してください. : ");
			 String filename;
			 filename=inputString();


		 try {

	            // ファイルのパスを指定する
	            File file = new File(filename);

	            // ファイルが存在しない場合に例外が発生するので確認する
	            if (!file.exists()) {
	                System.out.print("ファイルが存在しません");
	                this.readFriendList();
	            }


	            FileReader fileReader = new FileReader(file);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            String data;
	            while ((data = bufferedReader.readLine()) != null) {

	                List.add(data);

	            }

	            // 最後にファイルを閉じてリソースを開放する
	            bufferedReader.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }


}
	public void writeFriendList() {//友達リストを書き出す


		 System.out.print("書き出すファイルの名前を入力してください. : ");
		 String filename;
		 filename=inputString();
		 File newfile = new File(filename);

		    try{

		    	  PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(newfile)));
			  		int i;
			  		for (i = 0; i < List.size(); i++) {


			  			pw.println(List.get(i));

			  		}

			  		pw.close();

			  		System.out.print("書き出しました ");

		    }catch(IOException e) {
	            e.printStackTrace();
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
	 * キーボードから1行読み取る．エラーがあれば再入力させる．
	 *
	 * @return 読み込んだ数字
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
	 * メイン関数
	 */
	public static void main(String[] args) {
		FriendList fl = new FriendList();
fl.selectFileInput();
fl.menu();
fl.selectFileOutput();
	}

}
