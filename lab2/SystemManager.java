package lab2;

// No tiene una sola responsabilidad SRP
class SystemManager {

    private final OrderVerifier orderVerifier;

    private final PaymentProcessor paymentProcessor;

    private final OrderRepository repository;

    private final CustomerNotifier customerNotifier;

    // Dependency Inversion Principe
    public SystemManager(OrderVerifier orderVerifier, PaymentProcessor paymentProcessor, OrderRepository repository, CustomerNotifier customerNotifier) {
        this.orderVerifier = orderVerifier;
        this.paymentProcessor = paymentProcessor;
        this.repository = repository;
        this.customerNotifier = customerNotifier;

    }


    //Simple responsability Principe
    //The coupling was removed, applying the Open-Closed principle.
    public void processOrder(Order order) {
        orderVerifier.verifyOrder(order);
        paymentProcessor.processPayment(order);
        repository.updateOrderStatus(order);
        customerNotifier.notifyCustomer(order);
    }

}

