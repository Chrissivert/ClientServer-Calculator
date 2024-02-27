package org.example;

import java.io.*;
import java.net.*;

public class MultiThreadedServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from " + clientSocket);

                Thread clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String[] input = in.readLine().split(" ");

            long startTime = System.currentTimeMillis();
            String result = calculate(input);
            out.println(result);

            long endTime = System.currentTimeMillis();

            long elapsedTime = endTime - startTime;
            System.out.println("Time taken to calculate: " + elapsedTime + " milliseconds");

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String calculate(String[] input) {
        double num1 = Double.parseDouble(input[0]);
        double num2 = Double.parseDouble(input[1]);
        char operator = input[2].charAt(0);

        switch (operator) {
            case '+':
                return "Your numbers equals to: " + (double)(num1 + num2);
            case '-':
                return "Your numbers equals to: " + (double)(num1 - num2);
            case '*':
                return "Your numbers equals to: " + (double)(num1 * num2);
            case '/':
                return "Your numbers equals to: " + (double)(num1 / num2);
            case '%':
                return "Your numbers equals to: " + (double)(num1 % num2);
            default:
                return "Invalid operator: " + operator;
        }
    }
}

