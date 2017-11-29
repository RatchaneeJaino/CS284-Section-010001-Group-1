
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Testcase7 {

	Calculate c;
	double result=0;
	ReadFile read = new ReadFile();

	@Before
	public void setUp() throws Exception {
		c = new Calculate();
		JOptionPane.showMessageDialog(null, "Start test Calculate (Score).!");
	}
	
	@After
	public void tearDown() throws Exception {
		c = null ;
	}
	
	
	@Test
	public void TestScore() throws Exception{
		try{
			double result = c.CalculateResult(10, 20, 30);
			assertNotNull(result);
			assertTrue(result>0 && result<=100);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Score over 100 or less 100. Please try again");
			fail("Name Score not found.please try again.!!");
		}
		
	}
	
	@Test
	public void TestFileScoreNotNull() throws Exception{
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\Result.txt");
			assertNotNull(list);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "File Not Found. Please try again");
			fail("File Not Found.please try again.!!");
		}
		
	}
	

}
