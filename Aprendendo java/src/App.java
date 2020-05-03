/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilson costa
 */
public class App {
    
    public static void main(String[] args){
        JANELA r = new JANELA(); // instanciando o objeto r 
        Thread nova = new Thread(r);//instanciando a thred responsavel pela execuçao do nossa calculadora
    nova.start();// iniciando nossa thred ou seja o metodo Run() na classe Janela();
    
    }
}
