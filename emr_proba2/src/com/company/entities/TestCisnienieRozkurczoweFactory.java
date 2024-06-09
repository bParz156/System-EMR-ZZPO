package com.company.entities;

import java.sql.Date;

public class TestCisnienieRozkurczoweFactory implements TestFactory {
    @Override
    public TestResult createTestResult(int order) {
        TestResult result = new TestCisnienieRozkurczowe(order);
        return result;
    }

    @Override
    public void setGranice(float down, float up) {
        TestCisnienieRozkurczowe.setRozkurczoweDolne((int)down);
        TestCisnienieRozkurczowe.setRozkurczoweGorne((int)up);

    }

    @Override
    public TestResult readTestResult(int id,int order, Number number, Date resultDate) {
        return new TestCisnienieRozkurczowe(id, order, number.intValue(), resultDate);
    }
}
