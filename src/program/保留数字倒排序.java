package program;

import java.util.*;
public class 保留数字倒排序 {
	public static String sort(ArrayList<Integer> list) {
		int[] arr = new int[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < arr.length; i++) {
			int first = arr[i];
			int left = 0, right = i-1;
			while(left <= right) {
				int mid = (left + right)/2;
				if(first < arr[mid])
					right = mid -1;
				else
					left = mid + 1;
			}
			for (int j = i-1; j >= left; j--)
				arr[j+1] = arr[j];
			arr[left] = first;
		}
		for (int key : arr) {
			sb.insert(0, key);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String line = "[-2,ll,5,6,7,7]";
		 String[] str = line.substring(1, line.length()-1).split(",");
		 if(str[0].equals("")) {
			 System.out.println(".");
			 return;
		 }
		 ArrayList<Integer> list = new ArrayList<>();
		 for (int i = 0; i < str.length; i++) {
			 int key = 0;
			try {
				key = Integer.parseInt(str[i]);
				if (key >= 0) {
					list.add(key);
				}
			} catch (Exception e) {
			}
		 }
		 if(list.size() == 0) {
			 System.out.println(".");
			 return;
		 }
		 String result = sort(list); 
		 System.out.println(result);
	 }
}
