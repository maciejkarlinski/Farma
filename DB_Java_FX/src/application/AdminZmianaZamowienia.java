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
 * The type Admin zmiana zamowienia.
 */
public class AdminZmianaZamowienia implements Initializable {
    /**
     * The Wroc button.
     */
    @FXML
    public Button wrocButton;
    /**
     * The Zmien date realizacji zamowienia button click.
     */
    @FXML
    public Button zmienDateRealizacjiZamowieniaButtonClick;
    /**
     * The Data text field.
     */
    @FXML
    public TextField dataTextField;
    /**
     * The Id zamowienia text field.
     */
    @FXML
    public TextField IdZamowieniaTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Otwarto okno Zmiany Daty Realizacji");

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
     * Zmien date realizacji zamowienia button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void zmienDateRealizacjiZamowieniaButtonClick(ActionEvent actionEvent) throws IOException {
        String data = dataTextField.getText();
        String idZamowienia = IdZamowieniaTextField.getText();

        if (data.equals("") ||idZamowienia.equals("") ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moge byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            dataTextField.clear();
            IdZamowieniaTextField.clear();

        } else{
        String response = MainApp.client.zmienDateRealizacjiZamowienia(idZamowienia, data);
        if (response.equalsIgnoreCase("Tak")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Data realizacji zmieniona");
            alert.setHeaderText("Data realizacji zmieniona");
            alert.setContentText("Data realizacji zmieniona");
            alert.showAndWait();
            dataTextField.clear();
            IdZamowieniaTextField.clear();
        } else if (response.equalsIgnoreCase("Nie ma")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nie ma takiego zamowienia");
            alert.setHeaderText("Nie ma takiego zamowienia");
            alert.setContentText("Nie ma takiego zamowienia");
            alert.showAndWait();
            dataTextField.clear();
            IdZamowieniaTextField.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Blad przy zmianie daty zamowienia");
            alert.setHeaderText("Blad przy zmianie daty zamowienia");
            alert.setContentText("Blad przy zmianie daty zamowienia");
            alert.showAndWait();
            dataTextField.clear();
            IdZamowieniaTextField.clear();
        }
    }
}


}
