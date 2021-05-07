import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PersonManager {
	/*------ 学生の状態を決めるフィールド群 -----*/
	HashMap<Integer, Person> examineeList = new HashMap<Integer, Person>();

	public void addPerson(int number, Person person) {
		examineeList.put(number,person);

	}
	public Person getPerson(int number) {
		return examineeList.get(number);

	}

	public void showAllPersons() {
		  System.out.println("受信番号 : 名前");
		for (int key : examineeList.keySet()) {
			System.out.println(key+" : "+examineeList.get(key).name);
		}
	}

	public void loadPersonFile(String fileName) {
		 try {
		      File f = new File(fileName);
		      BufferedReader br = new BufferedReader(new FileReader(f));

		      String line;
		      while ((line = br.readLine()) != null) {
		        String[] data = line.split(",", 0); // 行をカンマ区切りで配列に変換
		        Person tempPerson = new Person(data[1],data[2] ,Double.parseDouble(data[3]) ,Double.parseDouble(data[4]));
		    	addPerson(Integer.parseInt(data[0]),tempPerson);


		      }
		      br.close();

		    } catch (IOException e) {
		      System.out.println(e);
		    }

	}

}