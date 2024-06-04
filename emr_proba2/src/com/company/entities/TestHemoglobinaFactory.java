package com.company.entities;

import com.company.entities.TestFactory;
import com.company.entities.TestHemoglobina;
import com.company.entities.TestResult;


public class TestHemoglobinaFactory implements TestFactory {
    @Override
    public TestResult createTestResult() {
        TestResult result = new TestHemoglobina();
        return result;
    }

    @Override
    public void setGranice(float down, float up) {
        TestHemoglobina.setWartoscDolna(down);
        TestHemoglobina.setWartoscGorna(up);
    }
}
