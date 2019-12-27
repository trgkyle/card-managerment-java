package com.company;

import java.sql.SQLException;

public class Customer {
    private ConnectionSQL connectionSQL = new ConnectionSQL();
    private boolean statusLogin;
    Customer() throws SQLException {
        System.out.println(connectionSQL.login("truong","hihi"));
    }
    public void deteleAccount(){
    }

    public void tranferMoney(){

    }
    public void editInfo(){

    }
    public void getRemainder(){

    }
    public void logoutAccount(){

    }
    public void showInfo(){

    }
}
