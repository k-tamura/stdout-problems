package org.t246osslab.stdoutproblems.batch;

import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Annual processing batch.
 */
public class BatchImpl implements BatchInterface {

    public static void main(String[] args) {
        System.out.println("Result: " + new BatchImpl().executeBatch());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int executeBatch() {
        try {
            Resource resource = new ClassPathResource("annual.bat");
            File batFile = resource.getFile();
            if (batFile.setExecutable(true)) {
                ProcessBuilder pb = new ProcessBuilder(batFile.getAbsolutePath());
                pb.start();
                //System.out.println(IOUtils.toString(process.getInputStream(), "UTF-8"));
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
