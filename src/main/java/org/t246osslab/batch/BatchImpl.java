package org.t246osslab.batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * A simple implementation of a printing interface.
 */
public class BatchImpl implements BatchInterface {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        BatchImpl pi = new BatchImpl();
        int executeBatch = pi.executeBatch();
        System.out.println(executeBatch);
    }

    @Override
    public int executeBatch() {
        /* get a batch file path */
        String batchFilePath = getBatchFilePath();

        if (batchFilePath == null) {
            log.error("Can't create a batch file");
        } else {
            try {
                /* execute the batch */
                ProcessBuilder pb = new ProcessBuilder(batchFilePath);
                Process process = pb.start();
                printInputStream(process.getInputStream());
                return process.hashCode();
            } catch (IOException e) {
                log.error("IOException occurs: ", e);
            }
        }
        return -1;
    }
    
    private String getBatchFilePath() {
        String batchFilePath = null;
        String osName = System.getProperty("os.name").toLowerCase();
        String batFileName = null;
        if (osName.toLowerCase().startsWith("windows")) {
            batFileName = "test.bat";
        } else {
            batFileName = "test.sh";
        }
        Resource resource = new ClassPathResource("/bat/" + batFileName);
        try {
            File batFile = resource.getFile();
            if (!batFile.setExecutable(true)) {
                log.debug("batFile.setExecutable(true) returns false.");
            }
            batchFilePath = batFile.getAbsolutePath();
            if (!osName.toLowerCase().startsWith("windows")) {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod 777 " + batchFilePath);
            }
        } catch (IOException e) {
            log.error("IOException occurs: ", e);
        }
        return batchFilePath;
    }

    private void printInputStream(InputStream is) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line + System.lineSeparator());
            }
        }
    }
}
