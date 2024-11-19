package lab2;

public interface PaymentProcessor {

    //Interface Segregation Principle
    boolean processPayment(Order order);
}
