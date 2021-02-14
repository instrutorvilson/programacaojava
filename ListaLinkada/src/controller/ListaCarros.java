/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import modelo.Carro;

public class ListaCarros {
   private LinkedList<Carro> carros = new LinkedList();
   
   
   public void inserir(Carro carro){
     if(carros.contains(carro))
       System.out.println("Carro já foi inserido");
     else
       carros.add(carro);
   }
   
   public void alterar(int item, Carro carro){
      carros.set(item, carro);
   }
   
   public void remover(int item){
       carros.remove(item);
   }
   
   public void remover(Carro carro){
      carros.remove(carro);
   }
   
   public void listar(){
       for(Carro obj : carros){
            System.out.println(obj.toString());  
        }
   }

    public LinkedList<Carro> getCarros() {
        return carros;
    }
   
   
}
