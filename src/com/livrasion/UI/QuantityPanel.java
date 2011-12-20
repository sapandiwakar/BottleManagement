/**
 * 
 */
package com.livrasion.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * @author hp
 * 
 */
public class QuantityPanel extends JPanel {

	private final int nSides = 5;

	public static final int ENTRY = 0;
	public static final int EXIT = 1;
	public static final int OTHER = 2;
	public static final int nSquaresPerRow = 3;

	MultiSpanCellTable table;
	int row;
	int col;

	int quantity;

	int type;
	List<String> tags;

	private int sideLength = 30;
	private int gap = 20;
	private int yInitial = 10;
	private int xInitial = 10;

	public int rowHeight = yInitial + sideLength + gap;
	private int colWidth;

	private Font font = new Font("Sansserif", Font.PLAIN, 10);

	private AffineTransform at;

	public QuantityPanel(int row, int col, MultiSpanCellTable table) {
		this.row = row;
		this.col = col;
		this.table = table;
		this.tags = new ArrayList<String>();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (type == EXIT) {
			g.setColor(new Color(255, 0, 0));
		} else if (type == ENTRY) {
			g.setColor(new Color(0, 255, 0));
		} else {
			g.setColor(new Color(0, 0, 255));
		}

		int nSquares = quantity / nSides;
		int lineType = 0;
		int currSquare = 0;
		int x = xInitial;
		int y = yInitial;
		//
		// int gap = (Math.min(table.getCellRect(row, col, false).height,
		// table.getCellRect(row, col, false).width)) / 10;
		//
		// int rowSideLength = table.getCellRect(row, col, false).height - gap
		// * nSquares / nSquaresPerRow - yInitial;
		//
		// int colSideLength = table.getCellRect(row, col, false).width - gap
		// * ((nSquares>2)?3:nSquares) - xInitial;
		//
		// int sideLength = Math.min(rowSideLength,colSideLength)/(nSquares+1);

		for (int i = 0; i < quantity; ++i) {
			switch (lineType) {
			case 0:
				g.drawLine(x, y, x, y + sideLength);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setFont(font);
				at = g2.getTransform();
				render(3, x - 1, y + sideLength - 3, tags.get(i), at, g2);
				break;
			case 1:
				g.drawLine(x, y, x + sideLength, y);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setFont(font);
				g2.drawString(tags.get(i), x + 5, y - 1);
				x += sideLength;
				break;
			case 2:
				g.drawLine(x, y, x, y + sideLength);
				y += sideLength;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setFont(font);
				at = g2.getTransform();
				render(1, x + 2, y - sideLength + 4, tags.get(i), at, g2);
				break;
			case 3:
				g.drawLine(x, y, x - sideLength, y);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				Font font3 = new Font("Sansserif", Font.PLAIN, 10);
				g2.setFont(font3);
				g2.drawString(tags.get(i), x - 22, y + 9);
				x -= sideLength;
				break;
			case 4:
				g.drawLine(x, y, x + sideLength, y - sideLength);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				Font font = new Font("Sansserif", Font.PLAIN, 10);
				g2.setFont(font);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setFont(font);
				at = g2.getTransform();
				render(3.5, x + 10, y - 10, tags.get(i), at, g2);
				currSquare++;
				x = xInitial + currSquare * (sideLength + gap);
				y = yInitial;

				if (currSquare % 3 == 0) {
					x = xInitial;
					y = yInitial + (sideLength + gap) * currSquare
							/ nSquaresPerRow;
					rowHeight += sideLength + gap;
					setPreferredSize(new Dimension(colWidth, rowHeight));
					// table.setRowHeight(1, 250);
					refresh();
				}
				break;
			}

			lineType++;
			lineType %= nSides;
		}
	}

	private void render(double n, int x, int y, String tag, AffineTransform at,
			Graphics2D g2) {
		Graphics2D g2d = g2;
		g2d.setTransform(at);
		g2d.rotate(n * Math.PI / 2, x, y);
		g2d.drawString(tag, x, y);
		g2d.setTransform(at);
	}

	void refresh() {
		table.clearSelection();
		table.revalidate();
		table.repaint();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity, String tag) {
		for (int i = this.quantity; i < quantity; ++i) {
			tags.add(tag);
		}
		this.quantity = quantity;
		refresh();
	}
	
	public void addQuantity(int quantity, String tag) {
		for (int i = 0; i < quantity; ++i) {
			tags.add(tag);
		}
		this.quantity += quantity;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	public MultiSpanCellTable getTable() {
		return table;
	}

	public void setTable(MultiSpanCellTable table) {
		this.table = table;
	}
}
