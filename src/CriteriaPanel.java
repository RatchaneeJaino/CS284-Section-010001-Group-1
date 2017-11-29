
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class CriteriaPanel extends JPanel {
	protected static final Exception NameException = null;
	int line = 0;
	private JTextField txtScoreName;
	private JTextField txtPersent;
	private DefaultTableModel model;
	int sum = 0;
	private String st = "";
	private JButton btnSave;
	private JButton btnAdd;
	private JButton btnDelete;
	private JLabel labelPersentResult;
	private HashMap<Integer, String> map;
	int nummap = 0;
	private JLabel label;
	private ScoreTablePanel pa;
	
	public CriteriaPanel() {
		map = new HashMap<Integer, String>();
		setBackground(new Color(255, 102, 51));
		setBounds(0, 0, 796, 629);
		setLayout(null);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 92, 572, 282);
		add(scrollPane);

		JTable table = new JTable();
		table.setEnabled(false);
		table.setRowHeight(40);
		scrollPane.setViewportView(table);

		Font f = new Font("TH Sarabun New", Font.PLAIN, 25);

		txtScoreName = new JTextField();
		txtScoreName.setToolTipText("Name");
		txtScoreName.setBounds(191, 405, 222, 34);
		txtScoreName.setFont(new Font("TH Sarabun New", Font.BOLD, 25));
		add(txtScoreName);

		txtPersent = new JTextField();
		txtPersent.setToolTipText("Persent");
		txtPersent.setBounds(497, 405, 121, 34);
		txtPersent.setFont(new Font("TH Sarabun New", Font.BOLD, 25));
		add(txtPersent);

		model = (DefaultTableModel) table.getModel();
		model.addColumn("ลำดับ");
		model.addColumn("ชื่อการสอบ");
		model.addColumn("สัดส่วน(%)");

		btnSave = new JButton("บันทึก");
		btnSave.setForeground(new Color(255, 102, 51));
		btnSave.setBackground(Color.DARK_GRAY);
		btnSave.setFont(new Font("TH Sarabun New", Font.BOLD, 25));
		btnSave.setBounds(447, 476, 111, 43);
		add(btnSave);

		if (sum != 100) {
			btnSave.setEnabled(false);
		}
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ReadFile rf = new ReadFile();
				for (int i = 0; i < line; i++) {
					st = model.getValueAt(i, 1) + "," + model.getValueAt(i, 2);
					try {
						rf.writerFile(st, "C:\\Users\\ANFIELD\\workspace\\New folder\\CS284\\src\\score.txt");
						pa = new ScoreTablePanel();
						pa.CreateTable();
						pa.setVisible(true);
						
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
				txtScoreName.setEditable(false);
				txtScoreName.setBackground(Color.DARK_GRAY);
				txtPersent.setEditable(false);
				txtPersent.setBackground(Color.DARK_GRAY);
				btnAdd.setEnabled(false);
				btnDelete.setEnabled(false);
				btnSave.setEnabled(false);
				
			}

		});

		btnAdd = new JButton("เพิ่ม");
		btnAdd.setForeground(new Color(255, 102, 51));
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setFont(new Font("TH Sarabun New", Font.BOLD, 25));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtScoreName.getText().isEmpty() && !txtPersent.getText().isEmpty()) {
					try {
						Double num1 = Double.parseDouble(txtPersent.getText());
						int size = map.size();

						if (map.isEmpty()) {
							if (num1 > 0) {
								
								map.put(nummap++, txtScoreName.getText());
								model.addRow(new Object[0]);
								model.setValueAt(line + 1, line, 0);
								model.setValueAt(txtScoreName.getText(), line, 1);
								model.setValueAt(txtPersent.getText(), line, 2);
								String x = String.valueOf(model.getValueAt(line, 2));
								sum += Integer.parseInt(x);
								System.out.println("Map empty");
							
							} else {
								throw new CriteriaZeroException();

							}

						}

						else if (map.containsValue(txtScoreName.getText()) == false) {
							
							map.put(nummap++, txtScoreName.getText());
							model.addRow(new Object[0]);
							model.setValueAt(line + 1, line, 0);
							model.setValueAt(txtScoreName.getText(), line, 1);
							model.setValueAt(txtPersent.getText(), line, 2);
							String x = String.valueOf(model.getValueAt(line, 2));
							sum += Integer.parseInt(x);
							System.out.println("check not found");
						

						}

						else {
							System.out.println("check  found");
							throw new NameException();
						}
						line = line + 1;
						txtScoreName.setText("");
						txtPersent.setText("");
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "กรุณากรอกสัดส่วนเป็นตัวเลขจำนวนเต็ม");
					} catch (NameException e1) {
						JOptionPane.showMessageDialog(null, "ชื่อการสอบนี้ถูกใช้ไปแล้ว กรุณาแก้ไขใหม่");
					} catch (CriteriaZeroException e1) {
						JOptionPane.showMessageDialog(null, "สัดส่วนต้องมากกว่า 0");
					}

					if (sum > 100) {
						JOptionPane.showMessageDialog(null, "สัดส่วนคะเเนนต้องได้100%");
						String x = String.valueOf(model.getValueAt(line - 1, 2));
						sum -= Integer.parseInt(x);
						// System.out.println(sum);
						labelPersentResult.setText(sum + " %");
						model.removeRow(line - 1);

						line--;
					}

					labelPersentResult.setText(sum + " %");
						if (sum == 100) {
						btnSave.setEnabled(true);
						btnAdd.setEnabled(false);
					}

				} else {
					JOptionPane.showMessageDialog(null, "กรุณากรอกช้อมูลให้ครบถ้วน!");
				}

			}

		});

		btnAdd.setBounds(207, 476, 111, 43);
		add(btnAdd);

		JLabel labelScoreName = new JLabel("ชื่อการสอบ :");
		labelScoreName.setFont(new Font("TH Sarabun New", Font.BOLD, 26));
		labelScoreName.setBounds(78, 405, 134, 32);
		add(labelScoreName);

		JLabel labelPersent = new JLabel("สัดส่วน :");
		labelPersent.setFont(new Font("TH Sarabun New", Font.BOLD, 26));
		labelPersent.setBounds(425, 410, 78, 25);
		add(labelPersent);

		btnDelete = new JButton("ลบ");
		btnDelete.setForeground(new Color(255, 102, 51));
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("TH Sarabun New", Font.BOLD, 26));
		btnDelete.setBounds(330, 476, 105, 43);
		add(btnDelete);

		labelPersentResult = new JLabel("0 %");
		labelPersentResult.setFont(new Font("TH Sarabun New", Font.BOLD, 26));
		labelPersentResult.setBounds(605, 65, 56, 16);
		add(labelPersentResult);
		
		label = new JLabel("%");
		label.setFont(new Font("TH Sarabun New", Font.BOLD, 24));
		label.setBounds(631, 410, 30, 25);
		add(label);

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					String x = String.valueOf(model.getValueAt(line - 1, 2));
					sum -= Integer.parseInt(x);
					map.values().remove(String.valueOf(model.getValueAt(line - 1, 1)));
					labelPersentResult.setText(sum + " %");
					model.removeRow(line - 1);
					line--;
				} catch (ArrayIndexOutOfBoundsException e5) {
					JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูล");
				}

				if (sum != 100) {
					btnSave.setEnabled(false);
				}
				if (sum < 100) {
					btnAdd.setEnabled(true);
				}

			}
		});

	}

	@Override
	public int hashCode() {
		return line;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj.equals(txtScoreName.getText()))) {
			return false;
		} else {
			return obj.equals(txtScoreName.getText());
		}
	}

}
