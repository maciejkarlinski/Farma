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
 * The type Admin dodaj dostawce.
 */
public class AdminDodajDostawce implements Initializable {
    /**
     * The Name text field.
     */
    @FXML
    public TextField nameTextField;
    /**
     * The Nip text field.
     */
    @FXML
    public TextField nipTextField;
    /**
     * The Country text field.
     */
    @FXML
    public TextField countryTextField;
    /**
     * The Adress text field.
     */
    @FXML
    public TextField adressTextField;
    /**
     * The Dodaj button.
     */
    @FXML
    public Button dodajButton;
    /**
     * The Wroc button.
     */
    @FXML
    public Button wrocButton;

    @Override
    public void initialize (URL location, ResourceBundle resources){
        System.out.println("Otwarto okno Wyswietlania Dostawce");
    }

    /**
     * Dodaj button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void dodajButtonClick(ActionEvent actionEvent) throws IOException {
        String NIP = nipTextField.getText();
        String kraj = countryTextField.getText();
        String adres = adressTextField.getText();

        if (NIP.equals("") || kraj.equals("") || adres.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moge byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            nipTextField.clear();
            adressTextField.clear();
            countryTextField.clear();
        } else { String nazwa = nameTextField.getText();

       String response = MainApp.client.dodajDostawce(nazwa,NIP,kraj,adres);
       System.out.println(response);
        if(response.equalsIgnoreCase("Tak"))
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Dostawca dodany");
            alert.setHeaderText("Dostawca dodany");
            alert.setContentText("Dostawca dodany");
            alert.showAndWait();
            nipTextField.clear();
            adressTextField.clear();
            countryTextField.clear();
        }
        else if(response.equalsIgnoreCase("Istnieje")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dostawca istnieje");
            alert.setHeaderText("Dostawca istnieje");
            alert.setContentText("Dostawca istnieje");
            alert.showAndWait();
            nipTextField.clear();
            adressTextField.clear();
            countryTextField.clear();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Dostawca nie dodany");
            alert.setHeaderText("Dostawca nie dodany");
            alert.setContentText("Dostawca nie dodany");
            alert.showAndWait();
            nipTextField.clear();
            adressTextField.clear();
            countryTextField.clear();
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
    public void wrocButtonClick(ActionEvent actionEvent) throws IOException{
        ScreenController control = new ScreenController(this.wrocButton);
        control.switchScene("AdminMain.fxml");
    }
}
