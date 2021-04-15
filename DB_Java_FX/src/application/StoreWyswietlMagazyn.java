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
 * The type Store wyswietl magazyn.
 */
public class StoreWyswietlMagazyn implements Initializable {
    /**
     * The Pozycja column.
     */
    public TableColumn pozycjaColumn;
    /**
     * The Idsurowca column.
     */
    public TableColumn idsurowcaColumn;
    /**
     * The Nazwa column.
     */
    public TableColumn nazwaColumn;
    /**
     * The Ilosc column.
     */
    public TableColumn iloscColumn;
    /**
     * The Data column.
     */
    public TableColumn dataColumn;
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
            lista = MainApp.client.wyswietlLista1("Magazyn");
            tabela.setItems(getZamowienia(lista));
            pozycjaColumn.setCellValueFactory(new PropertyValueFactory<>("pozycja_na_magazynie"));
            idsurowcaColumn.setCellValueFactory(new PropertyValueFactory<>("id_surowca"));
            nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
            iloscColumn.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
            dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        }catch(Exception e){

        }
        System.out.println("Otwarto okno Wyswietlania Magazynu");
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
        lista = MainApp.client.wyswietlLista1("Magazyn");
        tabela.setItems(getZamowienia(lista));
        pozycjaColumn.setCellValueFactory(new PropertyValueFactory<>("pozycja_na_magazynie"));
        idsurowcaColumn.setCellValueFactory(new PropertyValueFactory<>("id_surowca"));
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        iloscColumn.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
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
    public ObservableList<MagazynFX> getZamowienia(List<String> lista) {

        ObservableList<MagazynFX> magazyn = FXCollections.observableArrayList();
        String str = "";
        for(int i=0;i<lista.size();i++) {
            str=(lista.get(i));

            String[] tokens = StringUtils.split(str);

            String pozycja_na_magazynie=tokens[0];
            String id_surowca=tokens[1];
            String nazwa=tokens[2];
            String ilosc=tokens[3];
            String data=tokens[4];

            magazyn.add(new MagazynFX(pozycja_na_magazynie,id_surowca,nazwa,ilosc,data));
        }
        return magazyn;
    }
}
