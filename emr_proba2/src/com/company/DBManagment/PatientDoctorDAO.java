package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;

import java.util.List;

public interface PatientDoctorDAO {

    /**
     * @return  PESEL of all patients who are cured by doctor
     * @param doctor Doxtor whose patients we look for
     */
    List<Patient> getDoctorsPatients(Doctor doctor);

    /**
     * @return id of all doctors who cure Patient patient
     * @param patient - whose doctor to look for
     */
    List<Doctor> getPatientsDoctor(Patient patient);

    /**
     * Delete connection between doctor and patient
     * @param PESEL - identifier of Patient
     * @param id - identifier of doctor
     */
    void delete(String PESEL, int id);

    /**
     * Creates link between doctor and his patient
     * @param PESEL - patient's PESEL
     * @param id - doctor's identifier
     */
    void add(String PESEL, int id);


}
