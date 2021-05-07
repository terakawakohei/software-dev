
public class Box extends Shape {
	protected int width;//横の長さ
	protected int height;//縦の長さ

	public Box() {
		super();
	}

	public Box(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if (i == 1 || i == height || j == 1 || j == width) {
					System.out.print(getPen());
				} else
					System.out.print(" ");

			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "四角形 (" + this.width + "、" + this.height + ")";
	}

}
