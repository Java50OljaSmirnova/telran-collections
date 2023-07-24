package telran.recursion;

public class LinearRecursion {
	public static void function(int a) {
		if(a > 3) {
			function(a - 1);
		}
	}
	public static long factorial(int n) {
		long res = 1;
		if(n < 0) {
			throw new IllegalArgumentException("factorial exists only for positive numbers or 0");
		}
		if(n > 0) {
			res = n * factorial(n - 1);
		}
		return res;
	}
	public static long pow (int a, int b) {
		if(b < 0) {
			throw new IllegalArgumentException("degree cannot be a negative");
		}
		if(b == 0) {
			return 0;
		}
		int range = b - 1;
		int count = a;
		return b == 1 ? a : pow(a, b-1, range, count);
	}
	
	
	private static long pow(int a, int b, int range, int count) {
		long res = 0;
		if(b > 0) {
			if(a < 0 && range % 2 != 0) {
				res = counter(-a, count);
			} else {
				res = counter(a, count) + counter(counter(a, count), count);
			}
		}
		return res;
	}
	private static int counter(int a, int count) {
		if(count == 0) {
			return 0;
		}
		return count < 0 ? counter(a, count + 1) + a : counter(a, count - 1) + a;
	}
	public static void displayArray(int[] ar) {
		displayArray(0, ar, false);
	}
	public static void displayReversArray(int[] ar) {
		displayArray(0, ar, true);
	}
	private static void displayArray(int index, int[] ar, boolean isReverse) {
		if(index < ar.length) {
			if(isReverse) {
				displayArray(index+1, ar, isReverse);
				System.out.print(ar[index] + " ");
			}else {
				System.out.print(ar[index] + " ");
				displayArray(index+1, ar, isReverse);
			}
		}	
	}
	public static long sumArray(int[] array) {
		return sumArray(0, array);
	}
	private static long sumArray(int index, int[] array) {
		long res = 0;
		if(index < array.length) {
			res = array[index] + sumArray(index+1, array);
		}
		return res;
	}
	public static void reverseArray(int[] array) {
		reverseArray(0, array, array.length-1);
	}
	private static void reverseArray(int left, int[] array, int right) {
		if (left < right) {
			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			reverseArray(left+1, array, right-1);
		}	
	}
	public static int square(int x) {
		if( x == 0) {
			return 0;
		}
		return x > 0 ? square(x - 1) + x + x - 1 : square(x + 1) - x - (x + 1);
	}
	public static boolean isSubstring(String string, String subStr) {
		//TODO
		// returns true if a given 'substr' is indeed the //substring of a given `string` 

		/*
		  Challenges:
		 1. To apply only following methods of the class String: charAt(int ind);  
		String substring(int ind); 
		 int length(); 
		2. No cycles;
		*/ 
		return false;
	}
}
