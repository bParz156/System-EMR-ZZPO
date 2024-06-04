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

public class PatientDoctorDAOImpl extends PatientDoctorRelationDAO {


    public PatientDoctorDAOImpl(ManagerDB managerDB) {
        super(managerDB);
    }

    public List<Doctor> getPatientsDoctor(Patient patient) {
        List<Doctor> patientDoctorsList=new ArrayList<>();
        String query= "SELECT d.* FROM doctor d JOIN patient_doctor pd ON d.Id = pd.DoctorId WHERE pd.PatientPESEL = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, patient.getPESEL());
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("Id");
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


}
