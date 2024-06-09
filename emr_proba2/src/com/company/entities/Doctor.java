package com.company.entities;

import com.company.DBManagment.DoctorDAO;
import com.company.exceptions.NotAccessiblePatientException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doctor extends User {

	private int id;
	private String name;
	private String surname;
	private List<Patient> patients;
	private Speciality speciality;
	private static DoctorDAO doctorDAO;

	public static void setDoctorDAO(DoctorDAO doctorDAO) {
		Doctor.doctorDAO = doctorDAO;
	}


	public Doctor(int id, String name, String surname, Speciality speciality) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
	}

	public Doctor(int id, String name, String surname, Speciality speciality, DoctorDAO doctorDAO) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
		if (doctorDAO.getById(id)==null)
		{
			addToDB();
		}
	}

	public Doctor(int id, String name, String surname, Speciality speciality, DoctorDAO doctorDAO, String password) {
		this(id, name, surname, speciality, doctorDAO);
		setCredetianls(name+"."+surname, password);
	}



	public int getId() {
		return id;
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
		update();
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
	 * Order a test <-you can pick multiple testTypes
	 * @param patient
	 * @param testTypes
	 */
	public TestOrder orderTest(Patient patient, String [] testTypes) {
		long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		int n=testTypes.length;
		TestTyp[] types=new TestTyp[n];
		for(int i=0; i<n; i++)
		{
			types[i]=TestTyp.valueOf(testTypes[i]);
		}

		return TestOrder.createNewTestOrder(date, this, patient,types);
	}



	private void addToDB() {
		doctorDAO.add(this);
	}

	private void update()
	{
		doctorDAO.update(this);
	}

	public String toString()
	{
		return "Doctor \n"+
				"Id: "+this.id+"\n"+
				"Name: "+this.name+"\n"+
				"Surname: "+this.surname+"\n"+
				"Speciality: "+this.speciality.toString();

	}


	public static Doctor getDoctor(int id)
	{
		return doctorDAO.getById(id);
	}

	public void fillResult(int testResultId,Number number) throws NotAccessiblePatientException {
		TestResult result= TestResult.getById(this, testResultId);
		if (result==null)
			throw new NotAccessiblePatientException();
		else result.setValue(number);
	}


	public List<TestResult> resultsToFill()
	{
		List<TestOrder> orders = TestOrder.getDoctorsOrders(this);
		List<TestResult> resultList=new ArrayList<>();
		for (TestOrder order : orders)
		{
			List<TestResult> results=order.getResults();
			for(TestResult result: results)
			{
				if (result.getValue().intValue()<0)
					resultList.add(result);
			}

		}
		return  resultList;
	}


	public static List<Doctor> getAll()
	{
		return doctorDAO.getAll();
	}

	private void managePatient(Patient patient, boolean add)
	{
		if(add)
		{
			if(!patients.contains(patient))
			{
				patients.add(patient);
			}
		}
		else
		{
			if(patients.contains(patient))
			{
				patients.remove(patient);
			}
		}
	}

	public void addPatient(Patient patient)
	{
		managePatient(patient, true);
	}

	public void deletePatient(Patient patient)
	{
		managePatient(patient, false);
	}


}