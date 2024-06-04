package com.company;


import com.company.DBManagment.*;
import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.Speciality;
import com.company.entities.TestOrder;
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
            Doctor.setDoctorDAO(doctorDAO);
            TestOrder.setTestOrderDAO(testOrderDAO);
            Patient.setPatientDAO(patientDAO);

          //  Patient patient= new Patient("18987654321","Maciek", "Adamowicz", "123456789", Date.valueOf("2004-09-03"),"Kotem", patientDAO);
          //  Doctor doctor= new Doctor(1, "Kasia", "Zapala", Speciality.Kardiolog, doctorDAO);

            List<Doctor> doctorList=doctorDAO.getAll();
            List<Patient> patientList=patientDAO.getAll();

            Patient patient=patientList.get(0);
            Doctor doctor=doctorList.get(0);
            patient.signToDoctor(doctor);

            String [] types=new String[]{"Hemoglobina", "CisnienieSkurczowe"};
            TestOrder ord= doctor.orderTest(patient, types);
            System.out.println(ord);

        }
        catch (SQLException e)
        {
            System.out.println("Connection with database could not be made");
        }

    }
}
