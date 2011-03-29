package dojo.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

@SuppressWarnings("serial")
public class TestPuissance4 {
	@Test
	public void vrai(){
		assertTrue(true);
	}
	
	@Test public void testEmpty(){
		List<List<Integer>> grid=new ArrayList<List<Integer>>(){{
			add(new ArrayList<Integer>(){{}});
			add(new ArrayList<Integer>(){{}});
			add(new ArrayList<Integer>(){{}});
			add(new ArrayList<Integer>(){{}});			
		}};
		Puissance4 p4=new Puissance4();
		assertEquals(0,p4.solve(grid));
	}
	@Test public void testOnePeg(){
		List<List<Integer>> grid=new ArrayList<List<Integer>>(){{
			add(new ArrayList<Integer>(){{add(1);}});
			add(new ArrayList<Integer>(){{}});
			add(new ArrayList<Integer>(){{}});
			add(new ArrayList<Integer>(){{}});			
		}};
		Puissance4 p4=new Puissance4();
		assertEquals(0,p4.solve(grid));
	}
	@Test public void testfourPegInAColumn(){
		List<List<Integer>> grid=new ArrayList<List<Integer>>(){{
			add(new ArrayList<Integer>(){{add(1);add(1);add(1);}});
			add(new ArrayList<Integer>(){{}});
			add(new ArrayList<Integer>(){{}});
			add(new ArrayList<Integer>(){{}});			
		}};
		Puissance4 p4=new Puissance4();
		assertEquals(1,p4.solve(grid));
	}
	@Test public void testfourPegInASecondColumn(){
		List<List<Integer>> grid=new ArrayList<List<Integer>>(){{
			add(new ArrayList<Integer>(){});
			add(new ArrayList<Integer>(){{add(1);add(1);add(1);}});
			add(new ArrayList<Integer>(){{}});
			add(new ArrayList<Integer>(){{}});			
		}};
		Puissance4 p4=new Puissance4();
		assertEquals(1,p4.solve(grid));
	}
	@Test public void testfourPegInALine(){
		List<List<Integer>> grid=new ArrayList<List<Integer>>(){{
			add(new ArrayList<Integer>(){});
			add(new ArrayList<Integer>(){{add(1);}});
			add(new ArrayList<Integer>(){{add(1);}});
			add(new ArrayList<Integer>(){{add(1);}});			
		}};
		Puissance4 p4=new Puissance4();
		assertEquals(1,p4.solve(grid));
	}
	@Test public void testTwoPegInAColumn(){
		List<List<Integer>> grid=new ArrayList<List<Integer>>(){{
			add(new ArrayList<Integer>(){});
			add(new ArrayList<Integer>(){{add(1);add(1);}});
			add(new ArrayList<Integer>(){{}});
			add(new ArrayList<Integer>(){{}});			
		}};
		Puissance4 p4=new Puissance4();
		assertEquals(0,p4.solve(grid));
	}
	@Test public void testTwoPlayer(){
		List<List<Integer>> grid=new ArrayList<List<Integer>>(){{
			add(new ArrayList<Integer>(){{add(1);}});
			add(new ArrayList<Integer>(){{add(1);}});
			add(new ArrayList<Integer>(){{add(1);}});
			add(new ArrayList<Integer>(){{add(2);}});			
		}};
		Puissance4 p4=new Puissance4();
		assertEquals(1,p4.solve(grid));
	}
}

