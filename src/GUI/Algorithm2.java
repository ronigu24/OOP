package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Algorithm2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Algorithm2 frame = new Algorithm2();
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
	public Algorithm2() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 360, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlgorithm = new JLabel("Algorithm 2");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(115, 16, 117, 31);
		contentPane.add(lblAlgorithm);
		
		textField = new JTextField();
		textField.setBounds(15, 124, 308, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(117, 360, 115, 29);
		contentPane.add(btnOk);
		
		JLabel lblEnterMac = new JLabel("Chose input:");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMac.setBounds(125, 51, 105, 20);
		contentPane.add(lblEnterMac);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Scan Line");
		rdbtnNewRadioButton.setBounds(15, 83, 155, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMacsignalupTo = new JRadioButton("Mac&signal (up to 3)");
		rdbtnMacsignalupTo.setBounds(15, 162, 217, 29);
		contentPane.add(rdbtnMacsignalupTo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 232, 131, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMac = new JLabel("Mac");
		lblMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMac.setBounds(15, 196, 105, 20);
		contentPane.add(lblMac);
		
		JLabel lblSignal = new JLabel("Signal");
		lblSignal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSignal.setBounds(187, 197, 105, 20);
		contentPane.add(lblSignal);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(15, 274, 131, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(174, 232, 131, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(174, 274, 131, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(15, 318, 131, 26);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(174, 318, 131, 26);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(181, 87, 131, 26);
		contentPane.add(textField_7);
	}
}
