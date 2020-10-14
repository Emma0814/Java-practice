package program;

import java.util.*;
import java.util.regex.*;
public class 行编辑器 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split("\\|");
		ArrayList<String> result = complile(str);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	private static ArrayList<String> complile(String[] str) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		int num = str.length;
		for (int i = 0; i < num; i++) {
			String[] entry = str[i].split(" ");
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(entry[0]);
			if(!isNum.matches()) {
				System.out.println("error");
			}
			if(Integer.valueOf(entry[0]) > num) {
				System.out.println("error");
			}
			if(entry[1].length() == 1 && entry[1].charAt(0) == 'a') {
				StringBuilder sb = new StringBuilder();
				for(int j = 2; j < entry.length; j++) {
					sb.append(" "+ entry[j]);
				}
				result.add(Integer.valueOf(entry[0]),sb.toString().trim());
			}
			if(entry[1].length() == 1 && entry[1].charAt(0) == 'i') {
				StringBuilder sb = new StringBuilder();
				for(int j = 2; j < entry.length; j++) {
					sb.append(" " + entry[j]);
				}
				System.out.println(sb.toString());
				result.add(Integer.valueOf(entry[0])-1,sb.toString().trim());
			}
			if(entry[1].length() == 1 && entry[1].charAt(0) == 'r') {
				StringBuilder sb = new StringBuilder();
				for(int j = 2; j < entry.length; j++) {
					sb.append(" " + entry[j]);
				}
				System.out.println(sb.toString());
				result.set(Integer.valueOf(entry[0])-1,sb.toString().trim());
			}
			if(entry[1].length() == 1 && entry[1].charAt(0) == 'd') {
				result.remove(Integer.valueOf(entry[0])-1);
			}
		}
	
		
		
		return result;
	}

}
