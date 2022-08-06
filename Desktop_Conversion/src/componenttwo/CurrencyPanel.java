package componenttwo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class CurrencyPanel extends JFrame {

	// declaring private data type instance array
	private final static String[] list = { "British Pound/Japanese yen (JPY)", "British Pound/Euro (EUR)",
			"British Pound/US Dollars (USD) ", "British Pound/Australian Dollars (AUD)",
			"British Pound/Canadian Dollars (CAD)", "British Pound/South Korean Won (KRW)",
			"British Pound/Thai Baht (THB)", "British Pound/UAE Dirham (AED)" };

	// declaring private access modifier instance variables
	private JPanel contentPane, panel, panel_1;
	private JLabel select, enterlabel, resultlabel, outputresult, conversion, counter;
	private JTextField textField;
	private JButton convert, reset;
	private JComboBox comboBox;
	private JCheckBox reverse;

	// declaring the instance variable count of integer datatype and initialize it
	// to zero
	int count = 0;
	private String symbol;
	int total_file = 0;
	// declaring string array symbol1 which can store up 20 values
	private String[] symbol1 = new String[20];
	// declaring double array factor_value which can store up 20 values
	private double[] factor_value = new double[20];

	// constructor of CurrencyPanel class
	CurrencyPanel() {

		// creating a object of Convertlistener class from Actionlistener class
		ActionListener listener = new ConvertListener();

		// creating object of menubar with reference variable menuBar
		JMenuBar menuBar = new JMenuBar();

		// adding menuBar to the JmenuBar
		setJMenuBar(menuBar);

		// creating the first menu object for menubar with reference variable menu1_file
		JMenu menu1_file = new JMenu("File");

		// setting tooltip for menu1_file to specify the file
		menu1_file.setToolTipText("Press here to view all list of file");

		// adding menu1_file to the menuBar
		menuBar.add(menu1_file);

		// creating object of menuitem with reference variable neww
		JMenuItem neww = new JMenuItem("New");

		// setting the icon for menuitem neww
		neww.setIcon(
				new ImageIcon("C:/Users/munak/OneDrive/Documents/MyWorkspace/ComponentTwo/src/componenttwo/new.png"));

		// adding the key stroke(CTRL+N) to the menuitem neww
		neww.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));

		// adding menuitem to the menu1_file menu
		menu1_file.add(neww);

		// creating the second menu object for menubar with reference variable
		// menu2_edit
		JMenu menu2_edit = new JMenu("Edit");

		// setting tooltip for menu2_edit to specify the edit
		menu2_edit.setToolTipText("Press here to edit");

		// adding menu2_edit to the menuBar
		menuBar.add(menu2_edit);

		// creating the second menu object for menubar with reference variable
		// menu3_help
		JMenu menu3_help = new JMenu("Help");

		// setting tooltip for menu3_help to specify the help
		menu3_help.setToolTipText("Press here to view all list of help");

		// adding menu3_help to the menuBar
		menuBar.add(menu3_help);

		// creating object of menuitem with reference variable about
		JMenuItem about = new JMenuItem("About");

		// adding event Handler to execute the method while user pressing the about
		// menuitem.
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// adding seperate dialogbox in 'about' menuitem to describe about program
				JOptionPane.showMessageDialog(null, "Carries 60% Marks\n 2020 Copyright @muna kc\nTBC,Kathmandu",
						"2nd Component Assignment", 1);
			}
		});

		// setting the icon for menuitem about
		about.setIcon(
				new ImageIcon("C:/Users/munak/OneDrive/Documents/MyWorkspace/ComponentTwo/src/componenttwo/about.png"));

		// setting the key stroke ALT+H to the menuitem about
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_MASK));

		// adding menuitem to the help menu
		menu3_help.add(about);

		// creating the object of the panel
		contentPane = new JPanel();

		// setting setBackground to the panel
		contentPane.setBackground(new Color(0, 0, 0));

		// setting border to the panel
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// creating the object of the panel
		panel = new JPanel();

		// setting border to the panel
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		// setting setBackground to the panel
		panel.setBackground(new Color(135, 206, 250));

		// setting foreBackground to the panel
		panel.setForeground(new Color(255, 228, 181));

		// setting the bounds to decide the position and size of the panel
		panel.setBounds(1, 1, 300, 273);

		// adding panel to the content pane
		contentPane.add(panel);

		// setting layout of the panel null so that we can position our components
		// absolutely
		panel.setLayout(null);

		// creating an object of combobox with parameter
		comboBox = new JComboBox<String>(list);

		// setting tooltip for combobox to specify the combobox
		comboBox.setToolTipText("Press here to view all list");

		// setting fontfamily to the combobox
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// setting the bounds to decide the position and size of the combobox
		comboBox.setBounds(21, 45, 252, 40);

		// adding combobox to the panel
		panel.add(comboBox);

		// creating an object of select label and adding statement
		select = new JLabel("SELECT CURRENCY:");

		// setting fontfamily to the select label
		select.setFont(new Font("Times New Roman", Font.BOLD, 17));

		// setting the bounds to decide the position and size of the select label
		select.setBounds(21, 11, 201, 35);

		// adding select label to the panel
		panel.add(select);

		// creating an object of enterlabel and adding statement
		enterlabel = new JLabel("ENTER CURRENCY AMOUNT:");

		// setting fontfamily to the enterlabel
		enterlabel.setFont(new Font("Times New Roman", Font.BOLD, 16));

		// setting the bounds to decide the position and size of the enterlabel
		enterlabel.setBounds(21, 111, 236, 40);

		// adding enterlabel to the panel
		panel.add(enterlabel);

		// creating an object of textField
		textField = new JTextField(10);

		// setting tooltip for textfield to specify the textfield
		textField.setToolTipText("Enter your value here");

		// adding key Handler to execute the method while user pressing the 'Enter' key
		// to display the result.
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					convert.doClick();
			}
		});

		// setting fontfamily to the textField
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		// setting the bounds to decide the position and size of the textfield area
		textField.setBounds(21, 149, 146, 28);

		// adding textfield to the panel
		panel.add(textField);

		// setting the textfield column number of columns from which the field’s width
		// is calculated
		textField.setColumns(20);

		// creating an object of convert
		convert = new JButton("CONVERT");

		// setting tooltip for convert to specify the convert
		convert.setToolTipText("Press here to convert");

		// setting the foreground color for convert button
		convert.setForeground(new Color(255, 255, 255));

		// setting the bounds to decide the position and size of the convert button
		convert.setBounds(21, 202, 121, 40);

		// adding convert button to the panel
		panel.add(convert);

		// setting background color to the convert button
		convert.setBackground(new Color(105, 105, 105));

		// setting fontfamily to the convert button
		convert.setFont(new Font("Times New Roman", Font.BOLD, 13));

		// adding event handler to the convert button
		convert.addActionListener(listener);// convert values when pressed

		// creating an object of reset button
		reset = new JButton("RESET");

		// setting tooltip for reset to specify the reset
		reset.setToolTipText("Press here to clear everything");

		// setting foreground color to the reset button
		reset.setForeground(new Color(255, 99, 71));

		// setting background color to the reset button
		reset.setBackground(new Color(105, 105, 105));

		// setting the bounds to decide the position and size of the reset button
		reset.setBounds(152, 202, 121, 40);

		// adding reset button to the panel
		panel.add(reset);

		// setting fontfamily to the reset button
		reset.setFont(new Font("Times New Roman", Font.BOLD, 13));

		// adding action Handler to execute the method while user pressing the 'reset'
		// button to clear the different labels.
		reset.addActionListener(e -> {
			// adding null value to the texfield component after pressing reset button
			textField.setText(null);

			// adding null value to the outputresult component after pressing reset button
			outputresult.setText(null);

			// resetting the value of count to zero after pressing the reset button and
			// before starting the calculation
			count = 0;
			counter.setText(Integer.toString(count));
		});

		// creating the object of the panel
		panel_1 = new JPanel();

		// setting border to the panel
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		// setting border to the panel
		panel_1.setBackground(new Color(230, 230, 250));

		// setting the bounds to decide the position and size of the panel
		panel_1.setBounds(301, 1, 281, 189);

		// adding panel to the content pane
		contentPane.add(panel_1);

		// setting layout of the panel null so that we can position our components
		// absolutely
		panel_1.setLayout(null);

		// creating an object of resultlabel
		resultlabel = new JLabel("RESULT");

		// setting the font family to the resultlabel
		resultlabel.setFont(new Font("Times New Roman", Font.BOLD, 25));

		// setting the bounds to decide the position and size of the resultlabel
		resultlabel.setBounds(69, 11, 132, 46);

		// adding resultlabel to the panel_1
		panel_1.add(resultlabel);

		// creating an object of outputresult
		outputresult = new JLabel("20");
		outputresult.setText("-----------");

		// setting tooltip for outputresult to specify the outputresult
		outputresult.setToolTipText("Output appears here");

		// setting font family to the outputresult
		outputresult.setFont(new Font("Times New Roman", Font.BOLD, 22));

		// setting the bounds to decide the position and size of the outputresult
		outputresult.setBounds(79, 43, 148, 61);

		// adding outputresult to the panel_1
		panel_1.add(outputresult);

		// creating an object of reverse checkbox with parameter
		reverse = new JCheckBox("REVERSE CONVERSION");

		// setting tooltip for reverse checkbox to specify the checkbox
		reverse.setToolTipText("press here to reverse your conversion");

		// adding background color to the reverse checkbox
		reverse.setBackground(new Color(176, 196, 222));

		// setting the bounds to decide the position and size of the checkbox
		reverse.setBounds(24, 122, 203, 46);

		// adding checkbox to the panel_1
		panel_1.add(reverse);

		// setting the font family and size
		reverse.setFont(new Font("Times New Roman", Font.BOLD, 15));

		// creating an object of Conversion
		conversion = new JLabel("CONVERSION COUNT");

		// setting tooltip for Conversion to specify the Conversion
		conversion.setToolTipText("Your Total Converted counts");

		// setting the bounds to decide the position and size of the conversion label
		conversion.setBounds(351, 201, 188, 36);

		// adding conversion label to the contentpane
		contentPane.add(conversion);

		// setting foreground color to the conversion label
		conversion.setForeground(new Color(240, 230, 140));

		// setting the font family and size
		conversion.setFont(new Font("Times New Roman", Font.BOLD, 16));

		// creating an object of counter
		counter = new JLabel(String.valueOf(count));

		// setting tooltip for counter to specify the Conversion
		counter.setToolTipText("Your Total Converted counts");

		// setting the bounds to decide the position and size of the counter label
		counter.setBounds(428, 228, 103, 35);

		// adding counter to the contentpane
		contentPane.add(counter);

		// setting foreground color to the counter label
		counter.setForeground(new Color(240, 230, 140));

		// setting the font family and size
		counter.setFont(new Font("Times New Roman", Font.BOLD, 17));

		// creating object of menuitem with reference variable load
		JMenuItem load = new JMenuItem("Load");

		// setting the icon for menuitem load
		load.setIcon(
				new ImageIcon("C:/Users/munak/OneDrive/Documents/MyWorkspace/ComponentTwo/src/componenttwo/load.png"));

		// adding the key stroke(CTRL+L) to the menuitem load
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));

		// adding load to the menu1_file
		menu1_file.add(load);

		// adding event Handler to execute the method while user pressing the exit
		// menuitem.
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comboBox.removeAllItems(); // removing all the data from the combobox if we press the load option to
											// choose the file
				total_file = 1;
				// creating the file reference
				File file;

				// creating the jfc reference file chooser for selecting the file either to open
				// or save window
				JFileChooser jfc = new JFileChooser();

				// making jfc to open the selected file
				int status = jfc.showOpenDialog(null);

				if (status == JFileChooser.APPROVE_OPTION) {
					// setting the information of the selected file in the file reference
					file = jfc.getSelectedFile();

					try {// executing'try' block to handle the exception

						// reading the selected file from FileReader which is already in the harddisk of
						// the system
						BufferedReader br = new BufferedReader(new FileReader(file));

						// converting data into array line by line and add it to the object array
						Object[] line = br.lines().toArray();

						for (int i = 0; i < line.length; i++) {// creating the loop to read the line array

							// changing the data object form to string form
							String s = line[i].toString();

							// splitting data according to the delimiter and storing it in a string array
							String[] SplitText = s.split(",");
							
							if (SplitText.length == 3) {// checking the string array if it contains the required three
														// elements or if the wrong delimiter is used
								try {
									String name = SplitText[0].trim();
									// spliting and removing leading and trailing white space
									factor_value[i] = Double.parseDouble(SplitText[1].trim());

									symbol1[i] = SplitText[2].trim();
									comboBox.addItem("British Pound/" + name);

								} catch (NumberFormatException ex) {// implemented catchblock to handle the
																	// numberformatexception if there is other values
																	// except integer value
									
									comboBox.addItem("Invalid Format");
									JOptionPane.showMessageDialog(null, "Format is invalid"); 
								}
							} else {
								comboBox.addItem("Invalid");
								JOptionPane.showMessageDialog(null, "File is invalid"); 
							}

						}
					} catch (IOException a) {// implemented catchblock to handle the IOException if the file is
												// incorrect

						JOptionPane.showMessageDialog(null, "File is incorrect"); 

					}
				}

			}
		});

		// creating object of menuitem with reference variable save
		JMenuItem save = new JMenuItem("Save");

		// setting the icon for menuitem save
		save.setIcon(
				new ImageIcon("C:/Users/munak/OneDrive/Documents/MyWorkspace/ComponentTwo/src/componenttwo/save.png"));

		// adding the key stroke(CTRL+S) to the menuitem save
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

		// adding save menuitem to the menu1_file
		menu1_file.add(save);

		// creating object of menuitem with reference variable exit
		JMenuItem exit = new JMenuItem("Exit");

		// setting the icon for menuitem exit
		exit.setIcon(
				new ImageIcon("C:/Users/munak/OneDrive/Documents/MyWorkspace/ComponentTwo/src/componenttwo/exit.png"));

		// adding the key stroke(CTRL+X) to the menuitem exit
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));

		// adding event Handler to execute the method while user pressing the exit
		// menuitem.
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// adding exit menuitem to the mmenu1_file
		menu1_file.add(exit);

	}

	// creating a class convertlisteer and implementing an interface actionlistener
	private class ConvertListener implements ActionListener {

		@Override
		// overriding the methos of the interface
		public void actionPerformed(ActionEvent event) {

			// executing'try' block to handle the exception
			try {
				// creating the string variable that stores the value enter by the user
				String text = textField.getText().trim();

				// condition to check whether there is a value in the textfield or not
				if (text.isEmpty() == false) {

					// converting the string datatype to double data type stored in text
					double value = Double.parseDouble(text);

					// the factor applied during the conversion
					double factor = 0;

					if (total_file == 0)// checking if external file is loaded or not, if not loaded the following lines
										// of code is executed
					{
						// checking if reversecheckbox is selected or not,if not selected then the
						// following lines of code is executed
						if (reverse.isSelected() == false) {

							// implementing switchcase statement to check the combobox for selecting the
							// index
							switch (comboBox.getSelectedIndex()) {
							case 0: // case for British Pound/Japanese yen (JPY)
								factor = 137.52;
								symbol = "¥";
								break;

							case 1: // case for British Pound/Euro (EUR)
								factor = 1.09;
								symbol = "€";
								break;

							case 2:// case for British Pound/US Dollars (USD)
								factor = 1.29;
								symbol = "$";
								break;

							case 3: // case for British Pound/Australian Dollars (AUD)
								factor = 1.78;
								symbol = "A$";
								break;

							case 4:// case for British Pound/Canadian Dollars (CAD)
								factor = 1.70;
								symbol = "C$";
								break;

							case 5:// case for British Pound/South Korean Won (KRW)
								factor = 1537.75;
								symbol = "₩";
								break;

							case 6:// case for British Pound/Thai Baht (THB)
								factor = 40.52;
								symbol = "฿";
								break;

							case 7:// case for British Pound/UAE Dirham (AED)
								factor = 4.75;
								symbol = "إ.د";
								break;
							}
						}

						else// if reversebox is selected then the following lines of code is executed
						{
							switch (comboBox.getSelectedIndex()) {// implimenting switchcase statement to check the
																	// combobox for selecting the index

							case 0: // case for Japanese yen (JPY)/British Pound
								factor = 0.0072;
								symbol = "£";
								break;

							case 1: // case for Euro (EUR)/British Pound
								factor = 0.91;
								symbol = "£";
								break;

							case 2:// case for US Dollars (USD)/British Pound
								factor = 0.74;
								symbol = "£";
								break;

							case 3: // case for Australian Dollars (AUD)/British Pound
								factor = 0.56;
								symbol = "£";
								break;

							case 4:// case for Canadian Dollars (CAD)/British Pound
								factor = 0.58;
								symbol = "£";
								break;

							case 5:// case for South Korean Won (KRW)/British Pound
								factor = 0.00067;
								symbol = "£";
								break;

							case 6:// case for Thai Baht (THB)/British Pound
								factor = 0.025;
								symbol = "£";
								break;

							case 7:// case for UAE Dirham (AED)/British Pound
								factor = 0.20;
								symbol = "£";
								break;
							}
						}

						// declaring the double result variable to store the value after calculation
						double result = factor * value;

						// set two digit after decimal value
						String s = new DecimalFormat("0.00").format(result);

						// displaying the result
						outputresult.setText(symbol + s);
					} else {
						if (reverse.isSelected()) {
							factor = 1 / factor_value[comboBox.getSelectedIndex()];

							// store calculation into result
							double result = factor * value;
							
							// set two digit after decimal value
							String s = new DecimalFormat("0.00").format(result);
							
							// displaying the result
							outputresult.setText("£" + s);
						} else {
							factor = factor_value[comboBox.getSelectedIndex()];

							// store calculation into result
							double result = factor * value;

							// it display the result in decimal format
							String s = new DecimalFormat("0.00").format(result);

							String s1 = symbol1[comboBox.getSelectedIndex()]; // format

							outputresult.setText(s1 + s);
						}
					}
					// increases the counter value
					counter.setText(Integer.toString(++count));

				} else {// if the textfield is empty while executing the program, seperate dialogbox
						// will be poppedup to describe about the unentered value

					JOptionPane.showMessageDialog(null, "ERROR!!\nPlease Enter the Value First!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException f) {// implemented catchblock to handle the numberformatexception if we enter
												// any values except integer value
				JOptionPane.showMessageDialog(null, "ERROR!!\nPlease Enter the Valid Number!", "ERROR",
						JOptionPane.ERROR_MESSAGE);

			}

		}

	}
}
