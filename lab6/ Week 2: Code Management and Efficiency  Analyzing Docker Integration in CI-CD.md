## Lab Instructions
## 1. Review Simulated CI/CD Pipeline Configuration:
- **Build Stage:**

    - **Code Commit:** Developers commit code to a version control system, triggering the CI pipeline.

      - **Beneficios:**

        Cuando tenemos un pipeline que se ejecuta cuando el desarrollador hace un commit, nos da la posibilidad de ejecutar pruebas de calidad de software, de vulnerabilidades, de pruebas unitarias, permitiéndonos garantizar que el código cuenta con la calidad que se requiera.

      - **Desafíos potenciales:**
      
        El garantizar las cualidades que necesita el código para comenzar el flujo del pipeline, requiere de mayor esfuerzo, y compromete al desarrollador a cumplir con ciertas normas, implicando mayor atención y tiempo para lograr que el código que se sube, no implique que se rompan los lineamientos que están preestablecidos.
        
        - Mejoras
        
          Capacitación de las personas, para que sepan como llevar a cabo el correcto funcionamiento de los pipelines y cada una de sus etapas.

    - **Docker Image Creation:** Dockerfiles define the environment and dependencies, and Docker builds an image which encapsulates the application and its runtime.

      - **Beneficios:**
          
        Al trabajar con docker garantizamos, que cuando desarrollamos, el funcionamiento será el mismo a lo largo de todos los ambientes que lo despleguemos, garantizamos que funcione igual en dev, qa, staging, prod, etc...  

      - **Desafíos potenciales:**

          Podemos encontrar vulnerabilidades en las imágenes de docker, esto implica que pongamos en riesgo a la empresa.
          Cuando tenemos que administrar muchas imágenes, la gestión puede ser una tarea difícil.

        - Mejoras

          Ejecutar pruebas de vulnerabilidades, así mismo ejecutar pruebas de la imagen y herramientas como snyk. Así mismo mantener las versiones más actualizadas.
          Utilizar un administrador de imagenes como Kubernetes o Swarm.

- **Test Stage:**

    - **Automated Testing:** Docker images are used to spin up containers where automated tests are conducted, ensuring that the application behaves as expected in an environment identical to production.

      - **Beneficios:**

        Al trabajar pruebas automatizadas, garantizamos que cuando realicemos cambios en el código, no vayamos a generar bugs y también corroboramos que no se rompan las funcionalidades ya existentes.

      - **Desafíos potenciales:**

        Se puede elevar mucho la complejidad al momento de estar desarrollando, implica más tiempo al momento de programar.
        
          - Mejoras
          
            Capacitar al personal, para cumplir con las pruebas necesarias. Y validar que las pruebas cumplan con la totalidad de las funcionalidades, ya que si esto no se cumple, no podríamos reemplazar las pruebas manuales.
- **Deployment Stage:**

    - **Container Registry:** Successfully tested Docker images are tagged and pushed to a Docker registry.
      - **Beneficios:**

        Podemos manejar imágenes, versionarlas, y trabajar con ellas, teniendo puntos de respaldo que nos podrían ayudar en caso de alguna contingencia.

      - **Desafíos potenciales:**

        Si no se gestionan de manera adecuada, podemos exponer el código a atacantes, o exponer nuestro código, generando riesgos al momento de exponer los recursos de la empresa.

    - **Orchestration and Deployment:** Tools like Kubernetes or Docker Swarm manage the deployment of these images into containers across different environments, handling scaling and load balancing.
      - **Beneficios:**

          Podemos gestionar la ejecución de las imágenes, autoescalarlas según sea la demanda, y administrar todos los elementos de los contenedores en elementos básicos como pods.

      - **Desafíos potenciales:**

          El mantenimiento del cluster, así como el tema de los costes altos, de cada servicio desplegado se convierte en costos muy altos.
        - Mejoras
          
            Poder diseñar de manera adecuada, el comportamiento de los servicios que estarán desplegados en el cluster de kubernetes. Permitiendo hacer más eficientes los costos de nuestro sistema, ayudándonos de otras herramientas que se manejen en la nube, con tal de no hacer un uso excesivo de los servicios que estén ejecutándose. 
## 2. Analyze Enhancements and Potential Issues:
- **Enhancements:** Consider how Docker’s containerization benefits the build, test, and deployment processes by providing consistency, portability, and scalability.
- **Potential Issues:** Reflect on any possible challenges that might arise with Docker integration, such as security vulnerabilities in images, complexity in managing large numbers of services, or difficulties in orchestrating containers.

## 3. Write an Analysis Report:
- Task: Individually write a brief report that:
   - Summarizes how Docker is integrated into each stage of the CI/CD pipeline.
   - Analyzes the benefits and potential challenges identified during the review.
   - Suggests theoretical solutions or best practices to overcome the challenges.

| Etapa                 | Beneficios                                                                                                                                                                                               | Desafíos potenciales                                                                                                                                                 | Mejoras                                                                                                                                                                                                            |
|-----------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Etapa de Construcción | Desencadenador automatico que permite realizar todas las tareas necesarias para la cosntrucción de nuestra aplicación<br/> Garantizar que el código funcionara de la misma manera en todos los ambientes | Podemos encontrar vulnerabilidades que implican cuidado en este rubro<br/> El incremento del manejo de muchas imagenes, aumentará la complejidad para administrarlas | Ejecutar pruebas de vulnerabilidades en la imagenes<br/>Uso de aplicaciones con Kubernetes o Docker Swarm                                                                                                          |
| Etapa de pruebas      | Se garantiza que al meter algún cambio no se rompa el comportamiento actual, garantizando que no se metan bugs al crear nuevas funcionalidades                                                           | La curva de aprendizaje de los desarrolladores                                                                                                                       | La capacitación de los desarrolladores, y aprender a hacer las pruebas correctamente para identificar errores al momento de codificar                                                                              | 
| Etapa de despliegue   | Se pueden guardar las imágenes generadas, versionarlas, y administrarlas<br/> Podemos administrar las imágenes, escalarlas, y gestionar todos sus elementos con otras aplicaciones.                      | Se pueden exponer recursos en un repositorio público <br/> Se pueden incrementar los costos del cluster.                                                             | Se puede tener un registro de contenedores privado <br/> Se debe de diseñar correctamente como queremos que funcionen nuestros servicios, y utilizar herramientas adecuadas, para que no incrementemos los costos. |
## Evaluation Criteria
The success of this lab will be assessed based on the following criteria:

- **Quality of Analysis:** Evaluated by the depth and accuracy with which Docker’s integration into each stage of the CI/CD pipeline is explained. This includes a clear identification of how Docker enhances processes and potential drawbacks it might introduce.

- **Understanding of Docker Concepts:** Assessed based on the ability to apply theoretical knowledge about Docker to identify its impacts on CI/CD pipeline efficiency and reliability.

- **Solution Effectiveness:** Measured by the appropriateness and potential effectiveness of the proposed solutions or improvements to address the identified challenges within the pipeline setup.

- **Report Clarity and Structure:** Evaluated by the organization of the report, including how well the analysis is structured, the clarity of writing, and the logical flow of ideas from introduction to conclusion