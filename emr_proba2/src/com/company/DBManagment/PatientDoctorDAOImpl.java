package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.Speciality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDoctorDAOImpl implements PatientDoctorDAO {

    private Connection connection;

    public PatientDoctorDAOImpl(ManagerDB managerDB) {
        this.connection = managerDB.getConnection();
    }

    @Override
    public List<Patient> getDoctorsPatients(Doctor doctor) {
        List<Patient> doctorsPatientList=new ArrayList<>();
        String query= "SELECT p.* FROM patients p JOIN patient_doctor pd ON p.PESEL = pd.PatientPESEL WHERE pd.DoctorId = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, doctor.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String PESEL=rs.getString("PatientPESEL");
                doctorsPatientList.add(new Patient(
                        rs.getString("PESEL"),
                        rs.getString("Name"),
                        rs.getString("Surname"),
                        rs.getString("PhoneNumber"),
                        rs.getDate("Birthday")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorsPatientList;
    }

    @Override
    public List<Doctor> getPatientsDoctor(Patient patient) {
        List<Doctor> patientDoctorsList=new ArrayList<>();
        String query= "SELECT d.* FROM Doctor p JOIN patient_doctor pd ON d.Id = pd.DoctorId WHERE pd.PatientPESEL = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, patient.getPESEL());
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("DoctorId");
                patientDoctorsList.add(new Doctor(
                        id,
                        rs.getString("Name"),
                        rs.getString("Surname"),
                        Speciality.fromValue(rs.getInt("Speciality"))
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return patientDoctorsList;
    }

    @Override
    public void delete(String PESEL, int id) {
        String query = "DELETE FROM patient_doctor where PatientPESEL=? AND DoctorId=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, PESEL);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void add(String PESEL, int id) {
        String query = "INSERT INTO patient_doctor (PatientPESEL, DoctorId) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, PESEL);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        }

    }
}
