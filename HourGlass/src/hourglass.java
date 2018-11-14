
public class hourglass {
	public static void main(String[] args) {
		hourglass.base();
		hourglass.sand(8);
		hourglass.mid();
		hourglass.sand(2);
		hourglass.base();
	}
	public static void print(String s, int count) {
		for (int i = 1; i<= count; i++) {
			System.out.print(s);
		}
	}
	public static void base() {
		hourglass.print("|",1);
		hourglass.print("\"", 10);
		hourglass.print("|", 1);
		hourglass.print("\n", 1);
	}
	public static void sand(int line) {
		int linenum = line;
		for(int spacing = 1; spacing<=4; spacing++) {
			if (line ==8) {
				hourglass.print(" ", spacing);
				hourglass.print("\\", 1);
				hourglass.print(":", linenum);
				hourglass.print("/", 1);
				hourglass.print("\n", 1);
				linenum-=2;
			}
			else {
				hourglass.print(" ", (5-spacing));
				hourglass.print("/", 1);
				hourglass.print(":", linenum);
				hourglass.print("\\", 1);
				hourglass.print("\n", 1);
				linenum+=2;
			}
		}
	}
	public static void mid() {
		hourglass.print(" ", 5);
		hourglass.print("||", 1);
		hourglass.print("\n", 1);
	}
}
