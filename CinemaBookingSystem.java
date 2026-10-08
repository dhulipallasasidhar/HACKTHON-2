import java.util.Scanner;
import java.text.DecimalFormat;

class MovieTicket {
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;

    // Constructor
    public MovieTicket(String movieName, double ticketPrice, int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    // Method to calculate total amount
    public double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    // Method to calculate discount
    public double calculateDiscount() {
        if (numberOfTickets >= 5) {
            return calculateTotal() * 0.10; // 10% discount
        } else {
            return 0.0;
        }
    }

    // Method to calculate final amount
    public double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    // Method to display bill
    public void displayBill() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("----- Cinema Ticket Booking Bill -----");
        System.out.println("Movie Name      : " + movieName);
        System.out.println("Ticket Price    : ₹" + df.format(ticketPrice));
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Total Amount    : ₹" + df.format(calculateTotal()));
        System.out.println("Discount        : ₹" + df.format(calculateDiscount()));
        System.out.println("Final Amount    : ₹" + df.format(calculateFinalAmount()));
        System.out.println("--------------------------------------");
    }
}

public class CinemaBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input values
        System.out.print("Enter movie name: ");
        String movieName = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double ticketPrice = sc.nextDouble();

        System.out.print("Enter number of tickets: ");
        int numberOfTickets = sc.nextInt();

        // Create MovieTicket object
        MovieTicket ticket = new MovieTicket(movieName, ticketPrice, numberOfTickets);

        // Display bill
        ticket.displayBill();

        sc.close();
    }
}
