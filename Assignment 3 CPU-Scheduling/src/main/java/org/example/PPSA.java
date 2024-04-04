package org.example;

import java.util.*;

/**
 * This is the Preemptive Priority scheduling algorithm
 */
public class PPSA {
    private int processId;
    private int arrivalTime;
    private int burstTime;
    private int priority;
    private int remainingTime;

    /**
     * Creates an instance of the Preemptive Priority scheduling algorithm.
     */
    public PPSA(int processId, int arrivalTime, int burstTime, int priority){
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        List<PPSA> processes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for process " + (i + 1) + ":");
            System.out.print("Process ID: ");
            int processId = scanner.nextInt();
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();
            System.out.print("Priority: ");
            int priority = scanner.nextInt();
            processes.add(new PPSA(processId, arrivalTime, burstTime, priority));
        }

        // Sort the processes based on arrival time
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        // Priority Queue to store processes based on priority
        PriorityQueue<PPSA> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.priority));

        int currentTime = 0;
        int completed = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        System.out.println("Gantt Chart:");
        while (completed < n) {
            // Add processes to the queue that have arrived
            while (!processes.isEmpty() && processes.get(0).arrivalTime <= currentTime) {
                pq.add(processes.remove(0));
            }

            if (pq.isEmpty()) {
                currentTime++;
                continue;
            }

            // Process with highest priority
            PPSA currentProcess = pq.poll();

            // Execute the process for 1 unit of time
            System.out.print("| P" + currentProcess.processId + " ");
            currentTime++;
            currentProcess.remainingTime--;

            // Check if process is completed
            if (currentProcess.remainingTime == 0) {
                completed++;
                int turnaroundTime = currentTime - currentProcess.arrivalTime;
                int waitingTime = turnaroundTime - currentProcess.burstTime;
                totalWaitingTime += waitingTime;
                totalTurnaroundTime += turnaroundTime;
            } else {
                // Add back to the queue if not completed
                pq.add(currentProcess);
            }
        }
        System.out.println("|");

        double avgWaitingTime = (double) totalWaitingTime / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}
