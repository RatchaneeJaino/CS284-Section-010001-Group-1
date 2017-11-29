
import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Tesecase4 {
	ExamCriteria c;

	@Before
	public void setUp() throws Exception {
		c = new ExamCriteria();
		JOptionPane.showMessageDialog(null, "Start test ExamCriteria.!");
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test
	public void testNameScoreisNotEmpty() throws Exception{
		try{
			String str = c.getNameSriteria().get(0);
			//System.out.println(str);
			assertTrue(!str.isEmpty());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Name Score not found.please try again.!!");
			fail("Name Score not found.please try again.!!");
		}
		
	}
	
	@Test
	public void testScoreisNotEmpty() throws Exception{
		try{
			String str = c.getPersentCriteria().get(0);
			//System.out.println(str);
			assertTrue(!str.isEmpty());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Score not found.please try again.!!");
			fail("Score not found.please try again.!!");
		}
		
		
	}
	
	@Test
	public void testScoreNotCharecter() throws Exception{
		try{
			String str1 = c.getPersentCriteria().get(0);
			//double test2 = 30;
			double test = Double.valueOf(str1);
			assertNotNull(test);
			//assertTrue(test==50);
			
		}catch(NumberFormatException e2){
			JOptionPane.showMessageDialog(null, "Score Error Syntext!!!. Please try again");
			fail("Score Error Syntext!!!. Please try again");
		}
		
	}
	
	@Test
	public void testScoreTotal() throws Exception{
		try{
			String str1 = c.getPersentCriteria().get(0);
			String str2 = c.getPersentCriteria().get(1);
			String str3 = c.getPersentCriteria().get(2);
			
			double midterm = Double.valueOf(str1);
			double finalS = Double.valueOf(str2);
			double quiz = Double.valueOf(str3);
		
			double result = midterm+finalS+quiz;
		
			assertTrue(result == 100);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Summary Score over 100 or less 100. Please try again");
			fail("Summary Score over 100 or less 100. Please try again");
		}
		
	}
	
	@Test
	public void testScoreOverZero() throws Exception{
		try{
			String str1 = c.getPersentCriteria().get(0);
			String str2 = c.getPersentCriteria().get(1);
			String str3 = c.getPersentCriteria().get(2);
		
			double midterm = Double.valueOf(str1);
			double finalS = Double.valueOf(str2);
			double quiz = Double.valueOf(str3);
			
			assertTrue(midterm>0);
			assertTrue(finalS>0);
			assertTrue(quiz>0);
		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Summary Score over 100 or less 100. Please try again");
			fail("Summary Score over 100 or less 100. Please try again");
		}
		
	}
	
	@Test
	public void testNameScore() throws Exception{
		try{
			String name1 = c.getNameSriteria().get(0);
			String name2 = c.getNameSriteria().get(1);
		
			assertTrue(!name1.equals(name2));
				
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Name Score repeatedly!!!! Please try again");
			fail("Name Score repeatedly!!!! Please try again");
		}
	
	}
	

}
