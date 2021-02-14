/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacomobjetos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vilson.moro
 */
public class ListaComObjetos {
    static List<Pessoa> lista = new ArrayList<>();
    
    public static void main(String[] args) {       
       lista.add(new Pessoa("José", "13645", "jose@gmail.com"));
       lista.add(new Pessoa("João", "456789", "joao@gmail.com"));
       lista.add(new Pessoa("Maria", "29474", "maria@gmail.com")); 
       //listar();
       
       int i = posicao("Maria");
       System.out.println(i);
       Pessoa p = lista.get(i);
        System.out.println(p.toString());;
    }
    
    static void listar(){
        for(Pessoa obj : lista){
            System.out.println(obj.toString());  
        }
    }
    
    static int posicao(String nome){
       int x = 0;
       while(x < lista.size()){
         Pessoa p = lista.get(x);
         if(p.getNome().equals(nome))
             return x;
         else
             x++;
       }    
       return x;
    }
}
