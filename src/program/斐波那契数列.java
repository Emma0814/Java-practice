package program;
 
import java.util.*;
public class 斐波那契数列{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0 || n == 1){
            System.out.println(1);
            return;
        }
        long n0 = 1, n1 = 1;
        for (int i = 2; i <= n; i++) {
            n1 = n0+n1;
            n0 = n1- n0;
        }
        System.out.println(n1);
    }
}
