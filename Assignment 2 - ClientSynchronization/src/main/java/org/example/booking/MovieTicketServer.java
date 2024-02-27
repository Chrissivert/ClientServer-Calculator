package org.example.booking;

public class MovieTicketServer {

    String movieName;
    int availableSeats;


    public MovieTicketServer(String movieName, int availableSeats) {
        this.movieName = movieName;
        this.availableSeats = availableSeats;
    }

    public synchronized void bookTicket(String customerName, int numberOfSeats) {
      System.out.println("Hi," + customerName + " : "
              + availableSeats + " : Seats available for " + movieName);
        if ((availableSeats - numberOfSeats) < 0) {
            System.out.println("Sorry, " + customerName + " : "
                    + "No seats available for " + movieName);
        } else {
            availableSeats -= numberOfSeats;
            System.out.println("Congratulations, " + customerName + " : "
                    + "Booked " + numberOfSeats + " seats for " + movieName);
        }
    }
}