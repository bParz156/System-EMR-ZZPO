package com.company;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Patient {

	private String PESEL;
	private String name;
	private String surname;
	private String phoneNumber;
	private Date birthday;
	private List<Doctor> doctors;
	private List<TestOrder> tests;

	private PatientDAO patientDAO;

	public Patient(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Patient patient = (Patient) o;
		return Objects.equals(PESEL, patient.PESEL);
	}

	@Override
	public int hashCode() {
		return Objects.hash(PESEL);
	}

	public String getPESEL() {
		return this.PESEL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<TestOrder> getTests() {
		return tests;
	}

	public void setTests(List<TestOrder> tests) {
		this.tests = tests;
	}

	public List<TestOrder> getTestOrders() {
		// TODO - implement Patient.getTestOrders
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param PESEL
	 * @param name
	 * @param surname
	 * @param phoneNumber
	 * @param birthday
	 */
	public Patient(String PESEL, String name, String surname, String phoneNumber, Date birthday, List<TestOrder> tests, List<Doctor> doctors) {
		this.PESEL=PESEL;
		this.name=name;
		this.surname=surname;
		this.phoneNumber=phoneNumber;
		this.birthday=birthday;
		this.doctors=doctors;
		this.tests=tests;
	}

//	public List<TestResult> getResults()
//	{
//		List<TestResult> results=new List<TestResult>();
//	}


}