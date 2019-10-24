import java.util.Arrays;

public class T4 {
	public static int indexOf(String[] arr, String c) {
		if (arr.length == 0) return -1;
		int half = arr.length/2;
		if (arr[half] == c) return half;
		if (arr[half] == "") {
			String[] h1 = Arrays.copyOfRange(arr, 0, half);
			String[] h2 = Arrays.copyOfRange(arr, half+1, arr.length);
			int iH1 = indexOf(h1, c);
			int iH2 = indexOf(h2, c);
			if (iH1 >= 0) return iH1;
			if (iH2 < 0) return -1;
			return half + iH2 + 1;
		}
		if (arr[half].compareTo(c)>0) {
			String[] h1 = Arrays.copyOfRange(arr, 0, half);
			int iH1 = indexOf(h1, c);
			if (iH1 >= 0) return iH1;
			return -1;
		}
		if (arr[half].compareTo(c)<0) {
			String[] h2 = Arrays.copyOfRange(arr, half+1, arr.length);
			int iH2 = indexOf(h2, c);
			if (iH2 >= 0) return half + iH2 + 1;
			return -1;
		}
		return 0;
	}
	public static boolean exists;
	public static int indexOf(int[] arr, int n){
		exists = true;
		if (arr.length == 0) return 0;
		int half = arr.length/2;
		if (arr[half] == n) return half;
		if(arr.length == 1 && arr[0] < n){
			exists = false;
			return 0;
		}
		if(arr.length == 1 && arr[0] > n){
			exists = false;
			return 0;
		}

		if (arr[half]>n) {
			int[] h1 = Arrays.copyOfRange(arr, 0, half);
			int iH1 = indexOf(h1, n);
			if (exists) return iH1;
			return -1 * (iH1 );
		}
		if (arr[half]<n) {
			int[] h2 = Arrays.copyOfRange(arr, half+1, arr.length);
			int iH2 = indexOf(h2, n);
			
			if (exists) return half + iH2+1;
			return -1 * ( half + iH2+ 1);
		}
		
		return 0;
	}

	// public static int[] maxsubarray(int[] arr) {
	// 	int left, half, right;
	// 	left = 0;
	// 	half = arr.length/2 - 1;
	// 	right = arr.length-1;
	// 	if()
		
	// }

	public static void main(String[] args) {
		// String[] array = { "a", "b", "c", "d", "e", "", "", "f", "h", "", "i", "j" };
		// System.out.println(indexOf(array, "a"));	//0
		// System.out.println(indexOf(array, "b"));	//1
		// System.out.println(indexOf(array, "c"));	//2
		// System.out.println(indexOf(array, "d"));	//3
		// System.out.println(indexOf(array, "e"));	//4
		// System.out.println(indexOf(array, "f"));	//7
		// System.out.println(indexOf(array, "g"));	//-1
		// System.out.println(indexOf(array, "h"));	//8
		// System.out.println(indexOf(array, "i"));	//10
		// System.out.println(indexOf(array, "j"));	//11
		
		int[] arr = {-3, -2,-1, 0, 2, 5};
		System.out.println(indexOf(arr, -5));	//-1
		System.out.println(indexOf(arr, -3));	//0
		System.out.println(indexOf(arr, -2));	//1
		System.out.println(indexOf(arr, -1));	//2
		System.out.println(indexOf(arr, 0));	//3
		System.out.println(indexOf(arr, 01));	//-4
		System.out.println(indexOf(arr, 02));	//4
		System.out.println(indexOf(arr, 03));	//-5
		System.out.println(indexOf(arr, 04));	//-5
		System.out.println(indexOf(arr, 05));	//5
		System.out.println(indexOf(arr, 06));	//6
		System.out.println(indexOf(arr, 07));	//-7
	}
}
