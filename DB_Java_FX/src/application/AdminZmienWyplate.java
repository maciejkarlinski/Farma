package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Admin zmien wyplate.
 */
public class AdminZmienWyplate implements Initializable {
    /**
     * The Wroc button.
     */
    @FXML
    public Button wrocButton;
    /**
     * The Zmien wyplate button.
     */
    @FXML
    public Button zmienWyplateButton;
    /**
     * The Kwota text field.
     */
    @FXML
    public TextField kwotaTextField;
    /**
     * The Confkwota text field.
     */
    @FXML
    public TextField confkwotaTextField;
    /**
     * The Id pracownika text field.
     */
    @FXML
    public TextField IdPracownikaTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Otwarto okno Zmiany wyplaty");

    }

    /**
     * Wroc button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void wrocButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wrocButton);
        control.switchScene("AdminMain.fxml");
    }

    /**
     * Zmien wyplate button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void zmienWyplateButtonClick(ActionEvent actionEvent) throws IOException {
        String kwota = kwotaTextField.getText();
        String confirmKwota = confkwotaTextField.getText();
        String idPracownika = IdPracownikaTextField.getText();
        if (kwota.equals("") ||confirmKwota.equals("")||idPracownika.equals("") ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moge byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            kwotaTextField.clear();
            confkwotaTextField.clear();
            IdPracownikaTextField.clear();

        } else{
        if (!kwota.equals(confirmKwota)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Kwoty musza byc takie same");
            alert.setContentText("Wprowadz kwoty jeszcze raz");
            alert.showAndWait();

            kwotaTextField.clear();
            confkwotaTextField.clear();
        } else {
            String response = MainApp.client.zmienWyplate(idPracownika, kwota);
            if (response.equalsIgnoreCase("Tak")) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Wyplata zmieniona");
                alert.setHeaderText("Wyplata zmieniona");
                alert.setContentText("Wyplata zmieniona");
                alert.showAndWait();
                kwotaTextField.clear();
                confkwotaTextField.clear();
            } else if (response.equalsIgnoreCase("Nie ma")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Nie ma takiego pracownika");
                alert.setHeaderText("Nie ma takiego pracownika");
                alert.setContentText("Nie ma takiego pracownika");
                alert.showAndWait();
                kwotaTextField.clear();
                confkwotaTextField.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Blad przy zmianie wyplaty");
                alert.setHeaderText("Blad przy zmianie wyplaty");
                alert.setContentText("Blad przy zmianie wyplaty");
                alert.showAndWait();
                kwotaTextField.clear();
                confkwotaTextField.clear();
            }
        }
    }
}

}

