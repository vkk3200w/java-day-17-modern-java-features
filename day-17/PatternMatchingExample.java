sealed interface Payment
        permits CashPayment, CardPayment, UpiPayment {
}

record CashPayment(double amount)
        implements Payment {
}

record CardPayment(double amount, String cardNumber)
        implements Payment {
}

record UpiPayment(double amount, String upiId)
        implements Payment {
}

public class PatternMatchingExample {

    public static void main(String[] args) {

        Payment payment = new CardPayment(
            2500.0,
            "123456789012"
        );

        String result = switch (payment) {

            case CashPayment cash ->
                "Cash payment: " + cash.amount();

            case CardPayment card ->
                "Card payment: " + card.amount()
                + ", Card: " + card.cardNumber();

            case UpiPayment upi ->
                "UPI payment: " + upi.amount()
                + ", UPI ID: " + upi.upiId();
        };

        System.out.println(result);
    }
}