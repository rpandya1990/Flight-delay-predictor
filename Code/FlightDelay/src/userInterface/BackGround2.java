package userInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BackGround2 extends JPanel {
	private Image img;

	public BackGround2() {

		try {
			img = (new ImageIcon(BackGround2.class.getResource("/img/ipbg2.png")).getImage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
