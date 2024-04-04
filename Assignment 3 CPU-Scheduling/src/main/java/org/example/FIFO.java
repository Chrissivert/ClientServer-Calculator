package org.example;

import java.util.ArrayList;
import java.util.List;

public class FIFO {
  public static void watingTime(List<Integer> processes, Integer num, List<Integer> burstTime, List<Integer> waitTime) {
    waitTime.add(0, 0);
    for (int i = 1; i < num; i++) {
      waitTime.add(i, burstTime.get(i-1) + waitTime.get(i-1));
    }
  }

  public static void turnAroundTime(List<Integer> processes, Integer num, List<Integer> burstTime, List<Integer> waitTime, List<Integer> tat) {
    for (int i = 0; i < num; i++) {
      tat.add(i, burstTime.get(i) + waitTime.get(i));
    }
  }

  public static void avgTime(List<Integer> processes, Integer num, List<Integer> burstTime) {
    List<Integer> waitTime = new ArrayList<>(num);
    List<Integer> tat = new ArrayList<>(num);
    Integer total_waitTime = 0;
    Integer total_tat = 0;

    watingTime(processes, num, burstTime, waitTime);
    turnAroundTime(processes, num, burstTime, waitTime, tat);

    System.out.println("Processes " + " Burst Time " + " Wati Time " + " Turn AroundTime\n");

    for (int i = 0; i < num; i ++) {
      total_waitTime = total_waitTime + waitTime.get(i);
      total_tat = total_tat + tat.get(i);
      System.out.println(" " + i+1 + "\t\t" + burstTime.get(i) + "\t " + waitTime.get(i) + "\t\t" + tat.get(i));
    }

    System.out.println("Average Waiting Time = " + (double)(total_waitTime / num));
    System.out.println("Average Turn Around Time = " + (double)(total_tat / num));
  }

  public static void main(String[] args) {
    List<Integer> processes = new ArrayList<>();
    processes.add(1);
    processes.add(2);
    processes.add(3);
    Integer num = (processes.size()/processes.get(0));
    List<Integer> burst_time = new ArrayList<>();
    burst_time.add(7);
    burst_time.add(5);
    burst_time.add(6);
    avgTime(processes, num, burst_time);
  }
}