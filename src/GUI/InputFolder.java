package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objects.WiFiList;
import Tools.readcsv;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

public class InputFolder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputFolder frame = new InputFolder();
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
	public InputFolder() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 355, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlgorithm = new JLabel("Input/Output");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(104, 3, 124, 31);
		contentPane.add(lblAlgorithm);
		
		textField = new JTextField();
		textField.setBounds(85, 87, 161, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				File folder=new File (textField.getText());
				Main.Main.setFolder(folder);
				
				}

			
		});
		btnOk.setBounds(113, 129, 115, 29);
		contentPane.add(btnOk);
		
		JLabel lblEnterMac = new JLabel("Enter documant name:");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMac.setBounds(75, 50, 203, 20);
		contentPane.add(lblEnterMac);
	}
}
