package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Practica_ZX_Spectrum  {
    static void main() {
        Scanner tc=new Scanner(System.in);


        int ancho=0;
        int alto=0;

        boolean validar=false;
        boolean comprobador = false;
        boolean control_letras = false;

        System.out.println("╔==================================================================╗");
        System.out.println("║               INTRODUCE TU RESOLUCIÓN DE ZX_SPECTRUM             ║");
        System.out.println("║ (SOLO SE ADMITE VALORES QUE SEAN MULTIPLOS DE 8 Y MENORES DE 48) ║");
        System.out.println("╚==================================================================╝");
        do {
            try {
                System.out.print("ELIGE TU ANCHO: ");
                ancho = Integer.parseInt(tc.nextLine());

                if (ancho % 8 != 0 || ancho >= 48) {
                    System.out.println("EL ANCHO TIENE QUE SER MULTIPLO DE 8 Y MENOR QUE 48");
                    continue;
                }

                System.out.print("ELIGE TU ALTO: ");
                alto = Integer.parseInt(tc.nextLine());

                if (alto % 8 != 0 || alto >= 48) {
                    System.out.println("EL ALTO TIENE QUE SER MULTIPLO DE 8 Y MENOR QUE 48");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("SOLO SE ADMITEN NÚMEROS");
            }
        } while (true);

        System.out.println("╔==========================================╗");
        System.out.println("║       TU PANTALLA SERA DE "+alto+" X "+ancho+"         ║");
        System.out.println("╚==========================================╝");

        String matriz[][] = new String[alto][ancho];

        String filas_i ;
        String[] columnas_j;

        for (int i = 0; i < alto; i++) {

            System.out.print("Introduce la fila " + (i + 1) + ": ");
            filas_i = tc.nextLine();

            if (filas_i.length() != ancho) {
                System.out.println("ERROR: La línea debe tener exactamente " + ancho + " letras.");
                i--;
                continue;
            }

            if (!filas_i.matches("[a-oA-O]+")) {
                System.out.println("ERROR: Solo puedes usar letras de la A a la O.");
                i--;
                continue;
            }
            columnas_j = filas_i.split("");


            for (int j = 0; j < ancho; j++) {
                matriz[i][j] = columnas_j[j];
            }
        }

        System.out.println("╔=========================================╗");
        System.out.println("║             ESTA ES TU MATRIZ           ║");
        System.out.println("╚=========================================╝");

        for (String[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }


        for (int j = 0; j < ancho; j += 8) {
            for (int i = 0; i < alto; i++) {
                char character1 = matriz[0][j].charAt(0);
                char character2 = character1;


                for (int k = 0; k < 8 && j + k < ancho; k++) {
                    char c = matriz[i][j + k].charAt(0);

                    if (c != character1) {
                        if (!control_letras) {
                            character2 = c;
                            control_letras = true;
                        } else if (c != character2) {
                            comprobador = true;
                            break;
                        }
                    }
                }

                if (comprobador) break;
            }
            if (comprobador) break;
        }


        if (!comprobador) {
            System.out.println("╔====================================╗");
            System.out.println("║  Es compatible con un ZX Spectrum  ║");
            System.out.println("╚====================================╝");
        } else {
            System.out.println("╔====================================╗");
            System.out.println("║No es compatible con un ZX Spectrum ║");
            System.out.println("╚====================================╝");
        }

    }
}
