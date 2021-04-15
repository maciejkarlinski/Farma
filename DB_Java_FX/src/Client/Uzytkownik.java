package Client;

/**
 * The type Uzytkownik.
 */
public class Uzytkownik{
    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets stanowisko.
     *
     * @param stanowisko the stanowisko
     */
    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    /**
     * The Email.
     */
    public String email;
    /**
     * The Password.
     */
    public String password;
    /**
     * The Stanowisko.
     */
    public String stanowisko;

    /**
     * Instantiates a new Uzytkownik.
     *
     * @param email      the email
     * @param password   the password
     * @param stanowisko the stanowisko
     */
    public Uzytkownik(String email, String password, String stanowisko) {
        this.email = email;
        this.password = password;
        this.stanowisko = stanowisko;
    }}