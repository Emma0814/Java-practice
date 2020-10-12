package program;

import java.util.*;

public class 迷宫最短路径 {

	public static int solution(char[][] input) {
		int[] begin = new int[2];
		int[] end = new int[2];
		int[] view = new int[2];
		int[] check = new int[2];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (input[i][j] == '2') {
					begin[0] = i;
					begin[1] = j;
				}
				if (input[i][j] == '3') {
					end[0] = i;
					end[1] = j;
				}
				if (input[i][j] > 96 && input[i][j] < 123) {
					view[0] = i;
					view[1] = j;
				}
				if (input[i][j] > 64 && input[i][j] < 91) {
					check[0] = i;
					check[1] = j;
				}
			}
		}
		return bfs(input, begin, view) + bfs(input, view, check) + bfs(input, check, end);
	}
	
	public static int bfs(char[][] input, int[] begin, int[] end) {
		int[] ddx = {1, 0, -1, 0};
		int[] ddy = {0, 1, 0, -1};
		int n = input.length;
		int m = input[0].length;
		int[][] dis = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(begin);
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < m; j++) 
				dis[i][j] = Integer.MAX_VALUE;
		dis[begin[0]][begin[1]] = 0;
		while (queue.size() > 0) {
			int[] top = queue.poll();
			if (top[0] == end[0] && top[1] == end[1]) 
				break;
			for (int i = 0; i <= 3; i++) {
				int tempY = top[0] + ddy[i];
				int tempX = top[1] + ddx[i];
				if(tempY >= 0 && tempY < dis.length && tempX >= 0 && tempX < dis[0].length 
						&& input[tempY][tempX] != '0' && dis[tempY][tempX] == Integer.MAX_VALUE) {
					dis[tempY][tempX] = dis[top[0]][top[1]] + 1;
					int[] qq = {tempY, tempX};
					queue.offer(qq);
				}
			}
		}
		return dis[end[0]][end[1]];
	}
	
	public static void main(String[] args) {
		char[][] input = {
				{'0', '2', '1', '1', '1'},
				{'0', '1', '1', 'a', 'A'},
				{'0', '1', '0', '0', '3'},
				{'0', '1', '0', '0', '1'},
				{'0', '1', '1', '1', '1'}
		};
		System.out.println(solution(input));
	}
}
