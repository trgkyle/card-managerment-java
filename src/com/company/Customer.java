package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
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
            }
            else if(this.account.isAdmin()){
                System.out.println("Error Alert: Admin khong the truy cap duoi dang User");
                this.account.logout();
            }
            else{
                this.username = username;
            }
        }
        while(!this.account.statusLogin || this.account.isAdmin());
    }
    public String username;
    private Account account = new Account();
    public void deteleAccount() throws SQLException {
        account.deteleThisAccount();
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
    public void getRemainderThisAccount() throws SQLException {
        this.account.getRemainerThisAccount();
    }
    public void logoutAccount(){
        System.out.println("Dang xuat");
        this.account.logout();
    }
    public void showInfoAccount(){
        this.account.showInfoThisAccount();
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
    public static void main(){
        System.out.println("Hello main customer");
    }
}
