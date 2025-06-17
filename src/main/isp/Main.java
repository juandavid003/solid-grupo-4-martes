package isp;

public class Main {
    public static void main(String[] args) {
        Device phone = new Phone();
        Device camera = new DisposableCamera();

        phone.turnOn();
        ((Rechargeable) phone).charge(); 

        camera.turnOn();
        // camera.charge(); // Esto ya no existe, ni compila, así evitamos errores
    }
}
