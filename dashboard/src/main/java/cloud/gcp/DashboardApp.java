package cloud.gcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class DashboardApp {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DashboardApp.class, args);
    }

}
