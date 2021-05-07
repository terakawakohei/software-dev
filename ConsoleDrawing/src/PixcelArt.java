
public abstract class PixcelArt implements Drawable {


	//コンストラクタ
		public PixcelArt() {


		}



		public void display() {
			System.out.println(toString());
			draw();
		}

		public abstract String toString();

}
