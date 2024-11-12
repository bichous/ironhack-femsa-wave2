/****
 * Patrón: Factory
 * Razón: Este patrón nos ayuda con la creación de objetos basados en los parametros de entrada,
 *  ésto nos permite crear los objetos de forma dinámica dependiendo a las acciones del usuario
 *
 */

interface UIElement {
    void render();
}

class Button implements UIElement {
    // agregar los métodos de botton
}

class TextField implements UIElement {
    // agregar los métodos de textfield
}

public class DynamicObjectCreation {
    public static final BUTTON = "buttotn";
    public static final TEXT_FIELD = "text_field";

    public UIElement createElement(String type) {
        Switch (type) {
        case BUTTON:
            return new Button();
        case TEXT_FIELD:
            return new TextField();
            // podriamos agregar mas tipos de elementos
        default:
            return null;
        }
        
    }
}