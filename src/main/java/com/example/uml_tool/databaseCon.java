package com.example.uml_tool;

import java.sql.*;

public class databaseCon {
    public Connection databaseLink;
        
        public Connection getConnection(){
            String databaseName= "user";
            String databaseUser= "root";
            String databasePassword = "eleen114";
            String url = "jdbc:mysql://localhost/"+databaseName;
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
            } 
            catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
            
            return databaseLink;
//        }
//        public static void main(String args[]) {
//        // TODO code application logic here
    }
}
