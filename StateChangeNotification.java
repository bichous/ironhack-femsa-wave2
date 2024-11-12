/****
 * Patrón: Observer
 * Razón: Este patron nos ayuda a notificar a verios componentes cuando ocurre un cambio en el estado de otro component
 * sin crear un fuerte acoplamiento entre ellos
 *
 */

public interface Display {
    void display();
}

public class CurrentConditionsDisplay implements Observer, Display {
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public 
    void update(Subject subject) 
    {
        WeatherStation weatherStation = (WeatherStation) subject;
        this.temperature = weatherStation.getTemperature();
        this.humidity = weatherStation.getHumidity();
        display();
    }

    public void display() {
        System.out.println("Current temperature: " + temperature + "F , and " + humidity + "% humidity"); 

    }

    private float temperature;
    private float humidity; 

}