package lab2;

//Interface Segregation Principle
public interface PaymentService {

    boolean process(int amount);

    boolean process(int amount, String priority);
}
