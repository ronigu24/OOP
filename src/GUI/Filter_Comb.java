package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Filter_Comb extends JFrame {

	private JPanel contentPane;
	private JTextField lat;
	private JTextField lon;
	private JTextField textField_2;
	private JTextField distance;
	private JTextField min;
	private JTextField max;
	private JTextField ssid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filter_Comb frame = new Filter_Comb();
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
	public Filter_Comb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilterCombination = new JLabel("Filter Combination");
		lblFilterCombination.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFilterCombination.setBounds(226, 16, 201, 69);
		contentPane.add(lblFilterCombination);
		
		JRadioButton radioButton = new JRadioButton("Time");
		radioButton.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		radioButton.setBounds(61, 86, 155, 29);
		contentPane.add(radioButton);
		
		JRadioButton rdbtnSsid = new JRadioButton("SSID");
		rdbtnSsid.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		rdbtnSsid.setBounds(285, 86, 155, 29);
		contentPane.add(rdbtnSsid);
		
		JRadioButton rdbtnPosition = new JRadioButton("Position");
		rdbtnPosition.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		rdbtnPosition.setBounds(500, 86, 155, 29);
		contentPane.add(rdbtnPosition);
		
		JLabel label = new JLabel("Enter your loaction:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(477, 127, 193, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Lat:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(460, 178, 95, 20);
		contentPane.add(label_1);
		
		lat = new JTextField();
		lat.setColumns(10);
		lat.setBounds(512, 176, 158, 26);
		contentPane.add(lat);
		
		lon = new JTextField();
		lon.setColumns(10);
		lon.setBounds(512, 218, 158, 26);
		contentPane.add(lon);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(512, 262, 158, 26);
		contentPane.add(textField_2);
		
		distance = new JTextField();
		distance.setColumns(10);
		distance.setBounds(512, 308, 158, 26);
		contentPane.add(distance);
		
		JLabel label_2 = new JLabel("Lon:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(460, 221, 95, 20);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Alt:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(460, 265, 95, 20);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Distance (km):");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(391, 311, 145, 20);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Enter full/partial SSID:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_5.setBounds(234, 127, 193, 20);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Min Time:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_6.setBounds(52, 178, 95, 20);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Max Time:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_7.setBounds(52, 264, 95, 20);
		contentPane.add(label_7);
		
		JLabel lblEnterMinmaxTime = new JLabel("Enter min&max time:");
		lblEnterMinmaxTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMinmaxTime.setBounds(15, 127, 193, 20);
		contentPane.add(lblEnterMinmaxTime);
		
		min = new JTextField();
		min.setColumns(10);
		min.setBounds(15, 218, 158, 26);
		contentPane.add(min);
		
		max = new JTextField();
		max.setColumns(10);
		max.setBounds(15, 308, 158, 26);
		contentPane.add(max);
		
		ssid = new JTextField();
		ssid.setColumns(10);
		ssid.setBounds(244, 176, 158, 26);
		contentPane.add(ssid);
		
		JRadioButton not = new JRadioButton("Not");
		not.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		not.setBounds(111, 389, 97, 29);
		contentPane.add(not);
		
		JRadioButton and = new JRadioButton("And");
		and.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		and.setBounds(247, 389, 97, 29);
		contentPane.add(and);
		
		JRadioButton or = new JRadioButton("Or");
		or.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		or.setBounds(390, 389, 97, 29);
		contentPane.add(or);
		
		JButton button = new JButton("Ok");
		button.setBounds(266, 454, 115, 29);
		contentPane.add(button);
		
		JLabel lblSelectGateType = new JLabel("Select gate type:");
		lblSelectGateType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectGateType.setBounds(108, 357, 193, 20);
		contentPane.add(lblSelectGateType);
	}
}
