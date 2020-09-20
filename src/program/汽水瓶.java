package program;

import java.util.*;

/**
 * 三个空汽水瓶可以换一瓶汽水
 * @author emmajing
 *
 */
public class 汽水瓶 {
    public static int returnBottle(int n, int sum){
        if (n == 2)
            return sum + 1;
        if (n > 2)
            sum = returnBottle(n/3 + n%3, sum + n/3); 
        return sum;
    }
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(sc.hasNextInt()){ 
            int n = sc.nextInt();
            if (n == 0)
                break;
            list.add(returnBottle(n, 0));
        }
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
