/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listalinkada;

import controller.ListaCarros;
import java.util.Scanner;
import modelo.Carro;

public class ListaLinkada {
    static Scanner leitor = new Scanner(System.in);
    static ListaCarros lista = new ListaCarros();
    
    public static void main(String[] args) {        
        boolean continuar = true;
        while (continuar) {
            int oque = menu();
            switch (oque) {
                case 1: {
                    inserir();
                    break;
                }
                case 2: {
                    atualizar();
                    break;
                }
                case 3: {
                    System.out.println("Informe o indice do item");
                    int item = leitor.nextInt();
                    lista.remover(item); 
                }
                case 4: {
                    remover();
                }
                case 5: {
                    lista.listar();
                    break;
                }
                default:
                    System.out.println("Nenhuma opção foi escolhida");
            }

            System.out.println("Deseja continuar? S-sim");
            String opcao = leitor.next();
            continuar = opcao.toUpperCase().equals("S");
        }     
        
    }
    
    public static int menu() {
        System.out.println("1 = Inserir");
        System.out.println("2 = Alterar");
        System.out.println("3 = Excluir pelo valor");
        System.out.println("4 = Excluir pelo indice");
        System.out.println("5 = Listar");

        System.out.println("Qual sua opção");
        return leitor.nextInt();
    }

    static void inserir(){
        System.out.println("Informe placa do carro");
        String placa = leitor.next();
        
        System.out.println("Informe a marca do carro");
        String marca = leitor.next();
        
        System.out.println("Informe modelo do carro");
        String modelo = leitor.next();
        
        System.out.println("Informe a cor do carro");
        String cor = leitor.next();
        
        System.out.println("Informe o ano de fabricaçã do carro");
        int anofabricacao = leitor.nextInt();
       
        Carro carro = new Carro(placa, modelo, marca, anofabricacao, cor);
        lista.inserir(carro);
    }
   
    static void atualizar(){
        System.out.println("Informe a placa do carro que deseja alterar");  
        String placa = leitor.next();
        int posicao = lista.getCarros().indexOf(placa);
        Carro carro = lista.getCarros().get(posicao);
        
        System.out.println(carro.toString());
              
    }
    
    static void remover(){
       /* System.out.println("Informe o valor do item");
                    String valor = leitor.next();
                    remover(valor);*/
    }
}
