package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class bateria_arrays {

    public static void ejercicio2() {
        int[] vector = {1, 2, 3, 4, 5};
        System.out.println("Array original: " + Arrays.toString(vector));

        int numAux;

        for (int i = 0; i < vector.length / 2; i++) {
            numAux = vector[i];

            vector[i] = vector[vector.length - 1 - i];

            vector[vector.length - 1 - i] = numAux;
        }

        System.out.println("Array invertido: " + Arrays.toString(vector));
    }

    public static void ejercicio3() {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int[] vector = new int[25];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(101);
        }

        System.out.print("Ingresa un número para buscar [0,100]: ");
        int numero = teclado.nextInt();
        int contador = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == numero) {
                contador++;
            }
        }

        System.out.println("El número " + numero + " aparece " + contador + " veces en el array.");
    }

    public static void ejercicio4() {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int[] vector = {1, 3, 5, 6, 7, 9};
        int[] newVector = new int[vector.length - 1];

        System.out.print("Introduce el índice a eliminar: ");
        int num = teclado.nextInt();

        for (int i = 0; i < newVector.length; i++) {
            if (i < num) {
                newVector[i] = vector[i];
            } else if (i >= num) {
                newVector[i] = vector[i + 1];
            }
        }

        System.out.println(Arrays.toString(newVector));
    }

    public static void ejercicio5() {
        int[] vector = {1, 2, 3, 4, 5};
        int numAux = vector[0];

        for (int i = 0; i < vector.length - 1; i++) {
            vector[i] = vector[i + 1];
        }

        vector[vector.length - 1] = numAux;

        System.out.println(Arrays.toString(vector));
    }

    public static void ejercicio6() {
        int[] vector = {1, 2, 3, 2, 1};
        System.out.println("Array: " + Arrays.toString(vector));

        int numAux;
        int contador = 0;

        for (int i = 0; i < vector.length / 2; i++) {
            numAux = vector[i];
            vector[i] = vector[vector.length - 1 - i];
            vector[vector.length - 1 - i] = numAux;
        }

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == vector[vector.length - i - 1]) {
                contador++;
            }
        }

        System.out.print("Es símetrico: ");

        if (contador == 5) {
            System.out.print("SI");
        } else {
            System.out.print("NO");
        }
    }

    public static void ejercicio7() {
        int[] vector1 = {1, 2, 3};
        int[] vector2 = {4, 5, 6};

        int largo = vector1.length + vector2.length;
        int largoV1 = vector1.length;

        int[] vector3 = new int[largo];

        for (int i = 0; i < largo; i++) {
            if (i < largoV1) {
                vector3[i] = vector1[i];
            } else {
                vector3[i] = vector2[i - largoV1];
            }
        }

        System.out.println("Array 1: " + Arrays.toString(vector1));
        System.out.println("Array 2: " + Arrays.toString(vector2));
        System.out.println("Array combinado: " + Arrays.toString(vector3));
    }

    public static void ejercicio8() {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int[] vector = {1, 2, 3, 5};
        int[] newVector = new int[vector.length + 1];

        System.out.print("Introduce el número a añadir: ");
        int num = teclado.nextInt();

        System.out.print("Introduce la posición: ");
        int pos = teclado.nextInt();

        for (int i = 0; i < newVector.length; i++) {
            if (i < pos) {
                newVector[i] = vector[i];
            } else if (i == pos) {
                newVector[i] = num;
            } else {
                newVector[i] = vector[i - 1];
            }
        }

        System.out.println(Arrays.toString(newVector));
    }

    public static void ejercicio9() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String frase = teclado.nextLine();

        System.out.println(frase);

        int contador = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                contador++;
            }
        }
    }

    public static void ejercicio10() {

    }
}
