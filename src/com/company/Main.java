package com.company;
import dbFillers.Struktura;
import dbFillers.generateFiller;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub

        Connection connection=null;

        String url="jdbc:mariadb://localhost:3306/system_emr";
        String user="root";
        String pwd="password";


        connection = DriverManager.getConnection(url, user, pwd);
        System.out.println("Huuray");
        fillDB(connection);


    }



    private static void fillDB(Connection connection) throws SQLException {
        Struktura filler= generateFiller.generateFillers();
        Statement stmt = connection.createStatement();
        PreparedStatement ps = null;

        for(Lekarz lekarz: filler.lekarzs)
        {
            String statement=String.format("insert into lekarz(imie, nazwisko) values('%s', '%s')",
                    lekarz.getImie(), lekarz.getNazwisko());
            ps=connection.prepareStatement(statement);
            ps.execute();
        }


        for (Pacjent pacjent : filler.pacjents)
        {
            String statement=String.format("insert into pacjent(PESEL,imie,nazwisko) values('%s', '%s', '%s')",
                    pacjent.getPESEL(),pacjent.getImie(), pacjent.getNazwisko());
            stmt.executeUpdate(statement);
        }
    }

}
