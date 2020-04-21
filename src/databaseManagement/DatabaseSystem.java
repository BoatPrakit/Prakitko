package databaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseSystem {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       login();
    }
    private static Connection connectDB(){
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
    private static boolean checkDuplicateUsername(String name){
        String temp = name.toLowerCase();
        String sql = "SELECT username FROM account WHERE username LIKE '"+temp+"'";
        try {
            Connection c = connectDB();
            ResultSet rs = c.createStatement().executeQuery(sql);
                while(rs.next()){
                     if(rs.getString(1).equals(temp)){
                         System.out.println("This User ID has been used");
                         return false;
                     }
                 }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return true;
    }
    private static void insertInformation(String name,String password){
        if(checkDuplicateUsername(name)){
            String sql = "INSERT INTO account VALUES ('"+name.toLowerCase()+"','"+password+"')";
            try{
                Connection c = connectDB();
                Statement sm = c.createStatement();
                sm.executeUpdate(sql);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
    private static boolean isLoginSuccess(String name,String password){
        String sql = "SELECT * FROM account WHERE username LIKE '"+name.toLowerCase()+"' AND password LIKE '"+password+"'";
        try{
            Connection c = connectDB();
            Statement sm = c.createStatement();
            ResultSet rs = sm.executeQuery(sql);
                if(rs.next()){
                    return true;
                }else {
                    return false;
                }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public static void createId(){
        //username
        String name;
        String password;
        String confirmpassword;
        System.out.println("---------------Create ID---------------");
        do{
        System.out.print("Please insert your username : ");
        name = sc.nextLine();
        if(name == null || "".equals(name)) System.out.println("You can't use empty username");
        }while(checkDuplicateUsername(name)==false || name == null || "".equals(name));
        
        //password
        do{
         System.out.print("Password : ");
         password = sc.nextLine();
         System.out.print("Confirm Password : ");
         confirmpassword = sc.nextLine();
         if(!password.equals(confirmpassword) || "".equals(password))System.out.println("Your password is not match");
        } while(!password.equals(confirmpassword) || password == null || "".equals(password) );
        sc.close();
        System.out.println("Your account has been created.");
        insertInformation(name,password);
        System.out.println("---------------------------------------");
    }
    public static void login(){
        String name;
        String password;
        System.out.println("-----------------Login-----------------");
        do{
        System.out.print("Username : ");
        name = sc.nextLine();
        System.out.print("Password : ");
        password = sc.nextLine();
            if(!isLoginSuccess(name,password))System.out.println("Your Username or Password is wrong");
        } while(!isLoginSuccess(name,password));
        System.out.println("Login success");
    }
}
