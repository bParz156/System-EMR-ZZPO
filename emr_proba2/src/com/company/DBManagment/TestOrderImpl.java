package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.TestOrder;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class TestOrderImpl implements  TestOrderDAO{

    private Connection connection;

    public TestOrderImpl(ManagerDB managerDB)
    {
        this.connection=managerDB.getConnection();
    }

    @Override
    public TestOrder getById(int id) {
        TestOrder testOrder=null;
        String query="Select * from TestOrder where id= ?";
        try {
            PreparedStatement stmt=connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                Date date=rs.getDate("OrderDate");
                int doctor= rs.getInt("Doctor");
                String PESEL = rs.getString("Patient");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testOrder;
    }

    @Override
    public List<TestOrder> getByPatient(Patient patient) {
        return null;
    }

    @Override
    public List<TestOrder> getByDoctor(Doctor doctor) {
        return null;
    }

    @Override
    public List<TestOrder> getByDoctorAndPatient(Doctor doctor, Patient patient) {
        return null;
    }

    @Override
    public void add(TestOrder testOrder) {

    }

    @Override
    public void update(TestOrder testOrder) {

    }

    @Override
    public void delete(int id) {

    }
}
