import spock.lang.Specification

class DataProcessingSpec extends Specification {

    /**** Scenario 2
     * Se realizan algunos cambios para modificar las UT
     * 1.- Se aislan las pruebas por objetivo: Pruebas con datos exitosos, Pruebas con datos invalidos, Pruebas  con datos nulos
     * 2.- Definimos nombres descriptivos de las pruebas
     * 3.- Realizamos la configuración y limpieza (Setup, Cleanup)
     * 4.- Validamos diferentes escenarios, no solo el happy path (solo con datos exitosos)
     *
     * **/

    def dataService = null

    def setup() {
        dataService = new DataService()
        data = dataService.fetchData()
    }

    def cleanup() {
        dataService = null
        data = null;
    }

    def "data_shouldProcessSuccessfully"() {
        given: "a valid dataset"
        def values = [1,2,3,4,5]

        when: "process data set"
        boolean success = data.processData(values)

        then: "process should be successfully"
        data.processedSuccessfully == success

    }

    def "data_shouldHandleProcessingWithInvalidValues"() {
        given: "an invalid dataset that throws an error"
        def values = ["1","2","3","4","("]

        when: "try to process invalid data set"
         data.processData(values)

        then: "throws an exception with processing error"
        def error = thrown(RuntimeException)
        error.message == "Data processing error"
    }

    def "data_shouldHandleProcessingWithNullValues"() {
        given: "an invalid dataset that throws an error"
        def values = null

        when: "try to process a null data set"
        data.processData(values)

        then: "throws an exception with processing error"
        def error = thrown(RuntimeException)
        error.message == "Data processing error, values are null"
    }
}
