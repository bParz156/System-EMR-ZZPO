package com.company.entities;

import java.sql.Date;

public class TestAbstractFactory {
    TestResult testResult;

    /**
     *
     * @param order
     * @param testTyp
     * @param withAdd W przyapdku tworzenia i dodawania do bazu - True, jesli tylko czytam z bazy to False
     * @return
     */
    public TestResult createTestResult(int order,TestTyp testTyp,boolean withAdd)
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
        if (withAdd)
        {
            testResult.addToDB();
        }

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


    public TestResult readTestResult(int id, int order, TestTyp testTyp, Number number, Date resultDate)
    {
        switch (testTyp) {
            case Hemoglobina -> {
                testResult = new TestHemoglobinaFactory().readTestResult(id, order, number,  resultDate);
                break;
            }
            case CisnienieSkurczowe -> {
                testResult = new TestCisnienieSkurczoweFactory().readTestResult(id, order, number,  resultDate);
                break;
            }

            case CisnienieRozkurczowe -> {
                testResult = new TestCisnienieRozkurczoweFactory().readTestResult(id, order, number,  resultDate);
                break;
            }


        }

        return testResult;
    }



}
