public class InventoryImp implements IInventory {
    
    // verificar inventario
    @Override
    public Boolean verifyInventory(Order order) {
        System.out.println("Se verifica el inventario");
        Boolean inventory = true;
        // Checks inventory levels
        if (!inventory) {
            throw new Error("Out of stock");
        }
        return true;

    }
}
