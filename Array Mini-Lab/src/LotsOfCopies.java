import java.util.*;
public class LotsOfCopies {
	
	public static void main(String[] args) {
		int num = 7;
		String strmain = "APCS";
		int[] arrmain = {1,2,3,4,5};
		changeme(num,strmain, arrmain);
		System.out.println("num: " + num);
		System.out.println("strmain: " + strmain);
		System.out.println("arrmain : " + (Arrays.toString(arrmain)));
		part2ints();
		part2Strings();
		part2arrays();
	}
	
	public static void changeme (int x, String str, int[] arr) {
		x++;
		str += str;
		arr[2] = 42;
	}
	public static void part2ints () {
		System.out.println("=====PART 2 INTS=====");
		int a = 7; // a = startValue
		int b = a; // b = a
		a = 1;     // a = newValue
		System.out.println("a: " + a);
		System.out.println("b: "+ b);
	}
	public static void part2Strings() {
		System.out.println("=====PART 2 STRINGS=====");
		String a = ("My name is Bob!");
		String b = a;
		a = ("Sike my name is really Bryan!");
		System.out.println(a);
		System.out.println(b);
	}
	public static void part2arrays() {
		System.out.println("=====PART 2 ARRAYS=====");
		int[] a = {1,2,3,4,5};
		int[] b = a;
		a[2] = 9999999;
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
	}
}

