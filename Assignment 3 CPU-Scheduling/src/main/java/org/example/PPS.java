package org.example;

import java.util.Scanner;

public class PPS {
    private int processID;
    private int arrivalTime;
    private int burstTime;
    private int priority;

    public PPS(int processID, int arrivalTime, int burstTime, int priority){
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    public void Initialize(){
        System.out.println("***Preemptive Priority Scheduling***");
        System.out.println("Enter number of processes:");
        Scanner sc = new Scanner(System.in);
        int numberOfProcess = sc.nextInt();
        String process[] = new String[numberOfProcess];
    }
}
