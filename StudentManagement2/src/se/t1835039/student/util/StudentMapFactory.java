package se.t1835039.student.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

import se.t1835039.student.entity.InternationalStudent;
import se.t1835039.student.entity.RegularStudent;
import se.t1835039.student.entity.RobotStudent;
import se.t1835039.student.entity.Student;
import se.t1835039.student.entity.WorkingStudent;

/**
 * 学籍番号をキー，学生情報を値とするmapのファイル出入力を行う
 *
 * @author odayakalife
 *
 */
public class StudentMapFactory {
	/**
	 * テキストファイルから学生の情報を読み込み，学籍番号をキー，学生情報を値とするマップを作成する
	 *
	 * @param fileName 読み込むファイル名
	 * @return　読み込んだ学生情報のmap
	 */
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

				switch (Integer.parseInt(data[3])) {//学生区分を読み出す
				case 0: {
					RegularStudent s = new RegularStudent(data[0], data[1], Integer.parseInt(data[2]));
					map.put(data[0], s);
					break;
				}
				case 1: {
					//国費留学生かどうかの判定で、文字列の0,1をbool値に変換する
					boolean kokuhi;
					if (data[5].equals("1")) {
						kokuhi = true;
					} else {
						kokuhi = false;
					}
					InternationalStudent is = new InternationalStudent(data[0], data[1], Integer.parseInt(data[2]),
							data[4], kokuhi);
					map.put(data[0], is);

					break;
				}
				case 2: {
					WorkingStudent ws = new WorkingStudent(data[0], data[1], Integer.parseInt(data[2]), data[4]);
					map.put(data[0], ws);
					break;
				}
				case 3: {
					RobotStudent rs = new RobotStudent(data[0], data[1], Integer.parseInt(data[2]), data[4], data[5]);
					map.put(data[0], rs);
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

	/**
	 * 学籍番号をキー，学生情報を値とするマップからデータを読み込み、テキストファイルに書き出す
	 *
	 * @param map　学籍番号をキー，学生情報を値とするmap
	 * @param fileName 書き出すファイル名
	 */
	public static void store(TreeMap<String, Student> map, String fileName) {
		try {

			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

			for (Student s : map.values()) {
				if (s instanceof RegularStudent) { //正規学生の時
					RegularStudent rs = (RegularStudent) s; //ダウンキャスト

					pw.println(rs.getId() + "," + rs.getName() + "," + rs.getCredit() + ",0,,");
				} else if (s instanceof InternationalStudent) { //留学生の時，
					InternationalStudent is = (InternationalStudent) s; //ダウンキャスト
					pw.println(is.getId() + "," + is.getName() + "," + is.getCredit() + ",1," + is.getCountry() + ","
							+ is.perseBool(is.isKokuhi()));
				} else if (s instanceof WorkingStudent) { //社会人学生の時，
					WorkingStudent ws = (WorkingStudent) s; //ダウンキャスト
					pw.println(ws.getId() + "," + ws.getName() + "," + ws.getCredit() + ",2," + ws.getCompany() + ",");
				} else if (s instanceof RobotStudent) { //ロボット学生の時，
					RobotStudent robot = (RobotStudent) s; //ダウンキャスト
					pw.println(robot.getId() + "," + robot.getName() + "," + robot.getCredit() + ",3,"
							+ robot.getVendor() + "," + robot.getAlgorithm());
				}
			}

			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
