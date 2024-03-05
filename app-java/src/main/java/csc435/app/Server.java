package csc435.app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Server implements MathFormula {
    public Server() {
        super();
    }

    public String getFormula(String message)
    {
        if (message.compareTo("addition") == 0) {
            return "2+2=4";
        }

        if (message.compareTo("multiplication") == 0) {
            return "2x2=4";
        }

        return "???";
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("USE: java Server <IP address> <port>");
            System.exit(1);
        }

        try {
            MathFormula server = new Server();
            MathFormula stub = (MathFormula) UnicastRemoteObject.exportObject(server, Integer.parseInt(args[1]));
            Registry registry = LocateRegistry.getRegistry(args[0]);
            registry.bind("MathFormula", stub);

            Scanner sc = new Scanner(System.in);

            String command;

            while (true) {
                System.out.print("> ");
                
                command = sc.nextLine();
                
                if (command.compareTo("quit") == 0) {
                    break;
                }
            }

            sc.close();

            registry.unbind("MathFormula");
            UnicastRemoteObject.unexportObject(server, false);
            System.out.println("Server terminated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}