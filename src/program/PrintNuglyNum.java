package program;

import java.util.*;

/**
 * Print the n-th ugly number
 * @author emmajing
 *
 */
public class PrintNuglyNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();

		int two = 0;
		int three =0;
		int five = 0;
		ArrayList<Integer> ugly = new ArrayList<> ();
		ugly.add(1);
		for(int i = 0; i < a-1; i++ ){
			while(true){
				if(ugly.get(two) * 2 > ugly.get(ugly.size()-1))
					break;
				two++;
			}
			while(true){
				if(ugly.get(three) * 3 > ugly.get(ugly.size()-1))
					break;
				three++;
			}
			while(true){
				if(ugly.get(five) * 5 > ugly.get(ugly.size()-1))
					break;
				five++;
			}
			int m = Math.min(ugly.get(two)*2,ugly.get(three)*3);
			int n = Math.min(m,ugly.get(five)*5);
			ugly.add(n);
		}
		System.out.println(ugly.get(a-1));
	}
}