package program;

import java.util.*;
import java.util.regex.*;
public class 行编辑器 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split("\\|");
		ArrayList<String> result = complile(str);
		for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}

	private static ArrayList<String> complile(String[] str) {
		ArrayList<String> result = new ArrayList<String>();
		int num = str.length;
		for (int i = 0; i < num; i++) {
			String[] entry = str[i].split(" ");
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(entry[0]);
			if (!isNum.matches()) 
				System.out.println("error");
			if (Integer.valueOf(entry[0]) > num)
				System.out.println("error");
			if (entry[1].length() == 1) {
				StringBuilder sb = new StringBuilder();
				for(int j = 2; j < entry.length; j++)
					sb.append(" " + entry[j]);
				String temp = sb.toString().trim();
				switch (entry[1].charAt(0)) {
				case 'a':
					result.add(Integer.valueOf(entry[0]), temp);
					break;
				case 'i':
					System.out.println(temp);
					result.add(Integer.valueOf(entry[0]) - 1,temp);
					break;
				case 'r':
					System.out.println(sb.toString());
					result.set(Integer.valueOf(entry[0]) - 1, temp);
					break;
				case 'd':
					result.remove(Integer.valueOf(entry[0]) - 1);
				}
			}
		}
		return result;
	}
}
