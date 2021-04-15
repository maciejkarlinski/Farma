package Server;

import baza.*;
import klasy.*;
import klasy_glowne.Osoba;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The type Handler thread.
 */
public class HandlerThread extends Thread {//wątek do obsługi klienta
    /**
     * The Baza.
     */
    Baza_danych baza;//obiekt dostepu do bazy
    private final Socket clientSocket;//gniazdo klienta
    private final ServerColections serverColections;//gniazdo serwera
    private String login = null;//login
    private OutputStream outputStream;//do pisania
    private InputStream inputStream;

    /**
     * Instantiates a new Handler thread.
     *
     * @param serverColections the server colections
     * @param clientSocket     the client socket
     */
    public HandlerThread(ServerColections serverColections, Socket clientSocket) { //przekazywanie instancji serverColection do kazdego Workera
        this.serverColections = serverColections;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {//metoda run watku
        try {
            handleClientSocket();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void handleClientSocket() throws IOException, InterruptedException {//obsługa klienta
        this.inputStream = clientSocket.getInputStream();// obiekt do czytania danych z klienta
        this.outputStream = clientSocket.getOutputStream();// obiekt do wysyłania danych do klienta

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));//czytanie linijka po linijce
        String line;//zmienna do przechowania

        while (true) {//wczytywanie
            line = reader.readLine();
            String[] tokens = StringUtils.split(line);//obiekt do przechowywania wczytanych linii
            if (tokens != null && tokens.length > 0) {//jezeli przesłano jakiekolwiek dane
                String cmd = tokens[0];//pobierz pierwsze slowo
                if ("logoff".equals(cmd)) { //jesli napisales quit lub logoff to koniec czytania
                    break;
                } else if ("quit".equalsIgnoreCase(cmd)) { //login
                    clientSocket.close();
                    //wymuszone zamkniecie
                } else if ("login".equalsIgnoreCase(cmd)) { //login
                    handleLogin(outputStream, tokens);//obsluz logowanie
                } else if ("reg".equalsIgnoreCase(cmd)) { //registration
                    handleRegistration(outputStream, tokens);//obsluz rejstracje
                }else if ("text".equalsIgnoreCase(cmd)) { //registration
                    handleText(outputStream, tokens);//obsluz rejstracje
                }else if ("stanowisko".equalsIgnoreCase(cmd)) { //registration
                    handleStanowisko(outputStream, tokens);//obsluz rejstracje
                } else if ("wyswietl".equalsIgnoreCase(cmd)) {
                    handleWyswietl(outputStream, tokens);
                }else if ("zmienhaslo".equalsIgnoreCase(cmd)) {
                    handleZmianaHasla(outputStream, tokens);
                }else if ("recoverhaslo".equalsIgnoreCase(cmd)) {
                    handleRecoveryHasla(outputStream, tokens);
                }
                //=====================KLIENT===================================
                else if ("oferta".equalsIgnoreCase(cmd)) {
                    oferty(outputStream);
                } else if ("lek".equalsIgnoreCase(cmd)) {
                    lek(outputStream,tokens);
                } else if ("dodajDoKoszyka".equalsIgnoreCase(cmd)) {
                    dodajDoKoszyka(outputStream,tokens);
                } else if ("zmienHasloKlienta".equalsIgnoreCase(cmd)) {
                    zmianaHaslaKlienta(outputStream,tokens);
                } else if ("usunKontoKlienta".equalsIgnoreCase(cmd)) {
                    usunKlienta(outputStream);
                } else if ("pokazZamowienia".equalsIgnoreCase(cmd)) {
                    pokazZamowienia(outputStream);
                } else if("dodajZamowienie".equalsIgnoreCase(cmd)){
                    dodajZamowienie(outputStream);
                }else  if("usunKoszyk".equalsIgnoreCase(cmd)) {
                    usunKoszyk();
                }else if("wyswietlKoszyk".equalsIgnoreCase(cmd)){
                    wyswietlKoszyk(outputStream);
                }else if("getSzczegoloweZamowienie".equalsIgnoreCase(cmd)){
                    szczegoloweZamowienie(outputStream,tokens);
                }

                //=========================Magazynier====================================
                else if ("aktualizujMagazyn".equalsIgnoreCase(cmd)) {
                    handleaktualizujMagazyn(outputStream, tokens);
                } else if ("dodajDostawe".equalsIgnoreCase(cmd)) {
                    handledodajDostawe(outputStream, tokens);
                }

                //=======================Biuro=======================================  TODO BIURO + patryk zmiana hasła

                else if ("wystawFakture".equalsIgnoreCase(cmd)) {//faktury
                    handlewystawFakture(outputStream, tokens);
                } else if ("wyswietl".equalsIgnoreCase(cmd)) {//wyswietla faktury/surowce/leki/oferty
                    handleWyswietl(outputStream, tokens);
                } else if ("dodajLek".equalsIgnoreCase(cmd)) {
                    handledodajLek(outputStream, tokens);
                } else if ("dodajSurowiec".equalsIgnoreCase(cmd)) {
                    handledodajSurowiec(outputStream, tokens);
                } else if ("dodajOferte".equalsIgnoreCase(cmd)) {
                    handledodajOferte(outputStream, tokens);
                } else if ("usun".equalsIgnoreCase(cmd)) {
                    handleUsun(outputStream,tokens);
                } else if ("wyswietl1".equalsIgnoreCase(cmd)) {
                    handleWyswietl1(outputStream,tokens);
                } else if ("wyswietl2".equalsIgnoreCase(cmd)) {
                    handleWyswietlPomocniczedoListy(outputStream,tokens);
                } else if ("usuncalosc".equalsIgnoreCase(cmd)) {
                    handleUsun1(outputStream,tokens);
                }
/*
                //=====================Produkcja===================================  TODO PRODUKCJA
                */else if ("zmienSZ".equalsIgnoreCase(cmd)) {//pracownik moze zmienic stan zamowienia
                    handleZmienStanZamowienia(outputStream,tokens);
                }

                //=====================ADMIN===================================
                else if ("wyswietlKonta".equalsIgnoreCase(cmd)) {
                    handleWyswietl(outputStream, tokens);
                }  else if ("zmienDRZ".equalsIgnoreCase(cmd)) {//zarzadzanie przez admina
                    handleZmienDateRealizacjiZamowienia(outputStream, tokens);
                } else if ("zmienWyplate".equalsIgnoreCase(cmd)) {
                    handleZmienWyplate(outputStream, tokens);
                } else if ("zablokujKonto".equalsIgnoreCase(cmd)) {
                    handlezablokujOdblokujKonto(outputStream, tokens,1);
                } else if ("odblokujKonto".equalsIgnoreCase(cmd)) {
                    handlezablokujOdblokujKonto(outputStream, tokens,0);
                } else if ("dodajPracownika".equalsIgnoreCase(cmd)) {//dodawanie przez admina
                    handleDodajPracownika(outputStream, tokens);
                } else if ("dodajDostawce".equalsIgnoreCase(cmd)) {
                    handleDodajDostawce(outputStream, tokens);
                }else if("wyswietlPracownikow".equalsIgnoreCase(cmd)){
                    wyswietlPracownikow(outputStream);
                }
                else if("wyswietlKlientow".equalsIgnoreCase(cmd)){
                    wyswietlKlientow(outputStream);
                }
                //=============================================================

                     else {
                        String msg = "Nieznana komenda " + cmd + "\n"; //inne to nieznane
                        outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                        outputStream.flush();

                }}else{
                    String msg = "Brak danych\n"; //inne to nieznane
                    outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                    outputStream.flush();
                    }
            }
            if (clientSocket != null) {
                clientSocket.close();//zamknij gniazdo klienta jesli jeszcze nie zamkniete
            }
}

    private void handleZmienStanZamowienia(OutputStream outputStream, String[] tokens)throws IOException {
        baza=new Baza_danych();
        try {
            if (tokens.length == 3) {
                String IdZamowienia = tokens[1];
                int idZam = Integer.parseInt(IdZamowienia);
                String Stan = tokens[2];
                int stan = Integer.parseInt(Stan);

                Zamowienie zam = null;
                zam = baza.getZamowienie(idZam);
                if (zam != null) {
                    zam.setStan(stan);
                    if (baza.insert("update zamowienie set stan=" + stan + " where id_zamowienia=" + idZam + "")) {
                        String msg = "Tak\n";
                        outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                        outputStream.flush();

                    } else {
                        String msg = "Nie\n";
                        outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                        outputStream.flush();
                    }

                } else {
                    String msg = "Nie ma\n";
                    outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                    outputStream.flush();
                }

                baza.closeConnection();
            }
        }catch (Exception e){
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
    }
    private void handleRecoveryHasla(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        if(tokens.length == 4){
            String email = tokens[1];
            String imie = tokens[2];
            String nazwisko = tokens[3];
            String ID = baza.getSingle("select haslo from Osoba where e_mail='" + email + "' and imie='" + imie + "' and nazwisko='" + nazwisko + "';");
            ID=baza.odszyfruj(ID);
            String msg = ID+"\n";
            System.out.println(msg);
                outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                outputStream.flush();

        }
        baza.closeConnection();
    }
    private void handleZmienDateRealizacjiZamowienia(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        try {
            if (tokens.length == 3) {
                String idZamowienia = tokens[1];
                int id = Integer.parseInt(idZamowienia);
                String data = tokens[2];

                Zamowienie zam = baza.getZamowienie(id);
                if (zam != null) {
                    zam.setData_realizacji(data);
                    if (baza.insert("update zamowienie set data_realizacji='" + data + "' where id_zamowienia=" + id + ";")) {
                        String msg = "Tak\n"; //inne to nieznane
                        outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                        outputStream.flush();
                    } else {
                        String msg = "Err\n"; //inne to nieznane
                        outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                        outputStream.flush();
                    }
                } else {
                    String msg = "Nie ma\n"; //inne to nieznane
                    outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                    outputStream.flush();
                }
            }
        }catch (Exception e){
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }
    private void handleRegistration(OutputStream outputStream, String[] tokens) throws IOException{ //obsluga rejestracji klienta
        baza=new Baza_danych();
        if (tokens.length == 8) {//czy polecenie zawiera komende reg, login klienta i haslo klienta
            String imie = tokens[1];
            String nazwisko = tokens[2];
            String email = tokens[3];
            String x = tokens[4];
            int nrtel = Integer.parseInt(x);
            String c = tokens[5];
            int pesel = Integer.parseInt(c);
            String v = tokens[6];
            int nip = Integer.parseInt(v);
            String haslo = tokens[7];
            haslo=baza.zaszyfruj(haslo);

            if(!baza.insertKlient(imie, nazwisko, email, nrtel, pesel,nip,haslo)) {
                String msg = "NIE\n";//wiadomosc
                // przeslij(msg);//przeslij potwierdzenie zalogowania
                outputStream.write(msg.getBytes());//przeslij niepotwierdzenie zarejstrowania
                outputStream.flush();
            }
            else{
                //przeslij("To jest Twoje id : "+baza.getIdOsoba(email));
                String msg = "TAK\n";//wiadomosc
                // przeslij(msg);//przeslij potwierdzenie zalogowania
                outputStream.write(msg.getBytes());//przeslij potwierdzenie zarejstrowania
                outputStream.flush();
            }
        }
        baza.closeConnection();
    }
    private void handleText(OutputStream outputStream, String[] tokens) throws IOException{ //obsluga rejestracji klienta
        baza=new Baza_danych();
        if (tokens.length == 2) {//czy polecenie zawiera komende reg, login klienta i haslo klienta
            String email = tokens[1];



        }
        baza.closeConnection();
    }
    private void handleLogin(OutputStream outputStream, String[] tokens) throws IOException {//obsluga logowania klienta
        baza=new Baza_danych();
        if (tokens.length == 3) {//czy polecenie zawiera komende login, login klienta i haslo klienta
            String login = tokens[1];
            String password = tokens[2];

            if(baza.logowanie(login,password)){//jezeli w bazie jest taki osobnik
                String msg = "Zalogowano\n";//wiadomosc
               // przeslij(msg);//przeslij potwierdzenie zalogowania
                outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                outputStream.flush();
                this.login = login;
                System.out.println("Zalogowal sie poprawnie: " + login+ "\n");//pomocniczo w konsoli informacja kto sie zalogowal

            } else {//jezeli w bazie takiego osobnika nie ma to blad logowania
                String msg = "error login\n";
              //  przeslij(msg);//wyslij klientowi informacje o bledzie
                outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                outputStream.flush();
                System.err.println("Nieudane logowanie: " + login);
            }
        }

        baza.closeConnection();
    }
    private void handleStanowisko(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        if (tokens.length == 2) {//czy polecenie zawiera komende login, login klienta i haslo klienta
            String email = tokens[1];
            String ID = baza.getSingle("select id_osoby from Osoba where e_mail='"+email+"';");
            String wynik=baza.getSingle("select stanowisko from Pracownik where id_osoby='"+ID+"';");
            String stanowisko;
            if(wynik==null) {
                stanowisko="klient\n";
            }else {
                stanowisko=wynik + "\n";
            }

            System.out.println(stanowisko);
            outputStream.flush();
            outputStream.write(stanowisko.getBytes());//przeslij potwierdzenie zalogowania
            outputStream.flush();

            } else {//jezeli w bazie takiego osobnika nie ma to blad logowania
            String msg = "error\n";
            //  przeslij(msg);//wyslij klientowi informacje o bledzie
            outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
            outputStream.flush();
            System.err.println("error");
            }

        baza.closeConnection();
    }
    private void handleWyswietl(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        if(tokens.length==2){
            List<String>lista=baza.getMulti(tokens[1]);
            String str="";
            int x = lista.size();
            String roz = String.valueOf(x);
            roz = roz +"\n";
            outputStream.write(roz.getBytes());
            outputStream.flush();

            if(lista!=null) {
                for(int i=0;i<lista.size();i++) {
                    str+=(lista.get(i))+"\n";
                }
                outputStream.write(str.getBytes());
                outputStream.flush();
            }
            else outputStream.write("Brak rekordow\n".getBytes());
        }
        else{
            outputStream.write("Brak specyfikacji\n".getBytes());
        }
        baza.closeConnection();
    }

    private void handleWyswietl1(OutputStream outputStream, String[] tokens) throws IOException{//fcja pomocnicza do wypisywania na liste rozwijalną
        baza=new Baza_danych();
        if(tokens.length==2){
            String zapytanie="";
            int ilekolumn=0;
            if(tokens[1].equals("Oferta")){
                zapytanie="select id_oferty,nazwa,cena,gramatura from Oferta as ofe inner join lek on ofe.id_leku=lek.id_leku";
                ilekolumn=4;
            }
            else if(tokens[1].equals("Surowiec")){
                zapytanie="select s.id_surowca,s.nazwa,pozycja_na_magazynie,data_przydatnosci,d.nazwa from surowiec as s \n" +
                        "inner join dostawca as d on s.id_dostawcy=d.id_dostawcy;";
                ilekolumn=5;
            }
            else if(tokens[1].equals("Faktura")){
                zapytanie="select id_faktury,nr_faktury,id_zamowienia,NIP,imie,nazwisko,e_mail from faktura_klient as fk \n" +
                        "inner join klient as k on fk.id_klienta=k.id_klienta \n" +
                        "inner join osoba as o on o.id_osoby=k.id_osoby;";
                ilekolumn=7;
            }
            else if(tokens[1].equals("Magazyn")){
                zapytanie="select s.pozycja_na_magazynie,s.id_surowca,nazwa,ilosc,data_przydatnosci from magazyn as m inner join surowiec as s on m.id_surowca=s.id_surowca;";
                ilekolumn=5;
            }
            else if(tokens[1].equals("Dostawa")){
                zapytanie="select id_dostawy,data_dostawy,s.id_surowca,s.nazwa,ilosc,nr_serii,doss.id_dostawcy,doss.nazwa from dostawa as dos \n" +
                        "inner join dostawca as doss on dos.id_dostawcy=doss.id_dostawcy \n" +
                        "inner join surowiec as s on s.id_surowca=dos.id_surowca;";
                ilekolumn=8;
            }
            else if(tokens[1].equals("Lekdolisty")){
                zapytanie="select distinct nazwa from lek;";
                ilekolumn=1;
            }
            else if(tokens[1].equals("Dostawcadolisty")){
                zapytanie="select nazwa from Dostawca;";
                ilekolumn=1;
            }
            else if(tokens[1].equals("Surowiecdolisty")){//pobranie surowców które jeszcze nie mają pozycji
                zapytanie="select id_surowca,nazwa from Surowiec where pozycja_na_magazynie=0;";
                ilekolumn=2;
            }
            else if(tokens[1].equals("Surowiecdolisty1")){//pobranie surowców które są na magazynie
                zapytanie="select id_surowca,nazwa from Surowiec where pozycja_na_magazynie!=0;";
                ilekolumn=2;
            }
            else if(tokens[1].equals("Klientdolisty")){//pobranie surowców które są na magazynie
                zapytanie="select id_klienta,imie,nazwisko from Osoba as os inner join Klient as kl on os.id_osoby=kl.id_osoby;";
                ilekolumn=3;
            }
            else{
                outputStream.write("Brak specyfikacji\n".getBytes());
                return;
            }
            List<String>lista=baza.getMulti1(zapytanie,ilekolumn);
            String str="";
            int x = lista.size();
            String roz = String.valueOf(x);
            roz = roz +"\n";
            outputStream.write(roz.getBytes());
            outputStream.flush();
            if(lista!=null) {
                for(int i=0;i<lista.size();i++) {
                    str+=(lista.get(i))+"\n";
                }
                outputStream.write(str.getBytes());
                outputStream.flush();
            }
            else outputStream.write("Brak rekordow\n".getBytes());
        }
        else{
            outputStream.write("Brak specyfikacji\n".getBytes());
        }
        baza.closeConnection();
    }
    private void handleWyswietlPomocniczedoListy(OutputStream outputStream, String[] tokens) throws IOException{//fcja pomocnicza do wypisywania na liste rozwijalną
        baza=new Baza_danych();
        if(tokens.length==3){
            String zapytanie="";
            int ilekolumn=0;
            if(tokens[1].equals("Lek")){//pobiera gramatury lekow do dodawania nowej oferty
                zapytanie="select gramatura from Lek where nazwa='"+tokens[2]+"';";
                ilekolumn=1;
            }
            else if(tokens[1].equals("Zamowienie")){//pobiera id zamowienia danego klienta do wystawiania faktury
                int id_klienta=Integer.parseInt(tokens[2]);
                zapytanie="select id_zamowienia from Zamowienie as z \n" +
                        "inner join klient as kli on z.id_klienta=kli.id_klienta where kli.id_klienta="+id_klienta+";";
                ilekolumn=1;
            }
            else{
                outputStream.write("Brak specyfikacji\n".getBytes());
                return;
            }
            List<String>lista=baza.getMulti1(zapytanie,ilekolumn);
            String str="";
            int x = lista.size();
            String roz = String.valueOf(x);
            roz = roz +"\n";
            outputStream.write(roz.getBytes());
            outputStream.flush();
            if(lista!=null) {
                for(int i=0;i<lista.size();i++) {
                    str+=(lista.get(i))+"\n";
                }
                outputStream.write(str.getBytes());
                outputStream.flush();
            }
            else outputStream.write("Brak rekordow\n".getBytes());
        }
        else{
            outputStream.write("Brak specyfikacji\n".getBytes());
        }
        baza.closeConnection();
    }

    private void handleUsun(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        try {
            if (tokens.length == 3) {
                String tabela = tokens[1];
                int id = Integer.parseInt(tokens[2]);
                if (tabela.equals("Pracownik")) {
                    Pracownik prac = baza.getPracownik(id);
                    if (prac != null) {
                        String ID = baza.getSingle("select id_osoby from Pracownik where id_pracownika='" + id + "';");
                        int idosoby = Integer.parseInt(ID);
                        if (baza.delete(tabela, id) && baza.delete("Osoba", idosoby)) tabela = "Poprawnie usunieto";
                        else tabela = "Blad przy usuwaniu";
                    } else tabela = "Nie ma takiego pracownika";

                } else if (baza.checkIfTableExist(tabela, id)) {
                    if (baza.delete(tabela, id)) {
                        tabela = "Poprawnie usunieto";
                    } else tabela = "Blad przy usuwaniu";

                } else {
                    tabela = "Nie istnieje";
                }
                tabela += "\n";
                outputStream.write(tabela.getBytes());
            } else {
                outputStream.write("Brak specyfikacji\n".getBytes());
            }
        }catch (Exception e) {
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }

        baza.closeConnection();
    }



    private void handleUsun1(OutputStream outputStream, String[] tokens) throws IOException {
            baza = new Baza_danych();
            try{
            if (tokens.length == 3) {
                String tabela = tokens[1];
                tokens[2] = tokens[2].replaceAll(" ", "");
                int id = Integer.parseInt(tokens[2]);
                if (tabela.equals("Surowiec")) {//usuwanie surowca
                    if (baza.find("select * from surowiec where id_surowca=" + id + ";") != 0) {
                        int pozycja = Integer.parseInt(baza.getSingle("select pozycja_na_magazynie from Surowiec where id_surowca=" + id + ";"));
                        if (pozycja == 0) {//usuwamy surowiec którego jeszcze nie ma na magazynie
                            if (baza.delete(tabela, id)) outputStream.write("Poprawnie usunięto surowiec\n".getBytes());
                            else outputStream.write("Blad przy usuwaniu\n".getBytes());
                        } else {//usuwamy surowiec przyjęty na magazynie
                            String zapytanie1 = "delete from Magazyn where id_surowca=" + id + ";";
                            String zapytanie2 = "delete from Dostawa where id_surowca=" + id + ";";
                            String zapytanie3 = "delete from Surowiec where id_surowca=" + id + ";";
                            if (baza.update(zapytanie1) && baza.update(zapytanie2) && baza.update(zapytanie3))
                                outputStream.write("Poprawnie usunięto surowiec\n".getBytes());
                            else outputStream.write("Blad przy usuwaniu\n".getBytes());
                        }
                    } else outputStream.write("Takiego surowca nie ma w bazie\n".getBytes());

                } else if (tabela.equals("Oferta")) {//usuwanie oferty
                    List<String> listakoszykow;
                    List<String> listazamowien;
                    List<String> listafaktur;
                    if (baza.find("select * from oferta where id_oferty=" + id + ";") != 0) {//sprawdza czy taka oferta istnieje
                        //usuwamy faktury na dane oferte
                        String zapytanie = "select fk.id_faktury from Oferta as ofe " +
                                "inner join koszyk as ko on ofe.id_oferty=ko.id_oferty " +
                                "inner join zamowienie as zam on zam.id_koszyka=ko.id_koszyka " +
                                "inner join faktura_klient as fk on fk.id_zamowienia=zam.id_zamowienia;";
                        listafaktur = baza.getMulti1(zapytanie, 1);
                        for (int i = 0; i < listafaktur.size(); i++) {//usuwanie fakur na daną oferte
                            String s = listafaktur.get(i);
                            s = s.replaceAll(" ", "");
                            listafaktur.set(i, s);
                            zapytanie = "delete from Faktura_klient where id_faktury=" + Integer.parseInt(listafaktur.get(i)) + ";";
                            baza.update(zapytanie);
                        }

                        //usuwamy zamowienia na dane oferte
                        zapytanie = "select zam.id_zamowienia from Oferta as ofe " +
                                "inner join koszyk as ko on ofe.id_oferty=ko.id_oferty " +
                                "inner join zamowienie as zam on zam.id_koszyka=ko.id_koszyka;";
                        listazamowien = baza.getMulti1(zapytanie, 1);
                        for (int i = 0; i < listazamowien.size(); i++) {//usuwanie zamowien na daną oferte
                            String s = listazamowien.get(i);
                            s = s.replaceAll(" ", "");
                            listazamowien.set(i, s);
                            zapytanie = "delete from Zamowienie where id_zamowienia=" + Integer.parseInt(listazamowien.get(i)) + ";";
                            baza.update(zapytanie);
                        }

                        //usuwamy koszyki na dane oferte
                        zapytanie = "select ko.id_koszyka from Oferta as ofe " +
                                "inner join koszyk as ko on ofe.id_oferty=ko.id_oferty";
                        listakoszykow = baza.getMulti1(zapytanie, 1);
                        for (int i = 0; i < listakoszykow.size(); i++) {//usuwanie koszykow na daną oferte
                            String s = listakoszykow.get(i);
                            s = s.replaceAll(" ", "");
                            listakoszykow.set(i, s);
                            zapytanie = "delete from Koszyk where id_koszyka=" + Integer.parseInt(listakoszykow.get(i)) + ";";
                            baza.update(zapytanie);
                        }

                        //usuwamy dane oferte
                        zapytanie = "delete from Oferta where id_oferty=" + id + ";";//usuwanie oferty z bazy
                        if (baza.update(zapytanie)) outputStream.write("Poprawnie usunięto oferte\n".getBytes());
                        else outputStream.write("Blad przy usuwaniu\n".getBytes());
                    } else outputStream.write("Takiej oferty nie ma w bazie\n".getBytes());
                } else {
                    String nazwa = tabela;
                    int gramatura = id;
                    int idleku = baza.find("select * from lek where nazwa='" + nazwa + "' and gramatura=" + gramatura + ";");
                    System.out.println(idleku);
                    if (idleku != 0) {//sprawdzamy czy taki lek jest
                        if (baza.find("select * from oferta where id_leku=" + idleku + ";") != 0) {//sprawdzamy czy na podany lek sa w bazie oferty
                            outputStream.write("Uwaga! Na wybrany lek wciąż są dostępne oferty! Usun najpierw oferty!\n".getBytes());
                        } else {
                            if (baza.delete("Lek", idleku)) outputStream.write("Poprawnie usunieto lek\n".getBytes());
                            else outputStream.write("Blad przy usuwaniu\n".getBytes());
                        }
                    } else {//brak leku
                        outputStream.write("Takiego leku nie ma w bazie\n".getBytes());
                    }
                }
            } else {
                outputStream.write("Brak specyfikacji\n".getBytes());
            }
        }catch(Exception e)
        {
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }


    /**
     * Handledodaj lek.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void handledodajLek(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        try {
            if (tokens.length == 3) {
                String nazwa = tokens[1];
                int gramatura = Integer.parseInt(tokens[2]);
                String zapytanie;
                if (baza.find("select * from Lek where nazwa='" + nazwa + "' and gramatura=" + gramatura + ";") == 0) {
                    zapytanie = "insert into Lek values (NULL,'" + nazwa + "'," + gramatura + ");";
                    if (baza.insert(zapytanie)) outputStream.write("Dodano nowy lek\n".getBytes());
                    else {
                        outputStream.write("Problem z dodaniem leku\n".getBytes());
                    }
                } else outputStream.write("Taki lek juz istnieje\n".getBytes());
            } else {
                outputStream.write("Brak specyfikacji\n".getBytes());
            }
        }catch (Exception e){
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }

    /**
     * Handledodaj oferte.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void handledodajOferte(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        try {
            if (tokens.length == 4) {
                String nazwa = tokens[1];
                double cena = Double.parseDouble(tokens[2]);
                int gramatura = Integer.parseInt(tokens[3]);
                String zapytanie;
                if (baza.find("select * from Oferta where id_leku=(select id_leku from Lek where nazwa='" + nazwa + "' and gramatura=" + gramatura + ");") == 0) {
                    zapytanie = "insert into Oferta VALUES(NULL,(select id_leku from Lek where nazwa='" + nazwa + "' and gramatura=" + gramatura + ")," + cena + ");";
                    if (baza.insert(zapytanie)) outputStream.write("Dodano nowa oferte\n".getBytes());
                    else {
                        outputStream.write("Problem z dodaniem oferty\n".getBytes());
                    }
                } else outputStream.write("Taka oferta juz istnieje\n".getBytes());
            } else {
                outputStream.write("Brak specyfikacji\n".getBytes());
            }
        }catch (Exception e){
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();

        }
        baza.closeConnection();
    }

    /**
     * Handledodaj surowiec.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void handledodajSurowiec(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        System.out.println(tokens);
        try {
            if (tokens.length == 4) {
                String nazwa = tokens[1];
                String dostawca = tokens[2];
                String data = tokens[3];
                String zapytanie;
                zapytanie = "insert into Surowiec VALUES(NULL,'" + nazwa + "',(select id_dostawcy from dostawca where nazwa='" + dostawca + "'),0,'" + data + "');";
                if (baza.insert(zapytanie)) outputStream.write("Dodano nowy surowiec\n".getBytes());
                else {
                    outputStream.write("Problem z dodaniem surowca\n".getBytes());
                }
            } else {
                outputStream.write("Brak specyfikacji\n".getBytes());
            }
        }catch (Exception e){
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }

    /**
     * Handlewystaw fakture.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void handlewystawFakture(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        if(tokens.length==4){
            String nrfaktury=tokens[1];
            int idklienta=Integer.parseInt(tokens[2]);
            int idzamowienia=Integer.parseInt(tokens[3]);
            String zapytanie;
            if(baza.find("select * from Faktura_klient where nr_faktury="+nrfaktury+";")==0) {
                zapytanie = "insert into Faktura_klient VALUES(NULL,'" + nrfaktury + "'," + idklienta + "," + idzamowienia + ");";
                if (baza.insert(zapytanie)) outputStream.write("Dodano nową fakturę\n".getBytes());
                else {
                    outputStream.write("Problem z dodaniem faktury\n".getBytes());
                }
            }
            else outputStream.write("Faktura o podanym numerze juz istnieje\n".getBytes());
        }
        else{
            outputStream.write("Brak specyfikacji\n".getBytes());
        }
        baza.closeConnection();
    }

    /**
     * Handledodaj dostawe.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void handledodajDostawe(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        try {
            if (tokens.length == 7) {
                int idsurowca = Integer.parseInt(tokens[1]);
                int ilosc = Integer.parseInt(tokens[2]);
                int nrserii = Integer.parseInt(tokens[3]);
                String datadostawy = tokens[4];
                String dostawca = tokens[5];
                int pozycja = Integer.parseInt(tokens[6]);

                String zapytanie, zapytanie1, zapytanie2;
                if (baza.find("select * from Dostawa where nr_serii=" + nrserii + ";") == 0) {
                    if (baza.find("select * from Magazyn where pozycja_na_magazynie=" + pozycja + ";") == 0) {
                        zapytanie = "insert into Dostawa VALUES(NULL,'" + datadostawy + "',(select id_dostawcy from dostawca where nazwa='" + dostawca + "')," + idsurowca + "," + ilosc + "," + nrserii + ");";
                        zapytanie1 = "insert into Magazyn VALUES(" + pozycja + "," + idsurowca + "," + ilosc + ");";
                        zapytanie2 = "update Surowiec set pozycja_na_magazynie=" + pozycja + " where id_surowca=" + idsurowca + ";";
                        if (baza.insert(zapytanie) && baza.insert(zapytanie1) && baza.update(zapytanie2))
                            outputStream.write("Dodano nową dostawe\n".getBytes());
                        else {
                            outputStream.write("Problem z dodaniem dostawy\n".getBytes());
                        }
                    } else outputStream.write("Ta pozycja jest juz zajęta\n".getBytes());
                } else outputStream.write("Dostawa juz istnieje\n".getBytes());
            } else {
                outputStream.write("Brak specyfikacji\n".getBytes());
            }
        }catch (Exception e){
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }

    /**
     * Handleaktualizuj magazyn.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void handleaktualizujMagazyn(OutputStream outputStream, String[] tokens) throws IOException{
        baza=new Baza_danych();
        if(tokens.length==4){
            int idsurowca=Integer.parseInt(tokens[1]);
            int ilosc=Integer.parseInt(tokens[2]);
            int pozycja=Integer.parseInt(tokens[3]);
            String zapytanie,zapytanie1;
            if(baza.find("select * from Magazyn where id_surowca="+idsurowca+";")!=0) {
                if(baza.find("select * from Magazyn where pozycja_na_magazynie="+pozycja+";")==0) {
                    zapytanie = "update Magazyn set ilosc=" + ilosc + ", pozycja_na_magazynie=" + pozycja + " where id_surowca=" + idsurowca + ";";
                    zapytanie1 = "update Surowiec set pozycja_na_magazynie=" + pozycja + " where id_surowca=" + idsurowca + ";";
                    if (baza.update(zapytanie) && baza.update(zapytanie1))
                        outputStream.write("Zaktualizowano pozycję\n".getBytes());
                    else {
                        outputStream.write("Problem z aktualizacją\n".getBytes());
                    }
                }
                else outputStream.write("Ta pozycja jest juz zajęta\n".getBytes());
            }
            else outputStream.write("Brak surowca o podanym id w bazie\n".getBytes());
        }
        else{
            outputStream.write("Brak specyfikacji\n".getBytes());
        }
        baza.closeConnection();
    }
    private void handlezablokujOdblokujKonto(OutputStream outputStream, String[] tokens, int i)throws IOException {
        baza=new Baza_danych();
        try {
            String email = tokens[1];
            String ID = baza.getSingle("select id_osoby from Osoba where e_mail='" + email + "';");
            int x = Integer.parseInt(ID);
            Osoba os = baza.getOsoba(x);//pobranie danych wskazanej osoby/konta osoby
            if (i == 1) {//zablokuj
                os.setStatus_konta(1);//zablokowany
            } else {
                os.setStatus_konta(0);//odblokowany
            }
            if (baza.update("Osoba", os)) {
                String msg = "Konto uaktualnione\n"; //inne to nieznane
                outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                outputStream.flush();
            } else {
                String msg = "Problem z aktualizacja stanu konta\n"; //inne to nieznane
                outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                outputStream.flush();
            }
        }catch (Exception e)
        {
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }
    private void handleDodajDostawce(OutputStream outputStream, String[] tokens) throws IOException {
        baza=new Baza_danych();
        try {
            if (tokens.length == 5) {
                String nazwa = tokens[1];
                String temp = tokens[2];
                int nip = Integer.parseInt(temp);
                String kraj = tokens[3];
                String adres = tokens[4];
                String zapytanie;
                if (baza.find("select * from Dostawca where nazwa='" + nazwa + "';") == 0) {
                    zapytanie = "insert into Dostawca values (NULL,'" + nazwa + "','" + nip + "','" + kraj + "','" + adres + "');";
                    if (baza.insert(zapytanie)) {
                        outputStream.write("Tak\n".getBytes());
                    } else {
                        outputStream.write("Nie\n".getBytes());
                    }
                } else outputStream.write("Istnieje\n".getBytes());
            } else {
                outputStream.write("Brak specyfikacji\n".getBytes());
            }
        }catch (Exception e){
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }
    private void handleZmianaHasla(OutputStream outputStream, String[] tokens) throws IOException {
        baza = new Baza_danych();
        if (tokens.length == 3) {
            String email = tokens[1];
            String haslo = tokens[2];
            String ID = baza.getSingle("select id_osoby from Osoba where e_mail='" + email + "';");
            int x = Integer.parseInt(ID);
            if (baza.zmianaHasla(x, haslo)) {
                String msg = "Tak\n"; //inne to nieznane
                outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                outputStream.flush();
            } else {
                String msg = "Nie\n"; //inne to nieznane
                outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                outputStream.flush();
            }
            baza.closeConnection();
        }
    }
    private void handleDodajPracownika(OutputStream outputStream, String[] tokens)throws IOException {
        baza=new Baza_danych();
        try {
            if (tokens.length == 9) {
                String imie = tokens[1];
                String nazwisko = tokens[2];
                String email = tokens[3];
                String stanowisko = tokens[4];
                String temp = tokens[5];
                int telefon = Integer.parseInt(temp);
                String temp1 = tokens[6];
                int pesel = Integer.parseInt(temp1);
                String temp2 = tokens[7];
                int wynagrodzenie = Integer.parseInt(temp2);
                String haslo = tokens[8];
                haslo = baza.zaszyfruj(haslo);
                String zapytanie;
                if (baza.find("select * from Osoba where e_mail='" + email + "';") == 0) {
                    if (baza.insertPracownik(imie, nazwisko, email, telefon, pesel, wynagrodzenie, stanowisko, haslo)) {
                        outputStream.write("Tak\n".getBytes());
                        outputStream.flush();
                    } else {
                        outputStream.write("Nie\n".getBytes());
                        outputStream.flush();
                    }
                } else {
                    outputStream.write("Istnieje\n".getBytes());
                    outputStream.flush();
                }
            } else {
                outputStream.write("Brak specyfikacji\n".getBytes());
                outputStream.flush();
            }
        }catch (Exception e)
        {
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }
    private void handleZmienWyplate(OutputStream outputStream, String[] tokens)throws IOException {
        baza=new Baza_danych();
        try {
            String idPracownika = tokens[1];
            int id = Integer.parseInt(idPracownika);
            String kwota = tokens[2];
            int suma = Integer.parseInt(kwota);

            Pracownik prac = baza.getPracownik(id);
            if (prac != null) {
                prac.setWynagrodzenie(suma);
                if (baza.insert("update pracownik set wynagrodzenie=" + suma + " where id_pracownika=" + id + ";")) {
                    String msg = "Tak\n"; //inne to nieznane
                    outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                    outputStream.flush();
                } else {
                    String msg = "Err\n"; //inne to nieznane
                    outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                    outputStream.flush();
                }
            } else {
                String msg = "Nie ma\n"; //inne to nieznane
                outputStream.write(msg.getBytes());//przeslij potwierdzenie zalogowania
                outputStream.flush();
            }
        }catch (Exception e){
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }

    /**
     * Wyswietl pracownikow.
     *
     * @param outputStream the output stream
     * @throws IOException the io exception
     */
    public void wyswietlPracownikow(OutputStream outputStream) throws IOException{
        baza=new Baza_danych();
        String doklienta="";
        List<String> pracownicy=baza.getPracownicy();
        int ile=pracownicy.size();
        outputStream.write((ile+"\n").getBytes());
        outputStream.flush();
        for (int i=0;i<ile;i++){
            doklienta=pracownicy.get(i)+"\n";
            outputStream.write(doklienta.getBytes());
            outputStream.flush();
        }
    }

    /**
     * Wyswietl klientow.
     *
     * @param outputStream the output stream
     * @throws IOException the io exception
     */
    public void wyswietlKlientow(OutputStream outputStream) throws IOException{
        baza=new Baza_danych();
        String doklienta="";
        List<String> klienci=baza.getKlienci();
        int ile=klienci.size();
        outputStream.write((ile+"\n").getBytes());
        outputStream.flush();
        for (int i=0;i<ile;i++){
            doklienta=klienci.get(i)+"\n";
            outputStream.write(doklienta.getBytes());
            outputStream.flush();
        }
    }

    /**
     * Oferty.
     *
     * @param outputStream the output stream
     * @throws IOException the io exception
     */
//=======================KLIENT=================================
    public void oferty (OutputStream outputStream) throws IOException {
        baza=new Baza_danych();
        String doklienta = "";
        List<String> oferty = new ArrayList<String>();
        oferty = baza.getOferty();
        int ile=oferty.size();
        outputStream.write((ile+"\n").getBytes());
        outputStream.flush();
        for (int i = 0; i < oferty.size(); i++) {
            doklienta = oferty.get(i) + "\n";
            outputStream.write(doklienta.getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }

    /**
     * Lek.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void lek (OutputStream outputStream,String[]tokens) throws IOException{
        baza=new Baza_danych();
        int id = Integer.parseInt(tokens[1]);
        String lek = baza.getLek(id).toString() + "\n";
        outputStream.write(lek.getBytes());
        outputStream.flush();
        baza.closeConnection();

    }

    /**
     * Pokaz zamowienia.
     *
     * @param outputStream the output stream
     * @throws IOException the io exception
     */
    public void pokazZamowienia (OutputStream outputStream) throws IOException{//wszystkie zamowienia
        baza=new Baza_danych();
        List<String> listazamowien;
        int idklienta = Integer.parseInt(baza.getSingle("select id_klienta from klient join osoba on osoba.id_osoby=klient.id_osoby where e_mail=\"" + login + "\";"));
        listazamowien = baza.getWybraneZamowienia(idklienta);
        int ile=listazamowien.size();
        outputStream.write((ile+"\n").getBytes());
        outputStream.flush();

        for (int i = 0; i < listazamowien.size(); i++) {
            outputStream.write((listazamowien.get(i) + "\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }

    /**
     * Szczegolowe zamowienie.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void szczegoloweZamowienie(OutputStream outputStream,String[] tokens) throws  IOException{
        baza=new Baza_danych();
        int idklienta=0;
        if(baza.getSingle("select id_klienta from klient join osoba on osoba.id_osoby=klient.id_osoby where e_mail=\"" + login + "\";")!=null)
        {
            idklienta=Integer.parseInt(baza.getSingle("select id_klienta from klient join osoba on osoba.id_osoby=klient.id_osoby where e_mail=\"" + login + "\";"));
        }
        try {
            String zamowienie = baza.getSzczegoloweZamowienie(Integer.parseInt(tokens[1]), idklienta);
            zamowienie += "\n";
            outputStream.write(zamowienie.getBytes());
            outputStream.flush();
            baza.closeConnection();
        }catch (Exception e)
        {
            outputStream.write(("Blad\n").getBytes());
            outputStream.flush();
        }
    }

    /**
     * Zmiana hasla klienta.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void zmianaHaslaKlienta (OutputStream outputStream,String[]tokens) throws IOException{
        baza=new Baza_danych();
        String haslo = tokens[1];
        String str=baza.getSingle("select id_osoby from Osoba where e_mail='"+login+"';");
        int idosoby = Integer.parseInt(str);
        if (baza.zmianaHasla(idosoby, haslo))
        {
            outputStream.write(("Zmienino haslo\n").getBytes());
            outputStream.flush();
        }
        else {
            outputStream.write(("Nie udalo sie zmienic hasla \n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }

    /**
     * Dodaj do koszyka.
     *
     * @param outputStream the output stream
     * @param tokens       the tokens
     * @throws IOException the io exception
     */
    public void dodajDoKoszyka (OutputStream outputStream,String[]tokens) throws  IOException{
        baza=new Baza_danych();
        try {
            int idoferty = Integer.parseInt(tokens[1]);
            int ilosc = Integer.parseInt(tokens[2]);
            double cena = baza.getOferta(idoferty).getCena() * ilosc;
            int idklienta = Integer.parseInt(baza.getSingle("select id_klienta from klient join osoba on osoba.id_osoby=klient.id_osoby where e_mail=\"" + login + "\";"));
            if (baza.insertKoszyk(idoferty, idklienta, ilosc, cena)) {
                outputStream.write(("Dodano\n").getBytes());
                outputStream.flush();
            } else {
                outputStream.write(("NieDodano\n").getBytes());
                outputStream.flush();
            }
        }catch (Exception e)
        {
            outputStream.write(("NieDodano\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();


    }

    /**
     * Usun klienta.
     *
     * @param outputStream the output stream
     * @throws IOException the io exception
     */
    public void usunKlienta(OutputStream outputStream) throws IOException {
        baza=new Baza_danych();
        int idosoby = Integer.parseInt(baza.getSingle("select id_osoby from osoba where e_mail=\"" + login + "\";"));
        if(baza.usunKlienta(idosoby)){
            System.out.println("Usunieto klienta");
        }
        else {
            System.out.println("Nie udalo sie usunac ");
        }
        baza.closeConnection();
    }

    /**
     * Dodaj zamowienie.
     *
     * @param outputStream the output stream
     * @throws IOException the io exception
     */
    public void dodajZamowienie (OutputStream outputStream) throws IOException {
        baza=new Baza_danych();

        int idklienta = Integer.parseInt(baza.getSingle("select id_klienta from klient join osoba on osoba.id_osoby=klient.id_osoby where e_mail=\"" + login + "\";"));
        int idkoszyka = baza.getKoszyk(idklienta).getId_koszyka();
        int idoferty = baza.getKoszyk(idklienta).getId_oferty();
        int idleku = baza.getOferta(idoferty).getId_leku();
        int ilosc = baza.getKoszyk(idklienta).getIlosc();
        int waga = baza.getLek(idleku).getGramatura() * ilosc;

        Date data = new Date();//aktualna dat
        if( baza.insertZamowienie(idklienta, idkoszyka, waga,"2021-01-22","2021-01-22" , 0))
        {
            String temp=baza.getZamowienie(idkoszyka, idklienta).toString()+"\n";
            outputStream.write(temp.getBytes());
            outputStream.flush();

        }
        else {
            outputStream.write(("Nie udalo sie dodac zamowienia\n").getBytes());
            outputStream.flush();
        }
        baza.closeConnection();
    }

    /**
     * Usun koszyk.
     */
    public void usunKoszyk(){
        baza=new Baza_danych();
        int idklienta = Integer.parseInt(baza.getSingle("select id_klienta from klient join osoba on osoba.id_osoby=klient.id_osoby where e_mail=\"" + login + "\";"));
        int idkoszyka = baza.getKoszyk(idklienta).getId_koszyka();
        baza.usunKoszyk(idklienta,idkoszyka);
        baza.closeConnection();
    }

    /**
     * Wyswietl koszyk.
     *
     * @param outputStream the output stream
     * @throws IOException the io exception
     */
    public void wyswietlKoszyk(OutputStream outputStream) throws IOException{
        baza=new Baza_danych();
        int idklienta = Integer.parseInt(baza.getSingle("select id_klienta from klient join osoba on osoba.id_osoby=klient.id_osoby where e_mail=\"" + login + "\";"));
        String koszyk=baza.getKoszyk(idklienta).toString();
        outputStream.write((koszyk+"\n").getBytes());
        outputStream.flush();
        baza.closeConnection();
    }
//==================================
    
}
