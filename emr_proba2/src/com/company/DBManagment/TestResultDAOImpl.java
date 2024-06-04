package com.company.DBManagment;

import com.company.entities.*;

import java.sql.*;

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

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testResult;
    }

    @Override
    public void add(TestResult result, TestOrder testOrder) {
        String query = "INSERT INTO TestResult (TestOrder, ResultDate, ResultValue, typ) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, testOrder.getId());
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


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    };

}
