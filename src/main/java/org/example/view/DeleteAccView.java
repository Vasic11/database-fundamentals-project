package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DeleteAccView extends GridPane {
    private Label lbUserName,lbPassword, lbConfPassword2;
    private TextField tfUserName;
    private PasswordField pfPassworf,pfPassword2;
    private Button delete,back;




    public DeleteAccView() {
        initElements();
        addElemets();

    }

    private void addElemets() {
        this.addColumn(0,lbUserName,lbPassword,lbConfPassword2,delete);
        this.addColumn(1,tfUserName,pfPassworf,pfPassword2,back);
        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);


    }

    private void initElements() {
        lbUserName = new Label("Username");
        lbPassword = new Label("Password");
        lbConfPassword2 = new Label("Confirm Password");
        tfUserName = new TextField();
        pfPassworf = new PasswordField();
        pfPassword2 = new PasswordField();

        delete = new Button("Delete");
        back = new Button("Back");

    }
}
