package setsAndMaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bag {
	private int size = 0;

	Map<Integer, Integer> newMap = new HashMap<Integer, Integer>();

	public void add(int elt) {
		int key = elt;
		if (contains(key)) {
			newMap.put(key, newMap.get(key) + 1);
		} 
		else {
			newMap.put(key, 1);
		}
		size++;
	}

	public boolean contains(int elt) {
		boolean contains = false;
		if (newMap.get(elt)!= null) {
			contains = true;
		}
		return contains;
	}

	public int getCount(int elt) {
		if (newMap.get(elt) == null) {
			return 0;
		}
		return newMap.get(elt);
	}

	public int size() {
		return size;
	}

	public Set<Integer> uniqueElements() {
		size = 0;
		Set<Integer> unique = new HashSet<Integer>();
		for (Integer x: newMap.keySet()) {
			if (newMap.get(x) >= 1)
				unique.add(x);
			size++;
		}
		return unique;
	}

	public void remove(int elt) {
		int val = 0;
		if (newMap.get(elt) != null) {
			if (newMap.get(elt) - 1 > 0) {
				val = newMap.get(elt);
				val--;
				newMap.put(elt, val);
				size--;
			}
			else {
				newMap.remove(elt);
				size--;
			}
		}
	}

}
