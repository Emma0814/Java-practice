package program;

import java.util.*;

public class 解析IP地址 {
	
	public static boolean isError(String str) {
		if (str.equals("255.255.255.255") || str.equals("0.0.0.0"))
			return true;
		String[] mask = str.split("\\.");
		int start = 1;
		for (int i = 0; i < mask.length; i++) {
			int n = Integer.parseInt(mask[i]);
			String s = Integer.toBinaryString(n);
            while (s.length() < 8)
                s = "0" + s;
			if ((s.indexOf('0') != -1 && s.lastIndexOf('1') > s.indexOf('0')) 
					|| (start == 0 && s.indexOf('1') != -1))
				return true;
			start = s.indexOf('0') != -1 ? 0 : 1;
		}
		return false;
	}
    
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        int err = 0, pri = 0;
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split("~");
            String[] ip = str[0].split("\\.");
            if(ip[0] == "0" || ip[0] == "127")
            	continue;
            if (isError(str[1])) { 
            	err++;
            } else {
            	if (ip.length != 4 || ip[0].equals("") || ip[1].equals("") || ip[2].equals("") || ip[3].equals("")) {
            		err++;
            	}else if (Integer.parseInt(ip[0]) >= 1 && Integer.parseInt(ip[0]) <= 126) {
                	a++;
            		if (Integer.parseInt(ip[0]) == 10)
            			pri++;
            	} else if (Integer.parseInt(ip[0]) >= 128 && Integer.parseInt(ip[0]) <= 191) {
            		b++;
            		if (Integer.parseInt(ip[0]) == 172 && (Integer.parseInt(ip[1]) >= 16 && Integer.parseInt(ip[1]) <= 31))
            			pri++;
            	} else if (Integer.parseInt(ip[0]) >= 192 && Integer.parseInt(ip[0]) <= 223) {
            		c++;
            		if (str[0].substring(0, 7).equals("192.168"))
            			pri++;
            	} else if (Integer.parseInt(ip[0]) >= 224 && Integer.parseInt(ip[0]) <= 239) {
            		d++;
            	} else if (Integer.parseInt(ip[0]) >= 240 && Integer.parseInt(ip[0]) <= 255) {
            		 e++;
            	}
            }
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e+ " " + err + " " + pri);
    }
}
