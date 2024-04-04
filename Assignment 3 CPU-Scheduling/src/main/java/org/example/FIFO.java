package org.example;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

public class FIFO<Integer> extends AbstractQueue<Integer> {

  private LinkedList<Integer> elements;
  private int processId;
  private int arrivalTime;
  private int burtsTime;

  public FIFO() {
    this.elements = new LinkedList<Integer>();
  }

  @Override
  public boolean offer(Integer num) {
    if(num == null) {
      return false;
    }

    this.elements.add(num);
    return true;
  }

  @Override
  public Integer poll() {
    Iterator<Integer> iterator = this.elements.iterator();
    Integer num = iterator.next();

    if (num != null) {
      iterator.remove();
      return num;
    }

    return null;
  }

  @Override
  public Integer peek() {
    return this.elements.getFirst();
  }

  @Override
  public Iterator<Integer> iterator() {
    return this.elements.iterator();
  }

  @Override
  public int size() {
    return this.elements.size();
  }
}