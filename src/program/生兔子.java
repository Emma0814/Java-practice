package program;

import java.util.Scanner;
public class 生兔子{
	public static int getTotalCount(int n){
        if (n < 3){
            return 1;
        }
        return getTotalCount(n - 2) + getTotalCount(n - 1) ;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(getTotalCount(n));
        }
    }
}