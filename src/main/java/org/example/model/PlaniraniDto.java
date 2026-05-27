package org.example.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



public class PlaniraniDto {
    public static List<PlaniraniDto> readAllPlanirano(Connection connection){
        String query = "call ispis_plan_eksp();";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<PlaniraniDto> planirani = new ArrayList<>();
            while (resultSet.next()){
                int idPlanirani = resultSet.getInt("izvodjenje_id");
                String eksperimentNaziv = resultSet.getString("eksperiment_naziv");
                Date date = resultSet.getDate("izvodjenje_datum");
                String izvodjenjeStatus = resultSet.getString("izvodjenje_status");
                PlaniraniDto planiraniDto = new PlaniraniDto(idPlanirani, eksperimentNaziv, izvodjenjeStatus, date);
                planirani.add(planiraniDto);
            }
            return planirani;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private final int idPlanirani;
    private final String eksperimentNaziv;
    private final Date date;
    private final String izvodjenjeStatus;

    public PlaniraniDto(int idPlanirani, String eksperimentNaziv, String izvodjenjeStatus, Date date) {
        this.idPlanirani = idPlanirani;
        this.eksperimentNaziv = eksperimentNaziv;
        this.izvodjenjeStatus = izvodjenjeStatus;
        this.date = date;
    }
    public int getIdPlanirani() {
        return idPlanirani;
    }
    public String getEksperimentNaziv() {
        return eksperimentNaziv;
    }



    public Date getDate() {
        return date;
    }


    public String getIzvodjenjeStatus() {
        return izvodjenjeStatus;
    }


}

