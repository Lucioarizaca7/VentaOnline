/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ventaonline;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VentaOnline {

    // Lista para almacenar los productos del carrito
    static List<String> carrito = new ArrayList<>();
    static double total = 0.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            menu();
            opcion = sc.nextInt();
            procesarOpcion(opcion);
        } while (opcion != 4); // Salir del sistema

        if (!carrito.isEmpty()) {
            imprimirBoleta();
        } else {
            System.out.println("No se realizaron compras.");
        }

        System.out.println("Gracias por visitarnos!");
        sc.close();
    }

    private static void menu() {
        System.out.println("\nMenu Ropa Online:");
        System.out.println("1. Ver Catalogo de Ropa");
        System.out.println("2. Agregar al Carrito");
        System.out.println("3. Ver Carrito");
        System.out.println("4. Salir");
        System.out.println("Ingrese una opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                verCatalogo();
                break;
            case 2:
                agregarAlCarrito();
                break;
            case 3:
                verCarrito();
                break;
            case 4:
                // Salir del sistema (ya se maneja en el main)
                break;
            default:
                System.out.println("Opcion invalida. Ingrese nuevamente.");
        }
    }

    // Muestra el catálogo de ropa disponible
    private static void verCatalogo() {
        System.out.println("\n** Catalogo de Ropa **");
        System.out.println("1. Camiseta - s/.20");
        System.out.println("2. Pantalon - s/.40");
        System.out.println("3. Chaqueta - s/.60");
        System.out.println("4. Zapatos - s/.50");
    }



    // Agrega productos al carrito basado en el catálogo
    private static void agregarAlCarrito() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el numero del producto para agregar al carrito: ");
        int seleccion = sc.nextInt();

        switch (seleccion) {
            case 1:
                carrito.add("Camiseta - s/.20");
                total += 20;
                System.out.println("Camiseta agregada al carrito.");
                break;
            case 2:
                carrito.add("Pantalon - s/.40");
                total += 40;
                System.out.println("Pantalon agregado al carrito.");
                break;
            case 3:
                carrito.add("Chaqueta - s/.60");
                total += 60;
                System.out.println("Chaqueta agregada al carrito.");
                break;
            case 4:
                carrito.add("Zapatos - s/.50");
                total += 50;
                System.out.println("Zapatos agregados al carrito.");
                break;
            default:
                System.out.println("Producto no valido.");
        }
    }

    // Muestra el contenido del carrito y el total actual
    private static void verCarrito() {
        if (carrito.isEmpty()) {
            System.out.println("\nEl carrito esta vacio.");
        } else {
            System.out.println("\n** Carrito de Compras **");
            for (String item : carrito) {
                System.out.println(item);
            }
            System.out.println("Total actual: s/." + total);
        }
    }

    // Imprime la boleta con el detalle de las compras
    private static void imprimirBoleta() {
        System.out.println("\n*** BOLETA DE VENTA ***");
        for (String item : carrito) {
            System.out.println(item);
        }
        System.out.println("Total a pagar: s/." + total);
        System.out.println("Gracias por su compra.");
    }
}