package program;

import java.util.*;

public class 蛇形走 {
	private static boolean isDir = true;
    private static int N = 0;
    private static int[][] graph;
    private static int num;
 
    private static void createGraph1(int start){
		int x = start;
		int y = start;
		// D
		for (; y < N - start - 1; y++) 
			graph[x][y] = num++;
		// S
		for (; x < N - start - 1; x++) 
			graph[x][y] = num++;
		// A
		for (; y > start; y--) 
			graph[x][y] = num++;
		// W
		for (; x > start; x--) 
			graph[x][y] = num++;
		isDir = false;
	}

	private static void createGraph2(int start) {
		int x = start;
		int y = start;
		// S
		for (; x < N - start - 1; x++) 
			graph[x][y] = num++;
		// D
		for (; y < N - start - 1; y++) 
			graph[x][y] = num++;
		// W
		for (; x > start; x--) 
			graph[x][y] = num++;
		// A
		for (; y > start; y--) 
			graph[x][y] = num++;
		isDir = true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = Integer.parseInt(sc.nextLine());
		ArrayList<Integer> list = new ArrayList<>();
		while (C-- > 0) {
			String[] str = sc.nextLine().split(" ");
			num = 1;
			int N2 = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			if (N2 != N) {
				isDir = true;
				N = Integer.parseInt(str[0]);
				graph = new int[N][N];
				int start = 0;
				if (N == 1) {
					graph[0][0] = 1;
				} else {
					while (num < N * N) {
						if (isDir) 
							createGraph1(start);
						else 
							createGraph2(start);
						start++;
						if (num > N * N)
							break;
						else if (num == N * N)
							graph[start][start] = N * N;
					}
				}
			}
			while (M-- > 0) {
				String[] str1 = sc.nextLine().split(" ");
				int x = Integer.parseInt(str1[0]);
				int y = Integer.parseInt(str1[1]);
				list.add(graph[x][y]);
			}
		}
		for (int i : list)
			System.out.println(i);
	}
}