package lab2;

public class EmailCustomerNotifier implements CustomerNotifier{


    @Override
    public void notifyCustomer(Order order) {
        System.out.println("Your order has been processed.");
    }
}
