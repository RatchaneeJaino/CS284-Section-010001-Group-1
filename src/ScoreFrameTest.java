
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class ScoreFrameTest extends JFrame {

	private JPanel contentPane;

	private JPanel panel_3;
	private CriteriaPanel criteriaPanel = new CriteriaPanel();
	private ScoreTablePanel scorePanel = new ScoreTablePanel();;
	private GradePanel gradePanel = new GradePanel();
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton homeBtn;
	private ReadFile read;
	private Calculate cal = new Calculate();

	public ScoreFrameTest() {
		read = new ReadFile();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setPreferredSize(new Dimension(0, 72));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		homeBtn = new JButton("กำหนดสัดส่วนคะแนน");
		homeBtn.setFont(new Font("TH Sarabun New", Font.BOLD, 26));
		homeBtn.setForeground(Color.DARK_GRAY);
		homeBtn.setBackground(new Color(255, 102, 51));
		homeBtn.setBounds(0, 8, 210, 62);
		panel.add(homeBtn);
		homeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				criteriaPanel.setVisible(true);
				scorePanel.setVisible(false);
				gradePanel.setVisible(false);
				homeBtn.setForeground(Color.DARK_GRAY);
				homeBtn.setBackground(new Color(255, 102, 51));
				btnNewButton_1.setBackground(Color.DARK_GRAY);
				btnNewButton_1.setForeground(new Color(255, 102, 51));
				btnNewButton_2.setBackground(Color.DARK_GRAY);
				btnNewButton_2.setForeground(new Color(255, 102, 51));
			}
		});

		btnNewButton_1 = new JButton("กรอกคะแนน");
		btnNewButton_1.setFont(new Font("TH Sarabun New", Font.BOLD, 26));
		btnNewButton_1.setForeground(new Color(255, 102, 51));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(211, 8, 210, 62);
		panel.add(btnNewButton_1);

		btnNewButton_2 = new JButton("ผลคะแนน");
		btnNewButton_2.setFont(new Font("TH Sarabun New", Font.BOLD, 26));
		btnNewButton_2.setForeground(new Color(255, 102, 51));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(421, 8, 210, 62);
		panel.add(btnNewButton_2);

		criteriaPanel.setVisible(true);
		contentPane.add(criteriaPanel, BorderLayout.CENTER);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setLayout(null);
		panel_3.setVisible(false);

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				homeBtn.setForeground(new Color(255, 102, 51));
				homeBtn.setBackground(Color.DARK_GRAY);
				btnNewButton_1.setBackground(new Color(255, 102, 51));
				btnNewButton_1.setForeground(Color.DARK_GRAY);
				btnNewButton_2.setBackground(Color.DARK_GRAY);
				btnNewButton_2.setForeground(new Color(255, 102, 51));
				criteriaPanel.setVisible(false);
				gradePanel.setVisible(false);
				scorePanel.setVisible(true);
				scorePanel.CreateTable();
				contentPane.add(scorePanel, BorderLayout.CENTER);
			}
		});

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				homeBtn.setForeground(new Color(255, 102, 51));
				homeBtn.setBackground(Color.DARK_GRAY);
				btnNewButton_1.setBackground(Color.DARK_GRAY);
				btnNewButton_1.setForeground(new Color(255, 102, 51));
				btnNewButton_2.setBackground(new Color(255, 102, 51));
				btnNewButton_2.setForeground(Color.DARK_GRAY);
				criteriaPanel.setVisible(false);
				scorePanel.setVisible(false);
				gradePanel.setVisible(true);
				contentPane.add(gradePanel, BorderLayout.CENTER);
				cal.MakeFileGrade("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\ResultTotal.txt");
				gradePanel.createTable();
			}
		});

		Dimension d = this.getToolkit().getScreenSize();
		int screenWidth = d.width;
		int screenHeight = d.height;
		int centerX = screenWidth / 2;
		int centerY = screenHeight / 2;
		int x = centerX - this.getWidth() / 2;
		int y = centerY - this.getHeight() / 2;
		this.setLocation(x, y);
	}

	public static void main(String[] args) {
		ScoreFrameTest frame = new ScoreFrameTest();
	}
}
