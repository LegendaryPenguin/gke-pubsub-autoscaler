package cloud.gcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LetterReaderApp {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(LetterReaderApp.class, args);
    }

}
