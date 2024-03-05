package csc435.app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("USE: java Client <IP address>");
            System.exit(1);
        }
        
        try {
            Registry registry = LocateRegistry.getRegistry(args[0]);
            MathFormula server = (MathFormula) registry.lookup("MathFormula");
            String message;
            
            message = server.getFormula("addition");
            System.out.println(message);

            message = server.getFormula("multiplication");
            System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}