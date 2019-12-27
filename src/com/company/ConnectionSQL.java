package com.company;


import java.sql.*;

public class ConnectionSQL {
    private Statement statement;
    public boolean statusConnect;

    public Statement getStatement() {
        return statement;
    }

    ConnectionSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/dailythe","root","1507");
                this.statement = con.createStatement();
                this.statusConnect = true;
        }catch(ClassNotFoundException | SQLException e){
            this.statusConnect = false;
            System.out.println("Error connect. Connect fail!");
        }
    }
    public boolean isStatusConnect() {
        return this.statusConnect;
    }
}

