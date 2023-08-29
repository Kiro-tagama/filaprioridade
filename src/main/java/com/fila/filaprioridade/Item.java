package com.fila.filaprioridade;

import java.util.UUID;

public class Item {
  String id;
  String name;
  int priority;

  public Item(String name, int priority) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.priority = priority;
  }

}
