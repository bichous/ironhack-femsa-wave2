/****
 * Patrón: En java podriamos utilizar executos, en node async y await
 * Razón: nos ayuda a manejar tareas asincrónicas de forma eficiente
 *
 */
public class EfficientManagement {

    private static final ExecutorService executor = Executors.newFixedThreadPool(5); // Ajusta el número de hilos 

    public static CompletableFuture<String> fetchData(String url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simula el tiempo de respuesta de la operación asincrónica
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Datos de " + url;
        }, executor); // Especifica el executor
    }

    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://api1.com", "https://api2.com", "https://api3.com");

        // Crear una lista de CompletableFutures para cada URL
        List<CompletableFuture<String>> futures = urls.stream()
                .map(EfficientManagement::fetchData)
                .toList();

        // Usar CompletableFuture.allOf para esperar todas las operaciones
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        // Procesar los resultados una vez que todas las operaciones se completen
        allOf.thenRun(() -> {
            futures.forEach(future -> {
                try {
                    System.out.println(future.get());  // Obtener el resultado de cada operación
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }).join(); // Esperar hasta que todas las tareas finalicen

        // Cerrar el executor al finalizar
        executor.shutdown();
    }
}
