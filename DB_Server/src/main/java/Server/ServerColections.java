package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Server colections.
 */
public class ServerColections extends Thread {
    private final int serverPort;

    private ArrayList<HandlerThread> workerList = new ArrayList<>();

    /**
     * Instantiates a new Server colections.
     *
     * @param serverPort the server port
     */
    public ServerColections(int serverPort) {
        this.serverPort = serverPort;
    }


    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);//tworzenie socketu
            while(true) {
                System.out.println("Czekam na polaczenie");
                Socket clientSocket = serverSocket.accept();//akceptuje nowe połączenie
                System.out.println("Zaakceptowano polaczenie od " + clientSocket);
                HandlerThread worker = new HandlerThread(this, clientSocket);// tworzenie nowego wątku dla każdego klienta
                workerList.add(worker);
                worker.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove worker.
     *
     * @param handlerThread the handler thread
     */
    public void removeWorker(HandlerThread handlerThread) {
        workerList.remove(handlerThread);
    }
}
