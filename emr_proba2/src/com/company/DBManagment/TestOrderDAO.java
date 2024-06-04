package com.company.DBManagment;

import com.company.entities.Doctor;
import com.company.entities.Patient;
import com.company.entities.TestOrder;

import java.util.List;

public interface TestOrderDAO {

    TestOrder getById(int id);
    List<TestOrder> getByPatient(Patient patient);
    List<TestOrder> getByDoctor(Doctor doctor);
    List<TestOrder> getByDoctorAndPatient(Doctor doctor, Patient patient);
    int add(TestOrder testOrder);
    void update(TestOrder testOrder);
    void delete(int id);
}
