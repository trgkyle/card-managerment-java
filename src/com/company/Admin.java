package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    private Account account = new Account();
    private String username;
    private String password;
    Admin() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String username,password;
        do {
            System.out.println("==================Dang Nhap=====================");
            System.out.print("User name : ");
            username = sc.nextLine();
            System.out.print("Password : ");
            password = sc.nextLine();
            System.out.println("================================================");
            if(!this.account.login(username, password)){
                System.out.println("Error Alert: Sai Tai khoan hoac mat khau");
                System.out.println();
            }
            else{
                this.username = username;
                this.password = password;
            }
        }
        while(!this.account.statusLogin && !this.account.isAdmin());
    }
    public void createCustomerAccount(){

    }
    public void showAllCustomer(){

    }
    public void deteleCustomerAccount(){

    }
    public void loginAccount(String username,String password) throws SQLException {
        System.out.println(this.account.login(username,password));
    }
    public void logoutAccount(){

    }
    public static void main(){
        System.out.println("Hello main Admin");
    }
}
