package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class UpdateInformationView extends GridPane {
    private Label lbUserName,lbNewUserName,lbOldPassworf, lbConfPassword2,lblNewPassword3;
    private TextField tfUserName,tfNewUserName;
    private PasswordField pfPassworf,pfPassword2,pfPassword3;
    private Button create,back;




    public UpdateInformationView() {
        initElements();
        addElemets();

    }

    private void addElemets() {
        this.addColumn(0,lbUserName,lbNewUserName,lbOldPassworf,lblNewPassword3,lbConfPassword2,create);
        this.addColumn(1,tfUserName,tfNewUserName,pfPassworf,pfPassword3,pfPassword2,back);
        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);


    }

    private void initElements() {
        lbUserName = new Label("Username");
        lbNewUserName = new Label("New Username");
        lbOldPassworf = new Label("Old Password");
        lbConfPassword2 = new Label("Confirm Password");
        lblNewPassword3 = new Label("New Password");
        tfUserName = new TextField();
        tfNewUserName = new TextField();
        pfPassworf = new PasswordField();
        pfPassword2 = new PasswordField();
        pfPassword3 = new PasswordField();
        create = new Button("Create");
        back = new Button("Back");

    }
}
