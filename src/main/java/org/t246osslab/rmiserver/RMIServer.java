package org.t246osslab.rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.t246osslab.batch.BatchImpl;
import org.t246osslab.batch.BatchInterface;

/**
 * A simple implementation of an RMI server.
 */
public class RMIServer {
    private static BatchInterface bi = new BatchImpl();

    public static void startServer() {
        
        try {
            Remote remote = UnicastRemoteObject.exportObject(bi, 0);
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            registry.rebind("execBatch", remote);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
