import java.util.*;
public class ArraysLab3 {

	public static void main(String[] args) {
		int[] a1 = {5,10,15,20,25,30,35,40};
		int[] a2 = {7,14,21,28,35,42,49,56};
		int appendnum = 200;
		int removeidx = 5;
		int[] sumArr = sum(a1,a2);
		int[] appendarr = append(a1, appendnum);
		int[] removearr = remove(a2,removeidx);
		int sumofevens = sumEven(appendarr);
		System.out.println("sumArr: " + Arrays.toString(sumArr));
		System.out.println("appendArr: " + Arrays.toString(appendarr));
		System.out.println("removeArr: " + Arrays.toString(removearr));
		System.out.println("Sum Of Evens: " + sumofevens);
		System.out.println("a1 :" + Arrays.toString(a1));
	}
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] holder = new int[arr1.length];
		for(int i = 0; i < holder.length; i++) {
			holder[i] = arr1[i] +arr2[i];
		}
		return holder;
	}
	public static int[] append(int[] arr, int num) {
		int[] holder = new int[(arr.length+1)];
		for (int i = 0; i < holder.length; i++) {
			holder[i] = arr[i];
		}
		holder[holder.length] = num;
		return holder;
	}
	public static int[] remove ( int[] arr, int idx) {
		int[] holder = new int[arr.length-1];
		for (int i = 0; i <arr.length; i++) {
			if (i < idx){
				holder[i] = arr[i];
			}
			else {
			holder[i] = arr[i+1];
			}
		}
		return holder;
	}
	public static int sumEven(int[]arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i +=2){
			sum = sum + arr[i];
		}
		return sum;
	}
	public static void rotateRight(int[] arr) {
		int holder = arr[0];
		for (int i = (arr.length-1); i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = holder;
	}
}
