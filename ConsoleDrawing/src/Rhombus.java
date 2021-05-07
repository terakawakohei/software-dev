
public class Rhombus extends Shape{
	protected int height;//縦の長さ
	public Rhombus() {
		super();
	}
	public Rhombus(int height) {
		this.height=height;

	}
	@Override
	public void draw() {//上下で分けて出力する
		//上半分
		int center=height/2;//対称性を利用するため中央を取得

		for(int i = 0 ; i <= center ; i++){
		for(int j = i ; j <= center ; j++){
			System.out.print(" ");

		}
		System.out.print(getPen());
		for(int j = 0 ; j < i*2 ; j++){
			if(j==i*2-1) {
				System.out.print(getPen());
			}
			System.out.print(" ");
		}
		System.out.println();

		}


		// 下半分
		for(int i = center - 1 ; i >=0 ; i--){
		for(int j = center-i ; j >= 0 ; j--){
			System.out.print(" ");
		}

		System.out.print(getPen());
		for(int j = 0 ; j < i*2 ; j++){
			if(j==i*2-1) {
				System.out.print(getPen());
			}
			System.out.print(" ");
		}
		System.out.println();
		}

	}
	@Override
	public String toString() {
		return "ひし形 ("+this.height+")";
	}

}
