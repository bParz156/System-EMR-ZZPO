package com.company;


import com.company.DBManagment.*;
import com.company.entities.*;
import com.company.exceptions.PatientNotFoundException;

import javax.print.Doc;
import java.sql.Date;
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

            List<Doctor> doctorList=doctorDAO.getAll();
            List<Patient> patientList=patientDAO.getAll();

            Patient patient=patientList.get(1);
            Doctor doctor=doctorList.get(0);
            patient.signToDoctor(doctor);
            String [] types=new String[]{"CisnienieRozkurczowe", "CisnienieSkurczowe"};
            TestOrder ord= doctor.orderTest(patient, types);

            List<TestResult>results = ord.getResults();
            for (TestResult res : results)
                System.out.println(res);

        }
        catch (SQLException e)
        {
            System.out.println("Connection with database could not be made");
        }

    }
}
