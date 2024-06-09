package com.company;


import com.company.DBManagment.*;
import com.company.entities.*;
import com.company.exceptions.NotAccessiblePatientException;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args)  {
        try {
            ManagerDB managerDB=new ManagerDB();
            DoctorDAO doctorDAO = new DoctorDAOImpl(managerDB);
            PatientDAO patientDAO =new PatientDAOImpl(managerDB);
            TestOrderDAO testOrderDAO=new TestOrderDAOImpl(managerDB);
            TestResultDAO testResultDAO= new TestResultDAOImpl(managerDB);

            Doctor.setDoctorDAO(doctorDAO);
            TestOrder.setTestOrderDAO(testOrderDAO);
            Patient.setPatientDAO(patientDAO);
            TestResult.setTestResultDAO(testResultDAO);



          //  Patient patient= new Patient("18987654321","Maciek", "Adamowicz", "123456789", Date.valueOf("2004-09-03"),"Kotem", patientDAO);
          //  Doctor doctor= new Doctor(1, "Kasia", "Zapala", Speciality.Kardiolog, doctorDAO);

            List<Doctor> doctorList=Doctor.getAll();
            List<Patient> patientList=patientDAO.getAll();

//            for(Doctor doctor: doctorList)
//            {
//                System.out.println(doctor.getPatients());
//            }


            Patient patient=patientList.get(1);
            Doctor doctor=doctorList.get(1);
//            System.out.println("Przed");
//            System.out.println(doctor.getPatients());
//            patient.signToDoctor(doctor);
//            System.out.println("Po");
//            System.out.println(doctor.getPatients());
//            System.out.println("Pacjent");
//            System.out.println(patient.getDoctors());




//            List<TestResult> res= patient.getResults();
//            for (TestResult testResult : res) {
//                            System.out.println(testResult.getResult());
//            }
//
//            System.out.println("\n");
//
//            res= doctor.resultsToFill();
//            for (TestResult testResult : res) {
//                System.out.println(testResult.getResult());
//            }

        }
        catch (SQLException e)
        {
            System.out.println("Connection with database could not be made");
        }

    }
}
