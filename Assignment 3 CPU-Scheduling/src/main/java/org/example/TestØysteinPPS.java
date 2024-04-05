package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class TestØysteinPPS {
    private int processID;
    private int arrivalTime;
    private int burstTime;
    private int priority;
    private int remainingTime;

    public void Initialize(){
        System.out.println("***Preemptive Priority Scheduling***");
        System.out.println("Enter number of processes:");
        Scanner sc = new Scanner(System.in);
        int numberOfProcess = sc.nextInt();
        String process[] = new String[numberOfProcess];

        // Array to store burst time of each process
        int[] burstTimes = new int[numberOfProcess];
        // Array to store remaining time of each process
        int[] remainingTimes = new int[numberOfProcess];

        for (int i = 0; i < numberOfProcess; i++) {
            System.out.println("Enter ID of process number " + (i));
            Scanner sc2 = new Scanner(System.in);
            processID = sc2.nextInt();
            System.out.println("Enter arrival time of process number " + (i));
            arrivalTime = sc2.nextInt();
            System.out.println("Enter burst time of process number " + (i));
            burstTime = sc2.nextInt();
            System.out.println("Enter priority of process number " + (i));
            priority = sc2.nextInt();
            // Assign burst time and remaining time
            burstTimes[i] = burstTime;
            remainingTimes[i] = burstTime;
        }

        // Simulating the scheduling
        int currentTime = 0;
        while (true) {
            boolean allFinished = true;
            for (int i = 0; i < numberOfProcess; i++) {
                if (remainingTimes[i] > 0 && arrivalTime <= currentTime) {
                    allFinished = false;
                    System.out.println("Processing process with ID: " + i);
                    remainingTimes[i]--;
                    if (remainingTimes[i] == 0) {
                        System.out.println("Process " + i + " finished at time " + currentTime);
                    }
                    break; // Move to the next time unit
                }
            }
            if (allFinished)
                break; // All processes finished
            currentTime++; // Move to the next time unit
        }

        System.out.println(Arrays.toString(process));
    }

    public static void main(String[] args) {
        TestØysteinPPS scheduler = new TestØysteinPPS();
        scheduler.Initialize();
    }
}