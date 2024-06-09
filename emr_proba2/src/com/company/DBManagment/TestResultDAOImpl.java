package com.company.DBManagment;

import com.company.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestResultDAOImpl implements  TestResultDAO{

    private Connection connection;

    public TestResultDAOImpl(ManagerDB managerDB)
    {
        this.connection=managerDB.getConnection();
    }


    @Override
    public TestResult getById(int id) {
        TestResult testResult=null;
        String query="Select * from TestResult where id= ?";
        try {
            PreparedStatement stmt=connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {

                Date date=rs.getDate("ResultDate");
                int type= rs.getInt("typ");
                TestTyp testTyp=TestTyp.fromValue(type);
                int order =rs.getInt("TestOrder");
                Number value= rs.getFloat("ResultValue");
                testResult=new TestAbstractFactory().readTestResult(id, order, testTyp,  value,  date);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testResult;
    }

    @Override
    public void add(TestResult result) {
        String query = "INSERT INTO TestResult (TestOrder, ResultDate, ResultValue, typ) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, result.getOrder());
            pstmt.setDate(2, result.getResultDate());
            pstmt.setFloat(3, -1);
            pstmt.setInt(4, result.testTyp().getValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(TestResult result) {
        String query = "Update  TestResult SET  ResultDate=?, ResultValue=? where id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDate(1, result.getResultDate());
            pstmt.setFloat(2, result.getValue().floatValue());
            pstmt.setInt(3, result.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<TestResult> getByOrder(TestOrder testOrder) {
        List<TestResult> testResults=new ArrayList<>();
        int order=testOrder.getId();
        String query="Select * from TestResult where TestOrder= "+order;
        try {
            PreparedStatement stmt=connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int id= rs.getInt("Id");
                Date date=rs.getDate("ResultDate");
                int type= rs.getInt("typ");
                TestTyp testTyp=TestTyp.fromValue(type);
                Number value= rs.getFloat("ResultValue");
                TestResult testResult=new TestAbstractFactory().readTestResult(id, order, testTyp,  value,  date);
                testResults.add(testResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testResults;
    }

    @Override
    public void setGraniceAll() {
        TestTyp [] all=TestTyp.values();
        for(TestTyp typ : all)
        {
            setGranice(typ);
        }
    }

    @Override
    public void setGranice(TestTyp typ) {
        String query="Select * from TestWzorzec where ID=?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, typ.getValue());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {

                float down=rs.getFloat("DolnaGranica");
                float up= rs.getFloat("GornaGranica");
                new TestAbstractFactory().setGranice(typ, down, up);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
