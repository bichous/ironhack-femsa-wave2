import spock.lang.Specification

class UIResponsivenessSpec extends Specification {

    /**** Scenario 3
     * Se realizan algunos cambios para modificar las UT
     * 1.- Aislamos las pruebas por objetivo: Ajustar pantalla con valores positivos, Ajustar pantalla con valores negativos
     * 2.- Definimos los nombres descriptivos de las pruebas
     * 3.- Realizar la configuracion de los servicios (Mocks)
     *
     * **/

    def uiComponent = Mock(UiComponentService)


    def "UI component should adjust to a screen width of 1024 pixels"() {
        given: "a UI component and a screen width of 1024 pixels"
        int screenWidth = 1024

        when: "the component adjusts to the screen width"
        boolean result = uiComponent.adjustsToScreenSize(screenWidth)

        then: "the component should successfully adjust to 1024 pixels"
        result
    }

    def "UI component should not adjust to a negative screen width"() {
        given: "a UI component and an invalid screen width of -100 pixels"
        int screenWidth = -100

        when: "the component attempts to adjust to an invalid screen width"
        uiComponent.adjustsToScreenSize(screenWidth)

        then: "an exception is thrown due to invalid screen width"
        def error = thrown(IllegalArgumentException)
        error.message == "Invalid screen width"
    }


}
