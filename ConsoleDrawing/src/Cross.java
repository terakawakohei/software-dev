
public class Cross extends Shape {
	protected int height;//縦の長さ

	public Cross() {
		super();
	}

	public Cross(int height) {

		this.height = height;
	}

	@Override
	public void draw() {

		for (int i = height - 1; i >= 0; i--) {
			for (int j = height - i; j >= 0; j--) {
				System.out.print(" ");
			}

			System.out.print(getPen());
			for (int j = 0; j < i * 2; j++) {
				if (j == i * 2 - 1) {
					System.out.print(getPen());
				}
				System.out.print(" ");
			}
			System.out.println();
		}

		for (int i = 1; i <= height; i++) {
			for (int j = i; j <= height; j++) {
				System.out.print(" ");

			}
			System.out.print(getPen());
			for (int j = 0; j < i * 2; j++) {
				if (j == i * 2 - 1) {
					System.out.print(getPen());
				}
				System.out.print(" ");
			}
			System.out.println();

		}

	}

	@Override
	public String toString() {
		return "ばつ印 (" + this.height + ")";
	}

}
