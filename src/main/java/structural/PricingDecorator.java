package structural;
abstract class BasePrice {
    public abstract double getPrice();
}
class StdRoomPrice extends BasePrice {
    public double getPrice() {
        return 100;
    }
}
class SuiteRoomPrice extends BasePrice {
    public double getPrice() {
        return 200;
    }
}
class InRoomServicesPrice extends BasePrice {
    private BasePrice basePrice;
    public InRoomServicesPrice(BasePrice basePrice) {
        this.basePrice = basePrice;
    }   
    public double getPrice() {
        return basePrice.getPrice() + 50;
    }
}
class BreakfastPrice extends BasePrice {
    private BasePrice basePrice;
    public BreakfastPrice(BasePrice basePrice) {
        this.basePrice = basePrice;
    }   
    public double getPrice() {
        return basePrice.getPrice() + 20;
    }
}
class PricingDecoratorTest {
    public static void main(String[] args) {
        BasePrice stdRoom = new StdRoomPrice();
        BasePrice suiteRoom = new SuiteRoomPrice();
        BasePrice stdRoomWithInRoomServices = new InRoomServicesPrice(stdRoom);
        BasePrice suiteRoomWithInRoomServices = new InRoomServicesPrice(suiteRoom);
        BasePrice stdRoomWithBreakfast = new BreakfastPrice(stdRoom);
        BasePrice suiteRoomWithBreakfast = new BreakfastPrice(suiteRoom);
        System.out.println("Std Room: " + stdRoom.getPrice());
        System.out.println("Suite Room: " + suiteRoom.getPrice());
        System.out.println("Std Room with In Room Services: " + stdRoomWithInRoomServices.getPrice());
        System.out.println("Suite Room with In Room Services: " + suiteRoomWithInRoomServices.getPrice());
        System.out.println("Std Room with Breakfast: " + stdRoomWithBreakfast.getPrice());
        System.out.println("Suite Room with Breakfast: " + suiteRoomWithBreakfast.getPrice());
    }
}