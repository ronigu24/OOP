package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Main;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JEditorPane filter_pro = new JEditorPane();
		filter_pro.setEditable(false);
		filter_pro.setBounds(185, 126, 106, 26);
		contentPane.add(filter_pro);
		
		JEditorPane records = new JEditorPane();
		records.setEditable(false);
		records.setBounds(185, 47, 106, 26);
		contentPane.add(records);
		
		JEditorPane routers = new JEditorPane();
		routers.setEditable(false);
		routers.setBounds(185, 86, 106, 26);
		contentPane.add(routers);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				records.setText(Integer.toString(Main.Wifilist.size()));
				
			}
		});
		btnOk.setBounds(112, 212, 115, 29);
		contentPane.add(btnOk);
	}
}
