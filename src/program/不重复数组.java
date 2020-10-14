package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 不重复数组 {

	private static List<String> list = new ArrayList<>();
	public static void swap(int[] arr, int i, int j){
	     if(i ==j)
	         return;
	     int temp = arr[i];
	     arr[i] = arr[j];
	     arr[j] = temp;
	 }
	 public static void fullSort(int[] arr){
		 list.removeAll(list);
		 allKind(arr, 0, arr.length);
	 } 
	 public static void allKind(int[] arr, int from, int end){
	     if (from == end){
	    	 String str = Arrays.toString(arr);
	    	 if(!list.contains(str)) {
	    		 list.add(str);
	    		 System.out.println(str);
	    	 }
	    	 return;
	     }else {
	         for (int i = from; i < end; i++){
	             swap(arr, from, i);
	             allKind(arr, from + 1, end);
	             swap(arr, i, from);
	         }
	     }
	 }
	 public static void main(String[] args) {
		 int[] arr = {11,3,0,5};
		 fullSort(arr); 
	 }
}
