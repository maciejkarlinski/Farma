package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Store aktualizuj.
 */
public class StoreAktualizuj implements Initializable {

    /**
     * The Ilosc field.
     */
    @FXML
    public TextField iloscField;

    /**
     * The Pozycja field.
     */
    @FXML
    public TextField pozycjaField;

    /**
     * The Choice box.
     */
    @FXML
    public ChoiceBox<String> choiceBox;

    /**
     * Aktualizuj button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void AktualizujButtonClick(ActionEvent event) throws IOException, InterruptedException {
        String idsurowca[]=null;
        String surowiec=choiceBox.getValue();
        String ilosc = iloscField.getText();
        String pozycja = pozycjaField.getText();
        if (surowiec==null || ilosc.equals("") || pozycja.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();
            iloscField.clear();
            pozycjaField.clear();
        } else {
            try{
                idsurowca=surowiec.split(" ");//pobranie id surowca
                Integer.parseInt(ilosc);//sprawdzamy poprawnosc danych
                Integer.parseInt(pozycja);
                Integer.parseInt(idsurowca[0]);
                String wynik = MainApp.client.aktualizujMagazyn(idsurowca[0], ilosc, pozycja);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Komunikat");
                alert.setHeaderText(wynik);
                alert.showAndWait();
                iloscField.clear();
                pozycjaField.clear();
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Niepoprawny typ danych");
                alert.setContentText("Wprowadz dane ponownie!");
                alert.showAndWait();
                iloscField.clear();
                pozycjaField.clear();
            }
        }
    }

    /**
     * Powrot button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void PowrotButtonClick (ActionEvent event) throws IOException, InterruptedException {
        Parent tableview = FXMLLoader.load(getClass().getResource("StoreMain.fxml"));
        Scene tableviewscene = new Scene(tableview, 800, 800);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> availableChoices= null;
        try {
            availableChoices = FXCollections.observableArrayList(MainApp.client.wyswietlLista1("Surowiecdolisty1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        choiceBox.setItems(availableChoices);
    }
}
