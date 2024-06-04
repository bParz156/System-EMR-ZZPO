package com.company.entities;

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
}
