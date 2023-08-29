package com.fila.filaprioridade;

import java.util.ArrayList;
import java.util.List;

public class Filas {

  List<Item> fila1 = new ArrayList<>();
  List<Item> fila2 = new ArrayList<>();
  List<Item> fila3 = new ArrayList<>();
  List<Item> fila4 = new ArrayList<>();
  List<Item> filaFinal = new ArrayList<>();

  // Add elements to the queues
  // fila1.add(new Item(0, "dads", 1));
  // fila2.add(new Item(0, "dads", 2));
  // fila3.add(new Item(0, "dads", 3));
  // fila4.add(new Item(0, "dads", 4));
  public Object addToFila(Item element) {
    switch (element.priority) {
      case 1:
          fila1.add(element);
          break;
      case 2:
          fila2.add(element);
          break;
      case 3:
          fila3.add(element);
          break;
      case 4:
          fila4.add(element);
          break;
      default:
          System.out.println("Invalid queue number.");
    }
    return element;
  }
  // Combine queues
  public List<Item> getFilaFinal() {
    filaFinal.addAll(fila1);
    filaFinal.addAll(fila2);
    filaFinal.addAll(fila3);
    filaFinal.addAll(fila4);

    return filaFinal;
  }
}
