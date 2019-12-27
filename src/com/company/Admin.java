package com.company;

import java.sql.SQLException;

public class Admin {
    private ConnectionSQL connectionSQL = new ConnectionSQL();
    private boolean statusLogin;
    private String username;
    Admin(){

    }
    public void createCustomerAccount(){

    }
    public void deteleCustomerAccount(){

    }
    public void loginAccount(String username,String password) throws SQLException {
        System.out.println(connectionSQL.login(username,password));
    }
    public void logoutAccount(){

    }
    public static void main(){
        System.out.println("Hello Admin");
    }
}
