/*
 * Se refactoriza la clase SystemManager para que se encargue de instanciar las clases necesarias para procesar una orden.
 * Estas instancias funciona de forma independiente aplicando el principio de Single Responsibility Principle.
 */
class SystemManager {
    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        NotifyService notifyService = new NotifyService();

        Order order = new Order(1, "2023-10-01", 100.0, "email@gmail.com", "standard");

        ProccessOrder proccessOrder = new ProccessOrder(order);

        proccessOrder.processOrder(order);

        orderService.updateOrderStatus(order);
        notifyService.notifyCustomer(order);
    }
}

