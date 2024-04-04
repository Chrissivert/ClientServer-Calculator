package org.example;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * <p>First-in-first-out list. Includes methods to handle first elements in such as: <p>
 * <ul>
 * <li>'offer' to add elements</li>
 * <li>'poll' to remove the first elements</li>
 * <li>'peek' to get the first elements</li>
 * </ul>
 */
public class FCFS<T> extends AbstractQueue<T> {

  private LinkedList<T> elements;

  /**
   * Constructor for the FIFO-list algorithm.
   */
  public FCFS() {
    this.elements = new LinkedList<T>();
  }

  @Override
  public boolean offer(T t) {
    if(t == null) {
      return false;
    }

    this.elements.add(t);
    return true;
  }

  @Override
  public T poll() {
    Iterator<T> iterator = this.elements.iterator();
    T t = iterator.next();

    if (t != null) {
      iterator.remove();
      return t;
    }

    return null;
  }

  @Override
  public T peek() {
    return this.elements.getFirst();
  }

  @Override
  public Iterator<T> iterator() {
    return this.elements.iterator();
  }

  @Override
  public int size() {
    return this.elements.size();
  }
}