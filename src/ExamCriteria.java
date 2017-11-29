
import java.util.ArrayList;
	
public class ExamCriteria {
	private int size;
	private ArrayList<String> nameCri;
	private ArrayList<String> persentCri;
	private int numScore ;
	
	ReadFile r = new ReadFile();
	ArrayList<String> arr = new ArrayList<>();
	ArrayList<String> name = new ArrayList<>();
	ArrayList<String> persent = new ArrayList<>();
	
	
	public ExamCriteria() {
		
		nameCri = new ArrayList<>();
		persentCri = new ArrayList<>();
		
		arr = r.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\score.txt");
		for(int i = 0;i<arr.size();i++){
			String[] st = arr.get(i).split(",");
			name.add(st[0]);
			persent.add(st[1]);
		}

		for (int i = 0; i < name.size(); i++) {
			nameCri.add(name.get(i));
		}
		for (int j = 0; j < persent.size(); j++) {
			persentCri.add(persent.get(j));
		}
		numScore = name.size();
		//System.out.println(this.toString());
	}
	
	public ArrayList<String> getNameSriteria() {
		return nameCri;
	}

	public ArrayList<String> getPersentCriteria() {
		return persentCri;
	}
	
	public int getNumScore(){
		return numScore;
	}
	
	
	

	public String toString() {
		String toSt = "";
		for (int i = 0; i < nameCri.size(); i++) {
			toSt = toSt + "Name : " + nameCri.get(i) + " Persent : " + persentCri.get(i) + " % " + "\n";
		}
		return toSt;
	}

}
