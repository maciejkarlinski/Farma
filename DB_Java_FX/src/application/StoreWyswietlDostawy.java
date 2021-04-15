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
 * The type Store wyswietl dostawy.
 */
public class StoreWyswietlDostawy implements Initializable {
    /**
     * The Iddostawy column.
     */
    public TableColumn iddostawyColumn;
    /**
     * The Data column.
     */
    public TableColumn dataColumn;
    /**
     * The Idsurowca column.
     */
    public TableColumn idsurowcaColumn;
    /**
     * The Nazwasurowca column.
     */
    public TableColumn nazwasurowcaColumn;
    /**
     * The Ilosc column.
     */
    public TableColumn iloscColumn;
    /**
     * The Nrserii columnn.
     */
    public TableColumn nrseriiColumnn;
    /**
     * The Iddostawcy columnn.
     */
    public TableColumn iddostawcyColumnn;
    /**
     * The Nazwadostawcy columnn.
     */
    public TableColumn nazwadostawcyColumnn;
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
            lista = MainApp.client.wyswietlLista1("Dostawa");
            tabela.setItems(getZamowienia(lista));
            iddostawyColumn.setCellValueFactory(new PropertyValueFactory<>("id_dostawy"));
            dataColumn.setCellValueFactory(new PropertyValueFactory<>("data_dostawy"));
            idsurowcaColumn.setCellValueFactory(new PropertyValueFactory<>("id_surowca"));
            nazwasurowcaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwasurowca"));
            iloscColumn.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
            nrseriiColumnn.setCellValueFactory(new PropertyValueFactory<>("nr_serii"));
            iddostawcyColumnn.setCellValueFactory(new PropertyValueFactory<>("id_dostawcy"));
            nazwadostawcyColumnn.setCellValueFactory(new PropertyValueFactory<>("nazwadostawcy"));
        }catch(Exception e){

        }
        System.out.println("Otwarto okno Wyswietlania Dostaw");

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
        lista = MainApp.client.wyswietlLista1("Dostawa");
        tabela.setItems(getZamowienia(lista));
        iddostawyColumn.setCellValueFactory(new PropertyValueFactory<>("id_dostawy"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data_dostawy"));
        idsurowcaColumn.setCellValueFactory(new PropertyValueFactory<>("id_surowca"));
        nazwasurowcaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwasurowca"));
        iloscColumn.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        nrseriiColumnn.setCellValueFactory(new PropertyValueFactory<>("nr_serii"));
        iddostawcyColumnn.setCellValueFactory(new PropertyValueFactory<>("id_dostawcy"));
        nazwadostawcyColumnn.setCellValueFactory(new PropertyValueFactory<>("nazwadostawcy"));
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
    public ObservableList<DostawaFX> getZamowienia(List<String> lista) {

        ObservableList<DostawaFX> magazyn = FXCollections.observableArrayList();
        String str = "";
        for(int i=0;i<lista.size();i++) {
            str=(lista.get(i));

            String[] tokens = StringUtils.split(str);

            String id_dostawy=tokens[0];
            String data_dostawy=tokens[1];
            String id_surowca=tokens[2];
            String nazwas=tokens[3];
            String ilosc=tokens[4];
            String nr_serii=tokens[5];
            String id_dostawcy=tokens[6];
            String nazwad=tokens[7];

            magazyn.add(new DostawaFX(id_dostawy, id_surowca, id_dostawcy, ilosc, nr_serii, data_dostawy,nazwas,nazwad));
        }
        return magazyn;
    }
}
