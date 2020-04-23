package databaseManagement;

import status.LOGINSTATUS;

class Account {
    private String username;
    private String password;
    private LOGINSTATUS status = LOGINSTATUS.LOGOUT;
    
    Account(String username,String password){
        this.username = username;
        this.password = password;
    }
    void setStatus(LOGINSTATUS status){
        this.status = status;
    }
    String getUsername(){
        return username;
    }
    String getPassword(){
        return password;
    }
    LOGINSTATUS getStatus(){
        return status;
    }
}
