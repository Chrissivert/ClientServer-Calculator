package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class PPS {
    private int processID;
    private int arrivalTime;
    private int burstTime;
    private int priority;

    public PPS(){

    }

    public void Initialize(){
        System.out.println("***Preemptive Priority Scheduling***");
        System.out.println("Enter number of processes:");
        Scanner sc = new Scanner(System.in);
        int numberOfProcess = sc.nextInt();
        String process[] = new String[numberOfProcess];

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
        }
        System.out.println(Arrays.toString(process));
    }
}
