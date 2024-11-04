package com.electrotech.inventorymgr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCon {
    private Connection connection;

    public DatabaseCon() throws SQLException{
        String url="jdbc:mysql://localhost:3306/sakurastop?useSSL=false";
        connection = DriverManager.getConnection(url, "dba_user", "r4#I<xe6£jqv]2_S2/nX");
        System.out.println("** Conexión con la base de datos exitosa.");
    }

    public Statement getNewStatement() throws SQLException{
        return connection.createStatement();
    }

    public Statement getModifyStatement() throws SQLException{
        return connection.createStatement();
    }

    public Statement getListStatement() throws SQLException{
        return connection.createStatement();
    }

}
