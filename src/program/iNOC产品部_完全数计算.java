package program;

import java.util.*;
public class iNOC产品部_完全数计算 {
    public static boolean isPerfectNumber(int num){
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                sum += i;
        }
        return num == sum;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
        	int num = sc.nextInt();
        	int count = 0;
        	if (num <= 0 || num > 500000) {
        		System.out.println(-1);
        		return;
        	}
        	for (int i = 1; i <= num; i++) {
        		if (isPerfectNumber(i))
        			count++;
        	}
        	System.out.println(count);
        }
	}
}

