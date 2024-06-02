package com.company;

import java.util.List;
import java.util.Objects;

public class Doctor {

	private int id;
	private String name;
	private String surname;
	private List<Patient> patients;
	private Speciality speciality;

	public Doctor(int id, String name, String surname, List<Patient> patients, Speciality speciality) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.patients = patients;
		this.speciality = speciality;
	}

	public int getId() {
		return id;
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Doctor doctor = (Doctor) o;
		return id == doctor.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * 
	 * @param patient
	 * @param testType
	 */
	public TestOrder orderTest(Patient patient, String testType) {
		// TODO - implement Doctor.orderTest
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param patient
	 * @param testTypes
	 */
	public List<TestOrder> orderMultipleTest(Patient patient, List<String> testTypes) {
		// TODO - implement Doctor.orderMultipleTest
//		List<TestOrder> orders = new List<TestOrder>();
//		for (String type : testTypes)
//		{
//			orders.add(orderTest(patient, type));
//		}
//		return orders;
		return null;
	}

}