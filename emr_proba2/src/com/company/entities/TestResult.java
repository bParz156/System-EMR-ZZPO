package com.company.entities;

import java.sql.Date;

public abstract class TestResult {
	int id;
	Date resultDate;
	TestTyp testTyp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getResultDate() {
		return resultDate;
	}

	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	public TestTyp testTyp() {
		return testTyp;
	}

	public void setTestTyp(TestTyp testTyp) {
		this.testTyp = testTyp;
	}

	public TestResult(int id, Date resultDate,TestTyp testTyp) {
		this.id = id;
		this.resultDate = resultDate;
		this.testTyp = testTyp;
	}

	public TestResult( Date resultDate) {
		this.resultDate = resultDate;
	}


	public TestResult( Date resultDate, TestTyp testTyp) {
		this.resultDate = resultDate;
		this.testTyp = testTyp;
	}

	public String getResult() {
		// TODO - implement TestResult.getResult
		throw new UnsupportedOperationException();
	}

	public boolean isCorrect() {
		// TODO - implement TestResult.isCorrect
		throw new UnsupportedOperationException();
	}
	
	abstract void create();

}