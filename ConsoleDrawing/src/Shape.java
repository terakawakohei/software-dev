
public abstract class Shape implements Drawable {
	protected String pen = "️";

	//コンストラクタ
	public Shape() {
		this.pen = "■️";

	}

	public void setPen(String pen) {
		this.pen = pen;
	}

	public String getPen() {
		return pen;
	}

	public void display() {
		System.out.println(toString());
		draw();
	}

	public abstract String toString();

}
