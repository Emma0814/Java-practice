package program;

import java.util.Scanner;

public class 基站 {
	public static int connect(int m, int n) {
		if (m == 0  || n == 0)
			return 1;
		if (m < n)
			return connect(m, n);
		return connect(m, n - 1) + connect(m - n, n);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(connect(m, n));
	}

}
