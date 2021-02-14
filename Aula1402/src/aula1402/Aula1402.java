/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula1402;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vilson.moro
 */
public class Aula1402 {

    static List<String> lista = new ArrayList<>();
    static Scanner leitor = new Scanner(System.in);

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
                    System.out.println("Informe o item");
                    int item = leitor.nextInt();
                    System.out.println("Informe o novo valor");
                    String valor = leitor.next();
                    atualizar(item, valor);
                    break;
                }
                case 3: {
                    System.out.println("Informe o indice do item");
                    int item = leitor.nextInt();
                    remover(item);
                }
                case 4: {
                    System.out.println("Informe o valor do item");
                    String valor = leitor.next();
                    remover(valor);
                }
                case 5: {
                    listar();
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

    public static void inserir() {
        System.out.println("Digite um valor");
        String valor = leitor.next();
        if (lista.contains(valor)) {
            // if(lista.indexOf(str) >= 0){      
            System.out.println("Este valor já está na lista");
        } else {
            lista.add(valor);
        }
    }

    public static void atualizar(int item, String valor) {
        lista.set(item, valor);
    }

    public static void remover(int item) {
        lista.remove(item);
    }

    public static void remover(String item) {
        lista.remove(item);
    }

    public static void listar() {
        for (String item : lista) {
            System.out.println(item);
        }
    }

}
