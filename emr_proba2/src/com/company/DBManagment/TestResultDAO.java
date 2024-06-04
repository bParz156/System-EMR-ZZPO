package com.company.DBManagment;

import com.company.entities.TestOrder;
import com.company.entities.TestResult;
import com.company.entities.TestTyp;

public interface TestResultDAO {

    void setGranice(TestTyp typ);
    TestResult getById(int id);
    void add(TestResult result, TestOrder testOrder);
    void delete(int id);
    void update(TestResult result);


}
