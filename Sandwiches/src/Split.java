import java.util.*;
public class Split {
 public static void main(String[] args) {

	// Your task Part 0
	//String.split();
	//It's a method that acts on a string, <StringName>.split(<String sp>);
	//Where SP is the string where the string splits
	//And it returns an array
	// Example: "I like apples!".split(" ");
	// it will split at spaces and return an array of ["I","like","apples!"]
	System.out.println(Arrays.toString("I like apples!".split(" ")));
	
	// Example 2: "I really like really red apples"split("really")
	// it will split at the word "really" and return an array of ["I "," like ","red apples!"]
	System.out.println(Arrays.toString("I really like really red apples!".split("really")));
	String[] applesArray = ("I really like really red apples!".split("really"));
	System.out.println(Arrays.toString(applesArray));
	
	
	//play around with String.split!
	
	//What happens if you "I reallyreally likeapples".split("really") ?
	System.out.println(Arrays.toString("I reallyreally likeapples!".split("really")));
	
	//Your task Part 1:
	
	/*Write a method that take in a string like
	* "applespineapplesbreadlettustomatobaconmayohambreadcheese"
	* describing a sandwich.
	* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of
	* the sandwich and ignores what's on the outside
	* What if it's a fancy sandwich with multiple pieces of bread?
	*/
	Split.sandwichpart1();

	//Your task pt 2:
	/*Write a method that take in a string like
	* "apples pineapples bread lettus tomato bacon mayo ham bread cheese"
	* describing a sandwich	
	* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of
	* the sandwich and ignores what's on the outside.
	* Again, what if it's a fancy sandwich with multiple pieces of bread?
	*/
	Split.sandwichpart2();
 }
 public static void sandwichpart1() {
	 System.out.println("PART 1");
	 String[] part1 = "applespineapplesbreadlettucetomatobaconmayohambreadcheese".split("bread");
	 System.out.println(part1[1]);
 }
 public static void sandwichpart2() {
	 System.out.println("PART 2");
	 String[] part2 = ("apples pineapples bread lettuce tomato bacon mayo ham bread cheese".split("bread"));
	 System.out.println(part2[1]);
 }
 public static void sum (int[]arr , int[] arr2) {
	 
 }
}