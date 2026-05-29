package org.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrisanjeDto {
    public static List<BrisanjeDto> readAllDto(Connection connection) {
        String query = "call brisanje_tabela();";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<BrisanjeDto> brisanjeDtos = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("sesija_id");
                String nazivEksperimenta = resultSet.getString("eksperiment_naziv");
                String nazivLab = resultSet.getString("laboratorija_naziv");
                Date datumSesije = resultSet.getDate("sesija_datum");
                Time vremePocetkaSesije = resultSet.getTime("sesija_vreme_pocetka");
                Time vremeZavrsetkaSesije = resultSet.getTime("sesija_vreme_zavrsetka");
                BrisanjeDto brisanjeDto = new BrisanjeDto(id,nazivEksperimenta, nazivLab,datumSesije, vremePocetkaSesije,vremeZavrsetkaSesije);
                brisanjeDtos.add(brisanjeDto);
            }
            return brisanjeDtos;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    };

    public static int istrazivacIdZaSesiju(Connection connection,int idSesije){
        String query = "select ti.istrazivac_id from sesija s join tim_izvodjaca ti on s.izvodjenje_id = ti.izvodjenje_id where s.sesija_id = ? limit 1";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idSesije);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("istrazivac_id");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return -1;
    }



    private int id;
    private String nazivEksperimenta;
    private String nazivLab;
    private Date datumSesije;
    private Time vremePocetkaSesije;
    private Time vremeZavrsetkaSesije;

    public BrisanjeDto(int id, String nazivEksperimenta, String nazivLab, Date datumSesije, Time vremePocetkaSesije, Time vremeZavrsetkaSesije) {
        this.id = id;
        this.nazivEksperimenta = nazivEksperimenta;
        this.nazivLab = nazivLab;
        this.datumSesije = datumSesije;
        this.vremePocetkaSesije = vremePocetkaSesije;
        this.vremeZavrsetkaSesije = vremeZavrsetkaSesije;
    }

    public int getId() {
        return id;
    }

    public String getNazivEksperimenta() {
        return nazivEksperimenta;
    }

    public String getNazivLab() {
        return nazivLab;
    }

    public Date getDatumSesije() {
        return datumSesije;
    }

    public Time getVremePocetkaSesije() {
        return vremePocetkaSesije;
    }

    public Time getVremeZavrsetkaSesije() {
        return vremeZavrsetkaSesije;
    }
}
