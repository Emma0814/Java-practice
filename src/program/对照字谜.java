package program;

import java.util.*;
import java.util.regex.Pattern;

public class 对照字谜 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String line1 = "ABCD";
			String line2 = "xiao 人 yi yi";
			String[] str = line2.split(" ");
			ArrayList<String>  arr = new ArrayList<>();
			for(int i  =  0; i  <  str.length; i++) {
				if(Pattern.compile("^[A-Za-z ]+$").matcher(str[i]).matches()) {
					arr.add(str[i]);
				} else {
					System.out.println(-1);
					return;
				}
			}
			switch(line1) {
			case "ABAC":
				if(arr.get(0).equals(arr.get(2))
						&& !arr.get(0).equals(arr.get(1))
						&& !arr.get(0).equals(arr.get(3))
						&& !arr.get(2).equals(arr.get(3))) {
					 System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "ABCD":
				if(!arr.get(0).equals(arr.get(1))
						&& !arr.get(0).equals(arr.get(2))
						&& !arr.get(0).equals(arr.get(3))
						&& !arr.get(1).equals(arr.get(3))
						&& !arr.get(1).equals(arr.get(2))
						&& !arr.get(2).equals(arr.get(3))) {
					 System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "AABC":
				if(arr.get(0).equals(arr.get(1))
						&& !arr.get(0).equals(arr.get(2))
						&& !arr.get(0).equals(arr.get(3))
						&& !arr.get(2).equals(arr.get(3))
						) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;	
			default:
				System.out.println(-1);
			}
		} catch(Exception e) {
			System.out.println(-1);
		}
	}
}
