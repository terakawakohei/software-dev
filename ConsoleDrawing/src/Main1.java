
public class Main1 {
	public static void main(String[] args) {

		System.out.println("○長さ20の線を作ります．");
		Line line1 = new Line(20);
		System.out.println(line1);
		line1.draw();

		System.out.println("○ペン先をいろいろ変えて描画します．");
		line1.setPen("＝");
		line1.draw();

		line1.setPen("**");
		line1.draw();

		line1.setPen("++");
		line1.draw();

		line1.setPen("◇");
		line1.draw();

		System.out.println("○長さを10に変えて描画します．");
		line1.setLength(10);
		line1.draw();

		System.out.println("○別の線を長さ10で作ります．");
		Line line2 = new Line(10);
		System.out.println(line2);
		line2.draw();

		System.out.println("○さっきの線と交互に描画します．");
		line2.draw();
		line1.draw();
		line2.draw();
		line1.draw();
		line2.draw();
		line1.draw();

		System.out.println("○次は10x6の四角形を作ります．");
		Box box = new Box(10, 6);
		System.out.println(box);
		box.draw();

		System.out.println("○ペン先を○に変えて描画します．");
		box.setPen("○");
		box.draw();
	}
}
