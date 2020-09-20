package program;

import java.util.Scanner;
 
public class 接雨水 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(",");
        int[] m = new int[a.length];
        for(int i=0; i<a.length; i++)
            m[i] = Integer.parseInt(a[i]);
        System.out.println(getWater(m));
	}

    private static long getWater(int[] height) {
        int max_left = 0, max_right = 0;
        long sum = 0;
        int point_left = 1, point_right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            //从左往右更新
            if (height[point_left - 1] < height[point_right + 1]) {
                max_left = Math.max(max_left, height[point_left - 1]);
                int min = max_left - height[point_left];
                sum += min > 0 ? min : 0;
                point_left++;
            } else {
                max_right = Math.max(max_right, height[point_right + 1]);
                int min = max_right - height[point_right];
                sum += min > 0 ? min : 0;
                point_right--;
            }
        }
        return sum;
    }
}