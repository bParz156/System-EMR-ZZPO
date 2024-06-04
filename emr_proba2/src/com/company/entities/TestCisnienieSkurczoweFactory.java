package com.company.entities;

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
}
