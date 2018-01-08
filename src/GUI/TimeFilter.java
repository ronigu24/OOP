package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Filters.Filter;
import Main.Main;
import Tools.CreateCsv;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TimeFilter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField minimum;
	private JTextField maximum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeFilter frame = new TimeFilter();
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
	public TimeFilter() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 355, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlgorithm = new JLabel("Time Filter");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(115, 3, 117, 31);
		contentPane.add(lblAlgorithm);

		minimum = new JTextField();
		minimum.setBounds(115, 50, 203, 26);
		contentPane.add(minimum);
		minimum.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!minimum.getText().isEmpty()&&!maximum.getText().isEmpty())
				{
					String start=minimum.getText();
					String end=maximum.getText();
					dispose();

					 Main.filter = new Filter("Date", start + ";" + end);
					String FileName = "TimeCSV";
					Main.WifilistTemp=Main.Wifilist;
					Main.setWifilist(CreateCsv.ArrayByFilter(Main.getWifilist(), Main.filter, FileName,Main.getFolder()));
				}
			}
		});
		btnOk.setBounds(115, 129, 115, 29);
		contentPane.add(btnOk);

		JLabel lblEnterMac = new JLabel("Min Time:");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMac.setBounds(15, 52, 95, 20);
		contentPane.add(lblEnterMac);

		maximum = new JTextField();
		maximum.setColumns(10);
		maximum.setBounds(115, 92, 203, 26);
		contentPane.add(maximum);

		JLabel lblMaxTime = new JLabel("Max Time:");
		lblMaxTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaxTime.setBounds(15, 95, 95, 20);
		contentPane.add(lblMaxTime);
	}
}
