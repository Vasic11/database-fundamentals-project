package org.example;

public class Korisnik {
    private String userName;
    private String password;
    private String uloga;


    public Korisnik(String userName, String password,String uloga) {
        this.userName = userName;
        this.password = password;
        this.uloga = uloga;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUloga() {
        return uloga;
    }
    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

}
