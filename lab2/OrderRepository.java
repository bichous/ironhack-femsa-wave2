package lab2;

public interface OrderRepository {

    //Interface Segregation Principle
    void updateOrderStatus(Order order);
}
