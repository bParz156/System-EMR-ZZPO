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
    public void add(TestResult result) {

    }

    @Override
    public void delete(int id) {

    }
}
