package com.company.entities;

import java.sql.Date;
import java.util.List;

public class TestOrder {

	private int id;
	private Date orderDate;
	private Doctor doctor;
	private Patient patient;
	private List<TestResult> results;

}