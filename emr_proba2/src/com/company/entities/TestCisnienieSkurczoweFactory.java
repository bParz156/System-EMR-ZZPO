package com.company.entities;

import java.sql.Date;

public class TestCisnienieSkurczoweFactory implements TestFactory {
    @Override
    public TestResult createTestResult(int order) {
        TestResult result = new TestCisnienieSkurczowe(order);
        return result;
    }

    @Override
    public void setGranice(float down, float up) {
        TestCisnienieSkurczowe.setSkurczoweDolne((int)down);
        TestCisnienieSkurczowe.setskurczoweGorne((int)up);

    }

    @Override
    public TestResult readTestResult(int id, int order, Number number, Date resultDate) {
        return new TestCisnienieSkurczowe(id, order, number.intValue(), resultDate);
    }
}
