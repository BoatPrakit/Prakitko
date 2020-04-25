package databaseManagement;

import Field.Item;
import Item.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import prakitkomodel.*;
import prototype.Prakitko;
import status.LOGINSTATUS;

public class DatabaseSystem {
    private static int currentId;
    private static String currentUser;
    private static String currentPassword;
    private static LOGINSTATUS status = LOGINSTATUS.LOGOUT;
    private static Prakitko prakitko;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        login();
        Prakitko newprakitko = choosePrakitko();     
        System.out.println(newprakitko);
        System.out.println(newprakitko.getLevel());
        newprakitko.receiveItem(new Taco());
        newprakitko.showInventory();
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
            try( Connection c = connectDB();){
                Statement sm = c.createStatement();
            String sql = "INSERT INTO account VALUES ('"+id+"','"+name.toLowerCase()+"','"+password+"')";
                sm.executeUpdate(sql);
            String item = "INSERT INTO item VALUES ('"+id+"','0','0','0','0','0')";
                sm.executeUpdate(item);
            String prakitko = "INSERT INTO prakitko VALUES ('"+id+"','none','none','1','0')";
                sm.executeUpdate(prakitko);
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
        currentId = getUserId(name,password);
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
        currentId = getUserId(name,password);
        currentUser = name;
        currentPassword = password;
        status = LOGINSTATUS.LOGIN;
        System.out.println("Login success");
        System.out.println("---------------------------------------");
    }
    private static int getCountId(){
        String sql = "SELECT MAX(userid) FROM account";
     try(Connection c = connectDB();
         Statement stm = c.createStatement();){
         ResultSet rs = stm.executeQuery(sql);
         if(rs.next()){
             int temp = rs.getInt(1);
             temp++;
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
    private static void loadItemTo(Prakitko prakitko){
        String sql = "SELECT * FROM item WHERE userid LIKE '"+getUserId(currentUser,currentPassword)+"'";
        try(Connection c = connectDB();){
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                int countTaco = rs.getInt("taco");
                int countCake = rs.getInt("cake");
                int countBurger  = rs.getInt("burger");
                int countHealing = rs.getInt("healingpotion");
                int countStamina = rs.getInt("staminapotion");
                
                Item taco = new Taco();
                taco.setAmount(countTaco);
                Item cake = new Cake();
                cake.setAmount(countCake);
                Item burger = new Burger();
                burger.setAmount(countBurger);
                Item healingpotion = new HealingPotion();
                healingpotion.setAmount(countHealing);
                Item staminapotion = new StaminaPotion();
                staminapotion.setAmount(countStamina);
                
                Item[] inventory = {taco,cake,burger,healingpotion,staminapotion};
                for (int i = 0; i < inventory.length; i++) {
                    if(inventory[i].amountCheck()>0){  
                    prakitko.receiveItem(inventory[i]);
                    }
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }
    public static void updateTypePrakitko(Prakitko prakitko){
        try(Connection c = connectDB();){
            PreparedStatement psm = c.prepareStatement("UPDATE prakitko SET typeprakitko = ? , prakitkoname = ? WHERE userid = ?");
            psm.setString(1, prakitko.getType());
            psm.setString(2, prakitko.getName());
            psm.setInt(3, getUserId(currentUser,currentPassword));
            psm.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void insertLevel(int lvl,int exp){
        if(currentId > 0 && currentUser != null && currentPassword != null && status == LOGINSTATUS.LOGIN){
        updateLevel(currentUser,currentPassword,lvl,exp);
        }
    }
    private static void updateLevel(String name,String password,int lvl,int exp){
        try(Connection c = connectDB()){
            PreparedStatement psm = c.prepareStatement("UPDATE prakitko SET level = ?, exp = ? WHERE userid = "+getUserId(name,password));
            psm.setInt(1, lvl);
            psm.setInt(2, exp);
            psm.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    private static void loadLevelTo(Prakitko prakitko){
        try(Connection c = connectDB()){
            String sql = "SELECT * FROM prakitko WHERE userId = "+getUserId(currentUser,currentPassword);
            int levelToExp = 0;
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("typeprakitko").equals(prakitko.getType())){
                    prakitko.changeName(rs.getString("prakitkoname"));
                    levelToExp = prakitko.levelToExp(rs.getInt("level"), rs.getInt("exp"));
                    prakitko.receiveExp(levelToExp);
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void showPrakitkoForSelect(){
        try(Connection c = connectDB()){
           Statement sm = c.createStatement();
           ResultSet rs = sm.executeQuery("SELECT * FROM prakitko WHERE userid = "+getUserId(currentUser,currentPassword));
           if(rs.next()){
               if(rs.getString("typeprakitko").equals("none")) System.out.println("Empty");
               else if(!rs.getString("prakitkoname").equals("none")){
                   System.out.println("1. Type : " + rs.getString("typeprakitko") 
                       +" \n   Prakitko Name : " + rs.getString("prakitkoname") +
                       " \n   Level : " + rs.getString("level"));
            }
           }
           else System.out.println("Empty");
        }catch(Exception ex){
            System.out.println(ex);
        } 
    }
    public static void deletePrakitko(Prakitko prakitko){
        try(Connection c = connectDB()){
            String delete = "UPDATE prakitko SET typeprakitko = 'none', prakitkoname = 'none', level = '0', exp = '0' WHERE userid = "+currentId+" AND prakitkoname LIKE '"+prakitko.getName()+"'"+" AND level = "+prakitko.getLevel();
            Statement sm = c.createStatement();
            sm.executeUpdate(delete);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void createPrakitko(Prakitko prakitko){
        try(Connection c = connectDB()){
            String delete = "UPDATE prakitko SET typeprakitko = ? , prakitkoname = ? , level = 1 , exp = 0 WHERE userid = "+currentId;
            PreparedStatement sm = c.prepareStatement(delete);
            sm.setString(1, prakitko.getType());
            sm.setString(2, prakitko.getName());            
            sm.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
            }
    }
    public static Prakitko choosePrakitko(){
        try(Connection c = connectDB()){
            Statement sm = c.createStatement();
            ResultSet rs = sm.executeQuery("SELECT * FROM prakitko WHERE userid = "+currentId);
            if(rs.next()){
            
                switch(rs.getString("typeprakitko")){
                    case "Dog":
                        prakitko = new Dog(rs.getString("prakitkoname"));
                        break;
                    case "Cat":
                        prakitko = new Cat(rs.getString("prakitkoname"));
                        break;
                    case "Fish":
                        prakitko = new Fish(rs.getString("prakitkoname"));
                        break;
                    case "Bird":
                        prakitko = new Bird(rs.getString("prakitkoname"));
                        break;
                }
                        loadLevelTo(prakitko);
                        loadItemTo(prakitko);
                return prakitko;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
}
