package com.livrasion.UI;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Test extends JPanel {
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Font font = new Font("Serif", Font.PLAIN, 96);
		g2.setFont(font);

		g2.drawString("Java Source and Support", 40, 120);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 6; ++i) {
			for (int j = 0; j < 6; ++j) {
				// System.out.println("tableRowColumnMapping[" + i + "][" + j + "] = dt.getT" + i + j + "();");
				System.out.println("setQuantity(dt.getT" + i + j + "(), " + i + ", " + j + ", qp)");
			}
		}
		// JFrame f = new JFrame();
		// f.getContentPane().add(new Test());
		// f.setSize(300, 200);
		// f.setVisible(true);
	}
}
