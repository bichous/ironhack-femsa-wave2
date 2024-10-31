/*
 * Este clase solo se encarga procesar el pago
 * Dejando a cada clase encargada de una sola responsabilidad
 */
public class PaymentExpressService {    
    public Boolean process(double amount, String priority) {
        System.out.println("Procesando pago");
        // Procesa el pago express
        return true;
    }
    
}
