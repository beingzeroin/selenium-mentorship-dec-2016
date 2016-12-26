package in.beingzero.sandeep;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		
		List<Integer> al = new ArrayList<>();
		
		// int size()
		// int get(int idx);
		// void add(int a);
		
		al.add(5);
		al.add(10);
		al.add(20);
		
		System.out.println(al.size());
		
		System.out.println("Second element is "+al.get(2));
		
		int i;
		for(i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}
		
		List<String> names = new ArrayList<>();
		names.add("Prudhvi");
		names.add("Priya");
		names.add("Ravi");
		names.add("Suneeta");
		
		for(i=al.size()-1;i>=0;i--){
			System.out.println(names.get(i));
		}
	}
	
}
