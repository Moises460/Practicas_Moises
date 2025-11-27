package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class La_primitiva {
    static void main() {
        Scanner tc = new Scanner(System.in);
        Random rnd = new Random();

        String usuario;
        String[] usuario_val;

        boolean control = true;
        int[] premio = new int[6];
        int reintegro= rnd.nextInt(10);//GENERA RANDOM 0-9
        int complementario= rnd.nextInt(49)+1;//GENERA RANDOM DEL 1-49


// GENERA EL RANDOM DE LA PRIMITIVIA Y COMPRUEBA QUE NO SE REPETIN NINGUNO Y LOS ORDENAS DE MAS PEQUEÑO A MAS GRADNE
        for (int i = 0; i < premio.length; i++) {
            premio[i] = rnd.nextInt(49) + 1;
            for (int j = 0; j < i; j++) {
                if (premio[i] == premio[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(premio);

        System.out.println("*-------------------------------------------------------*");
        System.out.println("               BIENVENIDO A LA PRIMITIVA");
        System.out.println("*-------------------------------------------------------*");

        do {
            // DATOS QUE INTRODUCE EL USUARIO
            System.out.println("INTRODUCE SUS NUMEROS PARA LA PRIMITIVA [N-N-N-N-N-N/R]");
            usuario = tc.nextLine();
            usuario_val = usuario.split("[-/]");

            //COMPRUEBA EL FORMATO QUE SEA CORECTO DA UN TRUE SI ES CORRECTO Y UN FALS SI ES FALSO
            if (!usuario.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d{1}")) {
                System.out.println("FORMATO INCORRECTO EJ:[1-2-3-4-5-6/7]");
                control = false;
            } else {
                control = true;

                // COMPRUEBA QUE LOS NUMEROS DEL USUARIO NO SEA MAYOR A 49 NI MENOR A 0
                for (int i = 0; i < 6; i++) {
                    int correcto = Integer.parseInt(usuario_val[i]);

                    if (correcto < 1 || correcto > 49) {
                        System.out.println("NO PUEDES INTRODUCIR NÚMEROS MAYORES DE 49 NI MENORES DE 1");
                        control = false;
                        break;
                    }

                    //COMPRUEBA QUE EL USUARIO NO INTRODUCE NINGUN NUMERO REPETIDO
                    for (int j = i + 1; j < 6; j++) {
                        int comprobador = Integer.parseInt(usuario_val[j]);
                        if (correcto == comprobador) {
                            System.out.println("NO PUEDES REPETIR NÚMEROS EN LA PRIMITIVA");
                            control = false;
                            break;
                        }
                    }
                }
            }

        } while (!control);

//CONTADORES CON VALOR INICIAL A 0
        int aciertos = 0;
        int acierto_reintegro=0;
        int acierto_complementario=0;
        int[] usuario_nums = new int[6];

//SIRVE PARA RELLENAR EL USUARIO_NUM
        for (int i = 0; i < 6; i++) {
            usuario_nums[i] = Integer.parseInt(usuario_val[i]);
        }
        System.out.println("TUS NUMEROS SON : " + Arrays.toString(usuario_nums));

//CONTADOR PARA LOS NUMEROS DE ACIERTOS
        for (int i = 0; i < usuario_nums.length; i++) {
            for (int j = 0; j < premio.length; j++) {
                if (usuario_nums[i] == premio[j]) {
                    aciertos++;
                }
            }
        }

//CONTADOR PARA LOS NUMEROS COMPLEMENTARIOS
        for (int i = 0; i < usuario_nums.length; i++) {
            if (usuario_nums[i] == complementario) {
                acierto_complementario++;
                break;
            }
        }

//CONTADOR PARA EL REINTEGRO
        int posicion_final = Integer.parseInt(usuario_val[usuario_val.length - 1]);
        if(reintegro == posicion_final){
            acierto_reintegro++;
        }

//AQUI SE MUESTRA LOS RESULTADOS
        System.out.println("*---------------------------*");
        System.out.println("HA SALIDO:");
        System.out.println(Arrays.toString(premio));
        System.out.println("COMPLEMENTARIO: "+complementario);
        System.out.println("REINTEGRO: "+reintegro);
        System.out.println("*---------------------------*");

        System.out.println("RESULTADO");

// SIRVE PARA DAR LA CATEGORIA DEL PREMIO
        switch (aciertos){
            case 6:
                if(acierto_reintegro == 1){
                    System.out.println("CATEGORIA ESPECIAL 6 NUMEROS ACERTADOS + EL REINTEGRO");
                } else {
                    System.out.println("1ª CATEGORIA: 6 NUMEROS ACERTADOS");
                }
                break;

            case 5:
                if (acierto_complementario == 1) {
                    System.out.println("2ª CATEGORIA: 5 NUMEROS ACERTADOS + COMPLEMENTARIO");
                } else {
                    System.out.println("3ª CATEGORIA: 5 NUMEROS ACERTADOS");
                }
                break;

            case 4:
                System.out.println("4ª CATEGORIA: 4 NUMEROS ACERTADOS");
                break;

            case 3:
                System.out.println("5ª CATEGORIA: 3 NUMEROS ACERTADOS");
                break;

            default:
                if (acierto_reintegro == 1) {
                    System.out.println("REINTEGRO ACERTADO");
                } else {
                    System.out.println("NO PREMIADO");
                }
                break;
        }

        System.out.println("*---------------------------*");
    }
}
