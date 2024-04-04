package org.example;

/**
 * First come, first served CPU-scheduling. Enter the number of processes,
 * burst time and arrival time in main method.
 */
public class TestChrisSivert {


    /**
     * Function to find the waiting time for the processes
     * @param n number of processes
     * @param burstTime array of burst time
     * @param waitingTime array of waiting time
     * @param arrivalTime array of arrival time
     */
    static void findWaitingTime(int processes[], int n,
                                int burstTime[], int waitingTime[], int arrivalTime[]) {
        int service_time[] = new int[n];
        service_time[0] = 0;
        waitingTime[0] = 0;

        // calculating waiting time
        for (int i = 1; i < n; i++) {
            // Calculate service time for each process
            service_time[i] = service_time[i - 1] + burstTime[i - 1];

            // Calculate waiting time
            waitingTime[i] = Math.max(0, service_time[i] - arrivalTime[i]);
        }
    }

    /**
     * Function to find the turn around time for the processes
     * @param processes array of processes
     * @param n number of processes
     * @param burstTime array of burst time
     * @param waitingTime array of waiting time
     * @param turnTime array of turn around time
     */
    static void findTurnAroundTime(int processes[], int n,
                                   int burstTime[], int waitingTime[], int turnTime[]) {
        // calculating turnaround time by adding
        // burstTime[i] + waitingTime[i]
        for (int i = 0; i < n; i++) {
            turnTime[i] = burstTime[i] + waitingTime[i];
        }
    }


    /**
     * Function to calculate average time
     * @param processes array of processes
     * @param n number of processes
     * @param burstTime array of burst time
     * @param arrivalTime array of arrival time
     */
    static void findavgTime(int processes[], int n, int burstTime[], int arrivalTime[]) {
        int waitTime[] = new int[n], turnTime[] = new int[n];
        int totalWaitingTime = 0, totalTurnTime = 0;

        //Function to find waiting time of all processes
        findWaitingTime(processes, n, burstTime, waitTime, arrivalTime);

        //Function to find turn around time for all processes
        findTurnAroundTime(processes, n, burstTime, waitTime, turnTime);

        System.out.printf("Processes Burst time Arrival time Waiting"
                +" time Turn around time\n");

        // Calculate total waiting time and total turn
        // around time
        for (int i = 0; i < n; i++) {
            totalWaitingTime = totalWaitingTime + waitTime[i];
            totalTurnTime = totalTurnTime + turnTime[i];
            System.out.printf(" %d ", (i + 1));
            System.out.printf("     %d ", burstTime[i]);
            System.out.printf("     %d ", arrivalTime[i]);
            System.out.printf("     %d", waitTime[i]);
            System.out.printf("     %d\n", turnTime[i]);
        }
        float averageWaitingTime = (float)totalWaitingTime /(float) n;
        int averageTurnTime = totalTurnTime / n;
        System.out.printf("Average waiting time = %f", averageWaitingTime);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", averageTurnTime);
    }

    public static void main(String[] args) {
        int processes[] = {1, 2, 3};
        int burst_time[] = {10, 5, 8};
        int arrival_time[] = {0, 2, 4};

        int n = processes.length;

        findavgTime(processes, n, burst_time, arrival_time);

    }
}
