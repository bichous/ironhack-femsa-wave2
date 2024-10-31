
/*
 * ESta clase solo se encarga de notificar al cliente, aplicando el principio de Single Responsibility Principle
 */

public class NotifyService {
    public void notifyCustomer(Order order) {
        System.out.println("Notificando al cliente");
        // Notifica al cliente
    }
}
