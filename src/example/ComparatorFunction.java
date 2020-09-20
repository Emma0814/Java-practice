package example;

import java.util.*;

class ComparatorFunction {

	public static void main(String[] args) {
		
		Human h1 = new Human(180);
		Human h2 = new Human(130);
		Human h3 = new Human(150);
		
		Comparator comparator = new Comparator<Human>() {
			@Override
			public int compare(Human n1, Human n2) {
				if (n1.getHeight() < n2.getHeight()) 
					return -1;
				else if (n1.getHeight() > n2.getHeight())
					return 1;
				else
					return 0;
			}
		};
		
		PriorityQueue<Human> pq = new PriorityQueue<>(comparator);
		pq.offer(h1);
		pq.offer(h2);
		pq.offer(h3);
		
		ArrayList<Human> arr = new ArrayList<>();
		arr.addAll(pq);
		arr.sort(comparator);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(pq.poll().getHeight());
		}
		
		System.out.println();
		for (Human h : arr) {
			System.out.println(h.getHeight());
		}
	}
}

class Human {

	private int height;
    
    public Human(int height) {
        this.setHeight(height);
    }

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}

