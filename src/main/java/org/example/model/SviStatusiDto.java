package org.example.model;

import org.example.view.tables.SviStatusiTabela;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class SviStatusiDto {
    public static List<SviStatusiDto>readAllSviStatusiDto(Connection connection) {
        String query = "call ispis_svi_eksp_statusi();";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<SviStatusiDto> svi = new ArrayList<>();
            while (resultSet.next()){
                String eksperimentNazivSvi = resultSet.getString("eksperiment_naziv");
                String izvodjenjeStatusSvi = resultSet.getString("izvodjenje_status");
                Date izvodjenjeDatumSvi = resultSet.getDate("izvodjenje_datum");
                SviStatusiDto sviStatusiDto = new SviStatusiDto(eksperimentNazivSvi, izvodjenjeStatusSvi, izvodjenjeDatumSvi);
                svi.add(sviStatusiDto);
            }
            return svi;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    };
    private final String eksperimentNazivSvi;
    private final String izvodjenjeStatusSvi;
    private final Date izvodjenjeDatumSvi;

    public SviStatusiDto(String eksperimentNazivSvi, String izvodjenjeStatusSvi, Date izvodjenjeDatumSvi) {
        this.eksperimentNazivSvi = eksperimentNazivSvi;
        this.izvodjenjeStatusSvi = izvodjenjeStatusSvi;
        this.izvodjenjeDatumSvi = izvodjenjeDatumSvi;
    }

    public String getEksperimentNazivSvi() {
        return eksperimentNazivSvi;
    }

    public String getIzvodjenjeStatusSvi() {
        return izvodjenjeStatusSvi;
    }

    public Date getIzvodjenjeDatumSvi() {
        return izvodjenjeDatumSvi;
    }
}
