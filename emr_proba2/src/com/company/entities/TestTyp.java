package com.company.entities;

public enum TestTyp {
	Hemoglobina(1),
	CisnienieSkurczowe(2),
	CisnienieRozkurczowe(3)
	;

	private final int value;

	TestTyp(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}

	public static TestTyp fromValue(int value) {
		for (TestTyp type : TestTyp.values()) {
			if (type.getValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid value for Speciality: " + value);
	}

}