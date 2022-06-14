package geektime.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JavaAssemblyTest implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(XmlAssemblyTest.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //java 程序注入
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        CompactDisc compactDisc = (ClassicalMusic)configApplicationContext.getBean("classicalMusic");
        compactDisc.play();
    }
}

