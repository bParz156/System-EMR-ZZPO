package com.company.entities;

import com.company.DBManagment.TestResultDAO;

import java.sql.Date;

public abstract class TestResult {

	int id;
	Date resultDate;
	TestTyp testTyp;
	int order;
	static TestResultDAO testResultDAO;

	public static  void setTestResultDAO(TestResultDAO testResultDAO)
	{
		TestResult.testResultDAO=testResultDAO;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder()
	{
		return  order;
	}

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

	public TestResult(int order, TestTyp testTyp)
	{
		this.order=order;
		long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		this.resultDate=date;
		this.testTyp=testTyp;
	}

	public TestResult( Date resultDate) {
		this.resultDate = resultDate;
	}


	public TestResult( Date resultDate, TestTyp testTyp) {
		this(resultDate);
		this.testTyp = testTyp;
	}

	abstract public String getResult();
	abstract public boolean isCorrect();
	abstract void create(int order);
	public abstract void setValue(Number value);
	public abstract Number getValue();
	public void addToDB()
	{
		testResultDAO.add(this);

	}
	private void update()
	{
		testResultDAO.update(this);
	}
}