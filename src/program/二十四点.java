package program;

import java.util.*;

public class 二十四点 {
   
    private static String[] op = new String[]{"+","-","*","/"};
    private static String[] str;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine().split(" ");
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
        	if (str[i].equals("joker") ||str[i].equals("JOKER")) {
        		System.out.println("ERROR");
                return;
        	}
        	switch (str[i]) {
            case "A":
                nums.add(1);
                break;
            case "J":
            	nums.add(11);
            	break;
            case "Q":
            	nums.add(12);
            	break;
            case "K":
            	nums.add(13);
            	break;
            default:
            	nums.add(Integer.parseInt(str[i]));
        	}	
        }
        compute(nums);
    }

    public static void compute(ArrayList<Integer> arr) {
        // 运算符穷举数组
        String[][] symbols = symbol();
        for (int i = 0; i < 4; i++) {// 第一个数字
            for (int j = 0; j < 4; j++) {// 第二个数字
                for (int k = 0; k < 4; k++) {// 第三个数字
                    for (int p = 0; p < 4; p++) {// 第四个数字
                        if ((i!=j)&&(i!=k)&&(i!=p)&&(j!=k)&&(j!=p)&&(k!=p)) {// 如果四个数字互不相等才计算，不然一个字符就会出现两次
                            // 遍历运算符穷举数组
                            for (String[] s : symbols) {
                                int sum = sumNum(arr.get(i), arr.get(j), s[0]);
                                sum = sumNum(sum, arr.get(k), s[1]);
                                sum = sumNum(sum, arr.get(p), s[2]);
                                if (sum == 24) {
                                	String ans = "" + str[arr.indexOf(arr.get(i))] + 
                                			s[0] + str[arr.indexOf(arr.get(j))] + 
                                			s[1] + str[arr.indexOf(arr.get(k))] + 
                                			s[2] + str[arr.indexOf(arr.get(p))];
                                    System.out.println(ans);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        // 穷举之后仍然没有结果，返回none
        System.out.println("NONE");
    }
   
    /**
     * 64种可能的运算符组合
     * @return
     */
    public static String[][] symbol() {
        String[][] symbol = new String[64][3];
        int p = 0;
        for (int i = 0; i < 4; i++) // 第一个运算符
            for (int j = 0; j < 4; j++) // 第二个运算符
                for (int k = 0; k < 4; k++) // 第三个运算符
                    symbol[p++] = new String[]{op[i], op[j], op[k]};
        return symbol;
    } 
   
    /**
     * 两个数字计算结果
     * @param a
     * @param b
     * @param symbol
     * @return
     */
    public static int sumNum(int a, int b, String symbol) {
        switch(symbol){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                return 0;
        }
    }
}
