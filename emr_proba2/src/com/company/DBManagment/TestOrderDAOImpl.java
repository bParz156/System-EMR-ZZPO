package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.TestOrder;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class TestOrderDAOImpl implements  TestOrderDAO{

    private Connection connection;

    public TestOrderDAOImpl(ManagerDB managerDB)
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
                int doctorId= rs.getInt("Doctor");
                String PESEL = rs.getString("Patient");
                testOrder=new TestOrder(id, date,Doctor.getDoctor(doctorId),Patient.getPatient(PESEL));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testOrder;
    }

    @Override
    public List<TestOrder> getByPatient(Patient patient) {
        List<TestOrder> testOrders=new ArrayList<>();
        String PESEL=patient.getPESEL();
        String query="Select * from TestOrder where Patient= ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, PESEL);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                int id=rs.getInt("Id");
                Date orderDate=rs.getDate("OrderDate");
                int doctorId=rs.getInt("Doctor");
                testOrders.add(new TestOrder(id, orderDate,Doctor.getDoctor(doctorId), patient ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testOrders;
    }

    @Override
    public List<TestOrder> getByDoctor(Doctor doctor) {
        List<TestOrder> testOrders=new ArrayList<>();
        String query="Select * from TestOrder where Doctor= ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, doctor.getId());
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                int id=rs.getInt("Id");
                Date orderDate=rs.getDate("OrderDate");
                String PESEL=rs.getString("Patient");
                testOrders.add(new TestOrder(id, orderDate,doctor, Patient.getPatient(PESEL) ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testOrders;
    }

    @Override
    public List<TestOrder> getByDoctorAndPatient(Doctor doctor, Patient patient) {
        List<TestOrder> testOrders=new ArrayList<>();
        String query="Select * from TestOrder where Doctor= ? and Patient=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, doctor.getId());
            stmt.setString(2, patient.getPESEL());
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                int id=rs.getInt("Id");
                Date orderDate=rs.getDate("OrderDate");
                testOrders.add(new TestOrder(id, orderDate,doctor, patient ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testOrders;
    }

    @Override
    public int add(TestOrder testOrder) {
        String query = "INSERT INTO TestOrder (orderDate, Doctor, Patient) values (?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, testOrder.getOrderDate());
            pstmt.setInt(2, testOrder.getDoctor().getId());
            pstmt.setString(3,testOrder.getPatient().getPESEL());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            return  rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public void update(TestOrder testOrder) {
        String query = "Update TestOrder SET orderDate=?, Doctor=?, Patient=? values (?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, testOrder.getOrderDate());
            pstmt.setInt(2, testOrder.getDoctor().getId());
            pstmt.setString(3,testOrder.getPatient().getPESEL());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //DODAJ USUWANIE WYNIKOW
    @Override
    public void delete(int id) {
        String query="Delete from TestOrder where Id= ?";
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