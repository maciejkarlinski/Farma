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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Office usun.
 */
public class OfficeUsun implements Initializable {

    /**
     * The Gramatura box.
     */
    @FXML
    public ChoiceBox<String> gramaturaBox;
    /**
     * The Oferta box.
     */
    @FXML
    public ChoiceBox<String> ofertaBox;
    /**
     * The Surowiec box.
     */
    @FXML
    public ChoiceBox<String> surowiecBox;
    /**
     * The Nazwa box.
     */
    @FXML
    public ComboBox<String> nazwaBox;

    /**
     * Usun lek button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void UsunLekButtonClick(ActionEvent event) throws IOException, InterruptedException {
        String nazwa=nazwaBox.getValue();
        String gramatura=gramaturaBox.getValue();
        if (nazwa==null||gramatura==null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();
        } else {
            String wynik = MainApp.client.usun1(nazwa, gramatura);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Komunikat");
            alert.setHeaderText(wynik);
            alert.showAndWait();
        }
    }

    /**
     * Usun oferte button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void UsunOferteButtonClick(ActionEvent event) throws IOException, InterruptedException {
        String oferta=ofertaBox.getValue();
        if (oferta==null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();
        } else {
            String s[]=oferta.split(" ");

            String wynik = MainApp.client.usun1("Oferta", s[0]);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Komunikat");
            alert.setHeaderText(wynik);
            alert.showAndWait();
        }
    }

    /**
     * Usun surowiec button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void UsunSurowiecButtonClick(ActionEvent event) throws IOException, InterruptedException {
        String surowiec=surowiecBox.getValue();
        if (surowiec==null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();
        } else {
            String s[]=surowiec.split(" ");

            String wynik = MainApp.client.usun1("Surowiec", s[0]);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Komunikat");
            alert.setHeaderText(wynik);
            alert.showAndWait();
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
        //pobranie listy nazw lekow i ich gramatur do usuwania
        ObservableList<String> availableChoices= null;//inicjalizacja choicebox nazwa surowca
        try {
            availableChoices = FXCollections.observableArrayList(MainApp.client.wyswietlLista1("Lekdolisty"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        nazwaBox.setItems(availableChoices);
        nazwaBox.setOnAction(e->{//inicjalizacja choicebox gramatura
            ObservableList<String> availableChoices1= null;
            try {
                availableChoices1 = FXCollections.observableArrayList(MainApp.client.wyswietldanedoListy("Lek",nazwaBox.getValue()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            gramaturaBox.setItems(availableChoices1);
        });

        //pobranie listy ofert do usuwania
        ObservableList<String> availableChoices1= null;//inicjalizacja choicebox nazwa surowca
        try {
            availableChoices1 = FXCollections.observableArrayList(MainApp.client.wyswietlLista1("Oferta"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ofertaBox.setItems(availableChoices1);

        //pobranie listy surowcow do usuwania
        ObservableList<String> availableChoices2= null;//inicjalizacja choicebox nazwa surowca
        try {
            availableChoices2 = FXCollections.observableArrayList(MainApp.client.wyswietlLista1("Surowiec"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        surowiecBox.setItems(availableChoices2);
    }
}
