package dojo.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sun.swing.MenuItemLayoutHelper.ColumnAlignment;

public class Morpion2 {
	enum Values{
		VIDE
		, X
		,O
	};
		
	enum Results{
		NEXT
		,NUL
		,X
		,O
	};
	
	List<List<Values>> fields;
	Values currentPlayer=Values.VIDE;
	
	Set<Integer> freeFields;
	Set<Integer> playerX;
	Set<Integer> playerO;
	public Morpion2(){
		freeFields=new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		playerX = new HashSet<Integer>();
		playerO = new HashSet<Integer>();
		
//			fields=new ArrayList<List<Values>>(){{
//				add(new ArrayList<Values>(){{add(Values.VIDE);add(Values.VIDE);add(Values.VIDE);}});
//				add(new ArrayList<Values>(){{add(Values.VIDE);add(Values.VIDE);add(Values.VIDE);}});
//				add(new ArrayList<Values>(){{add(Values.VIDE);add(Values.VIDE);add(Values.VIDE);}});
//			}};
	}
	public Results evalGrille(){
		if(freeFields.size()==0) {
			return Results.NUL;
		}
		if(victoire(playerX)){
			return Results.X;
		}
		if(victoire(playerO)){
			return Results.O;
		}		
		
		return Results.NEXT;
	}
	
	public void joue(Values v, int x,int y){		
		if(!freeFields.contains(x*3+y+1) || currentPlayer==v && evalGrille()==Results.NEXT){			
			throw new IllegalStateException("boulet !!");	
		}
		freeFields.remove(x*3+y+1);
		if(v==Values.O)playerO.add(x*3+y+1);
		if(v==Values.X)playerX.add(x*3+y+1);
		currentPlayer=v;
	}
	public void print(){
			for (Integer n: playerX) {
				System.out.print(n%3+"\t");
				
			}
			System.out.println();
			for (Integer n: playerO) {
				System.out.print(n+"\t");
				
			}
			System.out.println();
		}
	Set<Integer> LIGNE=new HashSet<Integer>(){{add(0);add(1);add(2);}};
	Set<Integer> DIAG1=new HashSet<Integer>(){{add(1);add(5);add(9);}};
	Set<Integer> DIAG2=new HashSet<Integer>(){{add(3);add(5);add(7);}};
	List<Integer> COLUMN=new ArrayList<Integer>(){{add(1);add(1);add(1);}};
	private boolean victoire(Set<Integer> set) {
		Set<Integer> t=new HashSet<Integer>();
		List<Integer> l=new ArrayList<Integer>();
		for (Integer n : set) {
			t.add(n%3);
			l.add(n%3);
		}
			
		System.out.println();
		if(t.containsAll(LIGNE)){
			return true;		
		}
		if(set.contains(DIAG1) ||set.contains(DIAG2) ) return true;
		if(l.contains(COLUMN)) return true;
		return false;
	}
		

		
}
