import spock.lang.Specification

class UserAuthenticationSpec extends Specification {

    /**** Scenario 1
     * Se realizan algunos cambios para modificar las UT
     * 1.- Aislamos las pruebas por objetivo: Credenciales correctas, credenciales invalidas
     * 2.- Definimos los nombres descriptivos de las pruebas
     * 3.- Realizamos la configuración y limpieza (Mock, Setup, Cleanup)
     * 4.- Validamos diferentes escenarios, no solo el happy path
     *
     * **/

    def authenticationService = null

    def setup() {
        authenticationService = new AuthenticationService()
    }

    def cleanup() {
        authenticationService = null
    }

    def "authenticate_shouldSucceedWithCorrectCredentials"() {
        given: "a valid username and password"
        String username = "validUser"
        String password = "validPass"

        expect: "authentication is successful"
        authenticationService.authenticate(username, password) == true
    }

    def "authenticate_shouldFailWithIncorrectPassword"() {
        given: "a valid username and an incorrect password"
        String username = "validUser"
        String password = "wrongPass"

        expect: "authentication fails"
        authenticationService.authenticate(username, password) == false
    }

    def "authenticate_shouldFailWithIncorrectUser"() {
        given: "a valid username and an incorrect password"
        String username = "invalidUser"
        String password = "correctPassword"

        expect: "authentication fails"
        authenticationService.authenticate(username, password) == false
    }

}
