package databaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class DatabaseSystem {
        static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please insert your username : ");
        String s = sc.nextLine();
        findingData(s);
    }
    public static Connection connectDB(){
     String hostname=  "localhost";
     String db_name = "testdb";
    String user = "boat";
    String password = "prakitko";
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://"+hostname+"/"+db_name+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try{
            Class.forName(driver);
            Connection c = DriverManager.getConnection(url, user, password);
        return c;
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    public static void findingData(String name){
        String sql = "SELECT Name FROM Student WHERE Name LIKE '"+name+"'";
        try {
            Connection c = connectDB();
        ResultSet rs = c.createStatement().executeQuery(sql);
                while(rs.next()){
                     if(rs.getString(1).equals(name)){
                         System.out.println("This User ID has been used");
                     }
                 }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
