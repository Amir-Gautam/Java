class Seat {
    String seatNumber;

    Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    void bookSeat() {
        System.out.println("Seat " + seatNumber + " booked.");
    }
}

class RegularSeat extends Seat {
    RegularSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    void bookSeat() {
        System.out.println("Regular seat " + seatNumber + " booked anytime, no extra charges.");
    }
}

class PremiumSeat extends Seat {
    private double snackCost;
    private double luxuryTax;

    PremiumSeat(String seatNumber, double snackCost, double luxuryTax) {
        super(seatNumber);
        this.snackCost = snackCost;
        this.luxuryTax = luxuryTax;
    }

    @Override
    void bookSeat() {
        double total = snackCost + luxuryTax;
        System.out.println("Premium seat " + seatNumber + " booked with snack and luxury tax. Extra cost: Rs. " + total);
    }
}

public class TheaterBooking {
    public static void main(String[] args) {
        Seat[] seats = {
            new RegularSeat("A12"),
            new PremiumSeat("P1", 300, 150)
        };

        for (Seat seat : seats) {
            seat.bookSeat();
        }
    }
}
