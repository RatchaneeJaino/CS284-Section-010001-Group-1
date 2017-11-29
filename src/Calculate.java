package cs284;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Calculate {
	private double result;
	//private ExamCriteria criteria = new ExamCriteria();
	private ArrayList<String> arr = new ArrayList<>();
	private ArrayList<String> score = new ArrayList<>();
	private ArrayList<String> scoreResult= new ArrayList<>();
	private ArrayList<String> grade = new ArrayList<>();
	int index = 0;
	int numStudent = 0;
	

	public void MakeFileResult(String fileName){
		ReadFile r = new ReadFile();
		ExamCriteria exam = new ExamCriteria();
		arr = r.ReadFiletxt(fileName);
		for(int i = 0;i<arr.size();i++){
			String[] st = arr.get(i).split("\n");
			score.add(st[0]);
		}

		for (int i = 0; i < exam.getNameSriteria().size(); i++) {
			if (exam.getNameSriteria().get(i).equalsIgnoreCase(score.get(0))) {
				index = i;
			//	System.out.println("Name Score is : " + nameCri.get(i) + " index = " + index);
				break;
			} else {
				System.out.println("not found!");
			}
		}
		
		String st = null;
		for (int i = 2; i < score.size(); i++) {
			double s = Double.parseDouble(score.get(i));
			double m = Double.parseDouble(score.get(1));
			double p = Double.parseDouble(exam.getPersentCriteria().get(index));
			System.out.println("Stduent " + (i - 1) + " " + exam.getNameSriteria().get(index) + "  result : "
					+ CalculateResult(s, m, p));
			System.out.println("----------------------------");

			st = CalculateResult(s, m, p) + "";
			try {
				r.writerFile(st, "C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\Result.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		score.clear();
	}
	public void MakeResultTotal(String fileName){
		ReadFile r = new ReadFile();
		ExamCriteria exam = new ExamCriteria();
		
		scoreResult = r.ReadFiletxt(fileName);
		numStudent = scoreResult.size() / exam.getNumScore();
		for (int i = 0; i < scoreResult.size() / exam.getNumScore(); i++) {
			double sum = 0;
			for (int j = 0; j < exam.getNumScore(); j++) {
				if (j == 0) {
					sum = (Double.parseDouble(scoreResult.get(i)));
				} else {
					sum = sum + (Double.parseDouble(scoreResult.get(i + (scoreResult.size() / exam.getNumScore()) * j)));
				}
			}
			
			
			try {
				r.writerFile(sum+"", "C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\ResultTotal.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Student : " + (i + 1) + " result : " + sum + " คะแนน");
			System.out.println("---------------------------");
		}

	}
	public void MakeFileGrade(String fileName){
		ReadFile r = new ReadFile();
		ExamCriteria exam = new ExamCriteria();
		grade = r.ReadFiletxt(fileName);
		System.out.println(grade);
		for(int i = 0 ; i< grade.size();i++){
			System.out.println(Double.parseDouble(grade.get(i)));
			String g = CalculateGrade(Double.parseDouble(grade.get(i)));
			System.out.println("Student " +(i+1)+" Score : " +grade.get(i) +" Grade : " + g);
			try {
				r.writerFile(g+"", "C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\GradeStudent.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}
	
	public double CalculateResult(double score, double max, double precent) {
		result = (score / max) * precent;
		return result;
	}

	public String CalculateGrade(double resultAll) {
		if (resultAll >= 50 && resultAll < 55) {
			return "D";
		} else if (resultAll >= 55 && resultAll < 60) {
			return "D+";
		} else if (resultAll >= 60 && resultAll < 65) {
			return "C";
		} else if (resultAll >= 65 && resultAll < 70) {
			return "C+";
		} else if (resultAll >= 70 && resultAll < 75) {
			return "B";
		} else if (resultAll >= 75 && resultAll < 80) {
			return "B+";
		} else if (resultAll >= 80 && resultAll <= 100) {
			return "A";
		} else {
			return "F";
		}

	}
	public int getNumStudent(){
		return numStudent;
	}
	

}
