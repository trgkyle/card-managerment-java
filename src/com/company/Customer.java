package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
    private Account account = new Account();
    Customer() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String username,password;
        do {
            System.out.println("==================USER LOGIN=====================");
            System.out.print("User name : ");
            username = sc.nextLine();
            System.out.print("Password : ");
            password = sc.nextLine();
            System.out.println("================================================");
            if(!this.account.login(username, password)){
                System.out.println("Error Alert: Sai Tai khoan hoac mat khau");
                System.out.println();
            }
            else if(this.account.isAdmin()){
                System.out.println("Admin khong the truy cap duoi dang User");
                this.account.logout();
            }
        }
        while(!this.account.statusLogin && this.account.isAdmin());
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
        System.out.println("Dang xuat");
        this.account.logout();
    }
    public void showInfo(){
        this.account.showInfoThisAccount();
    }
    public static void main(){
        System.out.println("Hello main customer");
    }
}
