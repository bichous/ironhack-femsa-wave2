package antonio.incorrect;

/*
LA CLASE NO CUMPLE CON LOS PRINCIPIOS OCP PORQUE CONSIDERO QUE CUALQUIER CAMBIOS
* QUE SE DESEE AGREGAR IMPLICA MODIFICAR EL CODIGO DE LA CLASE.
 */
public class SystemManager {

    //Aqui se tienen varias responsabilidades, por lo tanto no cumple con el principio de responsabilidad unica.
    processOrder(order) {
        if (order.type == "standard") {
            verifyInventory(order);
            processStandardPayment(order);
        } else if (order.type == "express") {
            verifyInventory(order);
            processExpressPayment(order, "highPriority");
        }
        updateOrderStatus(order, "processed");
        notifyCustomer(order);
    }

    //Este metodo pudiera estar en una clase ServiceInventory aparte.
    verifyInventory(order) {
        // Checks inventory levels
        if (inventory < order.quantity) {
            throw new Error("Out of stock");
        }
    }

    //Este metodo pudiera estar en una clase ServicePayment aparte.
    processStandardPayment(order) {
        // Handles standard payment processing
        if (paymentService.process(order.amount)) {
            return true;
        } else {
            throw new Error("Payment failed");
        }
    }

    //Este metodo pudiera estar en una clase ServicePayment aparte.
    processExpressPayment(order, priority) {
        // Handles express payment processing
        if (expressPaymentService.process(order.amount, priority)) {
            return true;
        } else {
            throw new Error("Express payment failed");
        }
    }

    //Este metodo pudiera estar en una clase ServiceOrder aparte.
    updateOrderStatus(order, status) {
        // Updates the order status in the database
        database.updateOrderStatus(order.id, status);
    }

    //Este metodo pudiera estar en una clase ServiceEmail aparte.
    notifyCustomer(order) {
        // Sends an email notification to the customer
        emailService.sendEmail(order.customerEmail, "Your order has been processed.");
    }
}
