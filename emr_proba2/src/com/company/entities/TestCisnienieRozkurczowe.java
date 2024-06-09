package com.company.entities;

import java.sql.Date;

public class TestCisnienieRozkurczowe extends TestResult {

	private int rozkurczowe;
	private static int rozkurczoweDolne;
	private static int rozkurczoweGorne;

	public TestCisnienieRozkurczowe(int order)
	{
		super(order, TestTyp.CisnienieRozkurczowe);
	}

	public TestCisnienieRozkurczowe(int id, int order, int rozkurczowe, Date date) {
		super(date, TestTyp.CisnienieRozkurczowe);
		this.rozkurczowe = rozkurczowe;
		this.id=id;
		this.order=order;
		this.resultDate=date;
	}

	public TestCisnienieRozkurczowe(Date date)
	{
		super(date, TestTyp.CisnienieRozkurczowe);
	}


	public TestCisnienieRozkurczowe()
	{
		this(Date.valueOf("2023-09-02"));
	}


	public static int getRozkurczoweDolne() {
		return rozkurczoweDolne;
	}

	public static void setRozkurczoweDolne(int rozkurczoweDolne) {
		TestCisnienieRozkurczowe.rozkurczoweDolne = rozkurczoweDolne;
	}

	public static int getRozkurczoweGorne() {
		return rozkurczoweGorne;
	}

	public static void setRozkurczoweGorne(int rozkurczoweGorne) {
		TestCisnienieRozkurczowe.rozkurczoweGorne = rozkurczoweGorne;
	}


	/**
	 * 
	 * @param rozkurczowe
	 */
	public void setRozkurczowe(int rozkurczowe) {
		this.rozkurczowe = rozkurczowe;
	}

	public int getRozkurczowe() {
		return this.rozkurczowe;
	}

	

	@Override
	public String getResult() {
		return  "Typ:"+this.testTyp.name()+"; data: "+this.resultDate+"; wynik rozkurczowe:"+
				"wynik:"+this.rozkurczowe+"; Granice: "+rozkurczoweDolne+"-"+rozkurczoweGorne;
	}



	@Override
	public boolean isCorrect() {
		return rozkurczoweDolne<this.rozkurczowe && this.rozkurczowe<rozkurczoweGorne;
	}

	@Override
	void create(int order) {
		new TestCisnienieRozkurczowe(order);
	}

	@Override
	public void setValue(Number value) {
		setRozkurczowe(value.intValue());
		update();
	}

	@Override
	public Number getValue() {
		return rozkurczowe;
	}
}