package program;

import java.util.*;

public class 最大公共前缀字符串 {
    public static void main(String[] args) {
    	String in = "flower,flow,flight";
        String[] arr = in.split(",");
        
        String pre = "";
        int size = arr.length;
        boolean n = size != 0;
        if(n)
            pre = arr[0];
        for (int i = 0; i < size; i++){
            while (arr[i].startsWith(pre) == false){
                int g = pre.length() - 1;
                pre = pre.substring(0, g);
            }
        }
        System.out.println(pre);
    }
}
