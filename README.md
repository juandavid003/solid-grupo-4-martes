# SRP - Single Responsibility Principle
Descripción
Este ejercicio aplica el Principio de Responsabilidad Única (SRP), que establece que una clase debe tener una única razón para cambiar. Inicialmente, el código tenía clases multifuncionales que mezclaban lógica de negocio, validación, almacenamiento y comunicación.
 
## Refactorización
Se dividieron las responsabilidades en distintas clases:
 
Validator: valida los datos del usuario.
 
UserRepository: simula el almacenamiento de datos.
 
EmailService: maneja el envío de correos.
 
UserService: coordina el proceso de registro de usuario.
 
## Problemas resueltos
Evita acoplamiento innecesario: cada clase cumple una única función clara.
 
Mejor mantenimiento: los cambios en la validación no afectan al repositorio o al envío de emails.
 
Facilita pruebas unitarias: se pueden probar las clases de forma aislada.
 
## Ejecución
Desde Main, se crea un usuario y se llama al servicio de registro (UserService.register(user)), que:
 
Valida los datos.
 
Guarda el usuario.
 
Envía un correo de confirmación.
 
Todo ello sin que una sola clase asuma más de una responsabilidad.
 
## Reflexión
SRP mejora la legibilidad, modularidad y testabilidad del sistema. Aplicarlo obliga a pensar en términos de responsabilidades bien definidas, facilitando el trabajo en equipo y el mantenimiento a largo plazo.
 
 
# OCP - Open/Closed Principle
##  Descripción
Este ejercicio aplica el Principio de Abierto/Cerrado (OCP), el cual establece que las clases deben estar abiertas para extensión pero cerradas para modificación.
Inicialmente, si se quería agregar un nuevo tipo de notificación (por ejemplo, SMS o push), era necesario modificar directamente la clase encargada de enviar notificaciones, lo que rompía este principio.
 
##  Refactorización
Se introdujo una abstracción común:
 
Notification (interfaz): define el método send().
 
Y se crearon implementaciones específicas:
 
EmailNotification
 
SMSNotification
 
PushNotification
 
La clase NotificationService fue refactorizada para trabajar con la interfaz Notification sin importar el tipo concreto.
 
##  Problemas resueltos
No es necesario modificar código existente para agregar nuevas notificaciones.
 
Cumple con OCP: se extiende el sistema con nuevas clases, sin alterar las existentes.
 
Reduce errores en producción, ya que el código probado no se toca.
 
##  Ejecución
En Main.java, se instancian diferentes tipos de notificaciones (correo, SMS, push) y se envían mediante NotificationService.
 
java
Copiar
Editar
Notification email = new EmailNotification();
Notification sms = new SMSNotification();
Notification push = new PushNotification();
 
NotificationService service = new NotificationService();
service.sendNotification(email);
service.sendNotification(sms);
service.sendNotification(push);
## Reflexión
Aplicar OCP permite crear sistemas modulares, escalables y seguros ante cambios. En lugar de alterar el comportamiento interno de una clase para cubrir nuevos casos, se crean nuevas clases que extienden la funcionalidad, manteniendo la estabilidad del sistema original.
 
# LSP - Liskov Substitution Principle
## Descripción
Este ejercicio aplica el Principio de Sustitución de Liskov (LSP), que establece que las clases derivadas deben poder sustituir a sus clases base sin alterar el funcionamiento correcto del programa.
 
Inicialmente, todas las clases hijas heredaban métodos que no eran aplicables en ciertos contextos. Por ejemplo, obligar a un Fish a implementar walk() causaba excepciones o comportamientos inválidos.
 
## Refactorización
Se dividió el comportamiento en interfaces más específicas:
 
Animal: clase base general.
 
Walkable: interfaz con el método walk().
 
Y se aplicó de la siguiente forma:
 
Dog extiende Animal e implementa Walkable.
 
Fish extiende Animal pero no implementa Walkable, ya que no camina.
 
## Problemas resueltos
Se evita forzar comportamientos inapropiados (como peces caminando).
 
Mejora la lógica del programa, manteniendo la coherencia del dominio.
 
Cumple con LSP: cualquier clase hija puede reemplazar a la clase padre sin causar fallos.
 
## Ejecución
En Main.java, se crean instancias de Dog y Fish. Solo los objetos que implementan Walkable pueden ser utilizados para caminar:
 
java
Copiar
Editar
Dog dog = new Dog();
dog.walk();
 
Fish fish = new Fish();
// fish.walk(); // No compila ni lanza error: simplemente no tiene ese método.
## Reflexión
Aplicar LSP refuerza la coherencia semántica de las jerarquías de clases. Ayuda a evitar errores por mal diseño de herencia y asegura que cada clase hija cumpla correctamente el contrato de su clase padre o interfaz, sin romper el sistema.
 
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
 
 
## Reflexión:
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