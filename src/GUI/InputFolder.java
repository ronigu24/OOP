package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Main.Main;
import Objects.WiFiList;
import Tools.readcsv;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class InputFolder extends JFrame {

	private JPanel contentPane;
	private  JFileChooser OpenFileChooser;
	/**
	 * @wbp.nonvisual location=381,199
	 */
	private final JFileChooser fileChooser = new JFileChooser();

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

		JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 86, 303, 31);
		contentPane.add(textArea);

		JLabel lblAlgorithm = new JLabel("Input/Output");
		lblAlgorithm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgorithm.setBounds(104, 3, 124, 31);
		contentPane.add(lblAlgorithm);

		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<WiFiList> Wifilist1=new ArrayList<WiFiList>(Main.Wifilist);
					Main.WifilistTemp=Wifilist1;
					if(OpenFileChooser.getSelectedFile()!=null)
					{
						dispose();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}


			}
		});
		btnOk.setBounds(113, 129, 115, 29);
		contentPane.add(btnOk);

		JLabel lblEnterMac = new JLabel("Chose Folder:");
		lblEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterMac.setBounds(96, 50, 127, 20);
		contentPane.add(lblEnterMac);

		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				OpenFileChooser=new JFileChooser();
				OpenFileChooser.setCurrentDirectory(new File("c:"));
				OpenFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				OpenFileChooser.showOpenDialog(button);
				File filePath=OpenFileChooser.getSelectedFile();
				Main.folder=OpenFileChooser.getSelectedFile();
				textArea.setText(filePath.toString());
				try {
					readcsv.readcsvFolder(filePath);
					Thread thread = new Thread(new Thread_listens());
					thread.start();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(238, 50, 22, 29);
		contentPane.add(button);
	}
}
