package lab2;

public class SystemManagerApp {

    public static void main(String[] args) {

        // Liskov Substitution Principle
        OrderVerifier orderVerifier = new BaseOrderVerifier();

        // Liskov Substitution Principle
        PaymentService paymentService = new PaymentServiceImpl();

        // Liskov Substitution Principle
        PaymentProcessor paymentProcessor = new ExpressPaymentProcessor(paymentService);

        // Liskov Substitution Principle
        OrderRepository orderRepository = new OrderRepositoryImpl();

        CustomerNotifier customerNotifier = new EmailCustomerNotifier();

        // Dependency Inversion Principle
        SystemManager systemManager = new SystemManager(orderVerifier, paymentProcessor, orderRepository, customerNotifier);

        Order order = new Order();
        order.setAmount(2000);
        order.setQuantity(2);
        order.setType("express");

        systemManager.processOrder(order);

    }
}
