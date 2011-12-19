/**
 * 
 */
package com.livrasion.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

	public QuantityPanel(int row, int col, MultiSpanCellTable table) {
		this.row = row;
		this.col = col;
		this.table = table;
	}

	@Override
	public void paint(Graphics g) {
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
//		int gap = (Math.min(table.getCellRect(row, col, false).height,
//				table.getCellRect(row, col, false).width)) / 10;
//		
//		int rowSideLength = table.getCellRect(row, col, false).height - gap
//				* nSquares / nSquaresPerRow - yInitial;
//		
//		int colSideLength = table.getCellRect(row, col, false).width - gap
//				* ((nSquares>2)?3:nSquares) - xInitial;
//		
//		int sideLength = Math.min(rowSideLength,colSideLength)/(nSquares+1);
		

		for (int i = 0; i < quantity; ++i) {
			switch (lineType) {
			case 0:
				g.drawLine(x, y, x, y + sideLength);
				break;
			case 1:
				g.drawLine(x, y, x + sideLength, y);
				x += sideLength;
				break;
			case 2:
				g.drawLine(x, y, x, y + sideLength);
				y += sideLength;
				break;
			case 3:
				g.drawLine(x, y, x - sideLength, y);
				x -= sideLength;
				break;
			case 4:
				g.drawLine(x, y, x + sideLength, y - sideLength);
				currSquare++;
				x = xInitial + currSquare * (sideLength + gap);
				y = yInitial;

				if (currSquare % 3 == 0) {
					x = xInitial;
					y = yInitial + (sideLength + gap) * currSquare/nSquaresPerRow;
					rowHeight += sideLength + gap;
					setPreferredSize(new Dimension(colWidth, rowHeight));
//					table.setRowHeight(1, 250);
					refresh();
				}
				break;
			}

			lineType++;
			lineType %= nSides;
		}
	}

	void refresh() {
		table.clearSelection();
		table.revalidate();
		table.repaint();
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		refresh();
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
