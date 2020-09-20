package program;

import java.util.*;

/**
 * The last integer after "," is threshold
 * Find any two nums, sum equals to threshold
 * Count total of all possible group
 * @author emmajing
 *
 */
public class SumEqualToThreshold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();  //"0,1,5,11,17,16,2,5,10,30,12"
        String[] arr = line.split(",");
        int[] arr2 = new int[arr.length-1];
        for (int i = 0; i < arr.length - 1; i++) 
        	arr2[i] = Integer.parseInt(arr[i]);
        int total = 0;
        int threshold = Integer.parseInt(arr[arr.length-1]);
        for(int i = 0; i < arr2.length; i++) 
        	for(int j = i+1; j < arr2.length; j++)
        		if(arr2[i] + arr2[j] == threshold)
        			total = total + i + j ;
        System.out.println(total);   // (1+3)+(6+8)=18
    }
} 