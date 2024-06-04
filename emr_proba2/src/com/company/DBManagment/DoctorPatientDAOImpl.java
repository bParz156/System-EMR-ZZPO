package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorPatientDAOImpl extends PatientDoctorRelationDAO {

    public DoctorPatientDAOImpl(ManagerDB managerDB) {
        super(managerDB);
    }

    /**
     * @return  Patients of all patients who are cured by doctor
     * @param doctor Doxtor whose patients we look for
     */
    List<Patient> getDoctorsPatients(Doctor doctor)
    {
        List<Patient> doctorsPatientList=new ArrayList<>();
        String query= "SELECT p.* FROM patient p JOIN patient_doctor pd ON p.PESEL = pd.PatientPESEL WHERE pd.DoctorId = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, doctor.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String PESEL=rs.getString("PESEL");
                doctorsPatientList.add(new Patient(
                        PESEL,
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



}
