
import java.util.ArrayList;
import java.util.List;

public class ScoreList extends ReadFile {

	ArrayList<ScoreStudent> score;
	ArrayList<ArrayList<String>> data = new ArrayList<>();
	

	public ScoreList() throws Exception {
		score = new ArrayList<ScoreStudent>();
		
		super.readFileExcelRows("example.xls");
		
	
		data = super.getArray();
		
		int sizeh = data.size();
		
		for(int i=0;i<sizeh;i++){
			add(data.get(i).get(0),data.get(i).get(1),data.get(i).get(2),data.get(i).get(3),data.get(i).get(4),data.get(i).get(5),data.get(i).get(6));
		}

	// เขียนไฟล์คะแนนของนักศึกษารายคน
	/*for(int i = 0;i<super.getArray().get(i).size();i++){
		super.writerFile(super.getArray().get(0).get(i),"C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\testScore.txt");
		super.writerFile(super.getArray().get(1).get(i),"C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\testScore.txt");
	}*/
		
	}
	
	public void add(String ID, String Name, String Final,String Quiz1,String Quiz2,String Quiz3,String Midterm){
		score.add(new ScoreStudent(ID,Name,Final,Quiz1,Quiz2,Quiz3,Midterm));
	}
	
	public String getID(int index){
		return score.get(index).getID();
		
		
	}
	
	public String getName(int index){
		return score.get(index).getName();
		
	}
	
	public String getFinal(int index){
		return score.get(index).getFinal();
		
	}
	
	public String getMidterm(int index){
		return score.get(index).getMidterm();
		
	}
	
	public String getQuiz1(int index){
		return score.get(index).getQuiz1();
		
	}
	
	public String getQuiz2(int index){
		return score.get(index).getQuiz2();
		
	}
	
	public String getQuiz3(int index){
		return score.get(index).getQuiz3();
		
	}
	
	public String getAll(int index){
		return score.get(index).getID()+" "+score.get(index).getName()+" "+score.get(index).getFinal()+" "+score.get(index).getQuiz1()+" "+score.get(index).getQuiz2()+" "+score.get(index).getQuiz3()+" "+score.get(index).getMidterm();
		
	}
	
	
	public int size(){
		return score.size();
		
	}

	public int SearchIDStu(String id){
		
		int index = 0;
		for(int i = 0 ; i<score.size();i++){
			if(score.get(i).getID().equals(id)){
			index = i;
			
			}
		}	
		return index;	
	}
	
	public void printlist(){
		System.out.println(score);
	}
}

