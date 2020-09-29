package program;

import java.util.*;
public class 组合卖最大利润{
	public static void main(String[] args) {
//		Scanner sc = new Scanner (System.in);
//		String[] arr = sc.nextLine().split(" ");
		String line = "1 1 2 4 6 7 8";
		String[] arr = line.split(" ");
		long A = Long.parseLong(arr[0]);
		long B = Long.parseLong(arr[1]);
		long C = Long.parseLong(arr[2]);
		long D = Long.parseLong(arr[3]);
		long E = Long.parseLong(arr[4]);
		long F = Long.parseLong(arr[5]);
		long G = Long.parseLong(arr[6]);
		long sum = 0;
		for (int j = 0; j < C; j++) {
			if (D-- > 0) {
				sum += G;
			} else {
				System.out.println(sum);
				return;
			}
		}
		for (int j = 0; j < B; j++) {
			if (D-- > 0) {
				sum += F;
			} else {
				System.out.println(sum);
				return;
			}
		}
		for (int j = 0; j < A; j++) {
			if (D-- > 0) {
				sum += E;
			} else {
				System.out.println(sum);
				return;
			}
		}
		System.out.println(sum);
	}

}
