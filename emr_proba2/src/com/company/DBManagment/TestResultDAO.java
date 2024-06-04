package com.company.DBManagment;

import com.company.entities.TestOrder;
import com.company.entities.TestResult;
import com.company.entities.TestTyp;

public interface TestResultDAO {

    TestResult getById(int id);

    static void setGranice(TestTyp typ) {};
    void add(TestResult result);
    void delete(int id);


}
