<h1>Conversor de Monedas en Java</h1>
<h3>Descripción</h3>
Este proyecto es un conversor de monedas desarrollado en Java que consume la API de <a href="https://www.exchangerate-api.com/docs/overview">Exchange Rate</a> para obtener las tasas de cambio en tiempo real. Permite convertir montos de una moneda a otra de manera sencilla y eficiente.
<h3>Características</h3>
<li>Conversión de monedas en tiempo real utilizando la API de <a href="https://www.exchangerate-api.com/docs/overview">Exchange Rate</a>.</li>
<li>Interfaz de línea de comandos (CLI).</li>
<li>Manejo de errores (TryCatch) y validaciones básicas.</li>
<li>Peticion a API <a href="https://www.exchangerate-api.com/docs/overview">Exchange Rate</a> con <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpClient.html">HttpClient</a>, <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.html">HttpRequest</a> y <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpResponse.html">HttpResponse</a>.</li>
<li>Uso de la libreria <a href="https://mvnrepository.com/artifact/com.google.code.gson/gson/2.11.0">Gson</a>.</li>
<li>Uso de Records.</li>
<li>Uso de la clase <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html">Scanner</a> para pedir informacion y validar entrada de datos con <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html#hasNextDouble()">hasNextDouble().</a></li>
<h3>JDK Utilizado</h3>
Java Development Kit (JDK) 17.

<h3>Configuración</h3>
<li>Obtener un API KEY registrandose en <a href="https://www.exchangerate-api.com/">Exchange Rate</a></li>
<h3>Previsualizaciones</h3>
<h4>Validación con <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html#hasNextDouble()">hasNextDouble().</a></h4>
Verifica que el dato ingresado sea double, regresa true en caso de ser double o false en caso contrario.
<hr>

![Validacion con hasNextDouble](https://github.com/andresAGM/challenge-conversor-de-monedas-one/blob/master/ConversorDeMonedas/img/validacionDeTextoIngresado.png)

<hr>

<h4>Ejemplo de conversión</h4>
Convirtiendo de USD a COP
<hr

![Ejemplo de Conversion](https://github.com/andresAGM/challenge-conversor-de-monedas-one/blob/master/ConversorDeMonedas/img/pruebaConversion.png?raw=true)

<hr>

<h3>Autor</h3>
Creado por 👨‍💻 andresAGM
