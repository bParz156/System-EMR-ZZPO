package com.company.entities;

import java.sql.Date;
import java.util.List;

public class TestOrder {

	private int id;
	private Date orderDate;
	private Doctor doctor;
	private Patient patient;
	private List<TestResult> results;


	public TestOrder(int id, Date orderDate, Doctor doctor, Patient patient) {
		this.id = id;
		this.orderDate = orderDate;
		this.doctor = doctor;
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<TestResult> getResults() {
		return results;
	}

	public void setResults(List<TestResult> results) {
		this.results = results;
	}
}