package com.fila.filaprioridade;

import java.util.ArrayList;
import java.util.List;

public class Filas {

  List<Item> fila1 = new ArrayList<>();
  List<Item> fila2 = new ArrayList<>();
  List<Item> fila3 = new ArrayList<>();
  List<Item> fila4 = new ArrayList<>();
  List<Item> filaFinal = new ArrayList<>();

  public Object addToFila(Item res) {
    switch (res.priority) {
      case 1:
          fila1.add(res);
          break;
      case 2:
          fila2.add(res);
          break;
      case 3:
          fila3.add(res);
          break;
      case 4:
          fila4.add(res);
          break;
      default:
          System.out.println("Invalid queue number." + res.toString());
    }
    return res;
  }
  
  
  public Object[] getFilaFinal() {
    filaFinal.addAll(fila1);
    filaFinal.addAll(fila2);
    filaFinal.addAll(fila3);
    filaFinal.addAll(fila4);

    Object[] filas = {fila1,fila2,fila3,fila4,filaFinal};
    return filas;
  }
}
