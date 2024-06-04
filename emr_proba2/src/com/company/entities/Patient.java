package com.company.entities;

import com.company.DBManagment.PatientDAO;
import com.company.exceptions.PatientNotFoundException;

import javax.print.Doc;
import java.sql.Date;
import java.util.ArrayList;
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

	public void setPatientDAO(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

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
		update();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
		update();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		update();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
		update();
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
	public Patient(String PESEL, String name, String surname, String phoneNumber, Date birthday, PatientDAO patientDAO) {
		this(PESEL, name, surname, phoneNumber,birthday);
		this.patientDAO = patientDAO;
		try{
			if (patientDAO.getByPESEL(PESEL)==null)
			{
				addToDB();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	public Patient(String PESEL, String name, String surname, String phoneNumber, Date birthday) {
		this.PESEL=PESEL;
		this.name=name;
		this.surname=surname;
		this.phoneNumber=phoneNumber;
		this.birthday=birthday;

	}


	/**
	 * NIEZAIMPLEMENTPOWANA
	 * @return
	 */
	public List<TestResult> getResults()
	{
		List<TestResult> results=new ArrayList<>();
		return results;
	}

	public String toString()
	{
		return "Patient: \n"+
				"PESEL: "+this.PESEL+"\n"+
				"Name: "+this.name+"\n"+
				"Surname: "+this.surname+"\n"+
				"phoneNumber: "+this.phoneNumber+"\n"+
				"birthday: "+this.birthday;
	}

	private void update() {
		patientDAO.update(this);
	}

	private void addToDB() {
		patientDAO.add(this);
	}


	public void signToDoctor(Doctor doctor)
	{
		if(!doctors.contains(doctor))
		{
			doctors.add(doctor);
			update();
		}
	}

	public void signOutOfDoctor(Doctor doctor)
	{
		if(doctors.contains(doctor))
		{
			doctors.remove(doctor);
			update();
		}
	}


}