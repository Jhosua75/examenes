package org.example;

public class TextoUtil {

    public int obtenerLongitud(String texto){

        return texto.length();
    }

    public String convertirMayusculas(String texto){

        return texto.toUpperCase();
    }

    public char obtenerPrimerCaracter(String texto){

        return texto.charAt(0);
    }

    public String analizarTexto(String texto){

        int palabras = texto.split(" ").length;

        return "El texto contiene " + palabras + " palabras.";
    }
}