
public class Akabei extends AsciiArt{
	private String name;

	public Akabei() {
		this("名無し");
	}

	public Akabei(String name) {
		this.name = name;
	}

	@Override
	public void draw() {
		System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
		System.out.println("MMMMMMMMMMMMMMMMMMM#ZZZZZZZZZZZMMMMMMMMMMMMMMMMMMM");
		System.out.println("MMMMMMMMMMMMMMMMMMMHZZZZZZZZZZZMMMMMMMMMMMMMMMMMMM");
		System.out.println("MMMMMMMMMMMMMHZZZZZZZZZZZZZZZZZZZZZZZdMMMMMMMMMMMM");
		System.out.println("MMMMMMMMMMHZZZZZZZZZZZZZZZZZZZZZZZZZZZZZdMMMMMMMMM");
		System.out.println("MMMMMMMMMMY\"7\"\"74ZZZZZZZZZZZY\"\"\"\"\"4ZZZZZdMMMMMMMMM");
		System.out.println("MMMMMMMHZy!     JZyZZZZZZZZZ)     ,yZZZZZZZdMMMMMM");
		System.out.println("MMMMMMM!           jZZZZZ}           ,ZZZZZdMMMMMM");
		System.out.println("MMMMMMM+......     jZZZZZn.....,     ,ZZZZZdMMMMMM");
		System.out.println("MMMMMMMMMMMMM{    `jZZZZZMMMMMM]     ,ZZZZZdMMMMMM");
		System.out.println("MMMMHZyMMMMMM{     jZZZZZMMMMMM]   ` ,ZZZZZZyZdMMM");
		System.out.println("MMMMKZZMMMY\"\"'  ...JZZZZyMMM#\"\"\\  ...,ZZZZZZZZdMMM");
		System.out.println("MMMMKZZZZy!     JZZZZZZZZZZZ)    `,ZZZZZZZZZZZdMMM");
		System.out.println("MMMMKZZZZZyyyyyyZZZZZZZZZZZZyyyZyZZZZZZZZZZZZZdMMM");
		System.out.println("MMMMKZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZdMMM");
		System.out.println("MMMMKZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZdMMM");
		System.out.println("MMMMKZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZdMMM");
		System.out.println("MMMMKZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZdMMM");
		System.out.println("MMMMKZZZZZZZZZZZZZZZZZZZZZZZZZyZyZZZZZZZZZZZZZdMMM");
		System.out.println("MMMMKZZZZZZZZZZZMMM#ZZZZZZZZZZZMMM#ZZZZZZZZZZZdMMM");
		System.out.println("MMMMmmmkZZZZZQmQMMMNmmkZZZZZQmmMMMNmmkZZZZZQmmdMMM");
		System.out.println("MMMMMMMHZZZZZMMMMMMMMM#ZZZZyMMMMMMMMM#ZZZZZdMMMMMM");
		System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");



	}

	@Override
	public String toString() {
		return "アカベイ (" + name + ")";
	}
}
