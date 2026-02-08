package com.evaluacion.EvaluacionJohnCalle;

import com.evaluacion.EvaluacionJohnCalle.ejercicios.Ejercicios;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EvaluacionJohnCalleApplication {

	public static void main(String[] args) {

		SpringApplication.run(EvaluacionJohnCalleApplication.class, args);

		var ejercicios = new Ejercicios();

		System.out.print("\nEjercicio 1: \n");
		ejercicios.Ejercicio1Impresion();


		System.out.print("\n\nEjercicio 2: \n");
		var cadena1 = "ACUERDO";
		var cadena2 = "ECUADOR";
		boolean resultado = ejercicios.Ejercicio2Anagramas(cadena1, cadena2);
		System.out.println("\n" + cadena1 + " y " + cadena2 + (resultado ? " SI" : " NO" ) + " son anagramas ");


		System.out.print("\n\nEjercicio 3: \n");

		int arreglo[] = {50, 5, 10, 36, 25, 85, 23, 65};
		var arregloOrdenado = ejercicios.Ejercicio3Ordenacion(arreglo);
		for (var num : arregloOrdenado) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
