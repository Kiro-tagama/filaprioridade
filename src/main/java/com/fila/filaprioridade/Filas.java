package com.fila.filaprioridade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filas {

  List<Item> fila1 = new ArrayList<>();
  List<Item> fila2 = new ArrayList<>();
  List<Item> fila3 = new ArrayList<>();
  List<Item> fila4 = new ArrayList<>();

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
      
      public Object[] getFilas() {
        List<Item> filaFinal = new ArrayList<>();
        filaFinal.addAll(fila4);
        filaFinal.addAll(fila3);
        filaFinal.addAll(fila2);
        filaFinal.addAll(fila1);
    
    Object[] filas = {fila1,fila2,fila3,fila4,filaFinal};
    return filas;
  }

  public int getIndex() {
    List<Item> index = new ArrayList<>();
    index.addAll(fila4);
    index.addAll(fila3);
    index.addAll(fila2);
    index.addAll(fila1);

    return index.size();
  }

  public boolean removeUser(String userId) {
      boolean removed = false;
      
      for (List<Item> fila : Arrays.asList(fila1, fila2, fila3, fila4)) {
          Item userToRemove = null;
          
          for (Item user : fila) {
              if (user.id.equals(userId)) {
                  userToRemove = user;
                  break;
              }
          }
          
          if (userToRemove != null) {
              fila.remove(userToRemove);
              removed = true;
              break;
          }
      }
      
      return removed;
  }
}
