package com.company;

public class TestHemoglobina extends TestResult {

	private float wartosc;
	private static float wartoscDolna;
	private static float wartoscGorna;

	public TestHemoglobina(float wartosc)
	{
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
		return "Typ:"+this.name+"; data: "+this.resultDate+"; wynik:"+this.wartosc+"; Granice: "+this.wartoscDolna+"-"+this.wartoscGorna;
	}

	@Override
	public boolean isCorrect() {
		return wartoscDolna<this.wartosc && this.wartosc<wartoscGorna;
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