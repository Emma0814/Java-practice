package program;

import java.util.*;
public class 迷宫 {

	public static int M = 0;
	public static int B = 0;
	public static int N = 0;
	public static ArrayList<String[]> dirs = new ArrayList<>();
	public static String[][] map;
	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = Integer.parseInt(sc.nextLine());
		B = Integer.parseInt(sc.nextLine());
		N = Integer.parseInt(sc.nextLine());
		map = new String[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) 
				map[i][j] = "0";
		}
		for (int i = 0; i < B; i++) {
			String[] str = sc.nextLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			map[x][y] = "X";
		}
		int x = 0;
		int y = 0;
        boolean invalid = false;
		for (int i = 0; i < N; i++) {
			String[] str = sc.nextLine().split(" ");
			long step = Long.parseLong(str[1]);
			switch(str[0]) {
			case "R":
				for(int k = 1; k <= step; k++) {
					count++;
                    if (y+1>=M) {
                        System.out.println("INVALID");
                        return;
				    }
					if (!map[x][y+1].equals("X")) {
						y++;
					}
					map[x][y] = String.valueOf(count);
				}
				break;
			case "D":
				for(int k = 1; k <= step; k++) {
					count++;
                    if (x+1>=M) {
                        System.out.println("INVALID");
                        return;
				    } else {
                        if (!map[x+1][y].equals("X")) {
                            x++;
                        }
                        map[x][y] = String.valueOf(count);
                    }
				}
				break;
			case "L":
				for(int k = 1; k <= step; k++) {
					count++;
                    if (y-1<0) {
                        System.out.println("INVALID");
                        return;
				    }
					if (!map[x][y-1].equals("X")) {					
						y--;
					}
					map[x][y] = String.valueOf(count);
				}
				break;
			case "U":
				for(int k = 1; k <= step; k++) {
					count++;
                    if (x-1<0) {
                        System.out.println("INVALID");
                        return;
				    }
					if (!map[x-1][y].equals("X")) {						
						x--;
					}
					map[x][y] = String.valueOf(count);
				}
				break;

			}
		}
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M-1; j++) {
				System.out.printf("%-5s", map[i][j]);
			}
			System.out.println(map[i][M-1]);
		}		
	}
}

