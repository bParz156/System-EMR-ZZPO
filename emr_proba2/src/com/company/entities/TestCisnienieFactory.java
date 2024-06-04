package com.company.entities;

import com.company.entities.TestCisnienie;
import com.company.entities.TestFactory;
import com.company.entities.TestResult;

public class TestCisnienieFactory implements TestFactory {
    @Override
    public TestResult createTestResult() {
        TestResult result = new TestCisnienie();
        return result;
    }
}
