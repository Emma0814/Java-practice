package program;

import java.util.*;
public class 迷宫得分{
	public static int N;
	public static int M;
	public static int P;
	public static int Q;
	public static int X;
	public static int Y;
	public static int score = 0;
	public static char[][] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
		N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        P = Integer.parseInt(str[2]);
        Q = Integer.parseInt(str[3]);
        arr = new char[N+2][M+2];
        
        // Read map
        for (int i = 0; i < M+2; i++) {
        	arr[0][i] = '#';
        }
        for (int i = 1; i <= N; i++) {
        	String line = sc.nextLine();
        	arr[i][0] = '#';
        	for (int j = 1; j <= M; j++) {
        		arr[i][j] = line.charAt(j-1);
        		if(line.charAt(j-1) == 'S') {
        			X = i;
        			Y = j;
        		}
        	}
        	arr[i][M+1] = '#';
        }
        for (int i = 0; i < M+2; i++) {
        	arr[N+1][i] = '#';
        }
        for (int i = 0; i< arr.length; i++) {
        	for (int j = 0; j < arr[0].length; j++) {
        		System.out.print(arr[i][j]);
        	}
        	System.out.println();
        }
        // Go
        String step = sc.nextLine();
        for (int k = 0; k < step.length(); k++) {
        	if(step.charAt(k) == 'W') {
        		if (isWall(X-1, Y))
        			continue;
        		X = X-1;
        		if (isO(X, Y)) {
        			score += P;
        			arr[X][Y] = '+';
        		}
        		if (isX(X, Y)) {
        			score -= Q;
        			arr[X][Y] = '+';
        		}
        	} else if (step.charAt(k) == 'A') {
        		if (isWall(X, Y-1))
        			continue;
    			Y = Y-1;
        		if (isO(X, Y)) {
        			score += P;
        			arr[X][Y] = '+';
        		}
        		if (isX(X, Y)) {
        			score -= Q;
        			arr[X][Y] = '+';
        		}
        	} else if (step.charAt(k) == 'S') {
        		if (isWall(X+1, Y))
    				continue;;
    			X = X+1;
        		if (isO(X, Y)) {
        			score += P;
        			arr[X][Y] = '+';
        		}
        		if (isX(X, Y)) {
        			score -= Q;
        			arr[X][Y] = '+';
        		}
        		
        	} else if (step.charAt(k) == 'D') {
        		if (isWall(X, Y+1))
    				break;
    			Y = Y+1;
        		if (isO(X, Y)) {
        			score += P;
        			arr[X][Y] = '+';
        		}
        		if (isX(X, Y)) {
        			score -= Q;
        			arr[X][Y] = '+';
        		}
        	}
        }
        System.out.println(score);
        
    }
    
    public static boolean isWall(int x, int y) {
    	return arr[x][y] == '#';
    }
    
    public static boolean isO(int x, int y) {
    	return arr[x][y] == 'O';
    }
    
    public static boolean isX(int x, int y) {
    	return arr[x][y] == 'X';
    }
}