package org.example.view;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.example.Config;
import org.example.model.IzradjeniDto;
import org.example.model.PlaniraniDto;
import org.example.model.SviStatusiDto;
import org.example.view.tables.IzradjeniTabela;
import org.example.view.tables.PlaniraniTabela;
import org.example.view.tables.SviStatusiTabela;

public class HomeView extends GridPane {

    private TableView<PlaniraniDto> tabela;
    private TableView<IzradjeniDto> tabela2;
    private TableView<SviStatusiDto> tabela3;
    private Button btnPromena;
    private Button btnBrisanje;

    public HomeView() {
        initElements();
        addElemets();
    }

    private void addElemets() {
        this.setPadding(new Insets(20));

        // Horizontalni razmak između svih kolona u gridu
        this.setHgap(25);
        // Vertikalni razmak između redova (između tabela i dugmića)
        this.setVgap(15);

        // Kolone moraju biti zasebni objekti za svaku tabelu
        //TableColumn<PlaniraniDto, String> kol1 = new TableColumn<>("Ime");
        //TableColumn<PlaniraniDto, String> kol2 = new TableColumn<>("Prezime");
        //TableColumn<PlaniraniDto, String> kol7 = new TableColumn<>("Durum");
        //tabela.getColumns().addAll(kol1, kol2);
        //TableColumn<Object, String> kol3 = new TableColumn<>("Grad");
        //TableColumn<Object, String> kol4 = new TableColumn<>("Država");

        //tabela.getColumns().addAll(kol1, kol2);
        //TableColumn<Object, String> kol5 = new TableColumn<>("Grad");
        //TableColumn<Object, String> kol6 = new TableColumn<>("Država");
        //tabela.getColumns().addAll(kol1, kol2,kol7);
       // tabela2.getColumns().addAll(kol3, kol4);
        //tabela3.getColumns().addAll(kol5, kol6);



        HBox dugmiciLayout = new HBox(10);
        dugmiciLayout.getChildren().addAll(btnPromena, btnBrisanje);
        this.add(tabela, 0, 0);
        this.add(tabela2, 1, 0);
        this.add(tabela3, 2, 0);
        this.add(dugmiciLayout, 0, 1, 2, 1);
    }

    private void initElements() {
        tabela = new PlaniraniTabela(PlaniraniDto.readAllPlanirano(Config.getConnection()));
        tabela2 = new IzradjeniTabela(IzradjeniDto.readAllIzradjeni(Config.getConnection()));
        tabela3 = new SviStatusiTabela(SviStatusiDto.readAllSviStatusiDto(Config.getConnection()));
        btnPromena = new Button("Forma za promenu statusa");
        btnBrisanje = new Button("Forma za brisanje sesije");
    }

    //public TableView<Object> getTabela() {
     //   return tabela;
    //}

    //public void setTabela(TableView<Object> tabela) {
        //this.tabela = tabela;
   // }

    public Button getBtnBrisanje() {
        return btnBrisanje;
    }

    public void setBtnBrisanje(Button btnForma2) {
        this.btnBrisanje = btnForma2;
    }

    public Button getBtnPromena() {
        return btnPromena;
    }

    public void setBtnPromena(Button btnForma1) {
        this.btnPromena = btnForma1;
    }

    //public TableView<Object> getTabela2() {
    //    return tabela2;
   // }

    //public void setTabela2(TableView<Object> tabela2) {
    //    this.tabela2 = tabela2;
    //}
}