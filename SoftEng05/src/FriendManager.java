import java.util.ArrayList;

public class FriendManager {

	/* フィールド群 */

	private FriendList friendList = new FriendList();
	private ArrayList<FriendList> lists = new ArrayList<FriendList>();//複数の友達リストを管理するため、ListでFriendListを管理
	private int command = 3;

	public FriendManager() {
		//ファイルからの読み込みが行われない場合、「default」友達リストを設定
		FriendList temp = new FriendList();
		temp.setName("default");
		this.friendList = temp;
		this.lists.add(temp);

	}

	public void setFriendList(FriendList list) {
		this.friendList = list;
	}

	public void setLists(ArrayList<FriendList> lists) {
		this.lists = lists;
	}

	public ArrayList<FriendList> getLists() {
		return this.lists;
	}

	public FriendList getFriendList() {
		return friendList;
	}

	public void showMenu() {
		while (command != 0) {
			System.out.println("■ 「 " + friendList.getName() + " 」 リストを管理します．コマンドを入れてください．");
			System.out
					.println("[1: 友達リストを見る，2: 友達を追加する，3:友達を削除する, 4:友達の詳細を見る，5:別の友達リストを管理する，6:新たに友達リストを作成する:，0:終了する] ");

			command = KeyBoard.inputNumber(); // キーボードから読み込み

			switch (command) {
			case 1:
				showFriendList();
				break;
			case 2:
				addFriend();
				break;
			case 3:
				deleteFriend();
				break;
			case 4:
				showFriend();
				break;
			case 5:
				switchList();
				break;
			case 6:
				makeList();
				break;
			case 0:
				break;

			default:
				System.out.println("上記の番号を入力してください");
			}
		}
	}

	public void showFriendList() {//選択中の友達リストの友達を全て表示
		System.out.println("[リスト] 友達リストを表示します．");
		System.out.println("-------------------------------------");
		System.out.println("no : name ");
		System.out.println("-------------------------------------");

		for (int i = 0; i < friendList.getAllFriends().size(); i++) {

			System.out.print(i + " : " + friendList.getFriend(i).getName() + "\n"); // i番目の要素を取得して表示．

		}
		System.out.println("-------------------------------------");

	}

	public void showFriend() {//友達の詳細を確認
		System.out.println("[詳細] 何番の友達を確認しますか？");
		int number = 0;

		number = KeyBoard.inputNumber();
		if (number >= 0 && number <= friendList.getFriendNum()) {

			System.out.println("-------------------------------------");
			System.out.println("名前 : " + friendList.getFriend(number).getName());
			System.out.println("電話 : " + friendList.getFriend(number).getPhone());
			System.out.println("メールアドレス : " + friendList.getFriend(number).getEmail());
			System.out.println("-------------------------------------");
		} else {
			System.out.println("その番号の友達は存在しません.");
			this.showFriend();
		}
	}

	public void addFriend() {//選択中の友達リストに友達を追加
		System.out.println("[追加] 友達を追加します．");
		Friend temp = new Friend("", "", "");
		System.out.println("名前 : ");
		String name;
		name = KeyBoard.inputString();
		temp.setName(name);
		System.out.println("電話番号 : ");
		String phone;
		phone = KeyBoard.inputString();
		temp.setPhone(phone);
		System.out.println("メールアドレス : ");
		String mail;
		mail = KeyBoard.inputString();
		temp.setEmail(mail);

		friendList.addFriend(temp);

		System.out.println("追加しました");

	}

	public void deleteFriend() {//友達を削除
		System.out.println("[削除] 何番の友達を削除しますか？ ( 削除しない場合は-1を入力 )");
		int number = 0;

		number = KeyBoard.inputNumber();

		if (number == -1) {
			this.showMenu();
		}
		if (number >= 0 && number <= friendList.getFriendNum()) {
			friendList.deleteFriend(number);
			System.out.println("削除しました");
		} else {
			System.out.println("その番号の友達は存在しません.");
			this.deleteFriend();
		}

	}

	public void switchList() {//友達リストを切り替える
		System.out.println("現在管理しているリストを表示します");
		System.out.println("-------------------------------------");
		System.out.println("no : name ");
		System.out.println("-------------------------------------");

		for (int i = 0; i < lists.size(); i++) {//ListManagerが持っているFriendListを全て表示

			System.out.print(i + " : " + lists.get(i).getName() + "\n");

		}
		System.out.println("-------------------------------------");
		System.out.println("どのリストに切り替えますか？ no.を入力してください.(切り替えない場合は-1を入力)");

		int selectNum = 0;

		selectNum = KeyBoard.inputNumber();

		if (selectNum == -1) {
			this.showMenu();
		}

		if (0 <= selectNum && lists.size() >= selectNum) {//存在しうる友達リストの番号かチェック

			this.setFriendList(lists.get(selectNum));
			System.out.println("友達リスト「" + friendList.getName() + "」に切り替えました");
		} else {
			System.out.println("そのリストは存在しません");
			this.switchList();
		}

	}

	public void makeList() {
		System.out.println("新たに作成する友達リストの名前を入力してください");
		String listName = "";
		listName = KeyBoard.inputString();
		FriendList temp = new FriendList();

		temp.setName(listName);
		lists.add(temp);

		System.out.println("友達リスト 「 " + temp.getName() + " 」を追加しました");

	}

}
