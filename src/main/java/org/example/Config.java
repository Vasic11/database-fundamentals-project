package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Config {

    private static Properties properties;
    private static Connection connection;

    public static void connect(String host, String port, String db, String user, String password){
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
        try{
            connection = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void disconnect(){
        try{
            connection.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void loadProperties(String cfgFile){
        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(cfgFile);
            properties.load(fileInputStream);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public static Properties getProperties() {
        return properties;
    }

    public static Connection getConnection() {
        if(connection == null){
            System.out.println("Kritična greška: Pokušaj pristupa bazi pre pozivanja Config.connect()!");
        }
        return connection;
    }
}
