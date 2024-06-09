package com.company.DBManagment;

import com.company.entities.TestOrder;
import com.company.entities.TestResult;
import com.company.entities.TestTyp;

import java.util.List;

public interface TestResultDAO {

    TestResult getById(int id); //raczej do wyrzucenia
    void setGranice(TestTyp typ);
    void add(TestResult result);
    void delete(int id);
    void update(TestResult result);
    List<TestResult> getByOrder(TestOrder testOrder);
    void setGraniceAll();


}
