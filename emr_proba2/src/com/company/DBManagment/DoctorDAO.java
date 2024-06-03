package com.company.DBManagment;

import com.company.entities.Doctor;

import java.util.List;

public interface DoctorDAO {

    Doctor getById(int id);
    List<Doctor> getAll();
    void add(Doctor doctor);
    void update(Doctor doctor);
    void delete(int id);

}
