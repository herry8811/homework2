package geektime.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class XmlAssemblyTest implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(XmlAssemblyTest.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //xml 注入
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
        Customer customer = (Customer) context.getBean("customer");
        customer.order();

    }
}
