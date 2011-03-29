package dojo.kata;

import java.util.List;

public class Puissance4 {

	public Object solve(List<List<Integer>> grid) {
		boolean cpt = false;
		int r=0;
		int c=0;
		for (List<Integer> currentColumn : grid) {
			
			for (Integer currentRow : currentColumn) {
				
				if (currentRow != null) {
					r+=currentRow;
				} else if (currentColumn.size() == 1) {
					if (currentColumn.get(0) == 1) {
						c+=1;
					}
				}
			}
		}
		if (r==3 || c==3) {
			return 1;
		}

		return 0;
	}

}
