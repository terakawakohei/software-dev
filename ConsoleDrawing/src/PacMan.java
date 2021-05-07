
public class PacMan extends PixcelArt{
	private String name;

	public PacMan() {
		this("名無し");
	}

	public PacMan(String name) {
		this.name = name;
	}

	@Override
	public void draw() {
		System.out.println("　　　 ■　■　■　■　■　■　　　　");
		System.out.println("　■　■　■　■　■　■　■　■　■　　");
		System.out.println("■　■　■　■　■　■　■　■　■　■　■　");
		System.out.println("■　■　■　■　■　■　■　■　■　■　■　");
		System.out.println("　　■　■　■　■　■　■　■　■　■　■");
		System.out.println("　　　　　■　■　■　■　■　■　■　■　■");
		System.out.println("　　　　　　　　■　■　■　■　■　■　■　■");
		System.out.println("　　　　　■　■　■　■　■　■　■　■　■");
		System.out.println("　　■　■　■　■　■　■　■　■　■　■　■");
		System.out.println("■　■　■　■　■　■　■　■　■　■　■　");
		System.out.println("■　■　■　■　■　■　■　■　■　■　■　");
		System.out.println("　■　■　■　■　■　■　■　■　■　　");
		System.out.println("　　　 ■　■　■　■　■　■　　　　");


	}

	@Override
	public String toString() {
		return "パックマン (" + name + ")";
	}

}

