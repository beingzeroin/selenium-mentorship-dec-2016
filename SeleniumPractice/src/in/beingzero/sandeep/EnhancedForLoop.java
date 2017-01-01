package in.beingzero.sandeep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnhancedForLoop {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("Prudhvi");
		names.add("Ravi");
		names.add("Swetha");
		names.add("Suneeta");
		names.add("Priya");
		
		
		Set<String> uniqueNames = new HashSet<>();
		uniqueNames.add("Ravi");
		uniqueNames.add("Ravi");
		uniqueNames.add("Prudhvi");
		
		for(String u : uniqueNames){
			
			System.out.println(u);
		}
		
	}
	
}
