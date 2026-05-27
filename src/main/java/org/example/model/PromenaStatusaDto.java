package org.example.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromenaStatusaDto {
    public static List<PromenaStatusaDto> readPromenaStatusaTabela(Connection connection){
        String query = "call ispis_svi_eksp_statusi();";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<PromenaStatusaDto> listaSvihStatusa = new ArrayList<>();
            while(resultSet.next()){
                int idSviStatusi = resultSet.getInt("izvodjenje_id");
                String ekperimenti = resultSet.getString("eksperiment_naziv");
                String izvodjenje = resultSet.getString("izvodjenje_status");
                Date datum = resultSet.getDate("izvodjenje_datum");
                PromenaStatusaDto promenaStatusaDto = new PromenaStatusaDto(idSviStatusi,ekperimenti,izvodjenje,datum);
                listaSvihStatusa.add(promenaStatusaDto);
            }
            return listaSvihStatusa;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    private final int idSviStatusi;
    private final String eksperimentNazivSviStatusi;
    private final String izvodjenjeStatusSviStatusi;
    private final Date izvodjenjeDatumSviStatusi;

    public PromenaStatusaDto(int idSviStatusi,String eksperimentNazivSviStatusi, String izvodjenjeStatusSviStatusi, Date izvodjenjeDatumSviStatusi) {
        this.idSviStatusi = idSviStatusi;
        this.eksperimentNazivSviStatusi = eksperimentNazivSviStatusi;
        this.izvodjenjeStatusSviStatusi = izvodjenjeStatusSviStatusi;
        this.izvodjenjeDatumSviStatusi = izvodjenjeDatumSviStatusi;
    }
    public int getIdSviStatusi() {
        return idSviStatusi;
    }
    public String getEksperimentNazivSviStatusi() {
        return eksperimentNazivSviStatusi;
    }

    public String getIzvodjenjeStatusSviStatusi() {
        return izvodjenjeStatusSviStatusi;
    }

    public Date getIzvodjenjeDatumSviStatusi() {
        return izvodjenjeDatumSviStatusi;
    }
}
