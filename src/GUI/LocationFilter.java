package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class LocationFilter extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationFilter frame = new LocationFilter();
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
	public LocationFilter() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 355, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlgorithm = new JLabel("Distance Filter");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(102, 5, 153, 31);
		contentPane.add(lblAlgorithm);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(107, 250, 115, 29);
		contentPane.add(btnOk);
		
		JLabel lblEnterMac = new JLabel("Enter your loaction:");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMac.setBounds(15, 52, 193, 20);
		contentPane.add(lblEnterMac);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 92, 158, 26);
		contentPane.add(textField_1);
		
		JLabel lblMaxTime = new JLabel("Alt:");
		lblMaxTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaxTime.setBounds(15, 166, 95, 20);
		contentPane.add(lblMaxTime);
		
		JLabel lblLat = new JLabel("Lat:");
		lblLat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLat.setBounds(15, 94, 95, 20);
		contentPane.add(lblLat);
		
		JLabel lblLon = new JLabel("Lon:");
		lblLon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLon.setBounds(15, 130, 95, 20);
		contentPane.add(lblLon);
		
		JLabel lblDistancekm = new JLabel("Distance (km):");
		lblDistancekm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDistancekm.setBounds(15, 209, 145, 20);
		contentPane.add(lblDistancekm);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(144, 128, 158, 26);
		contentPane.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 164, 158, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(144, 206, 158, 26);
		contentPane.add(textField_3);
	}
}
