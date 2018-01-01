package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class Info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info frame = new Info();
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
	public Info() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 355, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlgorithm = new JLabel("Info");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(145, 0, 117, 31);
		contentPane.add(lblAlgorithm);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(112, 212, 115, 29);
		contentPane.add(btnOk);
		
		JLabel lblEnterMac = new JLabel("Quantity of records:");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMac.setBounds(15, 50, 164, 20);
		contentPane.add(lblEnterMac);
		
		JLabel lblQuantityOfRouters = new JLabel("Quantity of routers:");
		lblQuantityOfRouters.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantityOfRouters.setBounds(15, 91, 164, 20);
		contentPane.add(lblQuantityOfRouters);
		
		JLabel lblFilterProperties = new JLabel("Filter properties:");
		lblFilterProperties.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFilterProperties.setBounds(15, 127, 164, 20);
		contentPane.add(lblFilterProperties);
		
		JEditorPane dtrpnD = new JEditorPane();
		dtrpnD.setEditable(false);
		dtrpnD.setBounds(185, 126, 106, 26);
		contentPane.add(dtrpnD);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(185, 47, 106, 26);
		contentPane.add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		editorPane_1.setBounds(185, 86, 106, 26);
		contentPane.add(editorPane_1);
	}
}
