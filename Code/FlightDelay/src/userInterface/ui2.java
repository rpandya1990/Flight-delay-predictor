package userInterface;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ui2 {

	private JFrame frmFlightDelayPredictor;

	/**
	 * Launch the application.
	 */
	public static void dialog() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui2 window = new ui2();
					window.frmFlightDelayPredictor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ui2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFlightDelayPredictor = new JFrame();
		frmFlightDelayPredictor.setTitle("Flight Delay Predictor");
		frmFlightDelayPredictor.setBounds(100, 100, 450, 300);
		frmFlightDelayPredictor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setFont(new Font("Arial", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frmFlightDelayPredictor.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblHello, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addComponent(lblHello, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		frmFlightDelayPredictor.getContentPane().setLayout(groupLayout);
	}

}
