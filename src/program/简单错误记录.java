package program;

import java.util.*;
public class 简单错误记录 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" ");
			String file = str[0].substring(str[0].lastIndexOf('\\') + 1);
			file = file.length() > 16 ? file.substring(file.length()-16) : file;
            map.put(file + " " + str[1], map.getOrDefault(file + " " + str[1], 0) + 1);	
		}
		int count = 0;
        for (String key : map.keySet()) {
        	count++;
	        if (count > (map.size()-8))
	        	System.out.println(key+" "+map.get(key));
	    }
	}
}