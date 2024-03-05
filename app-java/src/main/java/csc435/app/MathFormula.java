package csc435.app;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathFormula extends Remote {
    public String getFormula(String message) throws RemoteException;
}