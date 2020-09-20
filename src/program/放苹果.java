package program;

import java.util.*;
public class 放苹果 {
    
	public static int count(int m, int n){
        if (m == 0 || n == 1)
           return 1;
        else if (m < n)
             return count(m, m);
        return count(m, n - 1) + count(m - n, n);
    }
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (m < 0 || m > 10 || n < 1 || n > 10)
                System.out.println(-1);
            System.out.println(count(m, n));
        }
    }
}

