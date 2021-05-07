import java.util.ArrayList;

public class FileManager {
	private ArrayList<FriendList> lists = new ArrayList<FriendList>();

	private int command = 3;

	public ArrayList<FriendList> getLists() {
		return this.lists;
	}

	public FriendList getFriendList(int number) {
		return this.lists.get(number);
	}

	public int selectReading() {//ファイルからの読み込みを行うなら1を、そうでないなら0を返す

		System.out.println("友達リストをファイルから読み込みますか？( 拡張子 → .txt )");
		System.out.println("[1:読み込む，0:読み込まない] ");

		command = KeyBoard.inputNumber(); // キーボードから読み込み

		switch (command) {
		case 1: {
			readFile();
			return 1;
		}
		case 0: {
			return 0;
		}

		default:
			System.out.println("上記の番号を入力してください");
			this.selectReading();
		}

		return 0;

	}

	public void selectWriting(ArrayList<FriendList> lists) {

		System.out.println("友達リストをファイルに書き出しますか？");
		System.out.println("[1:書き出す，0:書き出さない] ");

		command = KeyBoard.inputNumber(); // キーボードから読み込み

		switch (command) {
		case 1: {
			writeFile(lists);
			return;
		}
		case 0: {
			System.out.println("終了します");
			return;
		}

		default:
			System.out.println("上記の番号を入力してください");
		}
		return;
	}

	public void readFile() {

		System.out.print("いくつファイルを読み込みますか？");
		int fileNum = 0;
		fileNum = KeyBoard.inputNumber();

		for (int i = 0; i < fileNum; i++) {
			lists.add(new FriendList());
		}

		for (int i = 0; i < fileNum; i++) {
			System.out.print("読み込むファイル名を拡張子付きで入力してください " + (i + 1) + "つめ : ");
			String fileName = "";

			fileName = KeyBoard.inputString();
			lists.get(i).load(fileName);
			lists.get(i).setName(fileName.replace(".txt", ""));//ファイル名をそのまま管理する友達リストの名前に設定
			System.out.println("友達リスト : 「 " + fileName.replace(".txt", "") + " 」として読み込みました");
		}

		System.out.println("読み込みを続けますか？");
		System.out.println("[1:続ける，0:終了する] ");

		command = KeyBoard.inputNumber(); // キーボードから読み込み

		switch (command) {
		case 1: {
			readFile();
			return;
		}
		case 0:
			return;

		default: {
			System.out.println("上記の番号を入力してください");
			readFile();
		}
		}

	}

	public void writeFile(ArrayList<FriendList> lists) {
		System.out.println("-------------------------------------");
		System.out.println(lists.size() + "個の友達リストを書き出します.");
		System.out.println("-------------------------------------");

		for (FriendList list : lists) {
			System.out.println("・" + list.getName());
			System.out.print("この友達リストを書き出すファイル名を入力してください ( 拡張子 → .txt ) : ");
			String fileName = "";
			fileName = KeyBoard.inputString();
			list.save(fileName);
		}

		System.out.println("書き出しました");

	}
}
