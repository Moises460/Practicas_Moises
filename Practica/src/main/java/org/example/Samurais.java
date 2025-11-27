package org.example;

import java.util.Random;
import java.util.Scanner;

public class Samurais {
    static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        Random rnd = new Random();


        int contador = 0;
        int contador1 = 0;
        int contador2 = 0;
        String[] equipo1 = new String[7];
        String[] equipo2 = new String[7];
        int equipo_actual = 1;
        boolean validar_equipo = true;
        int inicio = rnd.nextInt(7);
        int victorias1 = 0;
        int victorias2 = 0;
        int empate = 0;


        do {
            validar_equipo = true;
            contador = 0;

            System.out.println("(INTRODUCE LOS VALORES CON ',')");
            System.out.print("SACA TUS SAMURAIS A LA BATALLA (EQUIPO" + equipo_actual + "): ");


            String numero = tc.next();

            String nu = tc.nextLine();

            String[] equipo = nu.split(",");

            // Control exacto de 7 digitos
            if (equipo.length != 7) {
                System.out.println("DEBES INTRODUCIR EXACTAMENTE 7 SAMURAIS CON LA ','");
                validar_equipo = false;
                continue;
            }

            // Controla que sean numeros y hace tambien la suma
            for (int i = 0; i < equipo.length; i++) {
                try {
                    contador += Integer.parseInt(equipo[i]);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: '" + equipo[i] + "' NO ES UN NÚMERO VÁLIDO.");
                    validar_equipo = false;
                    break;
                }
            }


            //  Comprueba el total de suma sea 30
            if (validar_equipo) {
                if (contador < 30) {
                    System.out.println("TU EQUIPO NO PUEDE SUMAR MENOS DE 30");
                    validar_equipo = false;
                } else if (contador > 30) {
                    System.out.println("TU EQUIPO NO PUEDE SUMAR MÁS DE 30");
                    validar_equipo = false;
                }
            }

            // Valida el equipo y asigna equipos
            if (validar_equipo) {
                if (equipo_actual == 1) {
                    equipo1 = equipo.clone();
                    contador1 = contador;
                    System.out.println("EQUIPO 1 COMPLETADO.");
                    equipo_actual = 2;
                } else {
                    equipo2 = equipo.clone();
                    contador2 = contador;
                    System.out.println("EQUIPO 2 COMPLETADO.");

                    break; // termina cuando ambos equipos están listos
                }
            } else {
                System.out.println("INTRODUCE BIEN TU EQUIPO " + equipo_actual);
            }


        } while (true) ;

        System.out.println("**********************************************");
        System.out.println("              EMPIEZA LA BATALLA              ");
        System.out.println("**********************************************");
        System.out.println("      LA BATALLA COMIENZA CON EL SAMURAI " + (inicio+1) + ".");
        System.out.println("**********************************************");

        // Hace la comparacion de numero por numero para sacar el resultado
        for (int i = 0; i < 7; i++) {
            int ronda = (inicio + i) % 7; //Empieza a comprobar desde un RANDOM
            int samurai1 = Integer.parseInt(equipo1[ronda]);
            int samurai2 = Integer.parseInt(equipo2[ronda]);

            System.out.print("    SAMURAI " + (ronda+1) + ": ");
            if (samurai1 > samurai2) {
                System.out.println("GANA EL EQUIPO 1 --> " + samurai1 + " VS " + samurai2);
                victorias1++;
            } else if (samurai1 < samurai2) {
                System.out.println("GANA EL EQUIPO 2 --> " + samurai2 + " VS " + samurai1);
                victorias2++;
            } else {
                System.out.println("EMPATE " + samurai1 + " VS " + samurai2);
                empate++;
            }

        }

        // Resultados finales
        System.out.println("**********************************************");
        System.out.println("                RECUENTO FINAL:");
        System.out.println("**********************************************");


        if (victorias1 > victorias2) {
            System.out.println("     GANA EL EQUIPO 1 CON -->" + victorias1 + " VICTORIAS");
        } else if (victorias2 > victorias1) {
            System.out.println("     GANA EL EQUIPO 2 CON -->" + victorias2 + " VICTORIAS");
        } else {
            System.out.println("      LA BATALLA HA SIDO UN EMPATE DE " + empate + " - " + empate);
        }


    }
}
