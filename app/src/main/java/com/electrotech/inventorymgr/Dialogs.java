package com.electrotech.inventorymgr;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;


public class Dialogs {
    public Dialogs(){
        UIManager.put("OptionPane.background", new Color(31, 31, 31));
        UIManager.put("Panel.background", new Color(31, 31, 31));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
    }

    public ImageIcon getIcon(String type){
        String workingDirectoryPath = System.getProperty("user.dir");
        String resourcesPath = workingDirectoryPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
        String path;

        switch (type) {
            case "general_warn":
                path = "warning.png";
                break;
            case "database_warn":
                path = "database-warning.png";
                break;
            case "data_error":
                path = "data-error.png";
                break;
            case "check":
                path = "check.png";
                break;
            default:
                return null;
        }
        return new ImageIcon(resourcesPath + path);
    }

    public boolean exitConfirmation(){
        String ObjButtons[] = {"Aceptar","Cancelar"};
        int clientResponse = JOptionPane.showOptionDialog(null, "¿Está seguro que quiere salir? Todos los cambios no guardados se perderán", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, getIcon("general_warn"), ObjButtons, ObjButtons[1]);
        return clientResponse == JOptionPane.YES_NO_OPTION;
    }

    public void databaseConnectionError(){
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado con la base de datos. Revise su conexión a internet e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE, getIcon("database_warn"));
        System.out.println("** Ha ocurrido un error fatal inesperado al conectar con la base de datos.");
        System.exit(1);
    }

    public void databaseQueryError(){
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al realizar esta accion. Puede que los cambios no se hayan guardado correctamente.", "Error", JOptionPane.ERROR_MESSAGE, getIcon("general_warn"));
        System.out.println("** Ha ocurrido un error no fatal inesperado al ejecutar una query.");
    }

    public boolean tooMuchValueWarn(int value){
        String ObjButtons[] = {"Aceptar","Cancelar"};
        int clientResponse = JOptionPane.showOptionDialog(null, "Usted está a punto de agregar " + value + " productos. ¿Está seguro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, getIcon("general_warn"), ObjButtons, ObjButtons[1]);
        return clientResponse == JOptionPane.YES_NO_OPTION;
    }

    public void duplicatedValueError(String value){
        JOptionPane.showMessageDialog(null, "El objeto \"" + value + "\" ya existe. Por favor, si desea modificarlo vaya a la ventana de modificar en el menú de inicio.", "Error", JOptionPane.ERROR_MESSAGE, getIcon("data_error"));
    }

    public void productCreatedSucessfully(int id, String name, String brand, String category, int price, int quantity, String datetime){
        JOptionPane.showMessageDialog(null, "El producto ha sido creado con éxito. Detalles del registro:\n\nID: " + id + "\nNombre: " + name + "\nMarca: " + brand + "\nPrecio: " + price + "\nCategoría: "+ category +"\nCantidad: " + quantity + "\nFecha de registro: " + datetime, "Producto registrado con éxito", JOptionPane.ERROR_MESSAGE, getIcon("check"));
    }

    public void categoryCreatedSucessfully(int id, String name){
        JOptionPane.showMessageDialog(null, "La categoría ha sido creada con éxito. Detalles del registro:\n\n ID: " + id + "\nNombre: " + name, "Categoría registrada con éxito", JOptionPane.ERROR_MESSAGE, getIcon("check"));
    }

    public void fieldsErrors(ArrayList<String> errorsFound){
        String errors = Utils.stringBuild(errorsFound);
        JOptionPane.showMessageDialog(null, "Se han producido los siguientes errores: \n\n" + errors, "Error", JOptionPane.ERROR_MESSAGE, getIcon("data_error"));
    }

    public void productEditedSucessfully(){
        JOptionPane.showMessageDialog(null, "El producto ha sido actualizado con éxito.", "Producto Actualizado", JOptionPane.ERROR_MESSAGE, getIcon("check"));
    }

    public boolean deleteItemWarn(String name){
        String ObjButtons[] = {"Aceptar","Cancelar"};
        int clientResponse = JOptionPane.showOptionDialog(null, "Usted está a punto de eliminar el producto \"" + name + "\", esta accion no se puede deshacer. ¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, getIcon("general_warn"), ObjButtons, ObjButtons[1]);
        return clientResponse == JOptionPane.YES_NO_OPTION;
    }

    public void productDeletedSucessfully(){
        JOptionPane.showMessageDialog(null, "El producto ha sido eliminado con éxito.", "Producto Eliminado", JOptionPane.ERROR_MESSAGE, getIcon("check"));
    }

    public void refreshProductsSucessfully(){
        JOptionPane.showMessageDialog(null, "Se ha refrescado la lista de productos.", "Lista de productos actualizados", JOptionPane.ERROR_MESSAGE, getIcon("check"));
    }

    public static void UnknownError(){
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error desconocido. El programa se cerrará.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
