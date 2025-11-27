package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    static void main() {
        Scanner tc= new Scanner(System.in);
        Random rnd=new Random();


        int bolas=rnd.nextInt(30)+10;
        int[] bolas_vector=new int[bolas];



        for (int i = 0; i < bolas_vector.length; i++) {
            bolas_vector[i]= rnd.nextInt(89)+1;
            for (int j = 0; j < i; j++) {
                if(bolas_vector[i]==bolas_vector[j]){
                    i--;
                    break;
                }
            }
        }

        Arrays.sort(bolas_vector);

        System.out.println(bolas+" BOLAS EXTRAIDAS HASTA AHORA: ");
        System.out.println(Arrays.toString(bolas_vector));

        System.out.println("INTRODUCIR DATOS DEL CARTON (FOMATANO VALIDO N-N-N)");

        int [][] carton=new int[3][3];

         String num_carton;
         String[] num_columnas;

        for (int i = 0; i < carton.length; i++) {

            System.out.print("INTRODUCE LA FILA " + (i + 1) + ": ");
            num_carton = tc.next();

            if (!num_carton.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")) {
                System.out.println("ERROR DE FORMATO. DEBE SER N-N-N (SOLO NUMEROS)");
                i--;
                continue;
            }

            num_columnas = num_carton.split("-");

            boolean control = false;
            for (String num : num_columnas) {
                int n = Integer.parseInt(num);
                if (n < 1 || n > 90) {
                    control = true;
                    break;
                }
            }

            if (control) {
                System.out.println("ERROR: LOS NUMEROS DEBEN ESTAR ENTRE 1 Y 90");
                i--;
                continue;
            }

            for (int j = 0; j < carton[0].length; j++) {
                carton[i][j] = Integer.parseInt(num_columnas[j]);
            }
        }

        for (int[] fila : carton) {
            System.out.println(Arrays.toString(fila));
        }

        //COMPRUEBA QUE TOS LOS NUMEROS SEAN IDUALES DE LA MATRIZ 3X3
        int bingo=0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < bolas_vector.length; k++) {
                    if (carton[i][i]== bolas_vector[k]){
                        bingo++;
                        break;
                    }
                }
            }
        }

        if (bingo==9){
            System.out.println("¡¡¡¡¡¡¡¡¡¡ENORABUENA BINGO!!!!!!!!!!!!");
        }



    }
}
