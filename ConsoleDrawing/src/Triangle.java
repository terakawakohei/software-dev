
public class Triangle extends Shape {
	protected int height;//縦の長さ

	public Triangle() {
		super();
	}

	public Triangle(int height) {

		this.height = height;

	}

	@Override
	public void draw() {

		for (int i = 0; i <= height; i++) {
			for (int j = i; j <= height; j++) {
				System.out.print(" ");

			}
			System.out.print(getPen());
			for (int j = 0; j < i * 2; j++) {
				if (j == i * 2 - 1 || i == height) {
					System.out.print(getPen());
				} else
					System.out.print(" ");

			}
			System.out.println();

		}

	}

	@Override
	public String toString() {
		return "三角形 (高さ:" + this.height + ")";
	}

}
