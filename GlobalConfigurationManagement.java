/****
 * Patrón: Singleton
 * Razón: Este patrón asegura que haya solo un objeto de forma global, ésto garantiza que todos los componentes
 *  de la aplicacion usen los mismos valores
 */
public class GlobalConfigurationManagement {
    private static GlobalConfigurationManagement instance;
    private Properties configProps;

    private GlobalConfigurationManagement() {
        configProps = new Properties();
    }

    public static GlobalConfigurationManagement getInstance() {
        if (instance == null) {
            instance = new GlobalConfigurationManagement();
        }
        return instance;
    }

    // se tienen que generar los getters de las propiedades dependiendo las que se necesiten
    public static Properties getProperty1() {
        return configProps.getProperty1(key);
    }
}

class Properties{
    // se pueden senerar las propiedades que se necesiten y sus respectivos getters 
    private final static String PROPERTY_1 = "property1";

    public String getProperty1(String property1){
        return PROPERTY_1;
    }
}