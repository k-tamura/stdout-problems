package org.t246osslab.batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * A simple implementation of a printing interface.
 */
public class BatchImpl implements BatchInterface {

    public static void main(String[] args) {
        BatchImpl pi = new BatchImpl();
        int executeBatch = pi.executeBatch();
        System.out.println("Result: " + executeBatch);
    }

    @Override
    public int executeBatch() {
        String batchFilePath = null;
        try {
            Resource resource = new ClassPathResource("test.bat");
            File batFile = resource.getFile();
            if (!batFile.setExecutable(true)) {
                batchFilePath = batFile.getAbsolutePath();
                ProcessBuilder pb = new ProcessBuilder(batchFilePath);
                Process process = pb.start();
                printInputStream(process.getInputStream());
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
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
