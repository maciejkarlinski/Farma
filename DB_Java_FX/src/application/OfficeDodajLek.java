package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Office dodaj lek.
 */
public class OfficeDodajLek implements Initializable {

    /**
     * The Nazwa field.
     */
    @FXML
    public TextField nazwaField;

    /**
     * The Gramatura field.
     */
    @FXML
    public TextField gramaturaField;

    /**
     * Dodaj lek button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void DodajLekButtonClick(ActionEvent event) throws IOException, InterruptedException {
        String nazwa=nazwaField.getText();
        String gramatura=gramaturaField.getText();
        if (nazwa.equals("") || gramatura.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();
            gramaturaField.clear();
            nazwaField.clear();
        } else {
            try{
                Integer.parseInt(gramatura);
                String wynik = MainApp.client.dodajLek(nazwa, gramatura);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Komunikat");
                alert.setHeaderText(wynik);
                alert.showAndWait();
                gramaturaField.clear();
                nazwaField.clear();
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Niepoprawny typ danych");
                alert.setContentText("Wprowadz dane ponownie");
                alert.showAndWait();
                gramaturaField.clear();
                nazwaField.clear();
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

        System.out.println("Otwarto okno biura");
    }
}
