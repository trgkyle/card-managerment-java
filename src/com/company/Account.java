package com.company;

import java.sql.*;

public class Account {
    private ConnectionSQL connectionSQL = new ConnectionSQL();
    private Statement statement = this.connectionSQL.getStatement();
    private String username;
    private String password;
    private ResultSet rs;

    public boolean statusLogin;
    public boolean isAdmin;
    public boolean checkExistAccount(String user,String password) throws SQLException {
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
            if(this.checkExistAccount(user,password)){
                System.out.println("Tai khoan da toi tai");
                return false;
            }
            try{
                String query = "INSERT INTO `mana_accout`(`username`, `password`) VALUES ('"+user+"','"+password+"')";
                System.out.println(query);
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
    public boolean isAdmin() throws SQLException {
        if(this.rs != null && this.rs.getBoolean(4)){
            return true;
        }
        else{
            return false;
        }
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
                System.out.println("Ten :"+rs.getString(5));
                System.out.println("Ten dem :"+rs.getString(6));
                System.out.println("Tuoi :"+rs.getInt(7));
                System.out.println("So dien thoai :"+rs.getString(8));
                System.out.println("So du :"+rs.getString(9));
                System.out.println("Trang thai :"+rs.getBoolean(10));
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

}
