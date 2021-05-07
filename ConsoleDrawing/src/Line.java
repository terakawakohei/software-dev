
public class Line extends Shape {

	protected int length;
	public Line() {
		super();
	}
	public Line(int length) {
		this.length=length;

	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public void draw() {
		for(int i=0;i<length;i++) {
			System.out.print(getPen());
		}
		System.out.println();
	}
	@Override
	public String toString() {
		return "直線 ("+this.length+")";
	}

}
