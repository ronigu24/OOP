package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Filters.Filter;
import Tools.CreateCsv;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class SSIDFilter extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SSIDFilter frame = new SSIDFilter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SSIDFilter() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 355, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlgorithm = new JLabel("SSID Filter");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(115, 3, 117, 31);
		contentPane.add(lblAlgorithm);

		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String SSID=textField_1.getText();
				Filter filter = new Filter("SSID", SSID);
				String FileName = "SSID";
				File folder = new File("C:\\Users\\"+username+"\\Desktop\\CSVFile\\BM2");
				CreateCsv.WriteByFilter(Wifilist, filter,FileName, folder);
			}
		});
		btnOk.setBounds(104, 129, 115, 29);
		contentPane.add(btnOk);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 87, 168, 26);
		contentPane.add(textField_1);

		JLabel lblMaxTime = new JLabel("Enter full/partial SSID:");
		lblMaxTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaxTime.setBounds(79, 50, 193, 20);
		contentPane.add(lblMaxTime);
	}
}
