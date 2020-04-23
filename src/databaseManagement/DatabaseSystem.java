package databaseManagement;

import Field.Item;
import Item.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import status.LOGINSTATUS;

public class DatabaseSystem {
    private static int currentId;
    private static String currentUser;
    private static String currentPassword;
    private static LOGINSTATUS status = LOGINSTATUS.LOGOUT;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
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
        String sql = "SELECT username FROM account WHERE username LIKE '"+name.toLowerCase()+"'";
        
        try (Connection c = connectDB();
            ResultSet rs = c.createStatement().executeQuery(sql);){    
                while(rs.next()){
                     if(rs.getString("username").equals(name.toLowerCase())){
                         System.out.println("This User ID has been used");
                         return false;
                     }
                 }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return true;
    }
    private static void insertUsername(String name,String password){
        if(checkDuplicateUsername(name)){
            int id = getCountId();
            ++id;
            String sql = "INSERT INTO account VALUES ('"+id+"','"+name.toLowerCase()+"','"+password+"')";
            try( Connection c = connectDB();){
                Statement sm = c.createStatement();
                sm.executeUpdate(sql);
            String item = "INSERT INTO item VALUES ('"+getUserId(name,password)+"','0','0','0','0','0')";
                sm.executeUpdate(item);
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
        insertUsername(name,password);
        currentUser = name;
        currentPassword = password;
        status = LOGINSTATUS.LOGIN;
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
        currentUser = name;
        currentPassword = password;
        status = LOGINSTATUS.LOGIN;
        System.out.println("Login success");
        System.out.println("---------------------------------------");
    }
    private static int getCountId(){
        String sql = "SELECT COUNT(username) FROM account";
     try(Connection c = connectDB();
         Statement stm = c.createStatement();){
         ResultSet rs = stm.executeQuery(sql);
         if(rs.next()){
             int temp = Integer.parseInt(rs.getString(1));
             return temp;
         }
     }catch(Exception ex){
         System.out.println(ex);
     }
     return 0;
    } 
    public static void insertItem(Item item){
        if(status == LOGINSTATUS.LOGIN && item != null && item.getName() != null){
            updateItemTo(currentUser,currentPassword,item.getName(),item.amountCheck());
            }
    }
    private static boolean updateItemTo(String name,String password,String itemname,int amount){
        if(name == null || password == null) return false;
        if(status == LOGINSTATUS.LOGOUT || currentId < 0) return false;
        if(getUserId(name,password)<0)return false;
        String update = "UPDATE item SET "+itemname+" = '"+amount+"' WHERE userid = '"+getUserId(name,password)+"'";
        try(Connection c = connectDB();){
            Statement stm = c.createStatement();
             stm.executeUpdate(update);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        return true;
    }
    public static void logout(){
        currentId = -1;
        currentUser = null;
        currentPassword = null;
        status = LOGINSTATUS.LOGOUT;
    };
    private static int getUserId(String name,String password){
          String userId = "SELECT userid FROM account WHERE username LIKE '"+name.toLowerCase()+"' AND password LIKE '"+password+"'";
          try(Connection c = connectDB();){
              Statement stm = c.createStatement();
              ResultSet rs = stm.executeQuery(userId);
              if(rs.next()){
                  return rs.getInt(1);
              }
          }catch(Exception ex){
              System.out.println(ex);
          }
          return -1;
    }
}
