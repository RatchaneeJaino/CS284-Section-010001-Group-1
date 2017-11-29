
import static org.junit.Assert.*;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Testcase6 {
	ReadFile read;

	@Before
	public void setUp() throws Exception {
		read = new ReadFile();
		JOptionPane.showMessageDialog(null, "Start test Score!");
	}

	@After
	public void tearDown() throws Exception {
		read = null;
	}

	
	@Test
	public void testFinalisNotNull() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\final.txt");
			assertNotNull(list);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Final Score is not data. Please try again");
			fail("Final Score is not data.please try again.!!");
		}
	}
	
	@Test
	public void testMidtermisNotNull() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\midterm.txt");
			assertNotNull(list);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Midterm Score is not data. Please try again");
			fail("Midterm Score is not data.please try again.!!");
		}
	}
	
	@Test
	public void testQuizisNotNull() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\quiz.txt");
			assertNotNull(list);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Quiz Score is not data. Please try again");
			fail("Midterm Score is not data.please try again.!!");
		}
	}
	
	@Test
	public void testFinalCheckEqual() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\final.txt");
			assertNotNull(list);
			int sizescore = list.size()-2; 
			
			ArrayList<String> list2 = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\idstudent.txt");
			assertNotNull(list2);
			int sizestd = list2.size();
			
			assertTrue(sizescore == sizestd);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Final Score is not data. Please try again");
			fail("Final Score is not data.please try again.!!");
		}
	}
	
	@Test
	public void testMidtermCheckEqual() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\midterm.txt");
			assertNotNull(list);
			int sizescore = list.size()-2; 
			
			ArrayList<String> list2 = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\idstudent.txt");
			assertNotNull(list2);
			int sizestd = list2.size();
			
			assertTrue(sizescore == sizestd);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Midterm Score is not data. Please try again");
			fail("Midterm Score is not data.please try again.!!");
		}
	}
	
	@Test
	public void testQuizCheckEqual() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\quiz.txt");
			assertNotNull(list);
			int sizescore = list.size()-2; 
			
			ArrayList<String> list2 = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\idstudent.txt");
			assertNotNull(list2);
			int sizestd = list2.size();
			
			assertTrue(sizescore == sizestd);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Quiz Score is not data. Please try again");
			fail("Quiz Score is not data.please try again.!!");
		}
	}
	
	@Test
	public void testFinalCheckOver() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\final.txt");
			assertNotNull(list);
			double max = Double.valueOf(list.get(1));
			
			for(int i=2 ;i<list.size()-2 ; i++){
				double score = Double.valueOf(list.get(i));
				assertTrue(score<=max);
			
			}
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Final Score is Over Max. Please try again");
			fail("Final Score is Over Max.please try again.!!");
		}
	}
	@Test
	public void testMidtermCheckOver() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\midterm.txt");
			assertNotNull(list);
			double max = Double.valueOf(list.get(1));
			
			for(int i=2 ;i<list.size()-2 ; i++){
				double score = Double.valueOf(list.get(i));
				assertTrue(score<=max);
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Midterm Score is Over Max. Please try again");
			fail("Midterm Score is Over Max.please try again.!!");
		}
	}
	
	@Test
	public void testQuizCheckOver() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\quiz.txt");
			assertNotNull(list);
			double max = Double.valueOf(list.get(1));
			
			for(int i=2 ;i<list.size()-2 ; i++){
				double score = Double.valueOf(list.get(i));
				assertTrue(score<=max);
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Quiz Score is Over Max. Please try again");
			fail("Quiz Score is Over Max.please try again.!!");
		}
	}
	
	@Test
	public void testFinalNotChar() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\final.txt");
			assertNotNull(list);
			//double score=0;
	
			for(int i=2 ;i<list.size()-2 ; i++){
				double score = Double.valueOf(list.get(i));
				assertNotNull(score);
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Final Score is Eror Syntax. Please try again");
			fail("Final Score is Eror Syntax.please try again.!!");
		}
	}
	
	@Test
	public void testMidtermNotChar() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\midterm.txt");
			assertNotNull(list);
			//double score=0;
	
			for(int i=2 ;i<list.size()-2 ; i++){
				double score = Double.valueOf(list.get(i));
				assertNotNull(score);
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Midterm Score is Eror Syntax. Please try again");
			fail("Midterm Sqore is Eror Syntax.please try again.!!");
		}
	}
	
	@Test
	public void testquizNotChar() throws Exception {
		try{
			ArrayList<String> list = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\quiz.txt");
			assertNotNull(list);
			//double score=0;
	
			for(int i=2 ;i<list.size()-2 ; i++){
				double score = Double.valueOf(list.get(i));
				assertNotNull(score);
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Quiz Score is Eror Syntax. Please try again");
			fail("Quiz Score is Eror Syntax.please try again.!!");
		}
	}
	
	

}
