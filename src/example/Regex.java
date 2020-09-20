package example;

public class Regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "3+2$*{1+2*[-4/(8-6)+7]}";
		String str2 = str.replaceAll("(?<![0-9)}\\]])(?=-[0-9({\\[])", "0") + "#";
		System.out.println(str2);
	}

}
