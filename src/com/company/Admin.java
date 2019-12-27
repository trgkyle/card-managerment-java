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
    public void deteleCustomerAccount() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String username;
        String username2;
        do{
            System.out.print("Nhap ten tai khoan : ");
            username = sc.nextLine();
            System.out.print("Xac nhan lai ten tai khoan : ");
            username2 = sc.nextLine();
        }while(!username.equals(username2));
        this.account.deteleCustomerAccount(username);
    }
    public void showInfoAccount(){
        this.account.showInfoThisAccount();
    }
    public void logoutAccount(){
        this.account.logout();
    }
    public void tranferMoney() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String userTo;
        int amount;
        System.out.println("Nhap ten tai khoan muon chuyen tien :");
        userTo = sc.nextLine();
        System.out.println("Nhap so tien muon chuyen");
        amount = sc.nextInt();
        if(!this.account.transferMoney(userTo,amount)){
            System.out.println("Chuyen tien that bai");
        }
    }
    public void editInfo() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String firstName;
        String lastName;
        int age;
        String phone;
        System.out.print("Ten : ");
        firstName = sc.nextLine();
        System.out.print("Ho : ");
        lastName = sc.nextLine();
        System.out.print("Tuoi : ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.print("So dien thoai : ");
        phone = sc.nextLine();
        this.account.editInfoThisAccount(firstName,lastName,age,phone);
    }
    public void changePassword() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String oldPassword;
        String password;
        String password2;
        System.out.print("Nhap mat khau cu : ");
        oldPassword = sc.nextLine();
        System.out.print("Nhap mat khau moi : ");
        password = sc.nextLine();
        System.out.print("Xac nhan mat khau moi : ");
        password2 = sc.nextLine();
        if (password.equals(password2)) {
            this.account.changePasswordThisAccount(oldPassword,password);
        } else{
            System.out.println("Mat khau xac thuc khong khop");
        }
    }
    public void adminResetPassword() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String userName;
        String password;
        String password2;
        System.out.print("Nhap tai khoan : ");
        userName = sc.nextLine();
        System.out.print("Nhap mat khau moi : ");
        password = sc.nextLine();
        System.out.print("Xac nhan mat khau moi : ");
        password2 = sc.nextLine();
        if (password.equals(password2)) {
            this.account.adminResetPassword(userName,password);
        } else{
            System.out.println("Mat khau xac thuc khong khop");
        }
    }
    public static void main(){
        System.out.println("Hello main Admin");
    }
}
