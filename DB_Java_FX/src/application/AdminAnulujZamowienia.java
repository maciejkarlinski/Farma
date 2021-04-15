package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Admin anuluj zamowienia.
 */
public class AdminAnulujZamowienia implements Initializable {

    /**
     * The Usun button.
     */
    @FXML
    public Button usunButton;
    /**
     * The Wroc button.
     */
    @FXML
    public Button wrocButton;
    /**
     * The Text field.
     */
    @FXML
    public TextField textField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Otwarto okno Anuluj zamowienie");
    }

    /**
     * Usun button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void usunButtonClick(ActionEvent actionEvent)throws IOException {
        String id_zamowienia = textField.getText();
        if (id_zamowienia.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Id zamowienia nie moze byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            textField.clear();
        } else {
        String response = MainApp.client.usun("Zamowienie",id_zamowienia);
        if(response.equalsIgnoreCase("Poprawnie usunieto"))
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Poprawnie usunieto");
            alert.setHeaderText("Poprawnie usunieto");
            alert.setContentText("Poprawnie usunieto");
            alert.showAndWait();
            textField.clear();
        }
        else if(response.equalsIgnoreCase("Nie istnieje")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nie istnieje");
            alert.setHeaderText("Nie istnieje");
            alert.setContentText("Nie istnieje");
            alert.showAndWait();
            textField.clear();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Blad przy usuwaniu");
            alert.setHeaderText("Blad przy usuwaniu");
            alert.setContentText("Blad przy usuwaniu");
            alert.showAndWait();
            textField.clear();
        }
    }
    }


    /**
     * Wroc button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void wrocButtonClick(ActionEvent actionEvent)throws IOException {
        ScreenController control = new ScreenController(this.wrocButton);
        control.switchScene("AdminMain.fxml");
    }
}