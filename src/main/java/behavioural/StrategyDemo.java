package behavioural;

public class StrategyDemo {

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new CreditCardStrategy());
        paymentService.makePayment();
        paymentService = new PaymentService(new UPIStrategy());
        paymentService.makePayment();
    }
    
}

class PaymentService {

	PaymentStrategy payStrategy;
	public PaymentService(PaymentStrategy payStrategy) {
		this.payStrategy = payStrategy;
	}

	void makePayment() {
		payStrategy.completePayment();
		System.out.println("Payment done");
	}

}
interface PaymentStrategy {
	public void completePayment();
}
class CreditCardStrategy implements PaymentStrategy {
	@Override
	public void completePayment() {
		System.out.println("Processing by CC");
	}
}
class UPIStrategy implements PaymentStrategy {
	@Override
	public void completePayment() {
		System.out.println("Processing by UPI");
	}
}