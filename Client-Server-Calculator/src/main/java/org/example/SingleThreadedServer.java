package org.example;

import java.io.*;
import java.net.*;

public class SingleThreadedServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from " + clientSocket);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String[] input = in.readLine().split(" ");
                String result = calculate(input);
                out.println(result);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String calculate(String[] input) {
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
