package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        ConnectionSQL a = new ConnectionSQL();
        System.out.println(a.login("truong","hihi"));
    }
}