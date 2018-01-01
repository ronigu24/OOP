package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Algorithm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Algorithm frame = new Algorithm();
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
	public Algorithm() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 355, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlgorithm = new JLabel("Algorithm 1");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(115, 16, 117, 31);
		contentPane.add(lblAlgorithm);
		
		textField = new JTextField();
		textField.setBounds(97, 88, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(117, 129, 115, 29);
		contentPane.add(btnOk);
		
		JLabel lblEnterMac = new JLabel("Enter Mac:");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMac.setBounds(125, 52, 105, 20);
		contentPane.add(lblEnterMac);
	}
}
