
public class Main2 {
	public static void main(String[] args) {

		System.out.println("■図形を生成");
		Line line = new Line(20);
		System.out.println(line);
		line.draw();
		//十段の階段

		Stairs stairs = new Stairs(10);
		System.out.println(stairs);
		stairs.setPen("=");
		stairs.draw();

		Rhombus rhombus = new Rhombus(20);
		System.out.println(rhombus);
		rhombus.draw();

		Triangle triangle = new Triangle(5);
		System.out.println(triangle);
		triangle.setPen("#");
		triangle.draw();

		Cross cross = new Cross(9);
		System.out.println(cross);
		cross.setPen("@");
		cross.draw();

		System.out.println("---------------------");
		System.out.println("ドット絵、アスキーアート");
		System.out.println("---------------------");

		Drawable pacman = new PacMan("なつかしのパックマン");
		System.out.println(pacman);
		pacman.draw();

		Akabei akabei = new Akabei("なつかしのアカベイ");
		System.out.println(akabei);
		akabei.draw();
	}
}
