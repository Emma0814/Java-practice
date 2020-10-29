package program;

import java.util.*;
public class 链表排序 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<String> arr = new ArrayList<>();
		HashMap<String, String> list = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			list.put(str[0], str[1]);
			arr.add(str[1]);
		}
		String start = "";
		for (String s : list.keySet()) {
			if(!arr.contains(s)) {
				start = s;
				break;
			}	
		}
		for (int i = 0; i <= n; i++) {
			System.out.println(start);
			start = list.get(start);
		}
	}
}
