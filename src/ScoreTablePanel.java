
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreTablePanel extends JPanel {
	JPanel panel1, panel2, panelmain;
	private Calculate calculate = new Calculate();
	private DefaultTableModel model;
	private ArrayList<String> arr = new ArrayList<>();
	private ArrayList<String> arr2 = new ArrayList<>();
	private JTextField textMaxScore;
	private ReadFile read = new ReadFile();
	JComboBox<String> comboBox = new JComboBox<String>();


	public ScoreTablePanel() {
		
		setBackground(new Color(255, 102, 51));
		setBounds(0, 0, 744, 636);
		setLayout(null);

		textMaxScore = new JTextField();
		textMaxScore.setHorizontalAlignment(SwingConstants.RIGHT);
		textMaxScore.setBounds(677, 99, 55, 31);
		add(textMaxScore);
		textMaxScore.setColumns(10);

		JLabel lblNewLabel = new JLabel("คะแนนเต็ม :");
		lblNewLabel.setFont(new Font("TH Sarabun New", Font.BOLD, 21));
		lblNewLabel.setBounds(588, 101, 80, 31);
		add(lblNewLabel);

		JButton btnSaveAllScore = new JButton("บันทึกคะแนนทั้งหมด");
		btnSaveAllScore.setFont(new Font("TH Sarabun New", Font.BOLD, 19));
		btnSaveAllScore.setForeground(new Color(255, 102, 51));
		btnSaveAllScore.setBackground(Color.DARK_GRAY);
		btnSaveAllScore.setBounds(575, 183, 157, 31);
		add(btnSaveAllScore);
		btnSaveAllScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ExamCriteria exam = new ExamCriteria();
				
				for(int i =1 ;i<arr.size();i++){
					System.out.println("C:\\\\Users\\\\ANFIELD\\\\workspace\\\\New folder\\\\CS284\\\\src\\\\"+arr.get(i)+".txt");
					calculate.MakeFileResult("C:\\\\Users\\\\ANFIELD\\\\workspace\\\\New folder\\\\CS284\\\\src\\\\"+arr.get(i)+".txt");
				}
				
			}
		});

		JButton btnCalculate = new JButton("คำนวณคะแนนสุทธิ");
		btnCalculate.setFont(new Font("TH Sarabun New", Font.BOLD, 19));
		btnCalculate.setForeground(new Color(255, 102, 51));
		btnCalculate.setBackground(Color.DARK_GRAY);
		btnCalculate.setBounds(575, 220, 157, 31);
		
		add(btnCalculate);
		btnCalculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ExamCriteria exam = new ExamCriteria();
				
				calculate.MakeResultTotal("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\Result.txt");
			}
		});
		JButton btnSave = new JButton("บันทึก");
		btnSave.setBackground(Color.DARK_GRAY);
		btnSave.setForeground(new Color(255, 102, 51));
		btnSave.setFont(new Font("TH Sarabun New", Font.BOLD, 19));
		btnSave.setBounds(575, 143, 157, 31);
		add(btnSave);

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < arr.size(); i++) {
					if (comboBox.getSelectedItem().equals(arr.get(i))) {
						try {
							getcolumn(i);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

	}

	public void CreateTable() {

		ArrayList<String> arrScore = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\score.txt");
		arr.add("รหัสนักศึกษา");
		String[] s = null;
		for (int i = 0; i < arrScore.size(); i++) {
			s = arrScore.get(i).split(",");
			arr.add(s[0]);
		}
		

		ArrayList<String> arrID = read.ReadFiletxt("idstudent.txt");
		String[] sp = null;
		for (int i = 0; i < arrID.size(); i++) {
			sp = arrID.get(i).split(",");
			arr2.add(sp[0]);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 57, 547, 519);
		add(scrollPane);

		JTable table = new JTable();
		scrollPane.setViewportView(table);

		model = (DefaultTableModel) table.getModel();
		table.setRowHeight(25);
		
		table.clearSelection();

		for (int i = 0; i < arr.size(); i++) {
			model.addColumn(arr.get(i));
		}

		for (int i = 0; i < arr2.size(); i++) {
			model.addRow(new Object[i + 1]);
			model.setValueAt(arr2.get(i), i, 0);
		}
		
		comboBox.removeAllItems();
		comboBox.setFont(new Font("TH Sarabun New", Font.BOLD, 20));
		comboBox.setForeground(new Color(255, 102, 51));
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setBounds(575, 55, 157, 31);
		for (int i = 1; i < arr.size(); i++) {
			comboBox.addItem(arr.get(i));
		}

		add(comboBox);
		
		this.repaint();
		this.revalidate();
		
	}

	public void getcolumn(int index) throws IOException {
		ReadFile read = new ReadFile();
		String st1 = arr.get(index) + "\n" + textMaxScore.getText();
		read.writerFile(st1, "C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\" + arr.get(index) + ".txt");

		for (int i = 0; i < model.getRowCount(); i++) {
		
			String st2 = String.valueOf(model.getValueAt(i, index));
			read.writerFile(st2, "C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\" + arr.get(index) + ".txt");
		
		}

	}

}
