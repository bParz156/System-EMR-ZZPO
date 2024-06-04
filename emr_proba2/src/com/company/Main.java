package com.company;


import com.company.DBManagment.*;
import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.Speciality;
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

            List<Doctor> doctorList=doctorDAO.getAll();
            List<Patient> patientList=patientDAO.getAll();

            Patient patient=patientList.get(0);
            Doctor doctor=doctorList.get(0);
            patient.signOutOfDoctor(doctor);

        }
        catch (SQLException e)
        {
            System.out.println("Connection with database could not be made");
        }

    }
}
