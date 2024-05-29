package br.senai.sp.vitalmessage;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class VitalMessage {

    public void start() {

        limparTela();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var leitor = new Scanner(System.in);

        System.out.println("VITAL MESSAGE 2.0");
        System.out.println();

        var escolha = 0;
        while (escolha < 4 || escolha > 10) {
            System.out.print("HOW DIFFICULT? (4-10): ");
            escolha = leitor.nextInt();
        }

        var min = 65;
        var max = 90;

        var random = new Random();
        StringBuilder frase = new StringBuilder();

        for (int i = 0; i < escolha; i++) {
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

        limparTela();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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

        System.out.println();
        System.out.println();

        String continuar = "";

        while (continuar.isEmpty()){
            System.out.println("Digite \"S\" e pressione ENTER para finalizar...");
            continuar = leitor.next();
        }

    }

    private void limparTela() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
