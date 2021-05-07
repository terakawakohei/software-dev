import java.util.ArrayList;

public class ListManager {
	private ArrayList<FriendList> lists = new ArrayList<FriendList>();

	public ListManager() {

	}

	public void setFriendList(FriendList friendList) {
		System.out.println("-------");
		this.showAllFriendList();
		 System.out.println("追加前");
		this.lists.add(friendList);
		System.out.println("追加後");
		this.showAllFriendList();
		System.out.println("-------");
	}
	public FriendList getFriendList(int number) {
		return lists.get(number);
	}


	public ArrayList<FriendList> getLists() {
		return lists;
	}

	public void setLists(ArrayList<FriendList> lists) {
		this.lists = lists;
	}

	public int getListsNum() {
		return this.lists.size();
	}
	public void showAllFriendList() {
		 for (FriendList friendList : lists){
		        System.out.println(friendList.getName());
		    }
	}

	@Override
	public String toString() {
		return "ListManager [lists=" + lists + "]";
	}



}
