package antonio.correct;

import java.util.HashMap;
import java.util.Map;

// Interface for order processing
public interface OrderProcessor {
    void process(Order order);
}

// Class for standard order processing
public class StandardOrderProcessor implements OrderProcessor {
    private InventoryService inventoryService;
    private PaymentService paymentService;

    public StandardOrderProcessor(InventoryService inventoryService, PaymentService paymentService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    @Override
    public void process(Order order) {
        inventoryService.verifyInventory(order);
        paymentService.processStandardPayment(order);
    }
}

// Class for express order processing
public class ExpressOrderProcessor implements OrderProcessor {
    private InventoryService inventoryService;
    private ExpressPaymentService expressPaymentService;

    public ExpressOrderProcessor(InventoryService inventoryService, ExpressPaymentService expressPaymentService) {
        this.inventoryService = inventoryService;
        this.expressPaymentService = expressPaymentService;
    }

    @Override
    public void process(Order order) {
        inventoryService.verifyInventory(order);
        expressPaymentService.processExpressPayment(order, "highPriority");
    }
}

// Service for inventory management
public class InventoryService {
    public void verifyInventory(Order order) {
        // Checks inventory levels
        if (inventory < order.quantity) {
            throw new Error("Out of stock");
        }
    }
}

// Service for standard payment processing
public class PaymentService {
    public boolean processStandardPayment(double amount) {
        // Handles standard payment processing
        return paymentService.process(amount);
    }
}

// Service for express payment processing
public class ExpressPaymentService {
    public boolean processExpressPayment(double amount, String priority) {
        // Handles express payment processing
        return expressPaymentService.process(amount, priority);
    }
}

// Service for updating order status
public class OrderStatusService {
    public void updateOrderStatus(int orderId, String status) {
        // Updates the order status in the database
        database.updateOrderStatus(orderId, status);
    }
}

// Service for sending email notifications
public class EmailService {
    public void sendEmail(String customerEmail, String message) {
        // Sends an email notification to the customer
        emailService.sendEmail(customerEmail, message);
    }
}

// Main class that uses the services and processors
public class SystemManagerSolid {
    private Map<String, OrderProcessor> processors;
    private OrderStatusService orderStatusService;
    private EmailService emailService;

    public SystemManagerSolid(InventoryService inventoryService, PaymentService paymentService, ExpressPaymentService expressPaymentService, OrderStatusService orderStatusService, EmailService emailService) {
        processors = new HashMap<>();
        processors.put("standard", new StandardOrderProcessor(inventoryService, paymentService));
        processors.put("express", new ExpressOrderProcessor(inventoryService, expressPaymentService));
        this.orderStatusService = orderStatusService;
        this.emailService = emailService;
    }

    public void processOrder(Order order) {
        OrderProcessor processor = processors.get(order.getType());
        if (processor != null) {
            processor.process(order);
            orderStatusService.updateOrderStatus(order.getId(), "processed");
            emailService.sendEmail(order.getCustomerEmail(), "Your order has been processed.");
        } else {
            throw new IllegalArgumentException("Unknown order type");
        }
    }
}