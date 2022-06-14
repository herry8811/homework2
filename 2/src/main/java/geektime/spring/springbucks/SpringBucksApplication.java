package geektime.spring.springbucks;

import geektime.spring.springbucks.model.Coffee;
import geektime.spring.springbucks.model.CoffeeOrder;
import geektime.spring.springbucks.model.OrderState;
import geektime.spring.springbucks.repository.CoffeeRepository;
import geektime.spring.springbucks.service.CoffeeOrderService;
import geektime.spring.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
@RestController
public class SpringBucksApplication implements ApplicationRunner {
	@Autowired
	private CoffeeRepository coffeeRepository;
	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private CoffeeOrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBucksApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("All Coffee: {}", coffeeRepository.findAll());

		Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
		if (latte.isPresent()) {
			CoffeeOrder order = orderService.createOrder("Li Lei", latte.get());
			log.info("Update INIT to PAID: {}", orderService.updateState(order, OrderState.PAID));
			log.info("Update PAID to INIT: {}", orderService.updateState(order, OrderState.INIT));
		}
	}

	@RequestMapping(value = "/coffee/name/{name}",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Coffee selectCoffee(@PathVariable("name") String name){
		System.out.println(name);
		Optional<Coffee> coffee = coffeeService.findOneCoffee(name);
		if (coffee.isPresent()) {
			return coffee.get();
		}
		else return null;
	}

	@RequestMapping(value = "/coffee/id/{id}",method = RequestMethod.GET,produces = "application/xml; charset=UTF-8")
	@ResponseBody
	public Coffee selectCoffee(@PathVariable("id") Integer id){
		System.out.println(id);
		Optional<Coffee> coffee = coffeeRepository.findById(id.longValue());
		if (coffee.isPresent()) {
			return coffee.get();
		}
		else return null;
	}
}

