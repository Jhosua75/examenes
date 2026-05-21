<%@ page import="org.example.UtilitarioNumerico" %>
<!DOCTYPE html>
<html>

<head>
    <title>Utilitario Numérico</title>
</head>

<body>

<h1>Utilitario Numerico</h1>

<form method="post">

    Numero entero:
    <input type="number" name="entero">

    <br><br>

    Numero real:
    <input type="number" step="any" name="real">

    <br><br>

    <input type="submit" value="Procesar">

</form>

<%
    String enteroTexto = request.getParameter("entero");
    String realTexto = request.getParameter("real");

    if(enteroTexto != null && realTexto != null){

        int entero = Integer.parseInt(enteroTexto);
        double real = Double.parseDouble(realTexto);

        UtilitarioNumerico util = new UtilitarioNumerico();
%>

<h2>Resultados</h2>

<p>
    Cantidad de digitos:
    <%= util.contarDigitos(entero) %>
</p>

<p>
    Numero redondeado:
    <%= util.redondearNumero(real) %>
</p>

<p>
    Potencia:
    <%= util.calcularPotencia(real) %>
</p>

<p>
    Raiz cuadrada:
    <%= util.calcularRaiz(real) %>
</p>

<p>
    <%= util.interpretarResultado(entero, real) %>
</p>

<%
    }
%>

<br>

<a href="index.jsp">Volver</a>

</body>
</html>