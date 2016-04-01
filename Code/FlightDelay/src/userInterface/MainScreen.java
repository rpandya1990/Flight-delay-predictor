package userInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import Algorithms.J48Classifier;
import Algorithms.Regression;

public class MainScreen {

	public JFrame frame;
	static J48Classifier classifier = new J48Classifier();
	static Regression regressor = new Regression();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainScreen() {
		initialize();
	}

	private void initialize() {
		int width = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.7);
		int height = (int) (java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.7);
		frame = new JFrame("Flight delay Prediciton System");
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

		JButton user1 = new JButton(new ImageIcon(MainScreen.class.getResource("/img/user1.png")));
		user1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				user1.setIcon(new ImageIcon(MainScreen.class.getResource("/img/user1p.png")));
				user1.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				user1.setIcon(new ImageIcon(MainScreen.class.getResource("/img/user1.png")));
				user1.setForeground(Color.WHITE);
			}
		});
		user1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AirTravellerScreen w = new AirTravellerScreen();
				w.frame.setVisible(true);
			}
		});
		user1.setForeground(Color.WHITE);
		user1.setText("Air Traveller");
		user1.setVerticalTextPosition(SwingConstants.BOTTOM);
		user1.setHorizontalTextPosition(SwingConstants.CENTER);
		user1.setFocusPainted(false);
		user1.setOpaque(false);
		user1.setContentAreaFilled(false);
		user1.setBorderPainted(false);
		user1.setFont(new Font("Arial", Font.BOLD, 30));
		sl.putConstraint(SpringLayout.WEST, user1, (int) (width * 0.23), SpringLayout.WEST, jp);
		sl.putConstraint(SpringLayout.SOUTH, user1, -(int) (width * 0.05), SpringLayout.SOUTH, jp);
		jp.add(user1);

		JButton user2 = new JButton(new ImageIcon(MainScreen.class.getResource("/img/user2.png")));
		user2.setText("ATC Staff");
		formatButton(user2);
		sl.putConstraint(SpringLayout.WEST, user2, (int) (width * 0.45), SpringLayout.WEST, jp);
		sl.putConstraint(SpringLayout.SOUTH, user2, 0, SpringLayout.SOUTH, user1);
		user2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				user2.setIcon(new ImageIcon(MainScreen.class.getResource("/img/user2p.png")));
				user2.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				user2.setIcon(new ImageIcon(MainScreen.class.getResource("/img/user2.png")));
				user2.setForeground(Color.WHITE);
			}
		});
		user2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AirTravellerScreen w = new AirTravellerScreen();
				w.frame.setVisible(true);
			}
		});
		jp.add(user2);

		JButton user3 = new JButton(new ImageIcon(MainScreen.class.getResource("/img/user3.png")));
		user3.setText("Data Analyst");
		formatButton(user3);
		sl.putConstraint(SpringLayout.WEST, user3, (int) (width * 0.63), SpringLayout.WEST, jp);
		sl.putConstraint(SpringLayout.SOUTH, user3, 0, SpringLayout.SOUTH, user1);
		user3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				user3.setIcon(new ImageIcon(MainScreen.class.getResource("/img/user3p.png")));
				user3.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				user3.setIcon(new ImageIcon(MainScreen.class.getResource("/img/user3.png")));
				user3.setForeground(Color.WHITE);
			}
		});
		user3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DataAnalystScreen w = new DataAnalystScreen();
				w.frame.setVisible(true);
			}
		});
		jp.add(user3);

		BackGround bg2 = new BackGround();
		sl.putConstraint(SpringLayout.NORTH, bg2, 0, SpringLayout.NORTH, jp);
		sl.putConstraint(SpringLayout.SOUTH, bg2, 0, SpringLayout.SOUTH, jp);
		sl.putConstraint(SpringLayout.EAST, bg2, 0, SpringLayout.EAST, jp);
		sl.putConstraint(SpringLayout.WEST, bg2, 0, SpringLayout.WEST, jp);
		jp.add(bg2);

		jp.setLayout(sl);
		frame.setContentPane(jp);

		classifier.build();
		// classifier.test();
		regressor.build();
		// regressor.test();
	}

	void formatButton(JButton user1) {
		user1.setForeground(Color.WHITE);
		user1.setVerticalTextPosition(SwingConstants.BOTTOM);
		user1.setHorizontalTextPosition(SwingConstants.CENTER);
		user1.setFocusPainted(false);
		user1.setOpaque(false);
		user1.setContentAreaFilled(false);
		user1.setBorderPainted(false);
		user1.setFont(new Font("Arial", Font.BOLD, 30));
	}
}
