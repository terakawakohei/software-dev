
public abstract class AsciiArt implements Drawable {

	//コンストラクタ
	public AsciiArt() {

	}

	public void display() {
		System.out.println(toString());
		draw();
	}

	public abstract String toString();

}
