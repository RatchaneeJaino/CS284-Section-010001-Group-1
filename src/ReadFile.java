
import java.io.BufferedReader; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadFile {
	protected ArrayList<String> data;
	protected ArrayList<ArrayList<String>> data2 = new ArrayList<>();
	protected ArrayList<String> score, result, sumResult, total;
	private ExamCriteria cri;
	private Calculate calculate = new Calculate();
	private int index = 0;
	private double resultSc = 0;
	private int numStudent = 0, numScore;

	public void readFileExcelColums(String fileName) throws Exception {

		String f = fileName;
		Workbook workbook = Workbook.getWorkbook(new File(f));
		Sheet w = workbook.getSheet(0);
		Cell cell = null;

		for (int i = 0; i < w.getColumns(); i++) {

			data = new ArrayList<>();

			for (int j = 0; j < w.getRows(); j++) {
				cell = w.getCell(i, j);
				// System.out.println(cell.getContents());
				data.add(cell.getContents()); 
			}
			data2.add(data);
		}
		workbook.close();
	}

	public void readFileExcelRows(String fileName) throws Exception {

		String f = fileName;
		Workbook workbook = Workbook.getWorkbook(new File(f));
		Sheet w = workbook.getSheet(0);
		Cell cell = null;

		for (int j = 0; j < w.getRows(); j++) {
			data = new ArrayList<>();

			for (int i = 0; i < w.getColumns(); i++) {
				cell = w.getCell(i, j);
				// System.out.println(cell.getContents());
				data.add(cell.getContents()); 
			}
			data2.add(data);
		}
		workbook.close();
	}

	public void writerFile(String s, String fileName) throws IOException {

		File f = new File(fileName);
		FileWriter w = new FileWriter(f, true);
		PrintWriter writer = new PrintWriter(w);

		writer.write(s);
		writer.write(System.getProperty("line.separator"));

		writer.close();
		w.close();
	}

	public ArrayList<ArrayList<String>> getArray() {
		return data2;
	}

	public boolean writeFileExcel(String fileName) throws IOException {
		if (new File("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\GradeStudent.txt").isFile() && new File("idstudent.txt").isFile()) {
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Student Grade");
			ArrayList<Long> idt = new ArrayList<Long>();
			ArrayList<String> gradet = new ArrayList<String>();
			
			File Gfile = new File("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\GradeStudent.txt");
			File Ifile = new File("idstudent.txt");
			BufferedReader br1 = new BufferedReader(new FileReader(Ifile));
			BufferedReader br2 = new BufferedReader(new FileReader(Gfile));
			String line;
			while ((line = br1.readLine()) != null) {
				idt.add(Long.parseLong(line));
			}
			while ((line = br2.readLine()) != null) {
				gradet.add(line);
			}
			
			System.out.println("Create file");
			int numRow = 0;
			System.out.println(idt.size());
			for (int i=0;i<idt.size();i++){
				Row row = sheet.createRow(numRow++);
				int numCol = 0;
				
				for (int j=1;j<3;j++) {
					org.apache.poi.ss.usermodel.Cell cell = row.createCell(numCol++);
					switch (numCol) {
					case 1 : cell.setCellValue((long)idt.get(i)); break;
					case 2 : cell.setCellValue(gradet.get(i)); break;
					}
				}
			}
			
			FileOutputStream fos = new FileOutputStream(fileName);
			workbook.write(fos);
			workbook.close();
			
			 System.out.println("Done");
			
			return true;
		}
		else return false;
	}
	
	public ArrayList<String> ReadFiletxt(String fileName) {

		ArrayList<String> arr = new ArrayList<>();
		File f = new File(fileName);

		try {
			FileReader fr = new FileReader(f);
			BufferedReader read = new BufferedReader(fr);

			String s = read.readLine();
			arr.add(s);
			while (s != null) {
				s = read.readLine();
				arr.add(s);
			}
			arr.remove(arr.size() - 1);

			read.close();
			fr.close();

		} catch (FileNotFoundException e1) {
			e1.getMessage();
		} catch (IOException e1) {
			e1.getMessage();
		}
		return arr;
	}

	public ArrayList<String> getScore() {
		return score;

	}
}
