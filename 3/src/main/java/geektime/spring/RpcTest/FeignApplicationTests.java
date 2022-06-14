package geektime.spring.RpcTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignApplicationTests implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplicationTests.class, args);
    }

    @Autowired
    private WebFeign webFeignTest;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String result = webFeignTest.search("mocha");
        System.out.println("result = " + result);
    }
}