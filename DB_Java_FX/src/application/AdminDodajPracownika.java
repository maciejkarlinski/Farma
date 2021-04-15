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
 * The type Admin dodaj pracownika.
 */
public class AdminDodajPracownika implements Initializable {

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
    /**
     * The Name text field.
     */
    @FXML
    public TextField nameTextField;
    /**
     * The Numer text field.
     */
    @FXML
    public TextField numerTextField;
    /**
     * The Pesel text field.
     */
    @FXML
    public TextField peselTextField;
    /**
     * The Wynagrodzenie text field.
     */
    @FXML
    public TextField wynagrodzenieTextField;
    /**
     * The Haslo text field.
     */
    @FXML
    public TextField hasloTextField;
    /**
     * The Nazwisko text field.
     */
    @FXML
    public TextField nazwiskoTextField;
    /**
     * The Email text field.
     */
    @FXML
    public TextField emailTextField;
    /**
     * The Stanowisko text field.
     */
    @FXML
    public TextField stanowiskoTextField;

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
            String Imie = nameTextField.getText();
            String Nazwisko = nazwiskoTextField.getText();
            String Email = emailTextField.getText();
            String Stanowisko = stanowiskoTextField.getText();
            String Telefon = numerTextField.getText();
            String Pesel = peselTextField.getText();
            String Wynagrodzenie = wynagrodzenieTextField.getText();
            String Haslo = hasloTextField.getText();

            if (Imie.equals("") || Nazwisko.equals("") || Email.equals("") || Stanowisko.equals("") || Telefon.equals("") || Pesel.equals("") || Wynagrodzenie.equals("") || Haslo.equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Dane nie moge byc puste");
                alert.setContentText("Wprowadz dane");
                alert.showAndWait();

                nameTextField.clear();
                nazwiskoTextField.clear();
                emailTextField.clear();
                stanowiskoTextField.clear();
                numerTextField.clear();
                peselTextField.clear();
                wynagrodzenieTextField.clear();
                hasloTextField.clear();

            } else {

                String response = MainApp.client.dodajPracownika(Imie, Nazwisko, Email, Stanowisko, Telefon, Pesel, Wynagrodzenie, Haslo);
                System.out.println(response);
                if (response.equalsIgnoreCase("Tak")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Pracownik dodany");
                    alert.setHeaderText("Pracownik dodany");
                    alert.setContentText("Pracownik dodany");
                    alert.showAndWait();
                    nameTextField.clear();
                    nazwiskoTextField.clear();
                    emailTextField.clear();
                    stanowiskoTextField.clear();
                    numerTextField.clear();
                    peselTextField.clear();
                    wynagrodzenieTextField.clear();
                    hasloTextField.clear();
                } else if (response.equalsIgnoreCase("Istnieje")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Osoba istnieje");
                    alert.setHeaderText("Osoba o podanym emailu juz istnieje");
                    alert.setContentText("Osoba o podanym emailu juz istnieje");
                    alert.showAndWait();
                    nameTextField.clear();
                    nazwiskoTextField.clear();
                    emailTextField.clear();
                    stanowiskoTextField.clear();
                    numerTextField.clear();
                    peselTextField.clear();
                    wynagrodzenieTextField.clear();
                    hasloTextField.clear();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Pracownik nie dodany");
                    alert.setHeaderText("Pracownik nie dodany");
                    alert.setContentText("Pracownik nie dodany");
                    alert.showAndWait();
                    nameTextField.clear();
                    nazwiskoTextField.clear();
                    emailTextField.clear();
                    stanowiskoTextField.clear();
                    numerTextField.clear();
                    peselTextField.clear();
                    wynagrodzenieTextField.clear();
                    hasloTextField.clear();
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

