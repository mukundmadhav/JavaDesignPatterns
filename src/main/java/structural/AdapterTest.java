package structural;

class CalcFareinUSD {
    double fare;
    public CalcFareinUSD(double fare) {
        this.fare = fare;
    }
    public double getFareinUSD() {
        return fare;
    }
}
class FairAdapter {
    private CalcFareinUSD calcFareinUSD;
    public FairAdapter(CalcFareinUSD calcFareinUSD) {
        this.calcFareinUSD = calcFareinUSD;
    }
    public double getFareinINR() {
        return calcFareinUSD.getFareinUSD() * 75;
    }
}

public class AdapterTest {

    public static void main(String[] args) {
        CalcFareinUSD calcFareinUSD = new CalcFareinUSD(100);
        FairAdapter fairAdapter = new FairAdapter(calcFareinUSD);
        System.out.println("Fare in INR: " + fairAdapter.getFareinINR());
    }
    
}
