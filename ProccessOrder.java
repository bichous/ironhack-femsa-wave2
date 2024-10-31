
/*
 * Esta clase se encarga de procesar la orden de compra
 * Dejando a cada clase encargada de una sola responsabilidad 
 * y queda abierto a futuras extensiones, aplicando el principio de Open-Closed Principle
 */
public class ProccessOrder implements IProccessOrder {

    private Order order;
    private InventoryImp inventoryImp;
    private PaymentService paymentService;
    private PaymentExpressService paymentExpressService;

    public ProccessOrder(Order order) {
        this.order = order;
    }

    //Orden de proceso
    public void processOrder(Order order) {
        if (order.getType() == "standard") {
            inventoryImp.verifyInventory(order);
            processStandardPayment(order);
        } else if (order.getType() == "express") {
            inventoryImp.verifyInventory(order);
            processExpressPayment(order, "highPriority");
        }
        
    }

    //Proceso de pago estándar
    @Override
    public Boolean processStandardPayment(Order order) {
        // Handles standard payment processing
        if (paymentService.process(order.getOrderAmount())) {
            return true;
        } else {
            throw new Error("Payment failed");
        }
    }

    @Override
    public Boolean processExpressPayment(Order order, String priority) {
         // Handles express payment processing
         if (paymentExpressService.process(order.getOrderAmount(), priority)) {
            return true;
        } else {
            throw new Error("Express payment failed");
        }
    }
}