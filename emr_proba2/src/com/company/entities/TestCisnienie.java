package com.company.entities;

import java.sql.Date;

public class TestCisnienie extends TestResult {

	private int rozkurczowe;
	private int skurczowe;
	private static int skurczoweDolne;
	private static int skurczoweGorne;
	private static int rozkurczoweDolne;
	private static int rozkurczoweGorne;

	public TestCisnienie(int id, int rozkurczowe, int skurczowe, Date date) {
		this.rozkurczowe = rozkurczowe;
		this.skurczowe = skurczowe;
		this.name = "Cisnienie";
		this.id=id;
		this.resultDate=date;
	}

	public static int getSkurczoweDolne() {
		return skurczoweDolne;
	}

	public static void setSkurczoweDolne(int skurczoweDolne) {
		TestCisnienie.skurczoweDolne = skurczoweDolne;
	}

	public static int getskurczoweGorne() {
		return skurczoweGorne;
	}

	public static void setskurczoweGorne(int skurczoweGorne) {
		TestCisnienie.skurczoweGorne = TestCisnienie.skurczoweGorne;
	}

	public static int getRozkurczoweDolne() {
		return rozkurczoweDolne;
	}

	public static void setRozkurczoweDolne(int rozkurczoweDolne) {
		TestCisnienie.rozkurczoweDolne = rozkurczoweDolne;
	}

	public static int getRozkurczoweGorne() {
		return rozkurczoweGorne;
	}

	public static void setRozkurczoweGorne(int rozkurczoweGorne) {
		TestCisnienie.rozkurczoweGorne = rozkurczoweGorne;
	}

	/**
	 * 
	 * @param skurczowe
	 */
	public void setSkurczowe(int skurczowe) {
		this.skurczowe = skurczowe;
	}

	public int getSkurczowe() {
		return this.skurczowe;
	}

	/**
	 * 
	 * @param rozkuczowe
	 */
	public void setRozkurczowe(int rozkuczowe) {
		this.rozkurczowe = rozkuczowe;
	}

	public int getRozkurczowe() {
		return this.rozkurczowe;
	}


	@Override
	public String getResult() {
		return  "Typ:"+this.name+"; data: "+this.resultDate+"; wynik rozkurczowe:"+this.rozkurczowe+ "; Granice: "+rozkurczoweDolne+"-"+rozkurczoweGorne+
				" wynik skurczowe"+this.skurczowe+"; Granice: "+skurczoweDolne+"-"+skurczoweGorne;
	}

	private boolean isRozkurczoweCorrect()
	{
		return rozkurczoweDolne<this.rozkurczowe && this.rozkurczowe<rozkurczoweGorne;
	}

	private boolean isSkurczoweCorrect()
	{
		return skurczoweDolne<this.skurczowe && this.skurczowe<skurczoweGorne;
	}

	@Override
	public boolean isCorrect() {
		return this.isRozkurczoweCorrect() && this.isSkurczoweCorrect();
	}
}