/**
 * IProccessOrder Interface con la responsabilidad de procesar una orden de compra,
 * aplicando el principio de Single Responsibility Principle
 * y principio de Interface Segregation Principle
 */

public interface IProccessOrder {
    Boolean processStandardPayment(Order order);
    Boolean processExpressPayment(Order order, String priority);
}
