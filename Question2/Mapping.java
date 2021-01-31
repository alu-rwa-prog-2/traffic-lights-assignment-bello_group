package Question2;

/*
Author: Abideen Hamisu
*/
import java.util.*;

public class Mapping {

	public static void main(String[] args) {
		// create two hash maps
		HashMap<Integer, String> hash_map1 = new HashMap<Integer, String>();
		HashMap<Integer, String> hash_map2 = new HashMap<Integer, String>();
		HashMap<Integer, String> hash_map3 = new HashMap<Integer, String>();
		// populate hash maps
		hash_map1.put(1, "Red");
		hash_map1.put(2, "Green");
		hash_map1.put(3, "Black");
		System.out.println("\nValues in first map: " + hash_map1);
		hash_map2.put(4, "White");
		hash_map2.put(5, "Blue");
		hash_map2.put(6, "Orange");
		System.out.println("\nValues in second map: " + hash_map2);
		hash_map3.put(7, "purple");
		hash_map3.put(8, "violet");
		hash_map3.put(9, "indigo");
		System.out.println("\nValues in third map: " + hash_map3);

		// put all values in secondmap
		hash_map1.putAll(hash_map3);
		hash_map2.putAll(hash_map1);
		System.out.println("\nNow all values in second map: " + hash_map2);

	}

}
