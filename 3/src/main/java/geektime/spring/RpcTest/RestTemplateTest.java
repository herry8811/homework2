package geektime.spring.RpcTest;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class RestTemplateTest implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateTest.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("RpcTest begin");
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject param = new JSONObject();
        HttpEntity<String> formEntity = new HttpEntity<String>(param.toJSONString(), headers);
        log.info("http rpc begin parm:{}", param);
        String url = "http://localhost:8080/coffee/name/{name}";
        try {
            String result = restTemplate.getForObject(url, String.class, "latte");
            log.info("http rpc get result:{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

