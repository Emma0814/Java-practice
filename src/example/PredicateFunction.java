package example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate method demo
 * @author emmajing
 *
 */
public class PredicateFunction {
	public static void main(String[] args) {

		String s1 = "abcdefg";
		String s2 = "abefg";
        Predicate<String> pre1 = s -> s.length() >= 3;
        Predicate<String> pre2 = s -> s.contains("cd");
        System.out.println(pre1.and(pre2).test(s1));     // true
        System.out.println(pre1.and(pre2).test(s2));     // false
      
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers)
           list.add(i);
        Predicate<Integer> p1 = i -> i > 5;
        Predicate<Integer> p2 = i -> i < 20;
        Predicate<Integer> p3 = i -> i % 2 == 0;
        List test = list.stream()
        		.filter(p1.and(p2).and(p3))
                .collect(Collectors.toList());
        System.out.println(test.toString());    //[6, 8, 10, 12, 14]
        
        list.removeIf(p1.and(p2).and(p3));
        System.out.println(list.toString());    //[1, 2, 3, 4, 5, 7, 9, 11, 13, 15]
   }
}