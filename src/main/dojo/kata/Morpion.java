package dojo.kata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("serial")
public class Morpion {
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
	public Morpion(){
		fields=new ArrayList<List<Values>>(){{
			add(new ArrayList<Values>(){{add(Values.VIDE);add(Values.VIDE);add(Values.VIDE);}});
			add(new ArrayList<Values>(){{add(Values.VIDE);add(Values.VIDE);add(Values.VIDE);}});
			add(new ArrayList<Values>(){{add(Values.VIDE);add(Values.VIDE);add(Values.VIDE);}});
		}};
	}
	public Results evalGrille(){
		if(victoire(Values.X)){
			return Results.X;
		}
		if(victoire(Values.O)){
			return Results.O;
		}		
		for (List<Values> values : fields) {
			for (Values values2 : values) {
				if(values2==Values.VIDE) return Results.NEXT;
			}
		}
		return Results.NUL;
	}
	
	private boolean victoire(Values o) {
		if(fields.get(0).get(0)==o && fields.get(0).get(1)==o && fields.get(0).get(2)==o) return true;
		if(fields.get(1).get(0)==o && fields.get(1).get(1)==o && fields.get(1).get(2)==o) return true;
		if(fields.get(2).get(0)==o && fields.get(2).get(1)==o && fields.get(2).get(2)==o) return true;
		
		if(fields.get(0).get(0)==o && fields.get(1).get(0)==o && fields.get(2).get(0)==o) return true;
		if(fields.get(0).get(1)==o && fields.get(1).get(1)==o && fields.get(2).get(1)==o) return true;
		if(fields.get(0).get(2)==o && fields.get(1).get(2)==o && fields.get(2).get(2)==o) return true;
		
		if(fields.get(0).get(0)==o && fields.get(1).get(1)==o && fields.get(2).get(2)==o) return true;
		if(fields.get(2).get(0)==o && fields.get(1).get(1)==o && fields.get(0).get(2)==o) return true;
		return false;
	}
	
	public void joue(Values v, int x,int y){		
		if(fields.get(x).get(y)!=Values.VIDE || currentPlayer==v || evalGrille()!=Results.NEXT){
			throw new IllegalStateException("boulet !!");	
		}
		fields.get(x).set(y, v);
		currentPlayer=v;
	}
	public void print(){
		for (List<Values> values : fields) {
			for (Values values2 : values) {
				System.out.print(values2.toString()+"\t");	
			}
			System.out.println();
		}
	}
}
