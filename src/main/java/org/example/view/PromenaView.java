package org.example.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.example.Config;
import org.example.model.PromenaStatusaDto;
import org.example.view.tables.PromenaStatusaTabela;

public class PromenaView extends GridPane {

    private TableView<PromenaStatusaDto> tabela;
    private ComboBox<String> comboStatusi;
    private Button btnPromeni;
    private Button btnBack;
    private Label lblStatus;


    public PromenaView() {
        initElements();
        addElemets();
    }

    private void addElemets() {
        // Osnovna podešavanja layout-a
        this.setPadding(new Insets(20));
        this.setHgap(15);
        this.setVgap(15);
        this.setAlignment(Pos.CENTER);
        //TableColumn<Object, String> colPodatak = new TableColumn<>("Podatak");
        //TableColumn<Object, String> colTrenutniStatus = new TableColumn<>("Trenutni Status");
        //colPodatak.setPrefWidth(200);
        //colTrenutniStatus.setPrefWidth(150);

        //tabela.getColumns().addAll(colPodatak, colTrenutniStatus);

        // Dodajemo tabelu u grid: kolona 0, red 0, širina 2 kolone
        this.add(tabela, 0, 0, 2, 1);
        HBox statusLayout = new HBox(10, lblStatus, comboStatusi);
        statusLayout.setAlignment(Pos.CENTER_LEFT);
        this.add(statusLayout, 0, 1);
        // Ovde ćemo dodati statuse (ovo možeš kasnije puniti i iz baze)
        comboStatusi.getItems().addAll("planirano", "zapoceto", "otkazano", "zavrseno_uspesno", "zavrseno_neuspesno");
        comboStatusi.setPromptText("Izaberi...");
        this.add(btnPromeni, 1, 1);
        this.add(btnBack, 0, 2);
    }

    private void initElements() {
        tabela = new PromenaStatusaTabela(PromenaStatusaDto.readPromenaStatusaTabela(Config.getConnection()));
        // 2. Labela i ComboBox (Padajući meni)

        comboStatusi = new ComboBox<>();
        lblStatus = new Label("Odaberi novi status:");
        // 3. Dugme za promenu
        btnPromeni = new Button("Sačuvaj Promenu");
        btnPromeni.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        // 4. Dugme za nazad (stavljamo ga skroz dole)
        btnBack = new Button("← Nazad na početnu");

    }

    // Getteri za kontroler
    //public TableView<Object> getTabela() {
    //    return tabela;
    //}

    public TableView<PromenaStatusaDto> getTabela() {
        return tabela;
    }

    public ComboBox<String> getComboStatusi() {
        return comboStatusi;
    }

    public Button getBtnPromeni() {
        return btnPromeni;
    }

    public Button getBtnBack() {
        return btnBack;
    }
}