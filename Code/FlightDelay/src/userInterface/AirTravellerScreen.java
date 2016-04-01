package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class AirTravellerScreen {

	public JFrame frame;
	String[] carriers = new String[] { "AMERICAN (AA)", "JETBLUE (B6)", "DELTA (DL)", "ATLANTIC SOUTHEAST (EV)",
			"AMERICAN EAGLE (MQ)", "SKYWEST (OO)", "UNITED (UA)", "SOUTHWEST (WN)" };
	String[] abr_c = new String[] { "AA", "B6", "DL", "EV", "MQ", "OO", "UA", "WN" };
	String[] origins = new String[] { "BOSTON (BOS)", "CHICAGO (ORD)", "DALLAS (DFW)", "DENVER(DEN)",
			"LOS ANGELES (LAX)", "NEWARK (EWR)", "NEW YORK (JFK)" };
	String[] abr_o = new String[] { "BOS", "ORD", "DFW", "DEN", "LAX", "EWR", "JFK" };

	public AirTravellerScreen() {
		initialize();
	}

	private void initialize() {
		int width = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.7);
		int height = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.7);
		frame = new JFrame("Air Traveller / ATC Staff");
		frame.setIconImage(new ImageIcon(MainScreen.class.getResource("/img/frameicon.png")).getImage());
		frame.setResizable(false);
		frame.setSize(width, height);
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBackground(new Color(192, 192, 192));
		// frame.setBounds(100, 100, 768, 575);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel jp = new JPanel();

		SpringLayout sl = new SpringLayout();

		JLabel lblNewLabel = new JLabel("Please enter the flight details:-", SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(SystemColor.control);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 50));
		sl.putConstraint(SpringLayout.NORTH, lblNewLabel, (int) (height * 0.15), SpringLayout.NORTH, jp);
		sl.putConstraint(SpringLayout.WEST, lblNewLabel, (int) (width * 0.08), SpringLayout.WEST, jp);
		jp.add(lblNewLabel);

		JLabel lblOrigin = new JLabel("Origin:");
		lblOrigin.setForeground(Color.WHITE);
		lblOrigin.setFont(new Font("Arial", Font.PLAIN, 45));
		sl.putConstraint(SpringLayout.WEST, lblOrigin, 0, SpringLayout.WEST, lblNewLabel);
		sl.putConstraint(SpringLayout.NORTH, lblOrigin, (int) (width * 0.1), SpringLayout.SOUTH, lblNewLabel);
		jp.add(lblOrigin);

		JLabel lblDest = new JLabel("Destination:");
		lblDest.setForeground(Color.WHITE);
		lblDest.setFont(new Font("Arial", Font.PLAIN, 45));
		sl.putConstraint(SpringLayout.WEST, lblDest, (int) (width * 0.4), SpringLayout.EAST, lblOrigin);
		sl.putConstraint(SpringLayout.SOUTH, lblDest, 0, SpringLayout.SOUTH, lblOrigin);
		jp.add(lblDest);

		JLabel lblAirline = new JLabel("Airlines:");
		lblAirline.setForeground(Color.WHITE);
		lblAirline.setFont(new Font("Arial", Font.PLAIN, 45));
		sl.putConstraint(SpringLayout.WEST, lblAirline, 0, SpringLayout.WEST, lblNewLabel);
		sl.putConstraint(SpringLayout.NORTH, lblAirline, (int) (width * 0.05), SpringLayout.SOUTH, lblOrigin);
		jp.add(lblAirline);

		JLabel lblDate = new JLabel("Date/Time:");
		lblDate.setLabelFor(frame);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Arial", Font.PLAIN, 45));
		sl.putConstraint(SpringLayout.WEST, lblDate, 0, SpringLayout.WEST, lblDest);
		sl.putConstraint(SpringLayout.NORTH, lblDate, 0, SpringLayout.NORTH, lblAirline);
		jp.add(lblDate);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 35));
		comboBox.setModel(new DefaultComboBoxModel(carriers));
		sl.putConstraint(SpringLayout.WEST, comboBox, 80, SpringLayout.EAST, lblAirline);
		sl.putConstraint(SpringLayout.SOUTH, comboBox, 0, SpringLayout.SOUTH, lblAirline);
		jp.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 35));
		comboBox_1.setModel(new DefaultComboBoxModel(origins));
		comboBox_1.setSelectedIndex(0);
		sl.putConstraint(SpringLayout.WEST, comboBox_1, 0, SpringLayout.WEST, comboBox);
		sl.putConstraint(SpringLayout.EAST, comboBox_1, 0, SpringLayout.EAST, comboBox);
		sl.putConstraint(SpringLayout.SOUTH, comboBox_1, 0, SpringLayout.SOUTH, lblOrigin);
		jp.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 35));
		comboBox_2.setSize(100, 50);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "BOSTON (BOS)", "CHICAGO (ORD)", "DALLAS (DFW)",
				"DENVER(DEN)", "LOS ANGELES (LAX)        ", "NEWARK (EWR)", "NEW YORK (JFK)" }));
		comboBox_2.setSelectedIndex(0);

		sl.putConstraint(SpringLayout.WEST, comboBox_2, 100, SpringLayout.EAST, lblDest);
		sl.putConstraint(SpringLayout.SOUTH, comboBox_2, 0, SpringLayout.SOUTH, lblDest);
		jp.add(comboBox_2);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1448600400000L), new Date(1448600400000L),
				new Date(1480222800000L), Calendar.DAY_OF_YEAR));
		spinner.setFont(new Font("Arial", Font.PLAIN, 35));

		// JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner,
		// "dd.MM.yyyy");
		// DateFormatter formatter = (DateFormatter)
		// editor.getTextField().getFormatter();
		// formatter.setAllowsInvalid(false); // this makes what you want
		// formatter.setOverwriteMode(true);

		sl.putConstraint(SpringLayout.WEST, spinner, 0, SpringLayout.WEST, comboBox_2);
		sl.putConstraint(SpringLayout.EAST, spinner, 0, SpringLayout.EAST, comboBox_2);
		sl.putConstraint(SpringLayout.SOUTH, spinner, 0, SpringLayout.SOUTH, lblDate);
		jp.add(spinner);

		JButton btnNewButton = new JButton("Predict Delay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBox_1.getSelectedIndex() == comboBox_2.getSelectedIndex()) {
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 25)));
					JOptionPane.showMessageDialog(null,
							"<html><center><font size=\"20\">Please select different Origin and Destination Airports.</font></center>",
							"Error", JOptionPane.INFORMATION_MESSAGE, null);
					return;

				}

				// Instance inst_co;
				// ArrayList<Attribute> attributeList = new
				// ArrayList<Attribute>();
				// Attribute Origin = new Attribute("ORIGIN");
				// Attribute Carrier = new Attribute("CARRIER");
				// Attribute DayOfMonth = new Attribute("DAY_OF_MONTH");
				// Attribute DayOfWeek = new Attribute("DAY_OF_WEEK");
				// Attribute Time = new Attribute("DEP_TIME");
				// Attribute Distance = new Attribute("DISTANCE");
				// Attribute Delay = new Attribute("DEP_DEL15");
				//
				// Origin.addStringValue(comboBox_2.getSelectedItem().toString());
				// Carrier.addStringValue(comboBox_1.getSelectedItem().toString());
				// DayOfMonth.addStringValue(comboBox.getSelectedItem().toString());
				// DayOfWeek.addStringValue(comboBox.getSelectedItem().toString());
				// Time.addStringValue(comboBox.getSelectedItem().toString());
				// Distance.addStringValue(comboBox.getSelectedItem().toString());
				// Delay.addStringValue("?");

				int day, time, time_interval;
				String hour, min;

				DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyy");
				// System.out.println(spinner.getValue());
				Date date1 = (Date) (spinner.getValue());
				String dayofweek = date1.toString().split(" ")[0];
				int dow = 0;
				switch (dayofweek) {
				case "Mon":
					dow = 1;
					break;
				case "Tue":
					dow = 2;
					break;
				case "Wed":
					dow = 3;
					break;
				case "Thu":
					dow = 4;
					break;
				case "Fri":
					dow = 5;
					break;
				case "Sat":
					dow = 6;
					break;
				case "Sun":
					dow = 0;
					break;
				}
				String dateStr = formatter.format(date1);
				day = Integer.parseInt((dateStr.split(" ")[2]));
				hour = dateStr.split(" ")[3].split(":")[0];
				min = dateStr.split(" ")[3].split(":")[1];
				String time_string = hour.concat(min);
				time = Integer.parseInt(time_string);
				if (time <= 800) {
					time_interval = 0;

				} else {
					if (time >= 801 && time <= 1600) {
						time_interval = 1;

					} else {
						time_interval = 2;
					}

				}

				if (day == 31)
					day = 30;
				String status = "notdelayed", timereg = "0";
				// System.out.println(day + "," + dow + "," + time_interval);

				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.arff")));
					bw.write(
							"@relation abc-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.instance.Randomize-S42-weka.filters.unsupervised.attribute.Remove-R6"
									+ "\n\n@attribute DAY_OF_MONTH numeric\n@attribute DAY_OF_WEEK numeric\n@attribute CARRIER {AA,B6,DL,EV,MQ,OO,UA,WN}\n@attribute ORIGIN {JFK,LAX,DFW,ORD,BOS,DEN,EWR}\n@attribute DEP_TIME numeric\n@attribute DISTANCE numeric\n@attribute DEP_DEL15 {notdelayed,delayed}\n\n@data\n");
					// bw.write("18,5,MQ,ORD,2,1,?\n");
					bw.write(day + "," + dow + "," + abr_c[comboBox.getSelectedIndex()] + ","
							+ abr_o[comboBox_1.getSelectedIndex()] + "," + time_interval + ",1," + "?\n");
					bw.flush();
					bw.close();

					DataSource data = new DataSource("test.arff");
					Instances instances2 = data.getDataSet();
					instances2.setClassIndex(instances2.numAttributes() - 1);

					status = MainScreen.classifier.test(instances2);

				} catch (Exception e) {
					e.printStackTrace();
				}

				if (status.equals("delayed")) {

					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(new File("testr.arff")));
						bw.write(
								"@relation regressionarff-weka.filters.unsupervised.attribute.NumericToNominal-R5-weka.filters.unsupervised.attribute.NumericToNominal-R5-weka.filters.unsupervised.attribute.NumericToNominal-R5\n\n@attribute DAY_OF_MONTH {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30}\n@attribute DAY_OF_WEEK {1,2,3,4,5,6,7}\n@attribute CARRIER {AA,B6,DL,EV,MQ,OO,UA,WN}\n@attribute ORIGIN {LAX,ORD,JFK,DFW,BOS,DEN,EWR}\n@attribute DEP_TIME {0,1,2}\n@attribute DISTANCE numeric\n@attribute DEP_DELAY_NEW numeric\n\n@data\n");

						// bw.write("18,5,MQ,ORD,2,1,?\n");
						bw.write(day + "," + dow + "," + abr_c[comboBox.getSelectedIndex()] + ","
								+ abr_o[comboBox_1.getSelectedIndex()] + "," + time_interval + ",1," + "?\n");
						bw.flush();
						bw.close();

						DataSource data = new DataSource("testr.arff");
						Instances instances2 = data.getDataSet();
						instances2.setClassIndex(instances2.numAttributes() - 1);

						timereg = MainScreen.regressor.test(instances2);

					} catch (Exception e) {
						e.printStackTrace();
					}

					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 25)));
					JOptionPane.showMessageDialog(null,
							"<html><b><font size=\"40\" color=\"RED\">DELAY</font></b><br>"
									+ "<font color=#000000 size=\"30\">Estimated delay: " + timereg + " mins</font>",
							"Prediction for Flight departure", JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(AirTravellerScreen.class.getResource("/img/delay.png")));

				} else {
					System.out.println(status);
					UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 25)));
					JOptionPane.showMessageDialog(null,
							"<html><b><font size=\"40\" color=\"GREEN\">ON TIME</font></b><br>",
							"Prediction for Flight departure", JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon(AirTravellerScreen.class.getResource("/img/delay.png")));
				}
			}
		});
		btnNewButton.setBackground(Color.decode("#3399ff"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setMargin(new Insets(15, 100, 15, 100));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 35));
		sl.putConstraint(SpringLayout.WEST, btnNewButton, (int) (width * 0.4), SpringLayout.WEST, jp);
		sl.putConstraint(SpringLayout.NORTH, btnNewButton, (int) (width * 0.1), SpringLayout.SOUTH, lblDate);
		jp.add(btnNewButton);

		// JLabel status = new JLabel("");
		// status.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		// sl.putConstraint(SpringLayout.NORTH, status, -20, SpringLayout.NORTH,
		// comboBox);
		// sl.putConstraint(SpringLayout.EAST, status, -250, SpringLayout.EAST,
		// jp);
		// status.setForeground(Color.RED);
		// status.setText("DELAY");
		// jp.add(status);
		//
		// JLabel pred = new JLabel("");
		// pred.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
		// sl.putConstraint(SpringLayout.SOUTH, pred, -20, SpringLayout.NORTH,
		// status);
		// sl.putConstraint(SpringLayout.WEST, pred, -25, SpringLayout.WEST,
		// status);
		// pred.setForeground(Color.WHITE);
		// pred.setText("PREDICTION");
		// jp.add(pred);
		//
		// JLabel time = new JLabel("");
		// time.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
		// sl.putConstraint(SpringLayout.NORTH, time, 20, SpringLayout.SOUTH,
		// status);
		// sl.putConstraint(SpringLayout.WEST, time, -100, SpringLayout.WEST,
		// status);
		// time.setForeground(Color.LIGHT_GRAY);
		// time.setText("Estimated Delay: 10 mins");
		// jp.add(time);

		BackGround2 bg2 = new BackGround2();
		sl.putConstraint(SpringLayout.NORTH, bg2, 0, SpringLayout.NORTH, jp);
		sl.putConstraint(SpringLayout.SOUTH, bg2, 0, SpringLayout.SOUTH, jp);
		sl.putConstraint(SpringLayout.EAST, bg2, 0, SpringLayout.EAST, jp);
		sl.putConstraint(SpringLayout.WEST, bg2, 0, SpringLayout.WEST, jp);
		jp.setBackground(Color.decode("#555555"));
		jp.add(bg2);

		jp.setLayout(sl);
		frame.setContentPane(jp);

	}
}
