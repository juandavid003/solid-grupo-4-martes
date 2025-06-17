# ISP - Interface Segregation Principle

## Descripción

En este ejercicio se aplicó el **Principio de Segregación de Interfaces (ISP)**. Se partió de una interfaz `Device` que forzaba a todas las clases que la implementaban a definir métodos no aplicables (por ejemplo, `charge()` en dispositivos no recargables).

## Refactorización

Se dividió la interfaz original en dos:
- `Device`: métodos comunes (`turnOn()`, `turnOff()`)
- `Rechargeable`: solo con el método `charge()`

De este modo, solo las clases que realmente lo requieren implementan `Rechargeable`.

## Problemas resueltos

- **Evita métodos innecesarios:** Ahora, las clases como `DisposableCamera` ya no están obligadas a implementar métodos irrelevantes.
- **Más mantenible:** Es más fácil agregar nuevos dispositivos que sean solo encendibles/apagables o recargables.
- **Previene errores en tiempo de ejecución:** No hay más lanzamientos de `UnsupportedOperationException` por métodos que no deberían existir.

## Ejecución

Se probaron ambos dispositivos:
- `Phone`: Se puede encender, apagar y cargar.
- `DisposableCamera`: Solo se puede encender y apagar, no tiene método de carga.


**Reflexión:**  
Aplicar ISP nos obliga a pensar cuidadosamente en las responsabilidades reales de cada clase y a evitar inflar interfaces con métodos innecesarios. Así, el código se vuelve más limpio y robusto.






# DIP - Dependency Inversion Principle

## Descripción

Este ejercicio aplica el **Principio de Inversión de Dependencias (DIP)** para un sistema de gestión de pagos. En la versión original, la clase `PaymentProcessor` dependía directamente de una implementación concreta, impidiendo la extensión del sistema a nuevos métodos de pago.

## Refactorización

- Se creó la interfaz `PaymentMethod` para abstraer los distintos métodos de pago.
- Se implementaron clases concretas para tarjeta de crédito, PayPal y criptomonedas.
- `PaymentProcessor` ahora depende de la abstracción, lo que facilita la extensión y el mantenimiento.

## Problemas resueltos

- **Desacoplamiento:** Ahora es fácil agregar nuevos métodos de pago sin modificar la lógica del procesador.
- **Escalabilidad:** El sistema se puede extender a nuevos métodos sin romper el código existente.
- **Código más limpio y flexible:** Las clases cumplen el principio de abierto/cerrado y pueden ser inyectadas (por ejemplo, mediante un framework de inversión de control en proyectos más grandes).

## Ejecución

Se realizaron pagos exitosos con tarjeta de crédito, PayPal y criptomonedas.

## Reflexión

El DIP ayuda a que los módulos de alto nivel no dependan de módulos de bajo nivel, sino de abstracciones. Esto reduce el acoplamiento y facilita la mantenibilidad, la extensibilidad y la posibilidad de pruebas unitarias.



