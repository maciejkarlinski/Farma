package Server;


/**
 * Created by jim on 4/18/17.
 */
public class ServerMain {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int port = 8818;
        ServerColections serverColections = new ServerColections(port);
        serverColections.start();
    }
}
