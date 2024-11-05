package com.electrotech.inventorymgr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;

public class DatabaseCon {
    private Connection connection;

    public DatabaseCon() throws SQLException{
        String workingDirectoryPath = System.getProperty("user.dir");
        String databasePath = workingDirectoryPath + File.separator + "src" + File.separator + "main" + File.separator + "db" + File.separator + "electrotech.db";


        String url="jdbc:sqlite:" + databasePath;
        connection = DriverManager.getConnection(url);
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
