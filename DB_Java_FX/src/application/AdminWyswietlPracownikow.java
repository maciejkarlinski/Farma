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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Admin wyswietl pracownikow.
 */
public class AdminWyswietlPracownikow implements Initializable{

    /**
     * The Refresh.
     */
    @FXML
    public Button refresh;
    /**
     * The Wroc.
     */
    @FXML
    public Button wroc;
    /**
     * The Tabela.
     */
    @FXML
    public TableView tabela;
    /**
     * The Pracownik column.
     */
    @FXML
    public TableColumn pracownikColumn;
    /**
     * The Osoba column.
     */
    @FXML
    public TableColumn osobaColumn;
    /**
     * The Pieniazki column.
     */
    @FXML
    public TableColumn pieniazkiColumn;
    /**
     * The Stanowisko column.
     */
    @FXML
    public TableColumn stanowiskoColumn;
    /**
     * The Imie column.
     */
    @FXML
    public TableColumn imieColumn;
    /**
     * The Nazwisko column.
     */
    @FXML
    public TableColumn nazwiskoColumn;


    @Override
    public void initialize (URL location, ResourceBundle resources){
        System.out.println("Otwarto okno Wyswietlania Konta");

    }

    /**
     * Refresh.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void refresh(ActionEvent actionEvent) throws IOException {
        List<String> lista=new ArrayList<String>();
        lista = MainApp.client.wyswietlPracownikow();
        tabela.setItems(getPracownika(lista));
        pracownikColumn.setCellValueFactory(new PropertyValueFactory<>("idpracownika"));
        osobaColumn.setCellValueFactory(new PropertyValueFactory<>("idosoby"));
        imieColumn.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        pieniazkiColumn.setCellValueFactory(new PropertyValueFactory<>("wynagrodzenie"));
        stanowiskoColumn.setCellValueFactory(new PropertyValueFactory<>("stanowisko"));

    }

    /**
     * Wroc.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void wroc(ActionEvent actionEvent) throws IOException{
        ScreenController control = new ScreenController(this.wroc);
        control.switchScene("AdminMain.fxml");
    }

    /**
     * Gets pracownika.
     *
     * @param lista the lista
     * @return the pracownika
     */
    public ObservableList<PracownikFX> getPracownika(List<String> lista) {

        ObservableList<PracownikFX> pracownik = FXCollections.observableArrayList();
        String str = "";
        for(int i=0;i<lista.size();i++) {
            str=(lista.get(i));

            String[] tokens = StringUtils.split(str);

            String idpracownika=tokens[0];
            String idosoby=tokens[1];
            String imie=tokens[4];
            String nazwisko=tokens[5];
            String wynagrodzenie=tokens[2];
            String stanowisko=tokens[3];

            pracownik.add(new PracownikFX(idpracownika, idosoby,imie,nazwisko, wynagrodzenie, stanowisko));

        }
        return pracownik;
    }


}
