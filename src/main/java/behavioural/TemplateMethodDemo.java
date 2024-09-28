package behavioural;

public class TemplateMethodDemo {

    public static void main(String[] args) {
        PaymentFlow paymentFlow = new PayToFriend();
        paymentFlow.pay();

        paymentFlow = new PayToBusiness();
        paymentFlow.pay();
    }
}

abstract class PaymentFlow {
    abstract void checkBalance();

    abstract void debitAndCredit();

    abstract void reconciliation();

    final void pay() {
        System.out.println("\n");
        checkBalance();
        debitAndCredit();
        reconciliation();
    }

}

class PayToFriend extends PaymentFlow {

    @Override
    void checkBalance() {
        System.out.println("Checking Balance for friends");
    }

    @Override
    void debitAndCredit() {
        System.out.println("Debit and Credit for friends");
    }

    @Override
    void reconciliation() {

        System.out.println("Reconciliation for friends");

    }
}

class PayToBusiness extends PaymentFlow {

    @Override
    void checkBalance() {
        System.out.println("Checking Balance for business");
    }

    @Override
    void debitAndCredit() {
        System.out.println("Debit and Credit for business");
    }

    @Override
    void reconciliation() {
        System.out.println("Reconciliation for business");
    }
}