package edu.ucr.rp.b97267.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientApp {
    ServerSocket serverSocket;

    public class Server {
        ServerSocket serverSocket;

        public Server(int port) {
            try {
                serverSocket = new ServerSocket(port);
                System.out.println("Esperando conexión");
                Socket socket = serverSocket.accept();//esperando a que llegue una conexión
                System.out.println("Conexión recibida");
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                String message = (String) in.readObject();
                System.out.println("Message Received: " + message);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                System.out.println("Mensaje recibido:" + message);
                out.writeObject("Mensaje Recibido: " + message);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();//Puede lanzar una excepción puesto que el puerto puede estar ocupado
            }

        }
    }

}
