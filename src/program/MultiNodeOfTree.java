package program;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Each multi-node has a "[" followed.
 * So, split String into an array by delimiter "[", find last closest nodeName in array.
 * @author emmajing
 *
 */
public class MultiNodeOfTree {
	
//	  { node: 'root', 
//	    next: [ { node: 'second_root' }, 
//	            { node: 'second_child', 
//	              next: [{ node: 'second_child_1', 
//	            	       next: { node: 'second_child_1_1' } }, 
//	                     { node: 'second_child_2' }] }, 
//	            { node: 'third_root', 
//                	 next: { node: 'third_child' , 
//                    	 	 next: [{ node: 'third_child_1', 
//                    	 			  next: { node: 'third_child_1_1' } }, 
//                    	 	        { node: 'third_child_2' }] } } ] }
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split("\\[");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
        	int to = arr[i].lastIndexOf('\'');
        	int from = arr[i].substring(0, to).lastIndexOf('\'');
        	list.add(arr[i].substring(from + 1, to));
        }
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
        	System.out.printf("\"%s\"", list.get(i));
        	if(i != list.size()-1)
        		System.out.printf(",");
        }
        System.out.println("]"); // ["root","second_child","third_child"]
    }
} 