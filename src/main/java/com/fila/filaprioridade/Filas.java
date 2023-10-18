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

  public boolean setUser(Item item){
    // Initialize variables to keep track of whether the user was found and removed.
    boolean userFound = false;
    boolean userRemoved = false;

    // Initialize a variable to store the user to be updated.
    Item userToUpdate = null;

    // Search for the user in all four queues.
    for (List<Item> fila : Arrays.asList(fila1, fila2, fila3, fila4)) {
        for (Item user : fila) {
            if (user.id.equals(item.id)) {
                // User found, update the name.
                user.name = item.name;

                // If the priority has changed, remove the user from the original queue.
                if (user.priority != item.priority) {
                    userToUpdate = user;
                    userFound = true;
                    break;
                }

                userFound = true;
                break;
            }
        }

        if (userFound) {
            break;
        }
    }

    // If the user was found and has a new priority, remove and re-add the user.
    if (userToUpdate != null) {
        userRemoved = removeUser(userToUpdate.id);
        if (userRemoved) {
            userToUpdate.priority = item.priority;
            addToFila(userToUpdate);
        }
    }

    return userFound && userRemoved;
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
