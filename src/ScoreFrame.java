package cs284;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
public class ScoreFrame extends JFrame implements ActionListener{
	private JLabel score;
	private JLabel course;
	private ArrayList<JCheckBox> exam;
	private JButton next;
	private Font font;
	private CourseMgn control;
	private ArrayList<String> nameScore;
	ScoreList scorelist;
	ScoreStudent scorestudent;
	//private String ID;

	private JPanel p,p1,p2,p3,p4;
	
	public ScoreFrame() throws Exception {
		control = new CourseMgn();
		nameScore = new ArrayList<String>();
		
		scorelist = new ScoreList();
		
		p = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		
		GridLayout g = new GridLayout(0,1);
		BorderLayout b = new BorderLayout();
		UserPanel panel = new UserPanel();
		
		p.setLayout(g);	
		p2.setLayout(g);	
		p2.setBorder(new TitledBorder( new LineBorder(Color.ORANGE), "??????????"));
		
		score = new JLabel("วิชา : ");
		course = new JLabel("...");
		
		String[] s = scorelist.getAll(0).split(" ");
		exam = new ArrayList<>();

		for(int i = 2;i<s.length;i++){
			exam.add(new JCheckBox(s[i].toUpperCase()));
		}

		font = new Font("Microsoft Sans Serif",Font.BOLD,20);
		
		score.setFont(font);

	
		
		p1.setBackground(Color.WHITE);
		
		p4.add(score);
		p4.add(course);
		p4.setBackground(Color.WHITE);
		p2.add(p4);
		for(int i = 0;i<exam.size();i++){
			exam.get(i).setFont(font);
			exam.get(i).setBackground(Color.WHITE);
			p2.add(exam.get(i));
			
		}

		p2.setPreferredSize(new Dimension(280, 700));
		p2.setBackground(Color.WHITE);
		
		next = new JButton("next");
		next.setBackground(Color.ORANGE);
		//next.setPreferredSize(new Dimension(150,35));
		next.setFont(font);
		next.addActionListener(this);
		p3.add(next);
		p3.setBackground(Color.WHITE);
		
		p.add(p1);
		p.add(p2);
		p.add(p3);
		
		this.setLayout(b);
		this.add(panel);
		this.add(p,BorderLayout.EAST);
		this.setSize(700,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public void setCourse(String c){
		course.setText(c);
		course.setFont(font);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i<exam.size();i++){
			if(exam.get(i).isSelected()){
				nameScore.add(exam.get(i).getText());
				try{			 
					control.SerchScore(nameScore);
				}catch(Exception e1){
					e1.getMessage();
				}
			}		
		}
		//JOptionPane.showMessageDialog(null,"Please selected choice");
		//System.out.println(nameScore);
		
	}

	

}
