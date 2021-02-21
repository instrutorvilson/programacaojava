/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroswing.entidades;

import java.util.ArrayList;
import java.util.List;

public class ListaCarros {
   List<Carro> lista = new ArrayList<>();
   
   public void adiciona(Carro carro){
       lista.add(carro);
   }
   
   public void listarTodos(){
       for(Carro c : lista){
           System.out.println(c.toString());
       }
   }
}
