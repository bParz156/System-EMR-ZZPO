package com.company.entities;

import java.sql.Date;

public class TestHemoglobinaFactory implements TestFactory {
    @Override
    public TestResult createTestResult(int order) {
        TestResult result = new TestHemoglobina(order);
        return result;
    }

    @Override
    public void setGranice(float down, float up) {
        TestHemoglobina.setWartoscDolna(down);
        TestHemoglobina.setWartoscGorna(up);
    }

    @Override
    public TestResult readTestResult(int id, int order, Number number, Date resultDate) {
        return new TestHemoglobina(id, order, number.floatValue(), resultDate);
    }
}
