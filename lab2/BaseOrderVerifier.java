package lab2;

public class BaseOrderVerifier implements OrderVerifier {

    private final int INVENTORY = 10;

    @Override
    public void verifyOrder(Order order) {
        if (INVENTORY < order.quantity) {
            throw new Error("Out of stock");
        }
    }
}
