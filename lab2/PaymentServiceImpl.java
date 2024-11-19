package lab2;


public class PaymentServiceImpl implements PaymentService{


    @Override
    public boolean process(int amount) {
        System.out.println("Processing payment");
        return true;
    }

    @Override
    public boolean process(int amount, String priority) {
        System.out.println("Processing payment with priority");
        return true;
    }
}
