package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class PatientDoctorRelationDAO {

    Connection connection;
    public PatientDoctorRelationDAO(ManagerDB managerDB) {
        this.connection = managerDB.getConnection();
    }

    /**
     * Delete connection between doctor and patient
     *
     * @param PESEL - identifier of Patient
     * @param id    - identifier of doctor
     */
    void delete(String PESEL, int id) {
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

    /**
     * Creates link between doctor and his patient
     *
     * @param patient
     * @param doctor
     */
    void add(Patient patient, Doctor doctor) {
        String query = "INSERT INTO patient_doctor (PatientPESEL, DoctorId) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, patient.getPESEL());
            stmt.setInt(2, doctor.getId());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}
