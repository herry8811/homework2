package geektime.demo;


public class Customer {

    private Coffee coffee;

    public Customer(Coffee coffee) {
        this.coffee = coffee;
    }

    public void order() {
        System.out.println("my order coffee name:" + coffee.coffeeName + " price:" + coffee.price);
    }
}
