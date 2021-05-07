
public class Stairs extends Shape {
	protected int height;//段数

	public Stairs(int height) {

		this.height=height;
	}
	@Override
	public void draw() {
		for(int i=1;i<=height;i++) {
			for(int j=1;j<=i;j++) {
			System.out.print(getPen());
			}
			System.out.println();
		}
	}
	@Override
	public String toString() {
		return "階段 ("+this.height+")";
	}

}
