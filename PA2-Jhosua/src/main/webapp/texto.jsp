<%@ page import="org.example.TextoUtil" %>

<!DOCTYPE html>
<html>

<head>
    <title>Utilitario de Texto</title>
</head>

<body>

<h1>Utilitario de Texto</h1>

<form method="post">

    Ingrese un texto:

    <input type="text" name="texto">

    <br><br>

    <input type="submit" value="Procesar">

</form>

<%
    String texto = request.getParameter("texto");

    if(texto != null){

        TextoUtil util = new TextoUtil();
%>

<h2>Resultados</h2>

<p>
    Longitud:
    <%= util.obtenerLongitud(texto) %>
</p>

<p>
    Texto en mayusculas:
    <%= util.convertirMayusculas(texto) %>
</p>

<p>
    Primer caracter:
    <%= util.obtenerPrimerCaracter(texto) %>
</p>

<p>
    <%= util.analizarTexto(texto) %>
</p>

<%
    }
%>

<br>

<a href="index.jsp">Volver</a>

</body>
</html>