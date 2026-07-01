# PA4 - Programación Orientada a Objetos

## Sistema de Gestión de Productos para una Tienda Académica

### Integrantes

* Integrante 1
* Integrante 2
* Integrante 3
* Integrante 4

---

## Descripción del proyecto

Este proyecto consiste en el desarrollo de un sistema de gestión de productos para una tienda académica utilizando Java y los principios de Programación Orientada a Objetos.

El sistema permite registrar, almacenar y consultar productos mediante una colección de objetos, aplicando herencia, clases abstractas, interfaces, sobrescritura de métodos, búsquedas y ordenamientos.

---

## Objetivo

Desarrollar una aplicación que demuestre el uso de:

* Clase abstracta.
* Herencia.
* Interfaces.
* Sobrescritura de métodos.
* Colecciones genéricas (ArrayList).
* Validación de datos mediante HashSet.
* Búsquedas y ordenamiento de objetos.

---

## Funcionalidades

* Registrar libros.
* Registrar útiles escolares.
* Listar todos los productos.
* Buscar productos por código.
* Buscar productos por nombre.
* Ordenar productos alfabéticamente por nombre.
* Validar que no existan códigos repetidos.

---

## Estructura del proyecto


PA4_TiendaAcademica
│
├── Producto.java
├── Descuento.java
├── Libro.java
├── UtilEscolar.java
├── TiendaAcademica.java
├── Main.java
└── README.md


---

## Tecnologías utilizadas

* Java
* IntelliJ IDEA / NetBeans
* Programación Orientada a Objetos

---

## Colecciones utilizadas

* *ArrayList*: almacena todos los productos registrados.
* *HashSet*: valida que cada producto tenga un código único.

---

## Decisiones tomadas

* Se creó la clase abstracta Producto para contener los atributos comunes de todos los productos.
* Se implementaron las clases Libro y UtilEscolar, que heredan de Producto.
* Se creó la interfaz Descuento, implementada por ambas clases para calcular descuentos según el tipo de producto.
* Se utilizó un ArrayList para almacenar los productos registrados.
* Se utilizó un HashSet para evitar el registro de códigos duplicados.
* Se implementaron funciones de búsqueda por código, búsqueda por nombre y ordenamiento alfabético.

---

## Instrucciones de ejecución

1. Abrir el proyecto en IntelliJ IDEA o NetBeans.
2. Ejecutar la clase Main.java.
3. Seleccionar una opción del menú.
4. Registrar productos, consultarlos, buscarlos o listarlos según sea necesario.

---

## Resultados

El sistema cumple con los requisitos de la evaluación:

* Clase abstracta.
* Dos clases derivadas.
* Interfaz.
* Sobrescritura de métodos.
* Uso de ArrayList.
* Uso de HashSet.
* Registro de productos.
* Búsqueda por código.
* Búsqueda por nombre.
* Ordenamiento por nombre.
* Menú funcional en consola.

---

## Repositorio GitHub

Pegar aquí el enlace del repositorio:

**https://github.com/usuario/PA4_TiendaAcademica**

---

## Video de sustentación

Pegar aquí el enlace del video de YouTube:

**https://www.youtube.com/**
