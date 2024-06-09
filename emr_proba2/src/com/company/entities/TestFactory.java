package com.company.entities;

import java.sql.Date;

public interface TestFactory {

	TestResult createTestResult(int order);
	void setGranice(float down, float up);
	TestResult readTestResult(int id, int order, Number number, Date resultDate);

}