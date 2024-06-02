package com.company;

import java.util.List;

public interface PatientDAO {

    Patient getByPESEL(String PESEL);
    List<Patient> getAll();
    void add(Patient patient);
    void update(Patient patient);
    void delete(String PESEL);
}
