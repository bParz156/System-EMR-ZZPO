package com.company;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class PatientDAOImpl implements PatientDAO {
    private Connection connection;

    public PatientDAOImpl(ManagerDB managerDB) {
        this.connection = managerDB.getConnection();
    }

    @Override
    public Patient getByPESEL(String PESEL) {
        Patient patient=null;
        try
        {
            Statement stmt = connection.createStatement();
            String query="Select * from Patient where PESEL="+PESEL;
            ResultSet rs = stmt.executeQuery(query);
            String name=rs.getString("Name");
            String surname=rs.getString("Surname");
            String phoneNumber=rs.getString("PhoneNumber");
            Date birthday=rs.getDate("Birthday");
            List<Doctor> doctors=null;
            List<TestOrder> tests=null;
            patient=new Patient(PESEL, name, surname, phoneNumber, birthday,tests, doctors);

        }
        catch(SQLException e)
        {
            System.out.println("Klapa");
        }
        return patient;
    }

    @Override
    public List<Patient> getAll() {
        // Implementacja metody getAll
        List<Patient> patientList=new List<Patient>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return this.size()==0;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Patient> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Patient patient) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Patient> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Patient> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Patient get(int index) {
                return null;
            }

            @Override
            public Patient set(int index, Patient element) {
                return null;
            }

            @Override
            public void add(int index, Patient element) {

            }

            @Override
            public Patient remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Patient> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Patient> listIterator(int index) {
                return null;
            }

            @Override
            public List<Patient> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
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
                List<Doctor> doctors=null;
                List<TestOrder> tests=null;
                Patient patient=new Patient(PESEL, name, surname, phoneNumber, birthday,tests, doctors);
                patientList.add(patient);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Blad w getAll");
        }

        return patientList;

    }

    @Override
    public void add(Patient patient) {
        String query = "INSERT INTO patients (name, email, phone_number) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, patient.getName());
            pstmt.setString(2, patient.getPhoneNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Patient patient) {
        String query = "UPDATE patients SET name = ?, email = ?, phone_number = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, patient.getName());
            pstmt.setString(3, patient.getPhoneNumber());
            pstmt.setString(4, patient.getPESEL());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String PESEL) {
        // Implementacja metody delete
    }
}