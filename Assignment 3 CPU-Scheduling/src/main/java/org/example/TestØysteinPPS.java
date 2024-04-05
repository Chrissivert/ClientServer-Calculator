package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

/**
 * This class represents a Preemptive Priority Scheduling algorithm.
 */
public class TestØysteinPPS {
    private int processID;
    private int arrivalTime;
    private int burstTime;
    private int priority;
    private int remainingTime;

    /**
     * Constructor to create a process instance.
     * @param processID     The ID of the process.
     * @param arrivalTime   The arrival time of the process.
     * @param burstTime     The burst time of the process.
     * @param priority      The priority of the process.
     */
    public TestØysteinPPS(int processID, int arrivalTime, int burstTime, int priority) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
    }

    /**
     * Initializes the Preemptive Priority Scheduling algorithm.
     * This method prompts the user to input details of processes such as process ID,
     * arrival time, burst time, and priority. It then simulates the scheduling
     * based on the preemptive priority scheduling algorithm.
     */
    public void Initialize() {
        System.out.println("***Preemptive Priority Scheduling***");
        System.out.println("Enter number of processes:");
        Scanner sc = new Scanner(System.in);
        int numberOfProcesses = sc.nextInt();

        List<TestØysteinPPS> processes = new ArrayList<>();

        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.println("Enter ID of process number " + (i));
            int processID = sc.nextInt();
            System.out.println("Enter arrival time of process number " + (i));
            int arrivalTime = sc.nextInt();
            System.out.println("Enter burst time of process number " + (i));
            int burstTime = sc.nextInt();
            System.out.println("Enter priority of process number " + (i));
            int priority = sc.nextInt();
            processes.add(new TestØysteinPPS(processID, arrivalTime, burstTime, priority));
        }

        // Sort processes by arrival time
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;
        List<String> ganttChart = new ArrayList<>();

        while (!processes.isEmpty()) {
            TestØysteinPPS currentProcess = null;
            int highestPriority = Integer.MAX_VALUE;

            for (TestØysteinPPS process : processes) {
                if (process.arrivalTime <= currentTime && process.priority < highestPriority) {
                    highestPriority = process.priority;
                    currentProcess = process;
                }
            }

            if (currentProcess == null) {
                currentTime++;
                ganttChart.add("-");
            } else {
                ganttChart.add("P" + currentProcess.processID);
                currentProcess.remainingTime--;
                currentTime++;

                if (currentProcess.remainingTime == 0) {
                    processes.remove(currentProcess);
                }
            }
        }

        // Print Gantt chart
        System.out.println("Gantt Chart:");
        System.out.print("|");
        for (String process : ganttChart) {
            System.out.print(process + "|");
        }
        System.out.println();
    }

    /**
     * The main method to execute the Preemptive Priority Scheduling algorithm.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        TestØysteinPPS scheduler = new TestØysteinPPS(0,0,0,0);
        scheduler.Initialize();
    }
}