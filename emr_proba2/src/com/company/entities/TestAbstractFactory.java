package com.company.entities;

public class TestAbstractFactory {
    TestResult testResult;

    public TestResult createTestResult(int order,TestTyp testTyp)
    {
        switch (testTyp)
        {
            case Hemoglobina -> {
                testResult=new TestHemoglobinaFactory().createTestResult(order);
                break;
            }
            case CisnienieSkurczowe -> {
                testResult=new TestCisnienieSkurczoweFactory().createTestResult(order);
                break;
            }

            case CisnienieRozkurczowe -> {
                testResult=new TestCisnienieRozkurczoweFactory().createTestResult(order);
                break;
            }


        }
        testResult.addToDB();
        return testResult;
    }

    public void setGranice(TestTyp testTyp, float down, float up)
    {
        switch (testTyp)
        {
            case Hemoglobina -> {
                new TestHemoglobinaFactory().setGranice(down, up);
                break;
            }
            case CisnienieSkurczowe -> {
                new TestCisnienieSkurczoweFactory().setGranice(down, up);
                break;
            }
            case CisnienieRozkurczowe -> {
                new TestCisnienieRozkurczoweFactory().setGranice(down, up);
                break;
            }
        }
    }



}
