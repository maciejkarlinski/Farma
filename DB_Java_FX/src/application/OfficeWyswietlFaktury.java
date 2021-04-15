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
 * The type Office wyswietl faktury.
 */
public class OfficeWyswietlFaktury implements Initializable {
    /**
     * The Idfaktury column.
     */
    public TableColumn idfakturyColumn;
    /**
     * The Nrfaktury column.
     */
    public TableColumn nrfakturyColumn;
    /**
     * The Idzamowienia column.
     */
    public TableColumn idzamowieniaColumn;
    /**
     * The Imie column.
     */
    public TableColumn imieColumn;
    /**
     * The Nazwisko column.
     */
    public TableColumn nazwiskoColumn;
    /**
     * The Nip column.
     */
    public TableColumn nipColumn;
    /**
     * The Email column.
     */
    public TableColumn emailColumn;
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
            List<String> lista = new ArrayList<String>();
            lista = MainApp.client.wyswietlLista1("Faktura");
            tabela.setItems(getZamowienia(lista));
            idfakturyColumn.setCellValueFactory(new PropertyValueFactory<>("id_faktury"));
            nrfakturyColumn.setCellValueFactory(new PropertyValueFactory<>("nr_faktury"));
            idzamowieniaColumn.setCellValueFactory(new PropertyValueFactory<>("id_zamowienia"));
            imieColumn.setCellValueFactory(new PropertyValueFactory<>("imie"));
            nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            nipColumn.setCellValueFactory(new PropertyValueFactory<>("nip"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        }catch(Exception e){

        }

        System.out.println("Otwarto okno Wyswietlania Faktur");
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
        lista = MainApp.client.wyswietlLista1("Faktura");
        tabela.setItems(getZamowienia(lista));
        idfakturyColumn.setCellValueFactory(new PropertyValueFactory<>("id_faktury"));
        nrfakturyColumn.setCellValueFactory(new PropertyValueFactory<>("nr_faktury"));
        idzamowieniaColumn.setCellValueFactory(new PropertyValueFactory<>("id_zamowienia"));
        imieColumn.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        nipColumn.setCellValueFactory(new PropertyValueFactory<>("nip"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
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
        control.switchScene("OfficeMain.fxml");
    }

    /**
     * Gets zamowienia.
     *
     * @param lista the lista
     * @return the zamowienia
     */
    public ObservableList<FakturaKlientFX> getZamowienia(List<String> lista) {

        ObservableList<FakturaKlientFX> magazyn = FXCollections.observableArrayList();
        String str = "";
        for(int i=0;i<lista.size();i++) {
            str=(lista.get(i));

            String[] tokens = StringUtils.split(str);

            String id_faktury=tokens[0];
            String nr_faktury=tokens[1];
            String id_zamowienia=tokens[2];
            String nip=tokens[3];
            String imie=tokens[4];
            String nazwisko=tokens[5];
            String email=tokens[6];
            magazyn.add(new FakturaKlientFX(id_faktury, nr_faktury, id_zamowienia, imie, nazwisko, nip, email));
        }
        return magazyn;
    }
}
