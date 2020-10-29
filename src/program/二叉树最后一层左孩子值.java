package program;

import java.util.*;

public class 二叉树最后一层左孩子值 {
	public static int findBottomLeftValue(TreeNode root) {	
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int result = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode top = queue.poll();  // 弹出
				if (i == 0) 
					result = top.val;
				if (top.left != null) 
					queue.add(top.left);   // 左孩子入队列
				if (top.right != null) 
					queue.add(top.right);  // 右孩子入队列
			}
		}
		return result;
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
