
public class ScoreStudent {
	private String ID;
	private String Name;
	private String Final;
	private String Quiz1;
	private String Quiz2;
	private String Quiz3;
	private String Midterm;
	public ScoreStudent(String iD, String name, String final1, String quiz1, String quiz2, String quiz3,
			String midterm) {
		super();
		ID = iD;
		Name = name;
		Final = final1;
		Quiz1 = quiz1;
		Quiz2 = quiz2;
		Quiz3 = quiz3;
		Midterm = midterm;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFinal() {
		return Final;
	}
	public void setFinal(String final1) {
		Final = final1;
	}
	public String getQuiz1() {
		return Quiz1;
	}
	public void setQuiz1(String quiz1) {
		Quiz1 = quiz1;
	}
	public String getQuiz2() {
		return Quiz2;
	}
	public void setQuiz2(String quiz2) {
		Quiz2 = quiz2;
	}
	public String getQuiz3() {
		return Quiz3;
	}
	public void setQuiz3(String quiz3) {
		Quiz3 = quiz3;
	}
	public String getMidterm() {
		return Midterm;
	}
	public void setMidterm(String midterm) {
		Midterm = midterm;
	}
	
	
	
	
}
