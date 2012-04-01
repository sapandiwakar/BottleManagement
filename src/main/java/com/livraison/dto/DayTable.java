package com.livraison.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "daytable")
public class DayTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	java.sql.Date date;

	@ElementCollection
	List<Quantity> quantities;

	public DayTable() {
		super();
		Date d = new Date();
		date = new java.sql.Date(d.getYear(), d.getMonth(), d.getDate());
		quantities = new ArrayList<Quantity>();
	}

	public DayTable(Date date) {
		super();
		Date d = date;
		this.date = new java.sql.Date(d.getYear(), d.getMonth(), d.getDate());
		quantities = new ArrayList<Quantity>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public List<Quantity> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<Quantity> quantities) {
		this.quantities = quantities;
	}

}
