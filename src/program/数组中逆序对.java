package program;

import java.util.ArrayList;

public class 数组中逆序对 {

	private static int inversePairs(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}
	
	private static int mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			int l = mergeSort(arr, left, mid);
			int r = mergeSort(arr, mid + 1, right);
			int m = merge(arr, left, mid, right);
			return l + m + r;
		} 
		return 0;
	}
	
	private static int merge(int[] arr, int left, int mid, int right) {
		int i = mid;
		int j = right;
		int count = 0;
		ArrayList<Integer> temp = new ArrayList<>();
		while (i >= left && j > mid) {
			if (arr[i] > arr[j]) {
				count += j - mid;
				temp.add(0, arr[i--]);
			} else 
				temp.add(0, arr[j--]);
		}
		while (i >= left) 
			temp.add(0, arr[i--]);
		while (j > mid) 
			temp.add(0, arr[j--]);
		for (int num : temp)
			arr[left++] = num;
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,44,38,5,77,9};
		System.out.println(inversePairs(arr));
	}
}
