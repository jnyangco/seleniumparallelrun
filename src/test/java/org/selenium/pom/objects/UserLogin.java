package org.selenium.pom.objects;

public class UserLogin {
    private String crewID;
    private String password;

    public UserLogin() {

    }

    //Constructors
    public UserLogin(String crewID, String password) {
        this.crewID = crewID;
        this.password = password;
    }


    //Getter and setter
    public String getCrewID() {
        return crewID;
    }

    public void setCrewID(String crewID) {
        this.crewID = crewID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
