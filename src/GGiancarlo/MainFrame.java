package GGiancarlo;

import java.awt.EventQueue;
import javax.swing.JFrame;
import GGiancarlo.GG;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private List<Integer> result;
	private String res;
	private String okunan = "";
	private String textlen;
	private String patternlen;
	private String text;
	private String pattern;
	private String time;
	private JFrame frmGalilGiancarlo;
	private JTextField txtText;
	private JTextField TxtPattern;
	private JPanel panel;
	private List<JLabel> labelList = new ArrayList<>();
	private JPanel panel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					} catch (Exception e) {
						e.printStackTrace();
					}
					MainFrame window = new MainFrame();
					window.frmGalilGiancarlo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGalilGiancarlo = new JFrame();
		frmGalilGiancarlo.setTitle("Galil Giancarlo");
		frmGalilGiancarlo.getContentPane().setBackground(Color.WHITE);
		frmGalilGiancarlo.setForeground(Color.BLUE);
		frmGalilGiancarlo.getContentPane().setForeground(Color.WHITE);
		frmGalilGiancarlo.setBounds(100, 100, 1395, 713);
		frmGalilGiancarlo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGalilGiancarlo.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(-20, 6, 1379, 674);
		frmGalilGiancarlo.getContentPane().add(panel);
		panel.setLayout(null);

		txtText = new JTextField(25);
		txtText.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		txtText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (txtText.getText().length() >= 25)
					arg0.consume();
			}
		});
		txtText.setBounds(208, 60, 339, 45);
		panel.add(txtText);
		txtText.setColumns(10);

		TxtPattern = new JTextField();
		TxtPattern.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		TxtPattern.setBounds(208, 117, 339, 45);
		panel.add(TxtPattern);
		TxtPattern.setColumns(10);

		JLabel txtlbl = new JLabel("Text:");
		txtlbl.setFont(new Font("Arial", Font.BOLD, 23));
		txtlbl.setForeground(Color.BLACK);
		txtlbl.setBounds(56, 69, 92, 29);
		panel.add(txtlbl);

		JLabel lblpattern = new JLabel("Pattern:");
		lblpattern.setFont(new Font("Arial", Font.BOLD, 23));
		lblpattern.setForeground(Color.BLACK);
		lblpattern.setBounds(53, 120, 117, 42);
		panel.add(lblpattern);

		JLabel lblfind = new JLabel("Karşılaştırma Sayısı:");
		lblfind.setForeground(Color.BLACK);
		lblfind.setFont(new Font("Arial", Font.BOLD, 23));
		lblfind.setBounds(612, 210, 235, 30);
		panel.add(lblfind);

		JLabel lblfindres = new JLabel();
		lblfindres.setFont(new Font("Arial", Font.BOLD, 22));
		lblfindres.setBounds(850, 210, 71, 29);
		panel.add(lblfindres);

		JLabel lbltime = new JLabel("Ge\u00E7en S\u00FCre:");
		lbltime.setForeground(Color.BLACK);
		lbltime.setFont(new Font("Arial", Font.BOLD, 22));
		lbltime.setBounds(612, 260, 156, 30);
		panel.add(lbltime);

		JLabel lbltimeres = new JLabel();
		lbltimeres.setFont(new Font("Arial", Font.BOLD, 22));
		lbltimeres.setBounds(760, 260, 141, 30);
		panel.add(lbltimeres);

		JLabel lblpatlen = new JLabel("Pattern Uzunlu\u011Fu:");
		lblpatlen.setForeground(Color.BLACK);
		lblpatlen.setFont(new Font("Arial", Font.BOLD, 22));
		lblpatlen.setBounds(612, 295, 186, 30);
		panel.add(lblpatlen);

		JLabel lblpatternlenres = new JLabel();
		lblpatternlenres.setFont(new Font("Arial", Font.BOLD, 22));
		lblpatternlenres.setBounds(821, 295, 65, 30);
		panel.add(lblpatternlenres);

		JLabel lbltextlen = new JLabel("Text Uzunlu\u011Fu:");
		lbltextlen.setForeground(Color.BLACK);
		lbltextlen.setFont(new Font("Arial", Font.BOLD, 22));
		lbltextlen.setBounds(612, 335, 156, 30);
		panel.add(lbltextlen);

		JLabel lbltextlenres = new JLabel();
		lbltextlenres.setFont(new Font("Arial", Font.BOLD, 22));
		lbltextlenres.setBounds(785, 340, 46, 30);
		panel.add(lbltextlenres);
		JButton btnchooser = new JButton("Dosyada Ara");
		btnchooser.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnchooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnchooser.setForeground(Color.BLACK);
		btnchooser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					JFileChooser openGUI = new JFileChooser();
					openGUI.setCurrentDirectory(new File(System.getProperty("user.home").concat("\\Desktop")));
					openGUI.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					if (JFileChooser.APPROVE_OPTION == openGUI.showOpenDialog(null)) {
						String yol = openGUI.getSelectedFile().getAbsolutePath();

						FileReader fileReader = new FileReader(yol);
						BufferedReader bufferedReader = new BufferedReader(fileReader);

						while ((okunan = bufferedReader.readLine()) != null) {
							text = okunan;
						}
						dosyadaara(e);
						Thread t = new Thread(new Runnable() {
							@Override
							public void run() {
								lblpatternlenres.setText(patternlen);
								lbltextlenres.setText(textlen);
								lblfindres.setText(res);
								lbltimeres.setText(time + " " + "ns");

							}
						});
						t.start();
						bufferedReader.close();

					} else
						JOptionPane.showMessageDialog(null, "Okuma iptal edildi");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnchooser.setBounds(598, 61, 170, 42);
		panel.add(btnchooser);

		JButton btnara = new JButton("Ara");
		btnara.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnara.setForeground(Color.BLACK);
		btnara.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ara(e);
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						lblpatternlenres.setText(patternlen);
						lbltextlenres.setText(textlen);
						lblfindres.setText(res);
						lbltimeres.setText(time + " " + "Ns");
						
					}
				});
				t.start();

			}
		});
		btnara.setBounds(598, 106, 141, 36);
		panel.add(btnara);
		
		panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(150, 210, 450, 189);
		panel.add(panel1);
		
		JButton btnAdmAdm = new JButton("Adım Adım");
		btnAdmAdm.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnAdmAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdmAdm.setBounds(598, 154, 146, 44);
		panel.add(btnAdmAdm);

	}

	private void ara(MouseEvent e) {

		panel1.removeAll();
		labelList.clear();

		long tStart = System.nanoTime();
		text = txtText.getText();
		pattern = TxtPattern.getText();
		textlen = String.valueOf(text.length());
		patternlen = String.valueOf(pattern.length());
		result = GG.findAll(pattern, text);

		long tEnd = System.nanoTime();
		long tRes = tEnd - tStart;
		res = String.valueOf(result.size() * pattern.length());
		time = String.valueOf(tRes);

		label();
	

	}

	private void label() {
		

		char[] textCharacters = text.toCharArray();
		for (int i = 0; i < textCharacters.length; i++) {
			JLabel lbl = new JLabel(String.valueOf(textCharacters[i]));
			lbl.setBackground(Color.WHITE);
			Border border = BorderFactory.createLineBorder(Color.black, 1);
			lbl.setBorder(border);
			
			 
			lbl.setFont(new Font("Arial", Font.BOLD, 40));
			lbl.setBounds(20 * (i + 1), 20, 50, 50);
			labelList.add(lbl);
			panel1.add(lbl);
		}

		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < pattern.length(); j++) {
				labelList.get(result.get(i) + j).setForeground(Color.GREEN);
				System.out.print(result.get(i) + j);
			}
		}

	}
	/*public void labelAdim() {
		char[] textCharacters = text.toCharArray();
		char[] patternChars=pattern.toCharArray();
		
		for (int i = 0; i < textCharacters.length; i++) {
			JLabel lbl = new JLabel(String.valueOf(textCharacters[i]));
			lbl.setBackground(Color.WHITE);
			Border border = BorderFactory.createLineBorder(Color.black, 1);
			lbl.setBorder(border);
			
			 
			lbl.setFont(new Font("Arial", Font.BOLD, 40));
			lbl.setBounds(20 * (i + 1), 20, 50, 50);
			labelList.add(lbl);
			panel1.add(lbl);
	}
		for(int j=1; j<patternChars.length;j++) {
			JLabel lbl2 = new JLabel(String.valueOf(patternChars[j]));
			lbl2.setBackground(Color.WHITE);
			Border border2 = BorderFactory.createLineBorder(Color.black, 1);
			lbl2.setBorder(border2);
			lbl2.setFont(new Font("Arial", Font.BOLD, 40));
			lbl2.setBounds(20 * (j + 1), 30, 60, 60);
			labelList.add(lbl2);
			panel1.add(lbl2);
		
	}
		
	
		
	}*/
	

	private void dosyadaara(MouseEvent e) {

		panel1.removeAll();
		labelList.clear();
		
		long tStart = System.nanoTime();
		pattern = TxtPattern.getText();
		textlen = String.valueOf(text.length());
		patternlen = String.valueOf(pattern.length());
		result = GG.findAll(pattern, text);
		long tEnd = System.nanoTime();
		long tRes = tEnd - tStart;
		res = String.valueOf(result.size() * pattern.length());
		time = String.valueOf(tRes);

		if (text.length() <= 25) {
			label();
		}

	}
}
