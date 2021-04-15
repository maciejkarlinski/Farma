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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Office dodaj oferte.
 */
public class OfficeDodajOferte implements Initializable {

    /**
     * The Cena field.
     */
    @FXML
    public TextField cenaField;

    /**
     * The Choice box.
     */
    @FXML
    public ComboBox<String> choiceBox;

    /**
     * The Choice box 1.
     */
    @FXML
    public ChoiceBox<String> choiceBox1;

    /**
     * Doda oferte button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void DodaOferteButtonClick(ActionEvent event) throws IOException, InterruptedException {
        String cena=cenaField.getText();
        String nazwa=choiceBox.getValue();
        String gramatura=choiceBox1.getValue();
        if (cena.equals("")||nazwa==null||gramatura==null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            cenaField.clear();
        } else {
            try{
                Double.parseDouble(cena);
                String wynik = MainApp.client.dodajOferte(nazwa, cena, gramatura);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Komunikat");
                alert.setHeaderText(wynik);
                alert.showAndWait();
                cenaField.clear();
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Niepoprawny typ danych");
                alert.setContentText("Wprowadz dane ponownie");
                alert.showAndWait();
                cenaField.clear();
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
    void PowrotButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeMain.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> availableChoices= null;//inicjalizacja choicebox nazwa surowca
        try {
            availableChoices = FXCollections.observableArrayList(MainApp.client.wyswietlLista1("Lekdolisty"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        choiceBox.setItems(availableChoices);


        choiceBox.setOnAction(e->{//inicjalizacja choicebox gramatura
            ObservableList<String> availableChoices1= null;
            try {
                availableChoices1 = FXCollections.observableArrayList(MainApp.client.wyswietldanedoListy("Lek",choiceBox.getValue()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            choiceBox1.setItems(availableChoices1);
        });
    }
}
