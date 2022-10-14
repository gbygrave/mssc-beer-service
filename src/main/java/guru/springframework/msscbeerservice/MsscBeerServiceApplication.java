package guru.springframework.msscbeerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsscBeerServiceApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MsscBeerServiceApplication.class, args);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

}
