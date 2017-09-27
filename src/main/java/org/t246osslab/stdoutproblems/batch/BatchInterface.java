package org.t246osslab.stdoutproblems.batch;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * A simple remote batch interface.
 * 
 */
public interface BatchInterface extends Remote {
    
    /**
     * Execute a remote batch.
     * 
     * @return batch result, 0: success, -1: failure
     * @throws RemoteException 
     */
    public int executeBatch() throws RemoteException;
}
