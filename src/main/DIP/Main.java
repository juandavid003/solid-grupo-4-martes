package DIP;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor creditCardProcessor = new PaymentProcessor(new CreditCardPayment());
        creditCardProcessor.makePayment(150.0);

        PaymentProcessor paypalProcessor = new PaymentProcessor(new PayPalPayment());
        paypalProcessor.makePayment(75.5);

        PaymentProcessor cryptoProcessor = new PaymentProcessor(new CryptoPayment());
        cryptoProcessor.makePayment(200.0);
    }
}
