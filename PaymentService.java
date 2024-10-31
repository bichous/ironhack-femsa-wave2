/**
 * Esta clase solo se encarga de realizar el pago
 * Dejando a cada clase encargada de una sola responsabilidad
 */
public class PaymentService {
    public Boolean process(double amount) {
        System.out.println("Payment in process: " + amount);
        return true;
    }
}
