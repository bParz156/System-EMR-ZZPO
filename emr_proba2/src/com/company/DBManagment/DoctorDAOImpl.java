package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.Speciality;
import com.company.entities.TestOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    private Connection connection;
    public DoctorDAOImpl(ManagerDB managerDB)
    {
        this.connection=managerDB.getConnection();
    }

    @Override
    public Doctor getById(int id)  {
        Doctor doctor=null;
        String query="Select * from Doctor where id= ?";
        PreparedStatement stmt= null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
               // List<Patient> patientList = new ArrayList<>();
                String specialityString=rs.getString("Speciality");
                Speciality speciality=Speciality.valueOf(specialityString);
              //  doctor=new Doctor(id, name, surname, patientList, speciality);
                doctor=new Doctor(id, name, surname, speciality);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctorList=new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            String query = "Select * from Doctor";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                int id= rs.getInt("Id");
                String name=rs.getString("Name");
                String surname=rs.getString("Surname");
              //  List<Patient> patientList = new ArrayList<>();
                String specialityString=rs.getString("Speciality");
                Speciality speciality=Speciality.valueOf(specialityString);
              //  Doctor doctor=new Doctor(id, name, surname, patientList , speciality);
                Doctor doctor=new Doctor(id, name, surname , speciality);
                doctorList.add(doctor);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return doctorList;
    }

    @Override
    public void add(Doctor doctor) {
        String query = "INSERT INTO Doctor (Name, Surname, Speciality) values (?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, doctor.getName());
            pstmt.setString(2, doctor.getSurname());
            pstmt.setInt(3,doctor.getSpeciality().getValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Doctor doctor) {
        String query = "UPDATE Doctor SET Name=?, Surname=?, Speciality=? where Id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, doctor.getName());
            pstmt.setString(2, doctor.getSurname());
            pstmt.setInt(3,doctor.getSpeciality().getValue());
            pstmt.setInt(4, doctor.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query="Delete from Doctor where Id= ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Poprawnie usunieto");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
