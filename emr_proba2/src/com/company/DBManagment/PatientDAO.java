package com.company.DBManagment;

import com.company.entities.Patient;
import com.company.entities.TestOrder;
import com.company.exceptions.PatientNotFoundException;

import java.util.List;

public interface PatientDAO {

    Patient getByPESEL(String PESEL);
    List<Patient> getAll();
    void add(Patient patient);
    void update(Patient patient);
    void delete(String PESEL);
    List<TestOrder> getTestsOrders(Patient patient);
}
