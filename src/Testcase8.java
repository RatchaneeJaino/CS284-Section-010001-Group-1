

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class Testcase8 {

	Calculate c;
	ReadFile read = new ReadFile();

	@Before
	public void setUp() throws Exception {
		c = new Calculate();
		JOptionPane.showMessageDialog(null, "Start test Calculate(Grade).!");
	}
	
	@After
	public void tearDown() throws Exception {
		c = null ;
	}

	@Test
	public void testGrade() throws Exception{
		try{
			double sum=70;
			assertTrue(sum == 70);
			
			String grade = c.CalculateGrade(sum);
			assertNotNull(grade);
			
			assertTrue(grade.equals("A") || grade.equals("B+") || grade.equals("B") || grade.equals("C+") || grade.equals("C") || grade.equals("D") || grade.equals("D+") ||grade.equals("F"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Grade is not A , B+ , B , C+ , C , D+ , D ,F !!!. please try again");
			fail("Grade is not A , B+ , B , C+ , C , D+ , D ,F !!!. please try again");
		}
		
	}
	
	@Test
	public void testFileGradeNotNull() throws Exception{
		try{
			//File file = new File("GradeStudent.txt");
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\srcGradeStudent.txt");
			assertNotNull(list);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "File Not Found. please try again");
			fail("File Not Found. please try again");
		}
		
	}

}
