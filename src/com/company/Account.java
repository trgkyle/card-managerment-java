package com.company;

import java.sql.*;
import java.util.*;
public class Account {
    private ConnectionSQL connectionSQL = new ConnectionSQL();
    private Statement statement = this.connectionSQL.getStatement();
    private String username;
    private String password;
    private ResultSet rs;
    private boolean statusLogin = false;
    private boolean isAdmin = false;
    private String getLog(String username){
        try{
            String query = "select * from mana_accout WHERE username='"+username+"'";
            ResultSet rs = this.statement.executeQuery(query);
            if(rs.next()){
                // System.out.println(rs.next());
//                if(rs.getString(11).toString().equals("null"))
//                    return null;
                return rs.getString(11);
            }
            else{
                // System.out.println("Khong tim thay du lieu");
                return null;
            }
        }
        catch(SQLException e){
            // System.out.println("Khong tim thay du lieu");
            return null;
        }
    }

    private void saveLog(String data, String username){
        try{
            String query = "update `mana_accout` set `log` = '" + (this.getLog(username)+data) + "'  where username='" + username + "' ";
            int rs = this.statement.executeUpdate(query);
             System.out.println("Da them vao lich su giao dich");
        }
        catch(SQLException e){
            System.out.println("Khong tim thay du lieu khong the luu log");
        }
    }
    private boolean transferMoneyAction(String from,String to,int amount) throws SQLException {
        try{
            int remainer = this.getRemainer(from) - amount;
            String fromQuery = "update `mana_accout` set `wallet`= '" + remainer + "' where username='" + from +"' ";
            int fromRS = this.statement.executeUpdate(fromQuery);
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("Loi tru tien");
            return false;
        }
        try{
            String toQuery = "update `mana_accout` set `wallet`= '" + (this.getRemainer(to) + amount) + "' where username='" + to +"' ";
            int toRS = this.statement.executeUpdate(toQuery);


            // luu log tai day
            java.util.Date date = new java.util.Date();
//            SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
            String logFrom = "\n" + "Chuyen tien den\t "+ to + " \t-"+ amount + "\t" + date.toString() ;
            String logTo = "\n" + "Nhan tien tu\t "+ from + " \t+"+ amount + "\t" + date.toString() ;
            System.out.println("Them log vao tai khoan chuyen");
            this.saveLog(logFrom,from);
            System.out.println("Them log vao tai khoan nhan");
            this.saveLog(logTo,to);
            return true;
        }catch(SQLException e){
            System.out.println("Loi cong tien");
            return false;
        }
    }
    private boolean validMoneyTransfer(String from,int moneyTransfer) throws SQLException{
        if(this.checkExistAccount(from)){
            String fromQuery = "select * from mana_accout WHERE username='"+from+"'";
            ResultSet fromRS = this.statement.executeQuery(fromQuery);
            if(fromRS.next()){
                int fromRemainer = fromRS.getInt(9);
                if(fromRemainer >= moneyTransfer)
                    return true;
                return false;
            }
            else{
                System.out.println("Co loi !. khong tim thay tai khoan chuyen tien");
                return false;
            }
        }
        else{
            System.out.println("Co loi !. khong tim thay tai khoan chuyen tien");
            return false;
        }
    }
    private boolean checkExistAccount(String user) throws SQLException {
        String query = "select * from mana_accout WHERE username='"+user+"'";
        ResultSet rs = this.statement.executeQuery(query);
        if(rs.next()){
            return true;
        }
        return false;
    }
    public boolean signUp(String user, String password) throws SQLException {
        //condition valid string
        if(this.isAdmin && this.statusLogin){
            if(this.checkExistAccount(user)){
                System.out.println("Tai khoan da toi tai");
                return false;
            }
            try{
                String query = "INSERT INTO `mana_accout`(`username`, `password`) VALUES ('"+user+"','"+password+"')";
                int rs = this.statement.executeUpdate(query);
                return true;
            }
            catch (SQLException e){
                System.out.println(e);
                return false;
            }
        }
        else{
            System.out.println("Ban khong co quyen tao tai khoan");
            return false;
        }
    }
    public boolean login(String user,String password) throws SQLException{
        //condition valid string
        try{
            String query = "select * from mana_accout WHERE username='"+user+"' && password='"+password+"'";
            ResultSet rs = this.statement.executeQuery(query);
            if(rs.next()){
                this.isAdmin = rs.getBoolean(4);
                this.statusLogin = true;
                this.rs = rs;
                this.username = user;
                this.password = password;
                return true;
            }
            else
            {
                this.statusLogin = false;
                return false;
            }
        }
        catch(SQLException e){
            return false;
        }
    }
    public void logout(){
        this.statusLogin = false;
        this.rs = null;
        this.isAdmin = false;
    }
    public boolean isAdmin(){
        return this.isAdmin;
    }
    public void showInfoThisAccount(){
        try{
            String query = "select * from mana_accout WHERE username='"+this.username+"' && password='"+this.password+"'";
            ResultSet rs = this.statement.executeQuery(query);
            if(rs.next()){
                if(rs.getBoolean(4)){
                    System.out.println("TAI KHOAN QUAN TRI VIEN");
                }
                else{
                    System.out.println("TAI KHOAN KHACH HANG");
                }
                System.out.println("Ten tai khoan : "+ rs.getString(2));
                System.out.println("Ten dem : "+rs.getString(6));
                System.out.println("Ten : "+rs.getString(5));
                System.out.println("Tuoi : "+rs.getInt(7));
                System.out.println("So dien thoai : "+rs.getString(8));
                System.out.println("So du : "+rs.getString(9));
                System.out.println("Trang thai : "+rs.getBoolean(10));
            }
            else
            {
                System.out.println("Tai khoan khong ton tai");
            }
        }
        catch(SQLException e){
            System.out.println("Co loi trong qua trinh lay thong tin tai khoan");
        }
    }
    public void showAllCustomer() throws SQLException {
        if(this.isAdmin && this.statusLogin){
            String query = "select * from mana_accout";
            ResultSet rs = this.statement.executeQuery(query);
            while(rs.next()){
                if(rs.getString(2) != this.username){
                    System.out.println("================KHACH HANG===============");
                    System.out.println("Ten tai khoan : "+ rs.getString(2));
                    System.out.println("Ten dem : "+rs.getString(6));
                    System.out.println("Ten : "+rs.getString(5));
                    System.out.println("Tuoi : "+rs.getInt(7));
                    System.out.println("So dien thoai : "+rs.getString(8));
                    System.out.println("So du : "+rs.getString(9));
                    System.out.println("Trang thai : "+rs.getBoolean(10));
                }
            }
            System.out.println("=====================================");
        }
        else{
            System.out.println("Ban khong co quyen truy cap");
        }

    }
    public void deteleThisAccount () throws SQLException{
        if(this.statusLogin){
            if(this.checkExistAccount(this.username)){
                String query = "DELETE FROM mana_accout WHERE username='"+this.username+"'";
                int rs = this.statement.executeUpdate(query);
                System.out.println("Xoa thanh cong tai khoan : "+ this.username);

                // after delete myself must to logout
                this.logout();
            }
            else{
                System.out.println("Tai khoan khong ton tai. Khong the xoa");
            }
        }
        else{
            System.out.println("Khong the xoa tai khoan nay");
        }
    }
    public void deteleCustomerAccount(String username)throws SQLException{
        if(this.isAdmin && this.statusLogin){
            if(this.checkExistAccount(username)){
                if(username.equals(this.username)){
                    System.out.println("Khong duoc xoa chinh tai khoan nay");
                }
                else{
                    String query = "DELETE FROM mana_accout WHERE username='"+username+"'";
                    int rs = this.statement.executeUpdate(query);
                    System.out.println("Xoa thanh cong tai khoan : "+ username);
                }
            }
            else{
                System.out.println("Tai khoan khong ton tai. Khong the xoa");
            }
        }
        else{
            System.out.println("Ban khong co quyen xoa tai khoan");
        }
    }
    private int getRemainer(String username) throws SQLException {
        if(this.checkExistAccount(username)){
            String query = "select * from mana_accout WHERE username='"+username+"'";
            ResultSet rs = this.statement.executeQuery(query);
            if(rs.next())
                return rs.getInt(9);
            else{
                System.out.println("Kiem tra so du tai, khoan khong ton tai");
                return -1;
            }
        }
        else
        {
            System.out.println("Loi khong tim thay tai khoan");
            return -1;
        }
    }
    public void getRemainerThisAccount() throws SQLException {
        System.out.println();
        System.out.println("So du Tai khoan hien co :"+ this.getRemainer(this.username));
        System.out.println();
    }
    public boolean isStatusLogin() {
        return this.statusLogin;
    }
    public boolean transferMoney(String username,int amount) throws SQLException {
        if(this.statusLogin){
            if(this.checkExistAccount(username)){
                if(this.validMoneyTransfer(this.username,amount)){
                    if(this.transferMoneyAction(this.username,username,amount)){
                        System.out.println("Chuyen tien thanh cong");
                        return true;
                    }
                    return false;
                }
                else{
                    System.out.println("Tai khoan cua ban khong du so du");
                    return false;
                }
            }
            else{
                System.out.println("Tai khoan nhan tien khong ton tai");
                return false;
            }
        }
        else{
            System.out.println("Ban phai dang nhap de chuyen tien");
            return false;
        }
    }
    public boolean editInfoThisAccount(String firstName, String lastName,int age,String phone) throws SQLException {
        try {
            String query = "update `mana_accout` set `firstName`= '" + firstName + "', " + "`lastName` = '" + lastName + "', " + "`age` = " + age + ", `phone` = '" + phone + "'  where username='" + this.username + "' ";
            int rs = this.statement.executeUpdate(query);
            System.out.println("Cap nhat thong tin thanh cong");
            return true;
        }catch (SQLException e){
            System.out.println("Loi cap nhap thong tin");
            return false;
        }
    }
    private boolean changePassWord(String username,String password) throws SQLException {
        if(this.checkExistAccount(username)){
            try {
                String query = "update `mana_accout` set `password`= '" + password + "' where username = '"+ username + "'";
                int rs = this.statement.executeUpdate(query);
                System.out.println("Doi mat khau thanh cong");
                return true;
            }catch (SQLException e){
                System.out.println("Doi mat khau that bai");
                return false;
            }
        }
        else{
            System.out.println("Tai khoan khong ton tai");
            return false;
        }
    }
    public boolean changePasswordThisAccount(String oldPassword, String password) throws SQLException{
        if(this.statusLogin){
            if(oldPassword.equals(this.password)){
                if(this.changePassWord(this.username,password)){
                    this.password = password;
                    return true;
                }
                else{
                    // doi mat khau khong thanh cong
                    return false;
                }
            }else{
                System.out.println("Mat khau cu khong chinh xac");
                return false;
            }
        }
        else{
            System.out.println("Khong the thuc hien tac vu nay");
            return true;
        }

    }
    public boolean adminResetPassword(String username,String password) throws SQLException {
        if(this.statusLogin && this.isAdmin){
            if(this.changePassWord(username, password)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            System.out.println("Ban khong co quyen thuc hien tac vu nay ");
            return false;
        }
    }
    public void getLogActiviry() throws SQLException{
        try{
            String query = "select * from mana_accout WHERE username='"+this.username+"' && password='"+this.password+"'";
            ResultSet rs = this.statement.executeQuery(query);
            if(rs.next()){
                System.out.println("Lich su giao dich : \n");
                System.out.println(rs.getString(11));
            }
            else{
                System.out.println("Khong tim thay du lieu");
            }
        }
        catch(SQLException e){
            System.out.println("Khong tim thay du lieu");
        }
    }
    public void payment(int amount) throws SQLException {
        if(this.transferMoney("adminCard",amount)){
            System.out.println("Da chuyen toi dich vu nap the !");
            System.out.println("Seri : " + (Math.random()*1000000000)%1000000000);
            System.out.println("Ma the nap : "+ (Math.random()*1000000000)%1000000000);
        }
    }
}
