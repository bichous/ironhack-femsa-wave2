package lab2;

public class ExpressPaymentProcessor implements PaymentProcessor{

    private final PaymentService paymentService;

    private  final String PRIORITY = "highPriority";

    public ExpressPaymentProcessor(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @Override
    public boolean processPayment(Order order) {
        if (paymentService.process(order.amount, PRIORITY)) {
            return true;
        } else {
            throw new Error("Express payment failed");
        }
    }
}
