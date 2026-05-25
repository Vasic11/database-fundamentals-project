package org.example.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IzradjeniDto {
    public static List<IzradjeniDto> readAllIzradjeni(Connection connection) {
        String query = "call ispis_zav_eksp();";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<IzradjeniDto> izradjeni = new ArrayList<>();
            while (resultSet.next()){
                String eksperimentNazivIzradjeni = resultSet.getString("eksperiment_naziv");
                String izvodjenjeStatusIzradjeni = resultSet.getString("izvodjenje_status");
                Date izvodjenjeDatumIzradjeni = resultSet.getDate("izvodjenje_datum");
                IzradjeniDto izradjeniDto = new IzradjeniDto(eksperimentNazivIzradjeni, izvodjenjeStatusIzradjeni, izvodjenjeDatumIzradjeni);
                izradjeni.add(izradjeniDto);
            }
            return izradjeni;
        }catch(Exception e){
            throw  new RuntimeException(e);
        }
    };
    private final String eksperimentNazivIzradjeni;
    private final String izvodjenjeStatusIzradjeni;
    private final Date izvodjenjeDatumIzradjeni;

    public IzradjeniDto(String eksperimentNazivIzradjeni, String izvodjenjeStatusIzradjeni, Date izvodjenjeDatumIzradjeni) {
        this.eksperimentNazivIzradjeni = eksperimentNazivIzradjeni;
        this.izvodjenjeStatusIzradjeni = izvodjenjeStatusIzradjeni;
        this.izvodjenjeDatumIzradjeni = izvodjenjeDatumIzradjeni;
    }

    public String getEksperimentNazivIzradjeni() {
        return eksperimentNazivIzradjeni;
    }

    public String getIzvodjenjeStatusIzradjeni() {
        return izvodjenjeStatusIzradjeni;
    }

    public Date getIzvodjenjeDatumIzradjeni() {
        return izvodjenjeDatumIzradjeni;
    }
}
