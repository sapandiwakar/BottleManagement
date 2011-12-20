package com.livrasion.UI;

import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

public class UserInputPanel extends javax.swing.JPanel {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
					.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private javax.swing.JPanel jPanel1;

	private javax.swing.ButtonGroup bottleCapacityRadioGroup;
	private javax.swing.JRadioButton B12;
	private javax.swing.JRadioButton B15;
	private javax.swing.JRadioButton B28;
	private javax.swing.JRadioButton B32;
	private javax.swing.JRadioButton B38;
	private javax.swing.JRadioButton B6;

	private javax.swing.ButtonGroup ioButtonRadioGroup;
	private javax.swing.JRadioButton entryRadioButton;
	private javax.swing.JRadioButton exitRadioButton;
	private javax.swing.JRadioButton reservationRadioButton;

	private javax.swing.ButtonGroup bottleWeightRadioGroup;
	private javax.swing.JRadioButton fullRadioButton;
	private javax.swing.JRadioButton emptyRadioButton;

	private javax.swing.JComboBox labelComboBox;
	private javax.swing.JSpinner quantitySpinnerBox;

	private javax.swing.JButton addButton;

	private javax.swing.JButton printButton;

	MultiSpanCellTable table;
	QuantityPanel[][] qp;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */

	public UserInputPanel(MultiSpanCellTable table, QuantityPanel[][] qp) {
		super();
		this.table = table;
		this.qp = qp;
		initGUI();
	}

