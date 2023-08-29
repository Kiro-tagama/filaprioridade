package com.fila.filaprioridade;

import java.util.UUID;

public class Item {
  public String id=UUID.randomUUID().toString();
  public String name;
  public int priority;

  public Object Item(String name, int priority) {
    this.name = name;
    this.priority = priority;

    return "{ id='" + id + '\'' +
    ", name='" + name + '\'' +
    ", priority=" + priority +
    '}';
  }

}
