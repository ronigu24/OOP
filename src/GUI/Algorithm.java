package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objects.WiFiList;
import algorithms.algorithm1;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextArea;

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
		setBounds(100, 100, 355, 307);
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
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(46, 173, 239, 62);
		contentPane.add(textArea);
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!textField.getText().isEmpty())
				{
				 ArrayList<WiFiList> Algo1=algorithm1.algorithm(Main.Main.getWifilist());
				for(int i=0;i<Algo1.size();i++)
				{
					if(Algo1.get(i).getArray().get(0).getMAC().equals(textField.getText()))
					{
						double lat=Algo1.get(i).getPoint().getLat();
						double lon=Algo1.get(i).getPoint().getLon();
						double alt=Algo1.get(i).getPoint().getAlt();

						textArea.append("Lat: "+lat+"\n Lon:  "+lon+"\n Alt: "+alt);
					}

				}
				}
			}
		});
	
	}
}
