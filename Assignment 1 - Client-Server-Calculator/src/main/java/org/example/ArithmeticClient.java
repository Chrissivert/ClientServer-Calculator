package org.example;

import java.io.*;
import java.net.*;

public class ArithmeticClient {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 30;
        long startTime = System.currentTimeMillis();
        int sleepTimeInMilli = 0;
        for (int i = 0; i < numThreads; i++) {
            new Thread(new ClientTask()).start();
            sleepTimeInMilli = 1000;
            Thread.sleep(sleepTimeInMilli);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime - (sleepTimeInMilli * numThreads) + " milliseconds");
    }
}

class ClientTask implements Runnable {
    @Override
    public void run() {
        String hostName = "localhost";
        int portNumber = 12345;

        try {
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            double num1 = Math.random() * 100;
            double num2 = Math.random() * 100;
            char[] operators = {'+', '-', '*', '/'};
            char operator = operators[(int)(Math.random() * operators.length)];

            out.println(num1 + " " + num2 + " " + operator);

            String response = in.readLine();
            System.out.println("Result from server: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
