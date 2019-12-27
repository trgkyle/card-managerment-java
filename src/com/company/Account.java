package com.company;

import java.sql.*;

public class Account {
    private ConnectionSQL connectionSQL = new ConnectionSQL();
    private Statement statement = this.connectionSQL.getStatement();
    private ResultSet rs;
    public boolean statusLogin;
    public boolean isAdmin;

    public boolean signUp(String user, String password) throws SQLException {
        //condition valid string
        try{
            String query = "INSERT INTO `mana_accout`(`username`, `password`,) VALUES ("+user+","+password+")";
            ResultSet rs = this.statement.executeQuery(query);
            return true;
        }
        catch (SQLException e){
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
    public boolean logout(){
        this.statusLogin = false;
        this.rs = null;
        return true;
    }
    public boolean isAdmin() throws SQLException {
        if(this.rs != null && this.rs.getBoolean(4)){
            return true;
        }
        else{
            return false;
        }
    }

}
