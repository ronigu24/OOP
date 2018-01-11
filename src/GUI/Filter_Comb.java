package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.AsyncHandler;

import de.micromata.opengis.kml.v_2_2_0.AltitudeMode;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Filter_Comb extends JFrame {

	private JPanel contentPane;
	private JTextField lat;
	private JTextField lon;
	private JTextField alt;
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
		setBounds(100, 100, 707, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilterCombination = new JLabel("Filter Combination");
		lblFilterCombination.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFilterCombination.setBounds(226, 16, 201, 69);
		contentPane.add(lblFilterCombination);
		
		JRadioButton timebt = new JRadioButton("Time");
		timebt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(timebt.isSelected())
				{
					min.setEditable(true);
					max.setEditable(true);
				}
				if(!timebt.isSelected())
				{
					min.setEditable(false);
					max.setEditable(false);
				}
				
				
			}
		});
		JRadioButton and = new JRadioButton("And");
		JRadioButton or = new JRadioButton("Or");
		JRadioButton not = new JRadioButton("Not");

		or.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(or.isSelected())
				{
					and.setEnabled(false);
					not.setEnabled(false);
				}
				if(!or.isSelected())
				{
					and.setEnabled(true);
					not.setEnabled(true);
				}
				
			}
		});
		and.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(and.isSelected())
				{
					or.setEnabled(false);
					not.setEnabled(false);
				}
				if(!and.isSelected())
				{
					or.setEnabled(true);
					not.setEnabled(true);
				}
			}
		});
	
		not.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(not.isSelected())
				{
					and.setEnabled(false);
					or.setEnabled(false);
				}
				if(!not.isSelected())
				{
					and.setEnabled(true);
					or.setEnabled(true);
				}
			}
		});
		not.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		not.setBounds(111, 390, 97, 29);
		contentPane.add(not);
		
		and.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		and.setBounds(247, 389, 97, 29);
		contentPane.add(and);
		
		or.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 18));
		or.setBounds(390, 389, 97, 29);
		contentPane.add(or);
		timebt.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		timebt.setBounds(61, 86, 155, 29);
		contentPane.add(timebt);
		
		JRadioButton ssidbt = new JRadioButton("SSID");
		ssidbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(ssidbt.isSelected())
				{
					ssid.setEditable(true);
				}
				if(!ssidbt.isSelected())
				{
					ssid.setEditable(false);
				}
			}
		});
		ssidbt.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		ssidbt.setBounds(285, 86, 155, 29);
		contentPane.add(ssidbt);
		
		JRadioButton posbt = new JRadioButton("Position");
		posbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(posbt.isSelected())
				{
					lat.setEditable(true);
					lon.setEditable(true);
					alt.setEditable(true);
					distance.setEditable(true);		
				}
				if(!posbt.isSelected())
				{
					lat.setEditable(false);
					lon.setEditable(false);
					alt.setEditable(false);
					distance.setEditable(false);		
				}
			}
		});
		posbt.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		posbt.setBounds(500, 86, 155, 29);
		contentPane.add(posbt);
		
		JLabel label = new JLabel("Enter your loaction:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(477, 127, 193, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Lat:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(460, 178, 95, 20);
		contentPane.add(label_1);
		
		lat = new JTextField();
		lat.setEditable(false);
		lat.setColumns(10);
		lat.setBounds(512, 176, 158, 26);
		contentPane.add(lat);
		
		lon = new JTextField();
		lon.setEditable(false);
		lon.setColumns(10);
		lon.setBounds(512, 218, 158, 26);
		contentPane.add(lon);
		
		alt = new JTextField();
		alt.setEditable(false);
		alt.setColumns(10);
		alt.setBounds(512, 262, 158, 26);
		contentPane.add(alt);
		
		distance = new JTextField();
		distance.setEditable(false);
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
		min.setEditable(false);
		min.setColumns(10);
		min.setBounds(15, 218, 158, 26);
		contentPane.add(min);
		
		max = new JTextField();
		max.setEditable(false);
		max.setColumns(10);
		max.setBounds(15, 308, 158, 26);
		contentPane.add(max);
		
		ssid = new JTextField();
		ssid.setEditable(false);
		ssid.setColumns(10);
		ssid.setBounds(244, 176, 158, 26);
		contentPane.add(ssid);
		
		JButton button = new JButton("Ok");
		button.setBounds(266, 454, 115, 29);
		contentPane.add(button);
		
		JLabel lblSelectGateType = new JLabel("Select gate type:");
		lblSelectGateType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectGateType.setBounds(108, 357, 193, 20);
		contentPane.add(lblSelectGateType);
	}
}