	private void initGUI() {

		try {

			jPanel1 = new javax.swing.JPanel();

			ioButtonRadioGroup = new javax.swing.ButtonGroup();
			entryRadioButton = new javax.swing.JRadioButton("entry", true);
			entryRadioButton.setActionCommand("0");
			exitRadioButton = new javax.swing.JRadioButton("exit", false);
			exitRadioButton.setActionCommand("1");
			reservationRadioButton = new javax.swing.JRadioButton(
					"reservation", false);
			reservationRadioButton.setActionCommand("2");

			bottleWeightRadioGroup = new javax.swing.ButtonGroup();
			fullRadioButton = new javax.swing.JRadioButton("full", true);
			fullRadioButton.setActionCommand("0");
			emptyRadioButton = new javax.swing.JRadioButton("empty", false);
			emptyRadioButton.setActionCommand("1");

			bottleCapacityRadioGroup = new javax.swing.ButtonGroup();
			B6 = new javax.swing.JRadioButton("B6", true);
			B6.setActionCommand("0");
			B12 = new javax.swing.JRadioButton("B12", false);
			B12.setActionCommand("1");
			B15 = new javax.swing.JRadioButton("B15", false);
			B15.setActionCommand("2");
			B28 = new javax.swing.JRadioButton("B28", false);
			B28.setActionCommand("3");
			B32 = new javax.swing.JRadioButton("B32", false);
			B32.setActionCommand("4");
			B38 = new javax.swing.JRadioButton("B38", false);
			B38.setActionCommand("5");

			labelComboBox = new javax.swing.JComboBox();
			quantitySpinnerBox = new javax.swing.JSpinner(
					new SpinnerNumberModel(0, 0, 99, 1));
			// labelTextField = new javax.swing.JTextField();
			// quantityTextField = new javax.swing.JTextField();
			addButton = new javax.swing.JButton();

			printButton = new javax.swing.JButton();

			ioButtonRadioGroup.add(entryRadioButton);
			entryRadioButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							entryRadioButtonActionPerformed(evt);
						}

						private void entryRadioButtonActionPerformed(
								ActionEvent evt) {
							// TODO Auto-generated method stub

						}
					});

			ioButtonRadioGroup.add(exitRadioButton);
			exitRadioButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							exitRadioButtonActionPerformed(evt);
						}

						private void exitRadioButtonActionPerformed(
								ActionEvent evt) {
							// TODO Auto-generated method stub

						}
					});

			ioButtonRadioGroup.add(reservationRadioButton);
			bottleWeightRadioGroup.add(fullRadioButton);
			bottleWeightRadioGroup.add(emptyRadioButton);
			bottleCapacityRadioGroup.add(B6);
			bottleCapacityRadioGroup.add(B12);
			bottleCapacityRadioGroup.add(B38);
			bottleCapacityRadioGroup.add(B32);
			bottleCapacityRadioGroup.add(B28);
			bottleCapacityRadioGroup.add(B15);

			addButton.setText("Add");
			addButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					addButtonActionPerformed(evt);
				}

				private void addButtonActionPerformed(ActionEvent evt) {
					String io = ioButtonRadioGroup.getSelection()
							.getActionCommand();
					String weight = bottleWeightRadioGroup.getSelection()
							.getActionCommand();
					String capacity = bottleCapacityRadioGroup.getSelection()
							.getActionCommand();

					String label = "";
					int quantity;

					// if (labelTextField.getText() == null ||
					// labelTextField.getText().isEmpty()) {
					// JOptionPane.showMessageDialog(null,
					// "You must enter the label", "Warning",
					// JOptionPane.WARNING_MESSAGE);
					// return;
					// }

					// if (quantityTextField.getText() == null
					// || quantityTextField.getText().isEmpty()) {
					// JOptionPane.showMessageDialog(null,
					// "You must specify the quantity", "Warning",
					// JOptionPane.WARNING_MESSAGE);
					// return;
					// }

					// label = labelTextField.getText();
					// quantity = quantityTextField.getText();

					label = (String) labelComboBox.getSelectedItem();
					quantity = (Integer) quantitySpinnerBox.getValue();

					int row = 2 * Integer.parseInt(io)
							+ Integer.parseInt(weight);
					int col = Integer.parseInt(capacity);

					if (label.equals("No Tag")) {
						label = "";
					}
					qp[row][col].addQuantity(quantity, label);

				}

				// public JRadioButton getSelection(ButtonGroup group) {
				// for (Enumeration e = group.getElements(); e
				// .hasMoreElements();) {
				// JRadioButton b = (JRadioButton) e.nextElement();
				// if (b.getModel() == group.getSelection()) {
				// return b;
				// }
				// }
				// return null;
				// }
			});

			printButton.setText("Print");
			printButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					printButtonActionPerformed(evt);
				}

				private void printButtonActionPerformed(ActionEvent evt) {
					// TODO Auto-generated method stub
					try {
						// MessageFormat headerFormat = new
						// MessageFormat("Page {0}");
						MessageFormat footerFormat = new MessageFormat(
								"- {0} -");
						table.print(JTable.PrintMode.FIT_WIDTH, null,
								footerFormat);
					} catch (PrinterException pe) {
						System.err.println("Error printing: " + pe.getMessage());
					}
				}
			});

			labelComboBox.setModel(new javax.swing.DefaultComboBoxModel(
					new String[] { "No Tag", "VZV", "LIV7", "SW", "PCI",
							"ORYX", "TOT", "MOB", "TEX", "PIV", "SIM", "ESS",
							"AUT" }));

			javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
					jPanel1);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1Layout
					.setHorizontalGroup(jPanel1Layout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									jPanel1Layout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													jPanel1Layout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addComponent(
																	exitRadioButton)
															.addComponent(
																	entryRadioButton)
															.addComponent(
																	reservationRadioButton))
											.addGap(34, 34, 34)
											.addGroup(
													jPanel1Layout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addComponent(
																	fullRadioButton)
															.addComponent(
																	emptyRadioButton))
											.addGap(47, 47, 47)
											.addGroup(
													jPanel1Layout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	jPanel1Layout
																			.createSequentialGroup()
																			.addComponent(
																					labelComboBox,
																					javax.swing.GroupLayout.PREFERRED_SIZE,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					javax.swing.GroupLayout.PREFERRED_SIZE)
																			.addGap(69,
																					69,
																					69)
																			.addComponent(
																					quantitySpinnerBox,
																					javax.swing.GroupLayout.PREFERRED_SIZE,
																					48,
																					javax.swing.GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	jPanel1Layout
																			.createSequentialGroup()
																			.addComponent(
																					B6)
																			.addGap(39,
																					39,
																					39)
																			.addGroup(
																					jPanel1Layout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.LEADING)
																							.addComponent(
																									printButton)
																							.addGroup(
																									jPanel1Layout
																											.createSequentialGroup()
																											.addComponent(
																													B12)
																											.addGap(31,
																													31,
																													31)
																											.addComponent(
																													B15)))))
											.addGap(27, 27, 27)
											.addGroup(
													jPanel1Layout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	jPanel1Layout
																			.createSequentialGroup()
																			.addGap(27,
																					27,
																					27)
																			.addComponent(
																					B28)
																			.addGap(26,
																					26,
																					26)
																			.addComponent(
																					B32)
																			.addGap(18,
																					18,
																					18)
																			.addComponent(
																					B38))
															.addGroup(
																	jPanel1Layout
																			.createSequentialGroup()
																			.addGap(40,
																					40,
																					40)
																			.addComponent(
																					addButton)))
											.addGap(46, 46, 46)));
			jPanel1Layout
					.setVerticalGroup(jPanel1Layout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									jPanel1Layout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													jPanel1Layout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	jPanel1Layout
																			.createSequentialGroup()
																			.addComponent(
																					entryRadioButton)
																			.addGap(32,
																					32,
																					32)
																			.addComponent(
																					exitRadioButton)
																			.addGap(28,
																					28,
																					28)
																			.addComponent(
																					reservationRadioButton))
															.addGroup(
																	jPanel1Layout
																			.createSequentialGroup()
																			.addGap(22,
																					22,
																					22)
																			.addGroup(
																					jPanel1Layout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									fullRadioButton)
																							.addComponent(
																									B12)
																							.addComponent(
																									B38)
																							.addComponent(
																									B32)
																							.addComponent(
																									B28)
																							.addComponent(
																									B6)
																							.addComponent(
																									B15))
																			.addGroup(
																					jPanel1Layout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.LEADING)
																							.addGroup(
																									jPanel1Layout
																											.createSequentialGroup()
																											.addGap(18,
																													18,
																													18)
																											.addComponent(
																													emptyRadioButton))
																							.addGroup(
																									jPanel1Layout
																											.createSequentialGroup()
																											.addGap(31,
																													31,
																													31)
																											.addGroup(
																													jPanel1Layout
																															.createParallelGroup(
																																	javax.swing.GroupLayout.Alignment.BASELINE)
																															.addComponent(
																																	addButton)
																															.addComponent(
																																	labelComboBox,
																																	javax.swing.GroupLayout.PREFERRED_SIZE,
																																	javax.swing.GroupLayout.DEFAULT_SIZE,
																																	javax.swing.GroupLayout.PREFERRED_SIZE)
																															.addComponent(
																																	quantitySpinnerBox,
																																	javax.swing.GroupLayout.PREFERRED_SIZE,
																																	javax.swing.GroupLayout.DEFAULT_SIZE,
																																	javax.swing.GroupLayout.PREFERRED_SIZE))))))
											.addGap(11, 11, 11)
											.addComponent(printButton)
											.addContainerGap(15,
													Short.MAX_VALUE)));
			this.add(jPanel1);

			setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleResize() {
		B12.setPreferredSize(new java.awt.Dimension(table.getColumnModel()
				.getColumn(0).getWidth(), 23));
		B38.setPreferredSize(new java.awt.Dimension(table.getColumnModel()
				.getColumn(0).getWidth(), 23));
		B32.setPreferredSize(new java.awt.Dimension(table.getColumnModel()
				.getColumn(0).getWidth(), 23));
		B28.setPreferredSize(new java.awt.Dimension(table.getColumnModel()
				.getColumn(0).getWidth(), 23));
		B15.setPreferredSize(new java.awt.Dimension(table.getColumnModel()
				.getColumn(0).getWidth(), 23));
		B6.setPreferredSize(new java.awt.Dimension(table.getColumnModel()
				.getColumn(0).getWidth(), 23));
	}

}
