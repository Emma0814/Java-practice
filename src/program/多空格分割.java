package program;

public class 多空格分割 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tstr = "ddd  ll dd";
		String[] mask = tstr.split("\\s+");
		for (int i = 0; i < mask.length; i++) {
			System.out.println(mask[i]);
		}
//		ddd
//		ll
//		dd

	}
}
