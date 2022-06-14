package geektime.spring.RpcTest;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "feign", url = "http://localhost:8080/coffee/name", configuration = FeignConfig.class, primary = false)
public interface WebFeign {
    @RequestLine("GET /{name}")
    String search(@Param("name") String name);
}
