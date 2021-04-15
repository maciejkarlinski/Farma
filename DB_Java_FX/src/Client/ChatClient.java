package Client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The type Chat client.
 */
public class ChatClient {

    private final String serverName;
    private final int serverPort;
    private Socket socket;
    private OutputStream serverOut;
    private InputStream serverIn;
    private BufferedReader bufferedIn;


    /**
     * Instantiates a new Chat client.
     *
     * @param serverName the server name
     * @param serverPort the server port
     */
    public ChatClient(String serverName , int serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException  {
        ChatClient client = new ChatClient("localhost", 8818);

    }

    /**
     * Connect boolean.
     *
     * @return the boolean
     */
    public boolean connect() {
        try {
            this.socket = new Socket("localhost",8818);
            System.out.println("Client port is " + socket.getLocalPort());
            this.serverOut = socket.getOutputStream();
            this.serverIn = socket.getInputStream();
            this.bufferedIn = new BufferedReader(new InputStreamReader(serverIn));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Login string.
     *
     * @param login    the login
     * @param password the password
     * @return the string
     * @throws IOException the io exception
     */
    public String login(String login, String password) throws IOException {//logowanie
        String cmd = "login " + login + " " + password + "\n";
        serverOut.write(cmd.getBytes());//wyslanie komendy logowania do serwera
        serverOut.flush();
        String response = bufferedIn.readLine();//czekaj na potwierdzenie logowania lub blad


        if("Zalogowano".equalsIgnoreCase(response)){//jesli serwer zwroci zalogowano to zakończ i zwroc true
            System.out.println("Odpowiedz serwera: " + "''"+response+"''");

        }
        else{
            System.err.println("Odpowiedz serwera: " + "''"+response+"''");
            }
        return response;

    }

    /**
     * Register string.
     *
     * @param name     the name
     * @param lastName the last name
     * @param email    the email
     * @param nrtel    the nrtel
     * @param pesel    the pesel
     * @param nip      the nip
     * @param password the password
     * @return the string
     * @throws IOException the io exception
     */
    public String register(String name, String lastName, String email, String nrtel, String pesel, String nip,  String password) throws IOException {
        String cmd = "reg " + name + " " + lastName + " " + email + " " + nrtel + " " + pesel + " " + nip + " " + password + "\n";

        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Text string.
     *
     * @param email the email
     * @return the string
     * @throws IOException the io exception
     */
    public String text(String email) throws IOException {
        String cmd = "text " + email + "\n";

        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        System.err.println(response);
        return response;
    }

    /**
     * Gets stanowisko.
     *
     * @param email the email
     * @return the stanowisko
     * @throws IOException the io exception
     */
    public String getStanowisko(String email) throws IOException{
        String cmd = "stanowisko " + email + "\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();

        String response = bufferedIn.readLine();
        System.out.println(response);


        return response;
    }

    /**
     * Wyswietl lista list.
     *
     * @param nazwatabeli the nazwatabeli
     * @return the list
     * @throws IOException the io exception
     */
    public List<String> wyswietlLista(String nazwatabeli) throws IOException{
        String cmd = "wyswietl " +nazwatabeli+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        List<String>lista=new ArrayList<>();
        String response = bufferedIn.readLine();
        int roz = Integer.parseInt(response);
        int i=0;
        while (i<roz) {
            response = bufferedIn.readLine();
            lista.add(response);
            i++;
        }
        return lista;
    }

    /**
     * Wyswietl lista 1 list.
     *
     * @param nazwatabeli the nazwatabeli
     * @return the list
     * @throws IOException the io exception
     */
    public List<String> wyswietlLista1(String nazwatabeli) throws IOException{//funkcja pomocnicza do wyswietlnia list
        String cmd = "wyswietl1 " +nazwatabeli+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        List<String>lista=new ArrayList<>();
        String response = bufferedIn.readLine();
        int roz = Integer.parseInt(response);
        int i=0;
        while (i<roz) {
            response = bufferedIn.readLine();
            lista.add(response);
            i++;
        }
        return lista;
    }

    /**
     * Wyswietldanedo listy list.
     *
     * @param nazwatabeli  the nazwatabeli
     * @param nazwarekordu the nazwarekordu
     * @return the list
     * @throws IOException the io exception
     */
    public List<String> wyswietldanedoListy(String nazwatabeli, String nazwarekordu) throws IOException{//funkcja pomocnicza do wyswietlnia list
        String cmd = "wyswietl2 " +nazwatabeli+" "+nazwarekordu+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        List<String>lista=new ArrayList<>();
        String response = bufferedIn.readLine();
        int roz = Integer.parseInt(response);
        int i=0;
        while (i<roz) {
            response = bufferedIn.readLine();
            lista.add(response);
            i++;
        }
        return lista;
    }

    /**
     * Wyswietl pracownikow list.
     *
     * @return the list
     * @throws IOException the io exception
     */
    public List<String> wyswietlPracownikow() throws IOException{
        List<String> lista= new ArrayList<String>();
        String cmd="wyswietlPracownikow\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String temp;
        int ile=Integer.parseInt(bufferedIn.readLine());
        for(int i=0;i<ile;i++){
            temp=bufferedIn.readLine();
            lista.add(temp);

        }
        return lista;

    }

    /**
     * Zablokuj string.
     *
     * @param email the email
     * @return the string
     * @throws IOException the io exception
     */
    public String zablokuj(String email)throws  IOException {
        String cmd = "zablokujKonto " +email+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Odblokuj string.
     *
     * @param email the email
     * @return the string
     * @throws IOException the io exception
     */
    public String odblokuj(String email)throws  IOException {
        String cmd = "odblokujKonto " +email+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Dodaj dostawce string.
     *
     * @param nazwa the nazwa
     * @param nip   the nip
     * @param kraj  the kraj
     * @param adres the adres
     * @return the string
     * @throws IOException the io exception
     */
    public String dodajDostawce(String nazwa, String nip, String kraj, String adres) throws IOException{
        String cmd = "dodajDostawce " +nazwa+" "+nip+" "+kraj+" "+adres+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Dodaj pracownika string.
     *
     * @param imie          the imie
     * @param nazwisko      the nazwisko
     * @param email         the email
     * @param stanowisko    the stanowisko
     * @param telefon       the telefon
     * @param pesel         the pesel
     * @param wynagrodzenie the wynagrodzenie
     * @param haslo         the haslo
     * @return the string
     * @throws IOException the io exception
     */
    public String dodajPracownika(String imie, String nazwisko, String email, String stanowisko, String telefon, String pesel, String wynagrodzenie, String haslo)throws IOException {
        String cmd;
        cmd = "dodajPracownika " +imie+" "+nazwisko+" "+email+" "+stanowisko+" "+telefon+" "+pesel+" "+wynagrodzenie+" "+haslo+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Recover password string.
     *
     * @param email    the email
     * @param name     the name
     * @param lastName the last name
     * @return the string
     * @throws IOException the io exception
     */
    public String recoverPassword(String email, String name, String lastName) throws IOException{
        String cmd = "recoverhaslo " + email + " " + name + " " + lastName + "\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();

        return response;
    }

    /**
     * Zmienhaslo string.
     *
     * @param email    the email
     * @param password the password
     * @return the string
     * @throws IOException the io exception
     */
    public String zmienhaslo(String email, String password) throws IOException {
        String cmd = "zmienhaslo " +email+" "+password+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Zmien wyplate string.
     *
     * @param idPracownika the id pracownika
     * @param kwota        the kwota
     * @return the string
     * @throws IOException the io exception
     */
    public String zmienWyplate(String idPracownika, String kwota)throws IOException {
        String cmd = "zmienWyplate " +idPracownika+" "+kwota+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Zmien date realizacji zamowienia string.
     *
     * @param idZamowienia the id zamowienia
     * @param data         the data
     * @return the string
     * @throws IOException the io exception
     */
    public String zmienDateRealizacjiZamowienia(String idZamowienia, String data)throws IOException {
        String cmd = "zmienDRZ " +idZamowienia+" "+data+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Usun string.
     *
     * @param nazwatabeli the nazwatabeli
     * @param id          the id
     * @return the string
     * @throws IOException the io exception
     */
    public String usun(String nazwatabeli, String id) throws IOException//usuniecie danego rekordu
    {
        String cmd = "usun " +nazwatabeli+" "+id+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Usun 1 string.
     *
     * @param nazwatabeli the nazwatabeli
     * @param id          the id
     * @return the string
     * @throws IOException the io exception
     */
    public String usun1(String nazwatabeli, String id) throws IOException//usuniecie calosci surowiec/lek/oferta
    {
        String cmd = "usuncalosc " +nazwatabeli+" "+id+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Dodaj lek string.
     *
     * @param nazwa     the nazwa
     * @param gramatura the gramatura
     * @return the string
     * @throws IOException the io exception
     */
    public String dodajLek(String nazwa, String gramatura) throws IOException//usuniecie danego rekordu
    {
        String cmd = "dodajLek " +nazwa+" "+gramatura+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Dodaj oferte string.
     *
     * @param idleku    the idleku
     * @param cena      the cena
     * @param gramatura the gramatura
     * @return the string
     * @throws IOException the io exception
     */
    public String dodajOferte(String idleku, String cena, String gramatura) throws IOException//usuniecie danego rekordu
    {
        String cmd = "dodajOferte " +idleku+" "+cena+" "+gramatura+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Dodaj surowiec string.
     *
     * @param nazwa             the nazwa
     * @param iddostawcy        the iddostawcy
     * @param data_przydatnosci the data przydatnosci
     * @return the string
     * @throws IOException the io exception
     */
    public String dodajSurowiec(String nazwa, String iddostawcy,String data_przydatnosci) throws IOException//usuniecie danego rekordu
    {
        String cmd = "dodajSurowiec " +nazwa+" "+iddostawcy+" "+data_przydatnosci+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Wystaw fakture string.
     *
     * @param numer        the numer
     * @param idklienta    the idklienta
     * @param idzamowienia the idzamowienia
     * @return the string
     * @throws IOException the io exception
     */
    public String wystawFakture(String numer, String idklienta,String idzamowienia) throws IOException//usuniecie danego rekordu
    {
        numer=numer.toUpperCase(Locale.ROOT);
        String cmd = "wystawFakture " +numer+" "+idklienta+" "+idzamowienia+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Dodaj dostawe string.
     *
     * @param idsurowca  the idsurowca
     * @param ilosc      the ilosc
     * @param nrserii    the nrserii
     * @param data       the data
     * @param iddostawcy the iddostawcy
     * @param pozycja    the pozycja
     * @return the string
     * @throws IOException the io exception
     */
    public String dodajDostawe(String idsurowca, String ilosc,String nrserii, String data, String iddostawcy, String pozycja) throws IOException//usuniecie danego rekordu
    {
        String cmd = "dodajDostawe " +idsurowca+" "+ilosc+" "+nrserii+" "+data+" "+iddostawcy+" "+pozycja+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Aktualizuj magazyn string.
     *
     * @param idsurowca the idsurowca
     * @param ilosc     the ilosc
     * @param pozycja   the pozycja
     * @return the string
     * @throws IOException the io exception
     */
    public String aktualizujMagazyn(String idsurowca, String ilosc,String pozycja) throws IOException//usuniecie danego rekordu
    {
        String cmd = "aktualizujMagazyn " +idsurowca+" "+ilosc+" "+pozycja+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }

    /**
     * Wyswietl lek string.
     *
     * @param id the id
     * @return the string
     * @throws IOException the io exception
     */
//==========Klient=================
public String wyswietlLek(int id) throws IOException{
    String cmd="lek "+id+"\n";
    serverOut.write(cmd.getBytes());
    serverOut.flush();
    String response = bufferedIn.readLine();
    return response;
}

    /**
     * Oferta list.
     *
     * @return the list
     * @throws IOException the io exception
     */
    public List<String> oferta() throws IOException {
        List<String> lista= new ArrayList<String>();
        String cmd="oferta\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String temp;
        int ile=Integer.parseInt(bufferedIn.readLine());
        for(int i=0;i<ile;i++){
            temp=bufferedIn.readLine();
            lista.add(temp);

        }
        return lista;
    }

    /**
     * Wyswietl zamowienia list.
     *
     * @return the list
     * @throws IOException the io exception
     */
    public List<String> wyswietlZamowienia() throws IOException {
        List<String> lista=new ArrayList<String>();
        String cmd="pokazZamowienia\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        int ile=Integer.parseInt(bufferedIn.readLine());
        String temp;
        for(int i=0;i<ile;i++) {
            temp = bufferedIn.readLine();
            lista.add(temp);
        }
        return lista;
    }

    /**
     * Wyswietlklientow list.
     *
     * @return the list
     * @throws IOException the io exception
     */
    public List<String> wyswietlklientow() throws IOException {
        List<String> lista=new ArrayList<String>();
        String cmd="wyswietlKlientow\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        int ile=Integer.parseInt(bufferedIn.readLine());
        String temp;
        for(int i=0;i<ile;i++) {
            temp = bufferedIn.readLine();
            lista.add(temp);
        }
        return lista;
    }

    /**
     * Zmien haslo klienta string.
     *
     * @param haslo the haslo
     * @return the string
     * @throws IOException the io exception
     */
    public String zmienHasloKlienta(String haslo) throws IOException
    {
        String cmd="zmienHasloKlienta "+haslo+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response=bufferedIn.readLine();
        System.out.println(response);
        return response;
    }

    /**
     * Usun koszyk.
     *
     * @throws IOException the io exception
     */
    public void usunKoszyk() throws IOException {
        String cmd="usunKoszyk\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
    }

    /**
     * Usun konto klienta.
     *
     * @throws IOException the io exception
     */
    public void usunKontoKlienta() throws IOException{
        String cmd="usunKontoKlienta\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
    }

    /**
     * Dodaj koszyk string.
     *
     * @param idoferty the idoferty
     * @param ilosc    the ilosc
     * @return the string
     * @throws IOException the io exception
     */
    public String dodajKoszyk(String idoferty, String ilosc) throws IOException{
        String temp="dodajDoKoszyka "+idoferty+" "+ilosc+"\n";
        serverOut.write(temp.getBytes());
        serverOut.flush();
        String response= bufferedIn.readLine();
        return response;
    }

    /**
     * Szczegolowe zamowienie string.
     *
     * @param id_zamowienia the id zamowienia
     * @return the string
     * @throws IOException the io exception
     */
    public String szczegoloweZamowienie(String id_zamowienia) throws IOException{
        String temp="getSzczegoloweZamowienie "+id_zamowienia+"\n";
        serverOut.write(temp.getBytes());
        serverOut.flush();
        return bufferedIn.readLine();
    }

    /**
     * Dodaj zamowienie string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    public String dodajZamowienie() throws IOException{
        String temp="dodajZamowienie\n";
        serverOut.write(temp.getBytes());
        serverOut.flush();
        String response=bufferedIn.readLine();
        return response;
    }

    /**
     * Wyswietl koszyk string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    public String wyswietlKoszyk() throws  IOException{
        serverOut.write(("wyswietlKoszyk\n").getBytes());
        serverOut.flush();
        String response=bufferedIn.readLine();
        return response;
    }


    /**
     * Logoff.
     *
     * @throws IOException the io exception
     */
    public void logoff() throws IOException{
        String cmd = "logoff\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        socket.close();
        connect();
    }


    /**
     * Zmien stan realizacji zamowienia string.
     *
     * @param idZamowienia the id zamowienia
     * @param i            the
     * @return the string
     * @throws IOException the io exception
     */
    public String zmienStanRealizacjiZamowienia(String idZamowienia, int i)throws IOException {
        String x = String.valueOf(i);
        String cmd = "zmienSZ " +idZamowienia+" "+x+"\n";
        serverOut.write(cmd.getBytes());
        serverOut.flush();
        String response = bufferedIn.readLine();
        return response;
    }
} // KONIEC KLASY



