package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.TestOrder;
import com.company.exceptions.PatientNotFoundException;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class PatientDAOImpl implements PatientDAO {
    private Connection connection;

    public PatientDAOImpl(ManagerDB managerDB) {
        this.connection = managerDB.getConnection();
    }

    @Override
    public Patient getByPESEL(String PESEL) {

        Patient patient=null;
        String query="Select * from Patient where PESEL= ?";
        try {
            PreparedStatement stmt=connection.prepareStatement(query);
            stmt.setString(1, PESEL);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String phoneNumber = rs.getString("PhoneNumber");
                Date birthday = rs.getDate("Birthday");
                List<Doctor> doctors=new ArrayList<>();;
                List<TestOrder> tests=new ArrayList<>();;
                patient = new Patient(PESEL, name, surname, phoneNumber, birthday);
                patient.setTests(tests);
                patient.setDoctors(doctors);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public List<Patient> getAll() {
        // Implementacja metody getAll
        List<Patient> patientList=new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            String query = "Select * from Patient";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                String PESEL=rs.getString("PESEL");
                String name=rs.getString("Name");
                String surname=rs.getString("Surname");
                String phoneNumber=rs.getString("PhoneNumber");
                Date birthday=rs.getDate("Birthday");
                List<Doctor> doctors=new ArrayList<>();;
                List<TestOrder> tests=new ArrayList<>();;
                Patient patient=new Patient(PESEL, name, surname, phoneNumber, birthday);
                patient.setTests(tests);
                patient.setDoctors(doctors);
                patientList.add(patient);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return patientList;

    }

    @Override
    public void add(Patient patient) {
        String query = "INSERT INTO patient (PESEL, Name, Surname, PhoneNumber, Birthday) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, patient.getPESEL());
            pstmt.setString(2, patient.getName());
            pstmt.setString(3, patient.getSurname());
            pstmt.setString(4, patient.getPhoneNumber());
            pstmt.setDate(5, patient.getBirthday());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Patient patient) {
        String query = "UPDATE patient SET Name = ?, Surname = ?, PhoneNumber = ?, Birthday = ? WHERE PESEL = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, patient.getName());
            pstmt.setString(2, patient.getSurname());
            pstmt.setString(3, patient.getPhoneNumber());
            pstmt.setDate(4, patient.getBirthday());
            pstmt.setString(5, patient.getPESEL());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String PESEL) {

        String query="Delete from Patient where PESEL= ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, PESEL);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Poprawnie usunieto");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
}