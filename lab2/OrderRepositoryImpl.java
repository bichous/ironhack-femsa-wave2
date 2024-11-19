package lab2;

public class OrderRepositoryImpl implements OrderRepository{


    @Override
    public void updateOrderStatus(Order order) {
        System.out.println("Saving order");
    }
}
