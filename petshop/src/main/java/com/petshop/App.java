package com.petshop;

import java.util.Scanner;

import com.petshop.Clases.Servicio;
import com.petshop.Clases.ServicioDAO;

public class App {

    static Scanner sc = new Scanner(System.in);
    static ServicioDAO dao = new ServicioDAO();

    public static void main(String[] args) {

        int opcion;

        do {

            System.out.println("\n====================");
            System.out.println("      PET SHOP");
            System.out.println("====================");
            System.out.println("1. Administrador");
            System.out.println("2. Limpiador");
            System.out.println("3. Ver servicios");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    administrador();
                    break;

                case 2:
                    limpiador();
                    break;

                case 3:
                    dao.mostrar();
                    break;

                case 4:
                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 4);

        sc.close();
    }

    // ROL ADMINISTRADOR
    public static void administrador() {

        System.out.println("\n===== ADMINISTRADOR =====");

        System.out.print("Nombre del perro: ");
        String perro = sc.nextLine();

        String servicio = elegirServicio();

        if (servicio.equals("")) {
            return;
        }

        System.out.print("Horario: ");
        String horario = sc.nextLine();

        System.out.print("Precio: $");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nombre del limpiador: ");
        String limpiador = sc.nextLine();

        Servicio nuevoServicio = new Servicio(
                perro,
                servicio,
                horario,
                precio,
                limpiador
        );

        dao.guardar(nuevoServicio);
    }

    // ROL LIMPIADOR
    public static void limpiador() {

        System.out.println("\n===== LIMPIADOR =====");

        System.out.print("Nombre del perro: ");
        String perro = sc.nextLine();

        String servicio = elegirServicio();

        if (servicio.equals("")) {
            return;
        }

        System.out.print("Horario: ");
        String horario = sc.nextLine();

        System.out.print("Precio: $");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.print("Tu nombre: ");
        String nombre = sc.nextLine();

        Servicio nuevoServicio = new Servicio(
                perro,
                servicio,
                horario,
                precio,
                nombre
        );

        dao.guardar(nuevoServicio);
    }

    // ELEGIR UNO DE LOS 3 SERVICIOS
    public static String elegirServicio() {

        System.out.println("\n¿Qué se le hará al perro?");
        System.out.println("1. Lavar");
        System.out.println("2. Rapar");
        System.out.println("3. Lavar y rapar");
        System.out.print("Seleccione: ");

        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {

            case 1:
                return "Lavar";

            case 2:
                return "Rapar";

            case 3:
                return "Lavar y rapar";

            default:
                System.out.println("Servicio incorrecto.");
                return "";
        }
    }
}