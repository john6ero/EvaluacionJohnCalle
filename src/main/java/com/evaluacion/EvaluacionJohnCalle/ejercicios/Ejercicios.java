package com.evaluacion.EvaluacionJohnCalle.ejercicios;

import java.util.Arrays;

public class Ejercicios {


    public void Ejercicio1Impresion() {
        for (var i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("SOMOS BA");
            } else if (i % 3 == 0) {
                System.out.println("SOMOS");
            } else if (i % 5 == 0) {
                System.out.println("BA");
            } else {
                System.out.println(i);
            }
        }
    }

    public boolean Ejercicio2Anagramas(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        var arr1 = s1.toUpperCase().toCharArray();
        var arr2 = s2.toUpperCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public int[] Ejercicio3Ordenacion(int[] arreglo) {

        var arr = Arrays.stream(arreglo).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> b - a);
        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }
}
