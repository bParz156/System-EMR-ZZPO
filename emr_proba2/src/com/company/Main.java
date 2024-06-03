package com.company;


import com.company.DBManagment.*;
import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.Speciality;
import com.company.exceptions.PatientNotFoundException;

import java.sql.Date;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args)  {
        try {
            ManagerDB managerDB=new ManagerDB();
            DoctorDAO doctorDAO = new DoctorDAOImpl(managerDB);
            int id=3;
            String Name="Aneczka";
            String Surname="Nowakowska";
            Speciality speciality=Speciality.Neurolog;

            Doctor doc= new Doctor(doctorDAO,id,Name, Surname,null, speciality);
            System.out.println(doc);
            doc.setSpeciality(Speciality.Kardiolog);
            System.out.println(doc);
        }
        catch (SQLException e)
        {
            System.out.println("Connection with database could not be made");
        }

    }
}
