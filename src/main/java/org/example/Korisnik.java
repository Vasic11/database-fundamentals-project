package org.example;

public class Korisnik {
    private String userName;
    private String password;
    private String uloga;
    private int id;

    public Korisnik(String userName, String password,String uloga,int id) {
        this.userName = userName;
        this.password = password;
        this.uloga = uloga;
        this.id = id;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
