package br.senai.sp.vitalmessage;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class VitalMessage {

    public void start(){

        System.out.print("\033[H\033[2J");
        //String[] comando = new String[]{"clear"};
//        try {
//            Runtime.getRuntime().exec(comando);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        var leitor = new Scanner(System.in);

        System.out.println("VITAL MESSAGE 2.0");
        System.out.println();

        var escolha = 0;
        while (escolha < 4 || escolha > 10){
            System.out.print("HOW DIFFICULT? (4-10): ");
            escolha = leitor.nextInt();
        }

        var min = 65;
        var max = 90;

        var random = new Random();
        StringBuilder frase = new StringBuilder();

        for (int i = 0; i < escolha; i++){
            var numeroSorteado = random.nextInt(max - min + 1) + min;
            char letra = (char) numeroSorteado;
            frase.append(letra);
        }

        System.out.println("SEND THIS MESSAGE:");
        System.out.println(frase);

        try {
            Thread.sleep(escolha * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.print("\033[H\033[2J");

        var leitor2 = new Scanner(System.in);
        System.out.println("TYPE THE MESSAGE NOW!! ");

        var message = leitor2.next().toUpperCase();

        System.out.println();

        if (message.equalsIgnoreCase(frase.toString())) {
            System.out.println("MESSAGE CORRECT!\nTHE WAR IS OVER!");
            System.out.println();
        } else {
            System.out.println("YOU GOT WRONG\nYOU SHOULD HAVE SENT: " + frase);
            System.out.println();
        }

    }

}
