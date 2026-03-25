package org.example.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogInModel {
    public boolean daLiKorisnikPostoji(String username, String password) {
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\Korisnici.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] korisnik = line.split(",");
                if(korisnik.length > 0 && korisnik[0].equals(username) || korisnik[1].equals(password)){
                    return true;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
