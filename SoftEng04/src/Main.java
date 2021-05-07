public class Main {

	public static void main(String[] args) {

		// 6人分インスタンスを生成する．
		Person p1 = new Person("前田さやか", "1999-6-17", 157,45);
		Person p2 = new Person("寺川航平", "1999-11-10", 176,70);
		Person p3 = new Person("吉倉亮人", "1999-10-6", 173,80);
		Person p4 = new Person("fatman_1", "1990-3-8", 169,90);
		Person p5 = new Person("fatman_2", "1990-3-8", 169,100);
		Person p6 = new Person("fatman_3", "1990-3-8", 169,130);
		System.out.println(Person.getNumberOfPersons()+"人のインスタンスを作成しました.");
		System.out.println("------------------------------------");
		p1.showObesity();
		p2.showObesity();
		p3.showObesity();
		p4.showObesity();
		p5.showObesity();
		p6.showObesity();
		System.out.println("------------------------------------");
		p1.showPerson();
		p2.showPerson();
		p3.showPerson();
		p4.showPerson();
		p5.showPerson();
		p6.showPerson();

		System.out.println("↑問１");
		System.out.println("------------------------------------");
		System.out.println("↓問２");



		PersonManager pm = new PersonManager();

		pm.loadPersonFile("kenko_shindan.csv");
		pm.showAllPersons();

		pm.getPerson(44).showPerson();
		pm.getPerson(44).showObesity();


	}
}