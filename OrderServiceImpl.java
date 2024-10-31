/*
 * Este clase solo se encarga de trabajar con las ordenes, aplicando el principio de Single Responsibility Principle
 */
public class OrderServiceImpl implements IOrderService {
    @Override
    public void createOrder(Order order) {
        // Implementation for creating an order
    }

    @Override
    public Order getOrder(int orderId) {
        // Implementation for getting an order
        return new Order(orderId, "2024-10-01", 100.0, "email@gmail.com", "type");
    }

    @Override
    public Order updateOrderStatus(Order order) {
        // Implementation for updating the order status
        System.out.println("Order status updated");
        return order;
    }
    
}
