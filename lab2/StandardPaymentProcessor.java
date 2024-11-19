package lab2;

public class StandardPaymentProcessor implements PaymentProcessor{

    private final PaymentService paymentService;

    public StandardPaymentProcessor(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @Override
    public boolean processPayment(Order order) {
        if (paymentService.process(order.amount)) {
            return true;
        } else {
            throw new Error("Payment failed");
        }
    }
}
