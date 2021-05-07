import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
public class StudentMapFactory {
	public static TreeMap<String, Student> create(String fileName) {
		TreeMap<String, Student> map = new TreeMap<String, Student>();

		try {
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

				switch (Integer.parseInt(data[3])) {
				case 0: {
					Student s = new Student(data[0], data[1], Integer.parseInt(data[2]));
					map.put(data[0], s);
					break;
				}
				case 1: {
					InternationalStudent is = new InternationalStudent(data[0], data[1], Integer.parseInt(data[2]),
							data[4], Boolean.valueOf(data[5]));
					map.put(data[0], is);
					break;
				}
				case 2: {
					WorkingStudent ws = new WorkingStudent(data[0], data[1], Integer.parseInt(data[2]), data[4]);
					map.put(data[0], ws);
					break;
				}

				default: {
					System.out.println("存在しない学生区分です");
					break;
				}
				}

			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}


}
