package program;

import java.util.*;
public class Fibcount {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long ans = 0;
        long cnt = 1;
        long a = 0;
        while(true){
            if(ans+cnt >= n) break;
            ans += cnt;
            cnt += a;
            a = cnt-a;
        }
        System.out.println(ans);
	}

}
