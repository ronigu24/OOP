package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;

public class TimeFilter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setBounds(115, 50, 203, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(115, 129, 115, 29);
		contentPane.add(btnOk);
		
		JLabel lblEnterMac = new JLabel("Min Time:");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMac.setBounds(15, 52, 95, 20);
		contentPane.add(lblEnterMac);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 92, 203, 26);
		contentPane.add(textField_1);
		
		JLabel lblMaxTime = new JLabel("Max Time:");
		lblMaxTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaxTime.setBounds(15, 95, 95, 20);
		contentPane.add(lblMaxTime);
	}
}
