package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.tools.Tool;

import Filters.Filter;
import Main.Main;
import Objects.WiFiList;
import Tools.CreateCsv;
import Tools.CreateKml;
import Tools.readcsv;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblObjectOrientedProframming = new JLabel("Object Oriented Proframming");
		lblObjectOrientedProframming.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblObjectOrientedProframming.setBounds(229, 16, 370, 32);
		contentPane.add(lblObjectOrientedProframming);

		JLabel lblInputoutput = new JLabel("Input/Output");
		lblInputoutput.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInputoutput.setBounds(102, 83, 135, 32);
		contentPane.add(lblInputoutput);



		JButton btnInputDocument = new JButton("Input Folder");
		btnInputDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInputDocument.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InputFolder frame = new InputFolder();
				frame.setVisible(true);			}
		});
		btnInputDocument.setBounds(85, 123, 152, 29);
		contentPane.add(btnInputDocument);

		JButton btnInputFile = new JButton("Input Csv File");
		btnInputFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				InputFile frame = new InputFile();
				frame.setVisible(true);
			}
		});
		btnInputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInputFile.setBounds(85, 168, 152, 29);
		contentPane.add(btnInputFile);

		JLabel lblDataStructure = new JLabel("Data Structure");
		lblDataStructure.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDataStructure.setBounds(93, 213, 144, 32);
		contentPane.add(lblDataStructure);

		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ArrayList<WiFiList> NewArray=new ArrayList<WiFiList>();
				Main.setWifilist(NewArray);
				System.out.println("Data Structure is clear");
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBounds(85, 247, 152, 29);
		contentPane.add(btnReset);

		JButton btnSave = new JButton("Save To CSV");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					CreateCsv.make10List(Main.Wifilist, Main.folder.getParentFile());
					System.out.println("Csv Created");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(85, 292, 152, 29);
		contentPane.add(btnSave);

		JButton btnSaveToKml = new JButton("Save To KML");
		btnSaveToKml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				try {
					File fold=new File(Main.folder.getParentFile()+"\\FinalCSV.csv");
					CreateCsv.make10List(Main.Wifilist, Main.folder);
					//CreateKml.csvtokml(fold);
					System.out.println("Kml Created");
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSaveToKml.setBounds(85, 337, 152, 29);
		contentPane.add(btnSaveToKml);

		JButton btnInfo = new JButton("Info");
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Info frame = new Info();
				frame.setVisible(true);

			}
		});
		btnInfo.setBounds(85, 382, 152, 29);
		contentPane.add(btnInfo);

		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFilters.setBounds(352, 83, 135, 32);
		contentPane.add(lblFilters);

		JButton btnTimeFilter = new JButton("Time Filter");
		btnTimeFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimeFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TimeFilter frame = new TimeFilter();
				frame.setVisible(true);
			}
		});
		btnTimeFilter.setBounds(305, 123, 152, 29);
		contentPane.add(btnTimeFilter);

		JButton btnLocationFilter = new JButton("Location Filter");
		btnLocationFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LocationFilter frame = new LocationFilter();
				frame.setVisible(true);
			}
		});
		btnLocationFilter.setBounds(305, 168, 152, 29);
		contentPane.add(btnLocationFilter);

		JButton btnSsidFilter = new JButton("SSID Filter");
		btnSsidFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SSIDFilter frame = new SSIDFilter();
				frame.setVisible(true);
				
			}
		});
		btnSsidFilter.setBounds(305, 216, 152, 29);
		contentPane.add(btnSsidFilter);

		JButton btnCancelFilter = new JButton("Cancel Filter");
		btnCancelFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				

				Filter filter2 = null;
				Main.filter=filter2;
				ArrayList<WiFiList> array=new ArrayList<WiFiList>(Main.WifilistTemp);
				Main.Wifilist=array;
			
			}
		});
		btnCancelFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelFilter.setBounds(305, 294, 152, 29);
		contentPane.add(btnCancelFilter);

		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String fileName="Csv";
				if(Main.filter!=null)
				{
					fileName=Main.filter.getFilter();
					CreateCsv.ArrayByFilter(Main.Wifilist, Main.filter,fileName , Main.Mainfolder);
				}
				CreateCsv.WriterCsv(Main.getWifilist(), fileName, Main.Mainfolder);
			}
		});
		btnSave_1.setBounds(305, 337, 152, 29);
		contentPane.add(btnSave_1);

		JButton btnAddFilter = new JButton("Filter combination");
		btnAddFilter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Filter_Comb frame = new Filter_Comb();
				frame.setVisible(true);
			}
		});
		btnAddFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddFilter.setBounds(305, 382, 152, 29);
		contentPane.add(btnAddFilter);

		JLabel lblAlgorithms = new JLabel("Algorithms");
		lblAlgorithms.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithms.setBounds(550, 83, 135, 32);
		contentPane.add(lblAlgorithms);

		JButton btnAlgorithm = new JButton("Algorithm 1");
		btnAlgorithm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Algorithm frame = new Algorithm();
				frame.setVisible(true);
			}
		});
		btnAlgorithm.setBounds(521, 123, 152, 29);
		contentPane.add(btnAlgorithm);

		JButton btnAlgorithm_2 = new JButton("Algorithm 2");
		btnAlgorithm_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Algorithm2 frame = new Algorithm2();
				frame.setVisible(true);
			}
		});
		btnAlgorithm_2.setBounds(521, 168, 152, 29);
		contentPane.add(btnAlgorithm_2);
	}
}
