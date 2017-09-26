package org.t246osslab.stdoutproblems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.t246osslab.rmiserver.RMIServer;

@SpringBootApplication
public class StdoutProblemsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StdoutProblemsApplication.class, args);
        RMIServer.startServer();
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StdoutProblemsApplication.class);
    }
}
