package DIP;

public class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod; // Ya no depende de una implementación concreta
    }

    public void makePayment(double amount) {
        paymentMethod.processPayment(amount);
    }
}
