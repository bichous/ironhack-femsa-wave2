/**
 * IOrderService Interface con la responsabilidad de solo trabajar con ordenes,
 * aplicando el principio de Single Responsibility Principle
 * y principio de Interface Segregation Principle
 */
public interface IOrderService {
    void createOrder(Order order);
    Order getOrder(int orderId);
    Order updateOrderStatus(Order order);
}
