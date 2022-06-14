package geektime.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutowiredTest implements ApplicationRunner {

    //注解自动注入
    @Qualifier("popularMusic")
    @Autowired
    private CompactDisc cd;

    public static void main(String[] args) {
        SpringApplication.run(XmlAssemblyTest.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        cd.play();
    }
}
