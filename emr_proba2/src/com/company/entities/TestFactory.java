package com.company.entities;

public interface TestFactory {

	TestResult createTestResult(int order);
	void setGranice(float down, float up);

}