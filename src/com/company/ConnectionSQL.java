package com.company;


import java.sql.*;

public class ConnectionSQL {
    private Statement statement;
    ConnectionSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/dailythe","root","1507");
                this.statement = con.createStatement();
                System.out.println("Connected!");
//                ResultSet rs=stmt.executeQuery("select * from mana_accout");
//                while(rs.next())
//                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error!");
//            System.out.println(e);

        }
    }
    public boolean signUp(String user,String password,String name,int age,String phone,int wallet,String log) throws SQLException {
        String query = "INSERT INTO `mana_accout`(`username`, `password`, `name`, `age`, `phone`, `wallet`, `log`) VALUES ("+user+","+password+","+name+","+age+","+phone+","+wallet+","+log+")";
            ResultSet rs = this.statement.executeQuery(query);
            return true;
    }
    public boolean login(String user,String password) throws SQLException{
        String query = "select * from mana_accout";
        ResultSet rs = this.statement.executeQuery(query);
        System.out.println(rs);
        System.out.println("go here");
        return true;
    }
    public boolean signUp(boolean login) {
        return login;
    }
}

