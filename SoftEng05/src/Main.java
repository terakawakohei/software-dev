
public class Main {

	public static void main(String[] args) {

		FriendManager fm = new FriendManager();
		FileManager f = new FileManager();
		if (f.selectReading() == 1) {//ファイル読み込みを行うなら

			fm.setLists(f.getLists());//FriendManagerに読み込んだ友達リストのArrayListを渡す
			fm.setFriendList(f.getFriendList(0));//渡したArrayListの先頭を初期状態としてセット

		}

		fm.showMenu();

		f.selectWriting(fm.getLists());//ファイル書き出しを行うか選択

	}
}