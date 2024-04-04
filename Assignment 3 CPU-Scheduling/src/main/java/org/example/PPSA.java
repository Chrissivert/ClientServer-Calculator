package org.example;

import java.util.*;

/**
 * This class implements the Preemptive Priority Scheduling Algorithm.
 * Preemptive Priority Scheduling is a scheduling algorithm in which the process with the highest priority
 * is executed first. If two processes have the same priority, the one with the earliest arrival time is executed first.
 * To use this algorithm, run the java class "PPSA" and submit the number of processes to be used in this algorithm.
 * Then submit the following values to create an instance of a process, such as process id, arrival time, burst time
 * and priority. When submitting this, the algorithm will print a simplified gantt chart as well as the average
 * waiting- and turnaround time.
 *
 * @author Group 10
 * @version 07/04/2024
 */
public class PPSA {
    private int processId; // ID of the process
    private int arrivalTime; // Time at which the process arrives
    private int burstTime; // Time required for the process to execute
    private int priority; // Priority of the process
    private int remainingTime; // Remaining execution time of the process

    /**
     * Constructs an instance of the Preemptive Priority Scheduling Algorithm.
     * @param processId ID of the process
     * @param arrivalTime Time at which the process arrives
     * @param burstTime Time required for the process to execute
     * @param priority Priority of the process
     */
    public PPSA(int processId, int arrivalTime, int burstTime, int priority){
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
    }

    /**
     * Main method to execute the Preemptive Priority Scheduling Algorithm.
     * Prompts the user to enter details for processes and calculates average waiting time
     * and average turnaround time for the processes.
     * @param args Command-line arguments
     */
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

            // Process with the highest priority
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
