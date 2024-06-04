package com.company.entities;

import java.sql.Date;

public class TestHemoglobina extends TestResult {

	private float wartosc;
	private static float wartoscDolna;
	private static float wartoscGorna;


	public TestHemoglobina(int order)
	{
		super(order, TestTyp.Hemoglobina);
	}

	public TestHemoglobina()
	{
		this(Date.valueOf("2023-09-02"));
	}

	public TestHemoglobina(Date date)
	{
		super(date, TestTyp.Hemoglobina);
	}

	public TestHemoglobina(Date date, float wartosc)
	{
		this(date);
		this.wartosc=wartosc;
	}
	/**
	 * 
	 * @param wartosc
	 */
	public void setWartosc(float wartosc) {
		this.wartosc = wartosc;
	}

	public float getWartosc() {
		return this.wartosc;
	}

	@Override
	public String getResult()
	{
		return "Typ:"+this.testTyp.name()+"; data: "+this.resultDate+"; wynik:"+this.wartosc+"; Granice: "+this.wartoscDolna+"-"+this.wartoscGorna;
	}

	@Override
	public boolean isCorrect() {
		return wartoscDolna<this.wartosc && this.wartosc<wartoscGorna;
	}

	@Override
	void create(int order) {
		new TestHemoglobina(order);
	}

	@Override
	public void setValue(Number value) {
		setWartosc(value.floatValue());

	}

	@Override
	public Number getValue() {
		return wartosc;
	}


	public static float getWartoscDolna() {
		return wartoscDolna;
	}

	public static float getWartoscGorna() {
		return wartoscGorna;
	}

	public static void setWartoscDolna(float dolna)
	{
		TestHemoglobina.wartoscDolna=dolna;
	}

	public static void setWartoscGorna(float wartoscGorna) {
		TestHemoglobina.wartoscGorna = wartoscGorna;
	}
}