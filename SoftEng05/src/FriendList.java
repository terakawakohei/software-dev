import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *友達リストを作成する
 *
 */
public class FriendList {
	/* フィールド群 */

	/* 友達を登録するList． */
	private ArrayList<Friend> friends = new ArrayList<Friend>();
	 String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void deleteName(int number) {
		this.name="";
	}

	public void addFriend(Friend friend) {
		friends.add(friend);
	}

	public void deleteFriend(int number) {
		friends.remove(number);
	}


	public Friend getFriend(int number) {
		return friends.get(number);
	}
	public int getFriendNum() {
		return friends.size();
	}

	public ArrayList<Friend> getAllFriends() {
		return friends;
	}

	public void load(String fileName) {

		try {

			// ファイルのパスを指定する
			File file = new File(fileName);

			// ファイルが存在しない場合に例外が発生するので確認する
			if (!file.exists()) {
				System.out.print("ファイルが存在しません");
			}

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",", 0); // 行をカンマ区切りで配列に変換
				Friend temp = new Friend(data[0], data[1], data[2]);
				friends.add(temp);

			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void save(String fileName) {

		try {

			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			int i;
			for (i = 0; i < friends.size(); i++) {

				pw.println(
						friends.get(i).getName() + "," + friends.get(i).getPhone() + "," + friends.get(i).getEmail());

			}

			pw.close();



		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
