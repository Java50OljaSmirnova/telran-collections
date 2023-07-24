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
				res += counter(counter(-a, count, range), count, range-1);
			} else {
				res += counter(counter(a, count, range), count, range-1);
			}
		}
		return res;
	}
	private static int counter(int a, int count, int range) {
		if(count == 0) {
			return 0;
		}
		if(range == 0) {
			return a;
		}
		return count < 0 ? counter(a, count + 1, range) + a : counter(a, count - 1, range) + a;
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
		 
		return isSubstring(string, subStr, 0, 0);
	}
	private static boolean isSubstring(String string, String subStr, int strIndex, int subIndex) {
		int lengthStr = string.length();
		int lengthSub = subStr.length();
		boolean res = false;
		if(strIndex > lengthStr - lengthSub) {
			return false;
		}

		if(string.charAt(strIndex) == subStr.charAt(subIndex)){
			String str = string.substring(strIndex, strIndex + lengthSub);
			if(str.equals(subStr)) {
				res = true;
			} else {
				isSubstring(string, subStr, strIndex + 1, subIndex);
			}
		}
		return res ? true : isSubstring(string, subStr, strIndex + 1, subIndex);
	}
}
