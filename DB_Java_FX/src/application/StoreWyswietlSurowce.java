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
 * The type Store wyswietl surowce.
 */
public class StoreWyswietlSurowce implements Initializable {
    /**
     * The Idsurowca column.
     */
    public TableColumn idsurowcaColumn;
    /**
     * The Nazwa column.
     */
    public TableColumn nazwaColumn;
    /**
     * The Pozycjanamagazynie column.
     */
    public TableColumn pozycjanamagazynieColumn;
    /**
     * The Data column.
     */
    public TableColumn dataColumn;
    /**
     * The Dostawca column.
     */
    public TableColumn dostawcaColumn;
    /**
     * The Wroc.
     */
    public Button wroc;
    /**
     * The Refresh 1.
     */
    public Button refresh1;
    /**
     * The Tabela.
     */
    public TableView tabela;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            List<String> lista=new ArrayList<String>();
            lista = MainApp.client.wyswietlLista1("Surowiec");
            tabela.setItems(getZamowienia(lista));
            idsurowcaColumn.setCellValueFactory(new PropertyValueFactory<>("id_surowca"));
            nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
            pozycjanamagazynieColumn.setCellValueFactory(new PropertyValueFactory<>("pozycja_na_magazynie"));
            dataColumn.setCellValueFactory(new PropertyValueFactory<>("data_przydatnosci"));
            dostawcaColumn.setCellValueFactory(new PropertyValueFactory<>("dostawca"));
        }catch(Exception e){

        }
        System.out.println("Otwarto okno Wyswietlania Surowcow");
    }

    /**
     * Refresh.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void refresh(ActionEvent actionEvent) throws IOException{
        List<String> lista=new ArrayList<String>();
        lista = MainApp.client.wyswietlLista1("Surowiec");
        tabela.setItems(getZamowienia(lista));
        idsurowcaColumn.setCellValueFactory(new PropertyValueFactory<>("id_surowca"));
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        pozycjanamagazynieColumn.setCellValueFactory(new PropertyValueFactory<>("pozycja_na_magazynie"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data_przydatnosci"));
        dostawcaColumn.setCellValueFactory(new PropertyValueFactory<>("dostawca"));
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
        control.switchScene("StoreMain.fxml");
    }

    /**
     * Gets zamowienia.
     *
     * @param lista the lista
     * @return the zamowienia
     */
    public ObservableList<SurowiecFX> getZamowienia(List<String> lista) {

        ObservableList<SurowiecFX> magazyn = FXCollections.observableArrayList();
        String str = "";
        for(int i=0;i<lista.size();i++) {
            str=(lista.get(i));

            String[] tokens = StringUtils.split(str);

            String id_surowca=tokens[0];
            String nazwa=tokens[1];
            String pozycja_na_magazynie=tokens[2];
            String data=tokens[3];
            String dostawca=tokens[4];

            magazyn.add(new SurowiecFX(id_surowca,nazwa,pozycja_na_magazynie,data,dostawca));
        }
        return magazyn;
    }
}
