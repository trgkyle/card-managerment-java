package com.company;


import java.sql.*;

public class ConnectionSQL {
    private Statement statement;
    private boolean statusConnect;
    private ResultSet rs;
    ConnectionSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/dailythe","root","1507");
                this.statement = con.createStatement();
                this.statusConnect = true;
                System.out.println("Connected!");
//                ResultSet rs=stmt.executeQuery("select * from mana_accout");
//                while(rs.next())
//                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        }catch(ClassNotFoundException | SQLException e){
            this.statusConnect = false;
            System.out.println("Error connect. Connect fail!");

        }
    }

    public boolean isStatusConnect() {
        return statusConnect;
    }

    public boolean signUp(String user, String password, String name, int age, String phone, int wallet, String log) throws SQLException {
        String query = "INSERT INTO `mana_accout`(`username`, `password`, `name`, `age`, `phone`, `wallet`, `log`) VALUES ("+user+","+password+","+name+","+age+","+phone+","+wallet+","+log+")";
            ResultSet rs = this.statement.executeQuery(query);
            return true;
    }
    public boolean login(String user,String password) throws SQLException{
        try{
            String query = "select * from mana_accout WHERE username='"+user+"' && password='"+password+"'";
            System.out.println(query);
            ResultSet rs = this.statement.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            return true;
        }
        catch(SQLException e){
            System.out.println("error");
            return false;
        }
    }
    public boolean signUp(boolean login) {
        return login;
    }
}

