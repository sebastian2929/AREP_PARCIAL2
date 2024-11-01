# PARCIAL 2

## Descripcion

Este proyecto implementa un sistema de microservicios que proporciona dos servicios para la búsqueda de elementos en listas de cadenas: búsqueda lineal y búsqueda binaria. El sistema está diseñado con un service proxy que distribuye las solicitudes entre dos instancias de los servicios de ordenamiento usando un algoritmo de round-robin. Además, incluye un cliente web que permite a los usuarios invocar los servicios de manera asíncrona.
 

## Logrado en el parcial
- Se implemento MathService
- Se creo un Proxy
- Se logro correr en local
- No se pudo implementar en nube
![image](https://github.com/user-attachments/assets/37894295-f72f-4c35-a255-b116460f4177)
![image](https://github.com/user-attachments/assets/483370ab-19cc-4f03-86d8-ddc521da005a)

## Como correr
- Primero
```
git clone https://github.com/sebastian2929/AREP_PARCIAL2.git
```
- Segundo
```
mvn clean install
```
- Tercero
```
mvn spring-boot:run 
```
- Cuarto
ingresar a ``` localhost:8080 ```
## Arquitectura del Sistema
![image](https://github.com/user-attachments/assets/52dc3de0-fc14-433c-9937-03ccea6c69f9)

- Service Proxy
- Math Services
- Búsqueda Lineal: Implementa la búsqueda lineal de un valor en una lista de cadenas.
- Búsqueda Binaria: Implementa la búsqueda binaria de un valor en una lista ordenada de cadenas.
- Cliente Web: Un formulario HTML para recibir entradas del usuario y hacer llamadas a los servicios a través del proxy.


## Requisitos
- Java 17 o superior
- Spring Boot
- AWS EC2
## Autor

- [Sebastián David Blanco Rodríguez](https://github.com/Sebastian2929)


## Licencia


Este proyecto está bajo la Licencia (MIT) - ver el archivo [LICENSE](LICENSE.md) para ver más detalles.


