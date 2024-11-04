
package com.electrotech.inventorymgr;

import javax.swing.*;


public class AppTest extends JFrame {
    
    public static void main(String[] args){

        String name = "Redmi Note 12";
        String brand = "Xiaomi";
        int price = 159990;
        int quantity = 23;
        int idCategoria = 3;
        int id = 5;
        String updateQuery = "UPDATE PRODUCT SET NOMBRE_PRODUCTO = " + "'" + name + "', MARCA_PRODUCTO = '" + brand + "', PRECIO_PRODUCTO = " + price + ", CANTIDAD_PRODUCTO = " + quantity + ", CATEGORY_ID_CATEGORIA = " + idCategoria + " WHERE ID_PRODUCTO = " + id;

        System.out.println(updateQuery);
    }
}
