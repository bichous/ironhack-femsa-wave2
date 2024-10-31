/**
 * Inventory Interface con una minima responsabilidad de verificar el inventario,
 * aplicando el principio de Single Responsibility Principle
 * y principio de Interface Segregation Principle
 */
public interface IInventory {

    Boolean verifyInventory(Order order);
}
