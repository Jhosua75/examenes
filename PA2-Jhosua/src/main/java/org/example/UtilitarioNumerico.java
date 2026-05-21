
package org.example;

public class UtilitarioNumerico {

    // Contar dígitos
    public int contarDigitos(int numero){

        numero = Math.abs(numero);

        return String.valueOf(numero).length();
    }

    // Redondear número real
    public double redondearNumero(double numeroReal){

        return Math.round(numeroReal);
    }

    // Calcular potencia
    public double calcularPotencia(double numero){

        return Math.pow(numero, 2);
    }

    // Calcular raíz
    public double calcularRaiz(double numero){

        return Math.sqrt(numero);
    }

    // Interpretación
    public String interpretarResultado(int entero, double real){

        return "El número entero tiene "
                + contarDigitos(entero)
                + " dígitos y el número real redondeado es "
                + redondearNumero(real);
    }
}