package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public void adminVoid() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int caseInput;
        Admin admin = new Admin();
        do{
            System.out.println("==================================ADMIN PAGE=====================================");
            System.out.println("Hi. "+admin.username +" !");
            System.out.println("1. Thong tin Tai khoan");
            System.out.println("2. Tra cuu so du Tai khoan");
            System.out.println("3. Chuyen tien");
            System.out.println("4. Tao tai khoan Khach Hang");
            System.out.println("5. Hien thi danh sach tat ca thong tin tai khoan Khach Hang");
            System.out.println("6. Reset mat khau khach hang");
            System.out.println("7. Xoa tai khoan Khach Hang");
            System.out.println("8. Doi mat khau");
            System.out.println("9. Dang Xuat");
            System.out.println("=================================================================================");
            caseInput = sc.nextInt();
            switch (caseInput){
                case 1:
                    admin.showInfoAccount();
                    break;
                case 2:
                    admin.getReMainerThisAccount();
                    break;
                case 3:
                    admin.tranferMoney();
                    break;
                case 4:
                    admin.createCustomerAccount();
                    break;
                case 5:
                    admin.showAllCustomer();
                    break;
                case 6:
                    //reset mat khau khach hang
                    break;
                case 7:
                    admin.deteleCustomerAccount();
                    break;
                case 8:
                    //doi mat khau admin
                    break;
                case 9:
                    admin.logoutAccount();
                    return;
                default:
                    break;

            }
        }while(true);
    }
    public void customerVoid() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int caseInput;
        Customer customer = new Customer();
        do{
            System.out.println("==================================CUSTOMER PAGE=====================================");
            System.out.println("Hi. "+customer.username +" !");
            System.out.println("1. Thong tin tai khoan ");
            System.out.println("2. Nap the");
            System.out.println("3. Tra cuu so du");
            System.out.println("4. Chuyen Tien");
            System.out.println("5. Lich su giao dich");
            System.out.println("6. Chinh sua thong tin ca nhan");
            System.out.println("7. Doi Mat Khau");
            System.out.println("8. Xoa Tai khoan");
            System.out.println("9. Dang xuat");
            System.out.println("====================================================================================");
            caseInput = sc.nextInt();
            switch (caseInput){
                case 1:
                    customer.showInfoAccount();
                    break;
                case 2:
                    //nap the
                    break;
                case 3:
                    customer.getRemainderThisAccount();
                    break;
                case 4:
                    customer.tranferMoney();
                    break;
                case 5:
                    // lich su giao dich
                    break;
                case 6:
                    customer.editInfo();
                    break;
                case 7:
                    // doi mat khau
                    break;
                case 8:
                    customer.deteleAccount();
                    break;
                case 9:
                    customer.logoutAccount();
                    return;
                default:
                    break;

            }
        }while(true);
    }
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int caseInput;
        Main main = new Main();
        do{
            System.out.println("====================================DAI LY THE MANAGEMENT=================================");
            System.out.println("Lua chon tai khoan");
            System.out.println("1. QUAN TRI");
            System.out.println("2. KHACHHANG");
            System.out.println("==========================================================================================");
            caseInput = sc.nextInt();
            switch (caseInput){
                case 1:
                    main.adminVoid();
                    break;
                case 2:
                    main.customerVoid();
                    break;
            }
        }while(true);

    }
}