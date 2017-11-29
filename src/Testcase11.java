

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Testcase11 {
	ReadFile r;

	@Before
	public void setUp() throws Exception {
		r = new ReadFile();
		JOptionPane.showMessageDialog(null, "Start test ReadExcelFile!");
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}
	
	@Test
	public void testHaveFile() throws Exception{
		try{
			boolean check = r.writeFileExcel("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\tu.xlsx");
			assertTrue(check);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "File Not Found. Please try again");
			fail("File Not Found.please try again.!!");
		}
	}
	
	@Test
	public void testFileNotNull() throws Exception{
		try{
			//File file = new File("tu.xlsx");
			ArrayList<String> list = r.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\tu.xlsx");
			assertNotNull(list);
           
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "File Not Data. Please try again");
			fail("File Not Data.please try again.!!");
		}
	}
	
	

}
