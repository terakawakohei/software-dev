import java.util.ArrayList;

public class Array {
	private ArrayList<Integer> lists = new ArrayList<Integer>();



	public void setFriendList(int friendList) {
		System.out.println("-------");
		this.showAllFriendList();
		 System.out.println("追加前");
		this.lists.add(friendList);
		System.out.println("追加後");
		this.showAllFriendList();
		System.out.println("-------");
	}

	public void showAllFriendList() {
		 for (int friendList : lists){
		        System.out.println(friendList);
		    }
	}




}
