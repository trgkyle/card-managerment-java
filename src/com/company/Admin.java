package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    private Account account = new Account();
    public String username;
    Admin() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String username,password;
        do {
            System.out.println("==================ADMIN LOGIN=====================");
            System.out.print("User name : ");
            username = sc.nextLine();
            System.out.print("Password : ");
            password = sc.nextLine();
            System.out.println("================================================");
            if(!this.account.login(username, password)){
                System.out.println("Error Alert: Sai Tai khoan hoac mat khau");
                System.out.println();
            }
            else if(!this.account.isAdmin()){
                System.out.println("Tai khoan khong co quyen truy cap");
            }
            else{
                this.username = username;
            }
        }
        while(!this.account.statusLogin || !this.account.isAdmin());
    }
    public void getReMainerThisAccount() throws SQLException {
        this.account.getRemainerThisAccount();
    }
    public void createCustomerAccount() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        System.out.print("Tai khoan : ");
        username = sc.nextLine();
        System.out.print("Mat khau : ");
        password = sc.nextLine();
        if(this.account.signUp(username,password)){
            System.out.println("Tao tai khoan thanh cong");
        }
        else
            System.out.println("Co loi tao tai khoan");
    }
    public void showAllCustomer() throws SQLException {
        this.account.showAllCustomer();
    }
    public void deteleCustomerAccount(){
        String username;


    }
    public void showInfoAccount(){
        this.account.showInfoThisAccount();
    }
    public void logoutAccount(){
        this.account.logout();
    }
    public static void main(){
        System.out.println("Hello main Admin");
    }
}
