package org.example;

import java.util.Arrays;
import java.util.Collections;

public class Chuleta {
    static void main(String[] args) {
    int numero = 1;
    String palabra = "Hola";

    // Array de enteros primitivos
    int[] numeroV = {1, 2, 4, 5};
    int[] numeroVcopia = numeroV.clone(); // Clonar vector

    // Array de objetos (para ordenar en reversa)
    Integer[] numeroVObj = {1, 2, 4, 5};
    String[] palabraV = {"Hola", "Adiós"};

    // Mostrar contenido del array
    System.out.println(Arrays.toString(palabraV));

    // Comprobar si contiene una palabra
    boolean contiene = Arrays.asList(palabraV).contains(palabra);
    System.out.println("¿Contiene '" + palabra + "'? " + contiene);

    // Ordenar ascendente
    Arrays.sort(numeroVObj);
    System.out.println("Ascendente: " + Arrays.toString(numeroVObj));

    // Ordenar descendente
    Arrays.sort(numeroVObj, Collections.reverseOrder());
    System.out.println("Descendente: " + Arrays.toString(numeroVObj));

    int n = 9;
    int[] nums = {2, 2, 4, 4, 7, 9};

    // Importante: el array debe estar ordenado para usar binarySearch()
    int pos = Arrays.binarySearch(nums, n);

    // Comprobación del resultado
    if (pos >= 0) {
        System.out.println("Número encontrado en la posición " + pos);
    } else {
        System.out.println("No se ha encontrado el número");
    }

    // Distincts se usa cuando necesitamos eliminar elementos duplicados, incluso sin estar ordenados
    int vector[] = Arrays.stream(nums).distinct().toArray();
}
}
