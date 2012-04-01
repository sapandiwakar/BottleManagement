package com.livraison.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quantity")
public class Quantity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	int numberOfBottles;
	String label;

	int row;
	int col;

	public Quantity() {
		super();
	}

	public Quantity(int numberOfBottles, String label, int row, int col) {
		super();
		this.numberOfBottles = numberOfBottles;
		this.label = label;
		this.row = row;
		this.col = col;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberOfBottles() {
		return numberOfBottles;
	}

	public void setNumberOfBottles(int numberOfBottles) {
		this.numberOfBottles = numberOfBottles;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
