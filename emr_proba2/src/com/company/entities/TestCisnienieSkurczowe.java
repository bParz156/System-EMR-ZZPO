package com.company.entities;

import java.sql.Date;

public class TestCisnienieSkurczowe extends TestResult {

	private int skurczowe;
	private static int skurczoweDolne;
	private static int skurczoweGorne;

	public TestCisnienieSkurczowe(int order)
	{
		super(order, TestTyp.CisnienieSkurczowe);
	}

	public TestCisnienieSkurczowe(int id, int order, int skurczowe, Date date) {
		super(date, TestTyp.CisnienieSkurczowe);
		this.skurczowe = skurczowe;
		this.id=id;
		this.order=order;
	}

	public TestCisnienieSkurczowe(Date date)
	{
		super(date, TestTyp.CisnienieSkurczowe);
	}



	public static int getSkurczoweDolne() {
		return skurczoweDolne;
	}

	public static void setSkurczoweDolne(int skurczoweDolne) {
		TestCisnienieSkurczowe.skurczoweDolne = skurczoweDolne;
	}

	public static int getskurczoweGorne() {
		return skurczoweGorne;
	}

	public static void setskurczoweGorne(int skurczoweGorne) {
		TestCisnienieSkurczowe.skurczoweGorne = skurczoweGorne;
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



	@Override
	public String getResult() {
		return  "Typ:"+this.testTyp.name()+"; data: "+this.resultDate+"; wynik rozkurczowe:"+
				"wynik:"+this.skurczowe+"; Granice: "+skurczoweDolne+"-"+skurczoweGorne;
	}



	@Override
	public boolean isCorrect() {
		return skurczoweDolne<this.skurczowe && this.skurczowe<skurczoweGorne;
	}

	@Override
	void create(int order) {
		new TestCisnienieSkurczowe(order);

	}

	@Override
	public void setValue(Number value) {
		setSkurczowe(value.intValue());
		update();
	}

	@Override
	public Number getValue() {
		return skurczowe;
	}
}