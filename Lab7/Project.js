/**
 * Desafío #1: Gestión de configuración global
 * ---- Diseñar un sistema que garantice un único objeto de configuración accesible globalmente sin conflictos de acceso. ----
 * Patrón de diseño: Singleton
 * Justificación: Este patrón garantiza que una clase(en este caso "Configuración") solo puede tener una instancia y proporciona un punto de acceso global a esa misma.
 */

class Configuration {
    static instance = null;
    constructor() {
      if (Configuration.instance) {
        return Configuration.instance;
      }
      // Se define la configuración inicial
      this.config = { team: "cruz azul", country: "mex" };
      // Se guarda la instancia para garantizar que únicamente exista una
      Configuration.instance = this;
    }
    getConfiguration() {
      return this.config;
    }
    setConfiguration(config) {
      this.config = { ...this.config, ...config };
    }
}

const configTeamA = new Configuration();
const configTeamB = new Configuration();
console.log(configTeamA === configTeamB);  // Ambas son la misma instancia (true)
console.log(configTeamA.getConfiguration());  // { team: "cruz azul", country: "mex" }
configTeamA.setConfiguration({ team: "pumas" });
console.log(configTeamB.getConfiguration());  // { team: "pumas", country: "mex" }

/**
 * Desafío #2: Creación dinámica de objetos basada en la entrada del usuario
 * ---- Implementar un sistema para crear dinámicamente varios tipos de elementos de interfaz de usuario en función de las acciones del usuario. ----
 * Patrón de diseño: Factory
 * Justificación: Este patrón permite que se logre la creación dinámica de objetos sin tener que especificar las clases exactas, lo que facilita la extensibilidad y mantenimiento del código.
 */

class Button {
    render() {
        console.log("Generando un botón");
    }
}
class Input {
    render() {
        console.log("Generando un campo de entrada");
    }
}
class Checkbox {
    render() {
        console.log("Generando un checkbox");
    }
}
class FactoryElement {
    static createItem(type) {
        switch (type) {
            case "button":
                return new Button();
            case "input":
                return new Input();
            case "checkbox":
                return new Checkbox();
            default:
                throw new Error("Tipo no reconocido");
        }
    }
}

const elementType = "input";  // Valor seleccionado por el usuario
const element = FactoryElement.createItem(elementType);
element.render();  // Generando un input

/**
 * Desafío #3: Notificación de cambio de estado en todos los componentes del sistema
 * ---- Garantizar que los componentes reciban notificaciones sobre los cambios en el estado de otras partes sin crear un acoplamiento estrecho. ----
 * Patrón de diseño: Observer
 * Justificación: Este patrón permite que los observadores reciban notificaciones sobre los cambios de estado de un objeto sin tener que estar acoplados directamente.
 */

class Notification {
    constructor() {
        this.observers = [];
    }
    addObserver(observador) {
        this.observers.push(observador);
    }
    removeObserver(observador) {
        this.observers = this.observers.filter(obs => obs !== observador);
    }
    notify() {
        this.observers.forEach(obs => obs.update());
    }
}
class Observer {
    constructor(name) {
        this.name = name;
    }
    update() {
        console.log(`${this.name} ha sido notificado que cambió el estado!`);
    }
}

const notification = new Notification();
const observerA = new Observer('Observer A');
const observerB = new Observer('Observer B');
notification.addObserver(observerA);
notification.addObserver(observerB);
notification.notify();  // Se notifica a todos los observadores

/**
 * Desafío #4: Gestión eficiente de operaciones asincrónicas
 * ---- Gestionar múltiples operaciones asincrónicas, como llamadas API, que deben coordinarse sin bloquear el flujo de trabajo de la aplicación principal. ----
 * Patrón de diseño: Asynchronous Model (Promise, Async/Await)
 * Justificación: Este patrón permite coordinar varias operaciones asincrónicas de manera eficiente y no bloqueante, evitando el problema de callback hell.
 */
// Opción A: Promise
function fetchData(url) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (url === "https://api.example.com") {
                resolve("Data fetched successfully");
            } else {
                reject("Error fetching data");
            }
        }, 1000);
    });
}
async function manageRequests() {
    try {
        const response1 = await fetchData("https://api.example.com");
        console.log(response1);
        const response2 = await fetchData("https://api.unknown.com");
        console.log(response2);
    } catch (error) {
        console.log(error);
    }
}
manageRequests();
// Opción B: Uso del Promise.all()
function fetchDataB(url) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (url === "https://api.example.com") {
                resolve("Data fetched from " + url);
            } else {
                reject("Error fetching data from " + url);
            }
        }, 1000);
    });
}
Promise.all([
    fetchDataB("https://api.example.com"),
    fetchDataB("https://api.unknown.com")
])
.then(results => {
    console.log(results); // Cuando las promesas indicadas son exitosas
})
.catch(error => {
    console.log(error); // Cuando alguna promesa indicada falla
});