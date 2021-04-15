package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Klient dodaj zamowienie.
 */
public class KlientDodajZamowienie implements Initializable{
@FXML
private TableView<KoszykFx> tableKoszyk;
@FXML
private TableColumn<KoszykFx,String> columnIdKoszyka;
@FXML
private TableColumn<KoszykFx,String> columnIdOferty;
@FXML
private TableColumn<KoszykFx,String> columnIdKlienta;
@FXML
private TableColumn<KoszykFx,String> columnIlosc;
@FXML
private TableColumn<KoszykFx,String> columnKoszt;
@FXML
private Button buttonPotwierdz;
@FXML
private Button buttonAnuluj;
@FXML
private Button buttonPokazKoszyk;

    @Override
    public void initialize (URL location, ResourceBundle resources) {

    }

    /**
     * Button pokaz koszyk click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void buttonPokazKoszykClick(ActionEvent event) throws IOException{
        String koszyk=MainApp.client.wyswietlKoszyk();
        tableKoszyk.setItems(getKoszyk(koszyk));
        columnIdKoszyka.setCellValueFactory(new PropertyValueFactory<>("idkoszyka"));
        columnIdOferty.setCellValueFactory(new PropertyValueFactory<>("idoferty"));
        columnIdKlienta.setCellValueFactory(new PropertyValueFactory<>("idklienta"));
        columnIlosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        columnKoszt.setCellValueFactory(new PropertyValueFactory<>("koszt"));
    }

    /**
     * Button potwierdz click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void buttonPotwierdzClick(ActionEvent event) throws IOException{
        MainApp.client.dodajZamowienie();
        ScreenController control = new ScreenController(this.buttonPotwierdz);
        control.switchScene("KlientMain.fxml");
    }

    /**
     * Buttone anuluj click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void buttoneAnulujClick(ActionEvent event) throws  IOException{
        MainApp.client.usunKoszyk();
        ScreenController control = new ScreenController(this.buttonAnuluj);
        control.switchScene("KlientMain.fxml");
    }

    /**
     * Get koszyk observable list.
     *
     * @param temp the temp
     * @return the observable list
     */
    public  ObservableList<KoszykFx> getKoszyk(String temp){
        ObservableList<KoszykFx> koszyk = FXCollections.observableArrayList();
        String[] tokens = StringUtils.split(temp);
        koszyk.add(new KoszykFx(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]));
        return koszyk;
    }
}
