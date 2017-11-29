

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;

public class GradePanel extends JPanel {
	
	private DefaultTableModel model;
	private ArrayList<String> arr;
	private ReadFile read = new ReadFile();
	
	public GradePanel() {
		setBackground(new Color(255, 102, 51));
		setBounds(0,0,744, 636);
		setLayout(null);
		
		
		
		JButton btnSave = new JButton("สร้างไฟล์");
		btnSave.setForeground(new Color(255, 102, 51));
		btnSave.setBackground(Color.DARK_GRAY);
		btnSave.setFont(new Font("TH Sarabun New", Font.BOLD, 25));
		btnSave.setBounds(307, 537, 127, 43);
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int ret = chooser.showSaveDialog(null);
				
				if (ret == JFileChooser.APPROVE_OPTION){
					String filePath = chooser.getSelectedFile().toString() + ".xlsx";
					ReadFile r = new ReadFile();
					try {
						if (r.writeFileExcel(filePath)) {
							System.out.println("Success");
						} else System.out.println("Not Success");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		add(btnSave);

	}
	
	public void createTable() {
		
		if (new File("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\GradeStudent.txt").isFile() && new File("idstudent.txt").isFile()) {
			
			System.out.println("Create Table == Grade");
			
			ArrayList<String> arrID = read.ReadFiletxt("idstudent.txt");
			ArrayList<String> arrGrade = read.ReadFiletxt("C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\GradeStudent.txt");
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(181, 86, 378, 410);
			add(scrollPane);

			JTable table = new JTable();
			table.setRowHeight(25);
			scrollPane.setViewportView(table);
			
			model = (DefaultTableModel)table.getModel();
			model.addColumn("รหัสนักศึกษา");
			model.addColumn("เกรด");
			
			for (int i = 0; i < arrID.size(); i++) {
				model.addRow(new Object[i + 1]);
				model.setValueAt(arrID.get(i), i, 0);
				model.setValueAt(arrGrade.get(i), i, 1);
			}
			
			this.repaint();
			this.revalidate();
			
		}

		else {
			System.out.println("didn't had file");
		}
		
	}

}
