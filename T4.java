import java.util.Arrays;

public class T4 {
	static int calls = 0;

	public static int indexOf(String[] arr, String c) {
		calls = 0;
		return indexOf(arr, 0, arr.length - 1, c);

	}

	static int indexOf(String[] array, int left, int right, String key) {
		if (left > right)
			return -1;
		calls++;
		int middle = (left + right) / 2; // D(N)
		if (array[middle] == "") {
			int iH1 = indexOf(array, left, middle - 1, key);
			int iH2 = indexOf(array, middle + 1, right, key);
			if (iH1 >= 0)
				return iH1;
			else
				return iH2;
		}
		if (array[middle] == key)
			return middle; // T(N/2)
		if (key.compareTo(array[middle]) > 0)
			return indexOf(array, middle + 1, right, key);
		else
			return indexOf(array, left, middle - 1, key);
	}

	public static boolean exists;

	public static int indexOf(int[] arr, int n) {
		calls = 0;
		exists = true;
		int i = indexOf(arr, 0, arr.length - 1, n);
		if (exists) {
			return i;
		} else
			return -1 * (i + 1);

		// if (arr.length == 0){
		// exists = false;
		// return 0;
		// }
		// if (arr.length == 1 && arr[0] != n) {
		// exists = false;
		// if(arr[0] > n) return 1;
		// return 0;
		// // return (arr[0]<n)?1:-1;
		// }
		// int half = (arr.length / 2);
		// if (arr[half] == n){
		// exists = true;
		// return half;
		// }

		// if (arr[half] > n) {
		// int[] h1 = Arrays.copyOfRange(arr, 0, half);
		// int iH1 = indexOf(h1, n);
		// if (exists)
		// return iH1;
		// else
		// return -1 * (1 - iH1);
		// }
		// if (arr[half] < n) {
		// int[] h2 = Arrays.copyOfRange(arr, half , arr.length);
		// int iH2 = indexOf(h2, n);

		// if (exists)
		// return half + iH2;
		// else
		// return -1 * (half - iH2 + 1);
		// }

		// return 0;
	}

	static int indexOf(int[] array, int left, int right, int key) {
		if (left > right) {
			exists = false;
			return left;
		}

		calls++;
		int middle = (left + right) / 2; // D(N)
		if (array[middle] == key)
			return middle; // T(N/2)
		if (key > array[middle])
			return indexOf(array, middle + 1, right, key);
		else
			return indexOf(array, left, middle - 1, key);
	}

	public static int[] maxsubarray(int[] arr) {
		calls = 0;
		int[] ded = new int[2];
		ded[0] = indexOf(arr, 0, arr.length - 1);
		ded[1] = arr.length - 1;
		return ded;
	}

	static int indexOf(int[] array, int left, int right) {
		if (left > right)
			return left;
		calls++;
		int middle = (left + right) / 2; // D(N)
		if (array[middle] == 0)
			return middle; // T(N/2)
		if (0 > array[middle])
			return indexOf(array, middle + 1, right);
		else
			return indexOf(array, left, middle - 1);
	}

	public static void main(String[] args) {
		String[] array = { "a", "b", "c", "d", "e", "", "", "f", "h", "", "i", "j" };
		System.out.println(indexOf(array, "a")); // 0
		System.out.println(indexOf(array, "b")); // 1
		System.out.println(indexOf(array, "c")); // 2
		System.out.println(indexOf(array, "d")); // 3
		System.out.println(indexOf(array, "e")); // 4
		System.out.println(indexOf(array, "f")); // 7
		System.out.println(indexOf(array, "g")); // -1
		System.out.println(indexOf(array, "h")); // 8
		System.out.println(indexOf(array, "i")); // 10
		System.out.println(indexOf(array, "j")); // 11

		System.out.println("---------------------------");

		int[] arr = { -3, -1, 1, 3 };
		System.out.println(indexOf(arr, -10)); // -1
		System.out.println(indexOf(arr, -3)); // 0
		System.out.println(indexOf(arr, -2)); // -2
		System.out.println(indexOf(arr, -1)); // 1
		System.out.println(indexOf(arr, 0)); // -3
		System.out.println(indexOf(arr, 1)); // 2
		System.out.println(indexOf(arr, 2)); // -4
		System.out.println(indexOf(arr, 3)); // 3
		System.out.println(indexOf(arr, 4)); // -5

		System.out.println("----------------------");

		int[] ded = { -5, -4, -3, -1, 0, 1, 3 };
		for (int i : maxsubarray(ded)) {
			System.out.println(i);
		} // 4 6

	}

}
