# Conversor de Divisas

## Descripción
Este proyecto es un conversor de divisas en Java que permite a los usuarios convertir entre diferentes monedas, utilizando tasas de cambio obtenidas de una API.
El programa está diseñado para ser fácil de usar y puede manejar múltiples conversiones de manera eficiente.

## Estructura del Proyecto
La estructura del proyecto es la siguiente:

conversor/ ├── com/ │ └── alura/ │ └── conversor/ │ ├── excepcion/ # Excepciones personalizadas │ │ └── ConversionException.java │ ├── calculos/ # Lógica de conversión │ │ ├── Conversor.java │ │ ├── ConversorMoneda.java │ └── principal/ # Main y lógica principal │ └── Main.java └── README.md # Documentación del proyecto


### Descripción de los Componentes
- **excepcion/ConversionException.java**: Clase personalizada para manejar excepciones relacionadas con las conversiones de divisas.
- **calculos/Conversor.java**: Contiene la lógica básica para realizar las conversiones.
- **calculos/ConversorMoneda.java**: Implementa las funcionalidades específicas para convertir entre diferentes monedas, utilizando tasas de cambio.
- **principal/Main.java**: Clase principal que gestiona la entrada del usuario, muestra el menú y realiza las conversiones.

- Conceptos Vistos
Método toString()
El método toString() es una función heredada de la clase Object en Java. Este método se utiliza para devolver una representación en forma de cadena de un objeto.
Al sobrescribir este método en nuestras clases, podemos proporcionar una descripción más significativa de los objetos que creamos, facilitando su impresión y depuración. Por ejemplo,
en el contexto de este proyecto, podríamos sobrescribir toString() en la clase ConversorMoneda para que devuelva el nombre de la moneda y su tasa de cambio.

ArrayList
ArrayList es una de las implementaciones de la interfaz List en Java. Proporciona una estructura de datos dinámica que puede cambiar de tamaño automáticamente a
medida que se añaden o eliminan elementos. A diferencia de los arrays tradicionales, que tienen un tamaño fijo, ArrayList permite manejar colecciones de elementos
de manera más flexible. En este proyecto, usamos ArrayList para almacenar las diferentes conversiones de moneda disponibles, lo que facilita la gestión y acceso a estas conversiones.

Programación Orientada a Objetos (OOP)
La programación orientada a objetos es un paradigma de programación que utiliza "objetos" para representar datos y métodos que operan sobre esos datos. Los principios
clave de la OOP son la encapsulación, la herencia y el polimorfismo. En este proyecto, aplicamos estos principios al definir clases como ConversorMoneda y ConversionException,
donde encapsulamos datos y comportamientos relacionados. Esto hace que el código sea más modular, reutilizable y fácil de mantener.

try-catch
La estructura try-catch se utiliza en Java para manejar excepciones. Al envolver el código que puede generar una excepción dentro de un bloque try, podemos "capturar"
las excepciones que se producen y manejarlas adecuadamente en el bloque catch. Esto previene que el programa se detenga abruptamente y permite al desarrollador proporcionar
un manejo de errores más amigable para el usuario. En este proyecto, podríamos usar try-catch al realizar conversiones que dependen de la entrada del usuario, garantizando
que el programa se comporte de manera predecible ante entradas inválidas.

Llamado a la API
Este proyecto utiliza una API externa para obtener tasas de cambio actualizadas. El llamado a la API se realiza mediante solicitudes HTTP, utilizando la biblioteca Gson para manejar la respuesta en formato JSON. Al iniciar la aplicación, la clase ConversorMoneda se encarga de:

Realizar una solicitud a la API de ExchangeRate-API utilizando una clave de API.
Obtener las tasas de cambio actuales y almacenarlas en una estructura de datos adecuada (como un Map).
Permitir que el usuario seleccione diferentes conversiones de divisas basadas en las tasas obtenidas.

## Requisitos
- Java 8 o superior.
- Librería [Gson](https://github.com/google/gson) para manejar JSON (asegúrate de incluir `gson-2.11.0.jar` en tu classpath).

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/conversor.git

 ***************************
1. Dólar USA --> Peso Colombiano
2. Dólar USA --> Real Brasileño
3. Dólar USA --> Peso Argentino
4. Peso Colombiano --> Dólar USA
5. Real Brasileño --> Dólar USA
6. Peso Argentino --> Dólar USA
7. Salir
***************************
Elige una opción: 
