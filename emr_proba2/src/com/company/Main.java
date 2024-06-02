package com.company;


import java.sql.SQLException;

public class Main {

    public static void main(String[] args)  {
        try {
            ManagerDB managerDB=new ManagerDB();
        }
        catch (SQLException e)
        {
            System.out.println("Connection with database could not be made");
        }

    }
}
