package common;

import java.util.Hashtable;

public class Start {

	private static Hashtable<Integer, Matchbox> table= new Hashtable<Integer, Matchbox>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Matchbox start = new Matchbox();

		table.put(start.hashCode(), start);
		allPossibilities(start, false);
	}
	
	private static void allPossibilities(Matchbox start, boolean cplacer) {
		System.out.println(start.toString());

		while(!start.finished()) {
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
