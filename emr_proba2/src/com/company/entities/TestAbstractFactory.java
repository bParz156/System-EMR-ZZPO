package com.company.entities;

public class TestAbstractFactory {
    TestResult testResult;

    TestResult createTestResult(TestTyp testTyp)
    {
        switch (testTyp)
        {
            case Hemoglobina -> {
                testResult=new TestHemoglobinaFactory().createTestResult();
                break;
            }
            case CisnienieSkurczowe -> {
                testResult=new TestCisnienieFactory().createTestResult();
                break;
            }
        }

        return testResult;
    }

    void setGranice(TestTyp testTyp, float down, float up)
    {
        switch (testTyp)
        {
            case Hemoglobina -> {
                new TestHemoglobinaFactory().setGranice(down, up);
                break;
            }
            case CisnienieSkurczowe -> {
                new TestCisnienieFactory().setGranice(down, up);
                break;
            }
        }
    }



}
