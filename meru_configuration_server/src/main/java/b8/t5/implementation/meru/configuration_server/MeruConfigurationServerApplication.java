package b8.t5.implementation.meru.configuration_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MeruConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeruConfigurationServerApplication.class, args);
	}

}
