package org.example;

/**
 * This is the Preemptive Priority scheduling algorithm
 */
public class PPSA {
    private int processId;
    private int arrivalTime;
    private int burstTime;
    private int priority;

    /**
     * Creates an instance of the Preemptive Priority scheduling algorithm.
     */
    public PPSA(int processId, int arrivalTime, int burstTime, int priority){
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}
