package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.TestOrder;
import com.company.exceptions.PatientNotFoundException;

import javax.print.Doc;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class PatientDAOImpl implements PatientDAO {
    private Connection connection;
    private PatientDoctorDAOImpl patientDoctorDAO;

    public PatientDAOImpl(ManagerDB managerDB) {
        this.connection = managerDB.getConnection();
        patientDoctorDAO= new PatientDoctorDAOImpl(managerDB);
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
                String password=rs.getString("Passsword");
                patient = new Patient(PESEL, name, surname, phoneNumber, birthday, password);
                patient.setPatientDAO(this);
                List<Doctor> doctors=patientDoctorDAO.getPatientsDoctor(patient);
                List<TestOrder> tests=TestOrder.getPatientsTestOrders(patient);
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
                String password=rs.getString("Passsword");
                Patient patient=new Patient(PESEL, name, surname, phoneNumber, birthday, password);

                patient.setPatientDAO(this);
                List<Doctor> doctors=patientDoctorDAO.getPatientsDoctor(patient);
                List<TestOrder> tests=TestOrder.getPatientsTestOrders(patient);
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
        String query = "INSERT INTO patient (PESEL, Name, Surname, PhoneNumber, Birthday, Passsword) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, patient.getPESEL());
            pstmt.setString(2, patient.getName());
            pstmt.setString(3, patient.getSurname());
            pstmt.setString(4, patient.getPhoneNumber());
            pstmt.setDate(5, patient.getBirthday());
            pstmt.setString(6, patient.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Patient patient) {
        String query = "UPDATE patient SET Name = ?, Surname = ?, PhoneNumber = ?, Birthday = ?,Passsword=?  WHERE PESEL = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, patient.getName());
            pstmt.setString(2, patient.getSurname());
            pstmt.setString(3, patient.getPhoneNumber());
            pstmt.setDate(4, patient.getBirthday());
            pstmt.setString(5, patient.getPassword());
            pstmt.setString(6, patient.getPESEL());
            pstmt.executeUpdate();

            List<Doctor>DBdoctorsList=patientDoctorDAO.getPatientsDoctor(patient);
            List<Doctor>doctors=patient.getDoctors();

            for(Doctor doctor: doctors)
            {
                if (!DBdoctorsList.contains(doctor))
                {
                    patientDoctorDAO.add(patient, doctor);
                    DBdoctorsList.add(doctor);
                }
            }
            for(Doctor doctor: DBdoctorsList)
            {
                if (!doctors.contains(doctor))
                {
                    patientDoctorDAO.delete(patient.getPESEL(), doctor.getId());
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deleting a patient from DB requieres deleting all connections in PatientDoctor table as well
     * @param PESEL
     */
    @Override
    public void delete(String PESEL) {
        Patient patient= getByPESEL(PESEL);
        if (patient!=null)
        {
            List<Doctor> doctorList = patient.getDoctors();
            for(Doctor doctor: doctorList)
            {
                patientDoctorDAO.delete(PESEL, doctor.getId());
            }
        }


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

    @Override
    public List<TestOrder> getTestsOrders(Patient patient) {
        return TestOrder.getPatientsTestOrders(patient);
    }
}