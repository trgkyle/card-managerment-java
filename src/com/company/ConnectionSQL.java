package com.company;


import java.sql.*;
import java.util.Scanner;

public class ConnectionSQL {
    private Statement statement;
    private boolean statusConnect;
    public Statement getStatement() {
        return statement;
    }
    public boolean isStatusConnect() {
        return this.statusConnect;
    }
    ConnectionSQL(){
        Scanner sc = new Scanner(System.in);
        do {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:8889/dailythe", "root", "1507");
                this.statement = con.createStatement();
                this.statusConnect = true;
            } catch (ClassNotFoundException | SQLException e) {
                this.statusConnect = false;
                System.out.println("Error connect. Khong the ket noi toi co so du lieu !");
            }
            if(!this.statusConnect) sc.nextLine();
        }while(!this.statusConnect);
    }

}

