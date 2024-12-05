/*
Refactor the code to make it more readable and maintainable

1. Single Responsability Principle - The SystemManager class performs multiple tasks therefore the code has been
divided into classes based on a specific responsibility. In this case the classes that have been created are
InventoryService, OrderStatusService, NotificationService and PaymentService, which are responsible for
checks inventory levels, order status update, notification to customer, and payment processing respectively.

2. Open/Closed Principle - The SystemManager class needs to be modified to add new payment process or new 
notification types therefore an interface and derived classes must be implemented for each one, allowing the system 
to be expanded without modifying the existing code.

3. Liskov Substitution Principle - The SystemManager class does not have clear hierarchies that can be extended 
without modifying the original implementation, so the StandardPaymentService and ExpressPaymentService classes 
were created and extend PaymentService. The OrderProcessor class can use any of these payment services without 
affecting their functionality. This ensures that the behavior is as expected when overriding service implementations.

4. Interface Segregation Principle - Specialized interfaces such as PaymentService, InventoryService, NotificationService, 
and OrderStatusService have been created. Each class implements only the methods it needs, preventing classes from 
depending on methods they do not use.

5. Dependency Inversion Principle - The SystemManager class depends on interfaces (InventoryService, OrderStatusService, 
NotificationService and PaymentService), which makes high-level classes not dependent on low-level classes.
*/

// Interface for Inventory Services
class InventoryService {
    verify(order) {
        throw new Error("Method 'verify' must be implemented.");
    }
}
// Checks inventory levels - Verify Inventory Implementation
class VerifyInventoryService extends InventoryService {
    verify(order) {
        if (inventory < order.quantity) {
            throw new Error("Out of stock");
        }
    }
}

// Interface for Notification Service
class NotificationService {
    notify(order) {
        throw new Error("Method 'notify' must be implemented.");
    }
}
// Email Notification Implementation
class EmailNotificationService extends NotificationService {
    notify(order) {
        emailService.sendEmail(order.customerEmail, "Your order has been processed.");
    }
}

// Interface for Order Status Update Service
class OrderStatusService {
    updateStatus(order, status) {
        throw new Error("Method 'updateStatus' must be implemented.");
    }
}
// Update Order Status Implementation
class UpdateOrderStatusService extends OrderStatusService {
    updateStatus(order, status) {
        database.updateOrderStatus(order.id, status);
    }
}

// Interface for Payment Services
class PaymentService {
    process(amount) {
        throw new Error("Method 'process' must be implemented.");
    }
}
// Standard Payment Implementation
class StandardPaymentService extends PaymentService {    
    process(amount) {
        if (paymentService.process(amount)) {
            return true;
        } else {
            throw new Error("Payment failed");
        }
    }
}
// Express Payment Implementation
class ExpressPaymentService extends PaymentService {
    process(amount, priority) {
        if (expressPaymentService.process(amount, priority)) {
            return true;
        } else {
            throw new Error("Express payment failed");
        }
    }
}

// Order Processing Logic separated from System Manager
class OrderProcessor {
    constructor(paymentService, inventoryService, notificationService, orderStatusService) {
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
        this.notificationService = notificationService;
        this.orderStatusService = orderStatusService;
    }
    processOrder(order) {
        this.inventoryService.verify(order);
        let paymentSuccessful = this.handlePayment(order);
        if (paymentSuccessful) {
            this.orderStatusService.updateStatus(order, "processed");
            this.notificationService.notify(order);
        }
    }
    handlePayment(order) {
        if (order.type === "standard") {
            return this.paymentService.process(order.amount);
        } else if (order.type === "express") {
            return this.paymentService.process(order.amount, "highPriority");
        }
        return false;
    }
}

// Main entry point to process orders
class SystemManager {
    constructor() {
        // Dependency Injection
        this.inventoryService = new VerifyInventoryService();
        this.orderStatusService = new UpdateOrderStatusService();
        this.notificationService = new EmailNotificationService();
    }
    processOrder(order) {
        let paymentService;
        if (order.type === "standard") {
            paymentService = new StandardPaymentService();
        } else if (order.type === "express") {
            paymentService = new ExpressPaymentService();
        }
        const orderProcessor = new OrderProcessor(paymentService, this.inventoryService, this.notificationService, this.orderStatusService);
        orderProcessor.processOrder(order);
    }
}