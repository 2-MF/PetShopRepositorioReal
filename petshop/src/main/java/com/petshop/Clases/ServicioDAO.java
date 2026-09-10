package com.petshop.Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicioDAO {

    public void guardar(Servicio servicio) {
        String sql = "INSERT INTO servicios (perro, servicio, horario, precio, limpiador) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, servicio.getPerro());
            ps.setString(2, servicio.getServicio());
            ps.setString(3, servicio.getHorario());
            ps.setDouble(4, servicio.getPrecio());
            ps.setString(5, servicio.getLimpiador());
            ps.executeUpdate();

            System.out.println("\nServicio registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el servicio: " + e.getMessage());
        }
    }

    public void mostrar() {
        String sql = "SELECT id, perro, servicio, horario, precio, limpiador FROM servicios ORDER BY id";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== SERVICIOS =====");
            boolean hayServicios = false;

            while (rs.next()) {
                hayServicios = true;
                System.out.println(
                    "ID: " + rs.getInt("id")
                    + " | Perro: " + rs.getString("perro")
                    + " | Servicio: " + rs.getString("servicio")
                    + " | Horario: " + rs.getString("horario")
                    + " | Precio: $" + rs.getDouble("precio")
                    + " | Limpiador: " + rs.getString("limpiador")
                );
            }

            if (!hayServicios) {
                System.out.println("No hay servicios registrados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar los servicios: " + e.getMessage());
        }
    }
}
