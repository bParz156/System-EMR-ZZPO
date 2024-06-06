package com.company.entities;

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
}
