package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DataAnalystScreen {

	public JFrame frame;

	public DataAnalystScreen() {
		initialize();
	}

	private void initialize() {
		int width = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.7);
		int height = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.7);
		frame = new JFrame("Data Analyst");
		// frame.setType(javax.swing.JFrame.Type.UTILITY);
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

		JLabel carrierGraph = new JLabel();
		sl.putConstraint(SpringLayout.WEST, carrierGraph, 0, SpringLayout.WEST, jp);
		sl.putConstraint(SpringLayout.NORTH, carrierGraph, 0, SpringLayout.NORTH, jp);
		sl.putConstraint(SpringLayout.SOUTH, carrierGraph, 0, SpringLayout.SOUTH, jp);
		carrierGraph.setSize(width, height);
		carrierGraph.setIcon(new ImageIcon(new ImageIcon(DataAnalystScreen.class.getResource("/img/CarrierGraph.jpg"))
				.getImage().getScaledInstance(carrierGraph.getWidth(), carrierGraph.getHeight(), Image.SCALE_DEFAULT)));

		jp.add(carrierGraph);

		jp.setLayout(sl);
		frame.setContentPane(jp);

	}
}
