/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa06;

import java.time.Instant;
import java.util.Date;
import java.time.LocalDate;
import org.hibernate.Session;

/**
 *
 * @author Rodrigo Mencías
 */
public class Programa06 {

    public static void main(String[] args) {
        DAOVenta dao = new DAOVenta();
        Venta venta=new Venta();
        
        
        Date fecha=Date.from(Instant.now());
        java.sql.Date fechaSQL=new java.sql.Date(fecha.getTime());
        
        venta.setFecha(fechaSQL);
        DetalleVenta detVenta=new DetalleVenta();
        detVenta.setCantidad(10);
        detVenta.setPrecio(20);
        detVenta.setSubtotal(200);
        detVenta.setVenta(venta);
        venta.getDetalleVenta().add(detVenta);
        
        DetalleVenta detVenta2=new DetalleVenta();
        detVenta2.setCantidad(3);
        detVenta2.setPrecio(10);
        detVenta2.setSubtotal(30);
        detVenta2.setVenta(venta);
        venta.getDetalleVenta().add(detVenta);
        
        venta.setMonto(30+200);
        dao.create(venta);
    }
}
