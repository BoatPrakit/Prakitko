package databaseManagement;
/*
    Create By Prakit
*/
import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import Model.Prakitko;
import static Service.ItemService.*;
import static Service.PrakitkoService.*;
import Type.CHARACTERTYPE;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
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
//       createPrakitko(createDog("tt"));
       prakitko = choosePrakitko();
        prakitko.receiveExp(50000);
        prakitko.useItem(createTaco());
        System.out.println(prakitko);
        System.out.println(prakitko.getLevel());
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
            int id = calculateUserId();
            try( Connection c = connectDB();){
                Statement sm = c.createStatement();
            String sql = "INSERT INTO account VALUES ('"+id+"','"+name.toLowerCase()+"','"+password+"')";
                sm.executeUpdate(sql);
            String item = "INSERT INTO item VALUES ('"+id+"','0','0','0','0','0')";
                sm.executeUpdate(item);
            String insert = "INSERT INTO prakitko VALUES ('"+id+"','none','none','1','0')";
                sm.executeUpdate(insert);
            }
            catch(SQLException ex){
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
    public static void register(){
        //username
        String name;
        String password;
        String confirmpassword;
        System.out.println("---------------Register---------------");
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
    private static int calculateUserId(){
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
    
    public static boolean updateItem(Item item){
        if(currentUser == null || currentPassword == null) return false;
        if(status == LOGINSTATUS.LOGOUT || currentId < 0) return false;
        if(getUserId(currentUser,currentPassword)<0)return false;
        String update = "UPDATE item SET "+item.getName()+" = '"+item.amountCheck()+"' WHERE userid = '"+getUserId(currentUser,currentPassword)+"'";
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
                
                Item taco = createTaco();
                taco.setAmount(countTaco);
                Item cake = createCake();
                cake.setAmount(countCake);
                Item burger = createBurger();
                burger.setAmount(countBurger);
                Item healingpotion = createHealingPotion();
                healingpotion.setAmount(countHealing);
                Item staminapotion = createStaminaPotion();
                staminapotion.setAmount(countStamina);
                
                Item[] inventory = {taco,cake,burger,healingpotion,staminapotion};
                for (int i = 0; i < inventory.length; i++) {
                    if(inventory[i].amountCheck()>0){
                        inventory[i].decreaseAmount();
                    prakitko.receiveItem(inventory[i]);
                    }
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public static void updateLevel(int lvl,int exp){
        try(Connection c = connectDB()){
            PreparedStatement psm = c.prepareStatement("UPDATE prakitko SET level = ?, exp = ? WHERE userid = "+getUserId(currentUser,currentPassword));
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
            
            String type = null;
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                    if(prakitko != null)
                        switch(prakitko.getType()){
                        case DOG:
                        type = "Dog";
                            break;
                        case CAT:
                        type = "Cat";
                            break;
                        case BIRD:
                        type = "Bird";
                        break;
                        case FISH:
                        type = "Fish";
                        break;
                    }
                if(rs.getString("typeprakitko").equals(type)){
                    prakitko.changeName(rs.getString("prakitkoname"));
                    prakitko.receiveExp(prakitko.levelToExp(rs.getInt("level"), rs.getInt("exp")));
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
            String type = null;
            if(null != prakitko.getType())
                switch (prakitko.getType()) {
                case DOG:
                    type = "Dog";
                    break;
                case CAT:
                    type = "Cat";
                    break;
                case BIRD:
                    type = "Bird";
                    break;
                case FISH:
                    type = "Fish";
                    break;
            }
            if(type != null){
            sm.setString(1, type);
            sm.setString(2, prakitko.getName());            
            sm.executeUpdate();
            }
        }catch(Exception ex){
            System.out.println(ex);
            }
    }
    public static Prakitko choosePrakitko() {
        try(Connection c = connectDB()){
            Statement sm = c.createStatement();
            ResultSet rs = sm.executeQuery("SELECT * FROM prakitko WHERE userid = "+currentId);
            if(rs.next()){
            
                switch(rs.getString("typeprakitko")){
                    case "Dog":
                        prakitko = createDog(rs.getString("prakitkoname"));
                        break;
                    case "Cat":
                        prakitko = createCat(rs.getString("prakitkoname"));
                        break;
                    case "Fish":
                        prakitko = createFish(rs.getString("prakitkoname"));
                        break;
                    case "Bird":
                        prakitko = createBird(rs.getString("prakitkoname"));
                        break;
                }
                    if(prakitko!=null){
                        loadLevelTo(prakitko);
                        loadItemTo(prakitko);
                    }
                return prakitko;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return prakitko;
    }
    
    public static String getUsername(){
        return currentUser;
    }
    private static void createTable(){
        try(Connection c = connectDB();){
            String createAccountTable = "CREATE TABLE account("
                    + "userid INT(5) PRIMARY KEY,"
                    + "username VARCHAR(20) NOT NULL,"
                    + "password VARCHAR(20) NOT NULL)";
            String createItemTable = "CREATE TABLE item("
                    + "userid INT(5) PRIMARY KEY,"
                    + "taco INT(3) NOT NULL,"
                    + "cake INT(3) NOT NULL,"
                    + "burger INT(3) NOT NULL,"
                    + "healingpotion INT(3) NOT NULL,"
                    + "staminapotion INT(3) NOT NULL)";
            String createPrakitkoTable = "CREATE TABLE prakitko("
                    + "userid INT(5) PRIMARY KEY,"
                    + "typeprakitko VARCHAR(10) DEFAULT 'none' NOT NULL,"
                    + "prakitkoname VARCHAR(20) DEFAULT 'none' NOT NULL,"
                    + "level INT(3) DEFAULT '1' NOT NULL,"
                    + "exp INT(5) DEFAULT '0' NOT NULL)";
            Statement sm = c.createStatement();
            sm.executeUpdate(createAccountTable);
            sm.executeUpdate(createItemTable);
            sm.executeUpdate(createPrakitkoTable);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
