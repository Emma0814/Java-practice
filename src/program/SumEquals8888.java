package program;

/**
 * a、b、c、d为0-9的正整数，abcd+bcda=8888
 * 输出满足要求的所有a、b、c、d
 * @author emmajing
 *
 */
public class SumEquals8888 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,d;
		for (int i = 0; i < 8888; i++ ) {
			a = i/1000;
			b = (i-a*1000)/100;
			c = (i-a*1000-b*100)/10;
			d = i-a*1000-b*100-c*10;
			if((i+b*1000+c*100+d*10+a) == 8888)
				System.out.println(a+" "+b+" "+c+" "+d);
		}
	}
}
