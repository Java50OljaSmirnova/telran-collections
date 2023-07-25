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
		long res = 1;
		if(b > 0) {
			res = multiply(a, pow(a, b-1));
		}
		return res;
	}
	
	
	private static int multiply(int a, long b) {
		int res = 0;
		if(b != 0) {
			res = b < 0 ? multiply(-a, -b): a + multiply(a, b - 1);
		}
		return res;
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
		int res = 0;
		if(x != 0) {
			res = x < 0 ? square(-x) : x + x - 1 + square(x - 1);
		}
		return res;
	}
	public static boolean isSubstring(String string, String subStr) {
		 
		boolean res = false;
		if(string.length() >= subStr.length()) {
			res = isEqual(string, subStr) ? true : isSubstring(string.substring(1), subStr);
		}
		return res;
	}
	private static boolean isEqual(String str, String substr) {
		boolean res = false;
		if(substr.length() == 0) {
			res = true;
		}else if (str.charAt(0) == substr.charAt(0)) {
			res = isEqual(str.substring(1), substr.substring(1));
		}
		return res;
	}
	
}