package org.t246osslab.stdoutproblems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.t246osslab.stdoutproblems.rmiserver.RMIServer;

@SpringBootApplication
public class StdoutProblemsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
        if (!"mode=RMIServer".equals(args[0])) {
            SpringApplication.run(StdoutProblemsApplication.class, args);
        }
        if (!"mode=SpringApp".equals(args[0])) {
            RMIServer.startServer();
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StdoutProblemsApplication.class);
    }
}
