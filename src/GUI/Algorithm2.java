package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Main;
import Objects.WiFiList;
import Tools.readcsv;
import algorithms.algorithm2;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Algorithm2 extends JFrame {

	private JPanel contentPane;
	private JTextField scanline;
	private JTextField mac1;
	private JTextField mac2;
	private JTextField signal1;
	private JTextField signal2;
	private JTextField mac3;
	private JTextField signal3;

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
		setBounds(100, 100, 360, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAlgorithm = new JLabel("Algorithm 2");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(115, 16, 117, 31);
		contentPane.add(lblAlgorithm);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 396, 292, 85);
		contentPane.add(textArea);

		scanline = new JTextField();
		scanline.setBounds(15, 124, 290, 26);
		contentPane.add(scanline);
		scanline.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ArrayList<WiFiList> Line1 = null;
				String str;
				if(mac1!=null&&signal1!=null&&scanline!=null)
				{
					if(scanline!=null)
					{
						str=scanline.getText();
						try {
							Line1=readcsv.readLine(str);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						algorithm2.algorithm(Main.Wifilist, Line1);
					}
					double lat=Line1.get(0).getPoint().getLat();
					double lon=Line1.get(0).getPoint().getLon();
					double alt=Line1.get(0).getPoint().getAlt();

					textArea.append("Lat: "+lat+"\n Lon:  "+lon+"\n Alt: "+alt);	

				}


			}
		});
		btnOk.setBounds(104, 360, 115, 29);
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

		mac1 = new JTextField();
		mac1.setBounds(15, 232, 131, 26);
		contentPane.add(mac1);
		mac1.setColumns(10);

		JLabel lblMac = new JLabel("Mac");
		lblMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMac.setBounds(15, 196, 105, 20);
		contentPane.add(lblMac);

		JLabel lblSignal = new JLabel("Signal");
		lblSignal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSignal.setBounds(187, 197, 105, 20);
		contentPane.add(lblSignal);

		mac2 = new JTextField();
		mac2.setColumns(10);
		mac2.setBounds(15, 274, 131, 26);
		contentPane.add(mac2);

		signal1 = new JTextField();
		signal1.setColumns(10);
		signal1.setBounds(174, 232, 131, 26);
		contentPane.add(signal1);

		signal2 = new JTextField();
		signal2.setColumns(10);
		signal2.setBounds(174, 274, 131, 26);
		contentPane.add(signal2);

		mac3 = new JTextField();
		mac3.setColumns(10);
		mac3.setBounds(15, 318, 131, 26);
		contentPane.add(mac3);

		signal3 = new JTextField();
		signal3.setColumns(10);
		signal3.setBounds(174, 318, 131, 26);
		contentPane.add(signal3);
	}
}
