class Ticket {
    String ticketNumber;
    double price;

    Ticket(String ticketNumber, double price) {
        this.ticketNumber = ticketNumber;
        this.price = price;
    }

    void generateTicket() {
        System.out.println("Ticket #" + ticketNumber + " - Price: Rs. " + price);
    }
}

class BusTicket extends Ticket {
    private String seatNumber;

    BusTicket(String ticketNumber, double price, String seatNumber) {
        super(ticketNumber, price);
        this.seatNumber = seatNumber;
    }

    @Override
    void generateTicket() {
        System.out.println("Sajha Yatayat Bus Ticket #" + ticketNumber + " - Seat: " + seatNumber + " - Price: Rs. " + price);
    }
}

class TrainTicket extends Ticket {
    private String coachType;

    TrainTicket(String ticketNumber, double price, String coachType) {
        super(ticketNumber, price);
        this.coachType = coachType;
    }

    @Override
    void generateTicket() {
        System.out.println("Janakpur Railway Ticket #" + ticketNumber + " - Coach: " + coachType + " - Price: Rs. " + price);
    }
}

class FlightTicket extends Ticket {
    private String boardingGate;

    FlightTicket(String ticketNumber, double price, String boardingGate) {
        super(ticketNumber, price);
        this.boardingGate = boardingGate;
    }

    @Override
    void generateTicket() {
        System.out.println("Buddha Air Flight Ticket #" + ticketNumber + " - Gate: " + boardingGate + " - Price: Rs. " + price);
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        Ticket[] tickets = {
            new BusTicket("BUS001", 550, "12A"),
            new TrainTicket("TRN001", 150, "General"),
            new FlightTicket("FLT001", 8500, "G14")
        };

        for (Ticket ticket : tickets) {
            ticket.generateTicket();
        }
    }
}
