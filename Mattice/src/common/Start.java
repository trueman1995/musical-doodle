package common;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Start {

	private static Hashtable<Integer, Matchbox> table= new Hashtable<Integer, Matchbox>();
	private static Set<Integer> set = table.keySet();
//	static int counter = 0;

	public static void main(String[] args) {

		Matchbox start = new Matchbox();

		table.put(start.hashCode(), start);

		allPossibilities(start, false);
//		int i=0;
//		for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
//			Integer type = (Integer) iterator.next();
//			System.out.println(type);
//			i++;
//			System.out.println(i);
//		}
//		System.out.println();
	}
	
	private static void allPossibilities(Matchbox start, boolean cplacer) {
		System.out.println(start.toString());
//		counter++;
//		System.out.println(counter);

		if(!start.finished()) {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					if(start.getPlayerAt(i, j) == 0) {
						Matchbox new_ = new Matchbox(start);
						new_.getField(i, j).setPlayer(cplacer ? 2 : 1);
						if(!contains(new_)) {
							table.put(new_.hashCode(), new_);
							start.getField(i, j).setNext(new_);
							allPossibilities(new_, !cplacer);
						}else {
							start.getField(i, j).setNext(get(new_));
						}
					}
				}
			}
		}
	}

	private static Matchbox get(Matchbox box) {
		int[] tmp = box.getallHashes();

		for (int i = 0; i < tmp.length; i++) {
			if(table.containsKey(tmp[i])) {
				return table.get(tmp[i]);
			}
		}
		return null;
	}

	private static boolean contains(Matchbox box) {

		int[] tmp = box.getallHashes();

		for (int i = 0; i < tmp.length; i++) {
			if(table.containsKey(tmp[i])) {
				return true;
			}
		}

		return false;
	}

}
