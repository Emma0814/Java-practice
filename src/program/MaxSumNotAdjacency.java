package program;

import java.util.*;
public class MaxSumNotAdjacency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String s[] = str.split(",");
		int len = s.length;
		int [] num = new int[len];
		for(int i = 0; i < len; i++)
			num [i]= Integer.parseInt(s[i]);
		int [] sum = new int[len+1];
		sum[0] = 0;
		sum [1] = num[0];
		for(int i =2; i <=len; i++)
			sum[i] = Math.max(sum[i-1], sum[i-2]+num[i-1]);
		System.out.println(sum[len]);
	}

}
