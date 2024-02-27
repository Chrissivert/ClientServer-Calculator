package org.example.booking;

public class MovieTicketClient extends Thread {

    String customerName;
    int numberOfSeats;
    MovieTicketServer server;

    public MovieTicketClient(MovieTicketServer server, String customerName, int numberOfSeats) {
        this.customerName = customerName;
        this.numberOfSeats = numberOfSeats;
        this.server = server;
    }

    public void run() {
        server.bookTicket(customerName, numberOfSeats);
    }

}
