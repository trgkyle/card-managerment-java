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
            System.out.println("4. Lich su chuyen tien");
            System.out.println("5. Tao tai khoan Khach Hang");
            System.out.println("6. Hien thi danh sach tat ca thong tin tai khoan Khach Hang");
            System.out.println("7. Reset mat khau khach hang");
            System.out.println("8. Xoa tai khoan Khach Hang");
            System.out.println("9. Chinh sua thong tin ca nhan");
            System.out.println("10. Doi mat khau");
            System.out.println("11. Dang Xuat");
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
                    admin.historyActivity();
                    break;
                case 5:
                    admin.createCustomerAccount();
                    break;
                case 6:
                    admin.showAllCustomer();
                    break;
                case 7:
                    admin.adminResetPassword();
                    break;
                case 8:
                    admin.deteleCustomerAccount();
                    break;
                case 9:
                    admin.editInfo();
                    break;
                case 10:
                    admin.changePassword();
                    break;
                case 11:
                    admin.logoutAccount();
                    return;
                default:
                    System.out.println("Khong hop le");
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
                    customer.payCard();
                    break;
                case 3:
                    customer.getRemainderThisAccount();
                    break;
                case 4:
                    customer.tranferMoney();
                    break;
                case 5:
                    customer.historyActivity();
                    break;
                case 6:
                    customer.editInfo();
                    break;
                case 7:
                    customer.changePassword();
                    break;
                case 8:
                    customer.deteleAccount();
                    break;
                case 9:
                    customer.logoutAccount();
                    return;
                default:
                    System.out.println("Khong hop le");
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
                default:
                    return;

            }
        }while(true);

    }
}