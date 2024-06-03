package com.company.entities;

public enum Speciality {
	Kardiolog (1),
	Neurolog (2),
	Ortopeda (3),
	Onkolog(4);

	private final int value;

	Speciality(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}

	public static Speciality fromValue(int value) {
		for (Speciality speciality : Speciality.values()) {
			if (speciality.getValue() == value) {
				return speciality;
			}
		}
		throw new IllegalArgumentException("Invalid value for Speciality: " + value);
	}

}