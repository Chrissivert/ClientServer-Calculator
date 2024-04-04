package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LineTest {
  @Test
  public void testAddBigerNumberFirst() {
    FIFO<Integer> line = new FIFO<>();

    line.offer(7);
    line.offer(5);

    Integer first = line.poll();
    Integer second = line.poll();

    assertEquals(7, first);
    assertEquals(5, second);
  }

  @Test
  public void testAddLowerNumberFirst() {
    FIFO<Integer> line = new FIFO<>();

    line.add(5);
    line.add(7);

    Integer first = line.poll();
    Integer second = line.poll();

    assertEquals(5, first);
    assertEquals(7, second);
  }
}