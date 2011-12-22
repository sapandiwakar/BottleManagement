package com.livrasion.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class QuantityPanelCellRenderer implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (row > 0 && row < 7 && column > 1) {
			QuantityPanel q = (QuantityPanel) value;
			return q;
		} else {
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(JLabel.CENTER);
			Component returnComponent = rightRenderer
					.getTableCellRendererComponent(table, value, isSelected,
							hasFocus, row, column);
			if (row == 0) {
				returnComponent.setBackground(new Color(200, 200, 200));
			}
			return returnComponent;
		}
	}
}
