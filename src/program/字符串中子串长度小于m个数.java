package program;

import java.util.*;
public class 字符串中子串长度小于m个数{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		long n = Long.parseLong(arr[0]);
		long m = Long.parseLong(arr[1]);
		long sum = (long) Math.pow(2, n);
		long result = (long) ((sum - solution(n, m)) % (1e9 + 7));
		System.out.println(result);
	}

	private static long solution(long n, long m) {
		long count = 0;
		for (long i = m; i <= n; i++) {
			for (long j = 0; j < n - i + 1; j++) {
				count++;
				long left = n - i - 1 - j;
				if (left >= i)
					count += solution(left, m);
			}
		}
		return count;
	}
}
