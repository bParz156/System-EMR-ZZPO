package com.company.entities;

import com.company.DBManagment.TestOrderDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TestOrder {

	private int id;
	private Date orderDate;
	private Doctor doctor;
	private Patient patient;
	private List<TestResult> results;
	private static TestOrderDAO testOrderDAO;


	public static void setTestOrderDAO(TestOrderDAO testOrderDAO) {
		TestOrder.testOrderDAO = testOrderDAO;
	}

	public TestOrder(int id, Date orderDate, Doctor doctor, Patient patient) {
		this.id = id;
		this.orderDate = orderDate;
		this.doctor = doctor;
		this.patient = patient;
	}

	public TestOrder(TestOrderDAO testOrderDAO ,int id, Date orderDate, Doctor doctor, Patient patient) {
		this(id, orderDate, doctor, patient);
		this.testOrderDAO=testOrderDAO;
		if (testOrderDAO.getById(id)==null)
		{
			addToDB();
		}
	}


	public int getId() {
		return id;
	}

	public void setId(int id)
	{
		this.id=id;
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

	private void addToDB() {
		testOrderDAO.add(this);
	}

	private static int addToDB(TestOrder order)
	{
		return testOrderDAO.add(order);
	}

	public String toString()
	{
		return "TestOrder: "+id+"\n"+
				"Patient: "+patient.toString()+"\n"+
				"Doctor: "+doctor+"\n"+
				"OrderDate: "+orderDate;
	}

	public static List<TestOrder> getPatientsTestOrders(Patient patient)
	{
		List<TestOrder> orders=testOrderDAO.getByPatient(patient);
		return orders;
	}

	public static TestOrder createNewTestOrder(Date date, Doctor doctor,Patient patient, TestTyp[] types)
	{
		TestOrder order=new TestOrder(-1, date, doctor, patient);
		int id=addToDB(order);
		order.setId(id);
		TestAbstractFactory testAbstractFactory= new TestAbstractFactory();
		List<TestResult> testResults=new ArrayList<>();
		for(TestTyp type : types)
		{
			TestResult result= testAbstractFactory.createTestResult(id, type);
			testResults.add(result);
		}
		order.setResults(testResults);

		return order;
	}


}