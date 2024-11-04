package com.electrotech.inventorymgr;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Model {
    private DatabaseCon databaseCon;
    private Dialogs dialogs;
    private IteratePanels iteratePanels;
    public Model(){
        this.dialogs = new Dialogs();
        try{
            this.databaseCon = new DatabaseCon();
        }
        catch(Exception e){
            e.printStackTrace();
            dialogs.databaseConnectionError();
        }
    }

    public void setIteratePanels(IteratePanels iteratePanels){
        this.iteratePanels = iteratePanels;
    }
    
    public void checkActive(){
        String query = "SELECT 1";
        try {
            this.databaseCon.getNewStatement().executeQuery(query);
            System.out.println("ACTIVA");
        }
        catch (Exception e){
            dialogs.databaseConnectionError();
        }
    }

    public void fetchProductToScrollPane(String filters){


        StringBuilder queryWithFilters = new StringBuilder();
        String query = "SELECT P.ID_PRODUCTO, P.NOMBRE_PRODUCTO, P.MARCA_PRODUCTO, C.NOMBRE_CATEGORIA, P.PRECIO_PRODUCTO, P.CANTIDAD_PRODUCTO, P.FECHA_REGISTRO_PRODUCTO FROM PRODUCT P INNER JOIN CATEGORY C ON C.ID_CATEGORIA = P.CATEGORY_ID_CATEGORIA";
        ResultSet rSet = null;
        String finalQuery = "";
        int id = 0, price = 0, quantity = 0;
        String name = "", brand = "", category = "", formatedDate = "";
        Timestamp timestamp = null;

        
        queryWithFilters.append(query);
        queryWithFilters.append(filters);
        
        finalQuery = queryWithFilters.toString();
        
        try{
            rSet = databaseCon.getModifyStatement().executeQuery(finalQuery);
            while(rSet.next()){

                id = rSet.getInt("ID_PRODUCTO");
                name = rSet.getString("NOMBRE_PRODUCTO");
                brand = rSet.getString("MARCA_PRODUCTO");
                category = rSet.getString("NOMBRE_CATEGORIA");
                price = rSet.getInt("PRECIO_PRODUCTO");
                quantity = rSet.getInt("CANTIDAD_PRODUCTO");
                timestamp = rSet.getTimestamp("FECHA_REGISTRO_PRODUCTO");
                formatedDate = timestampFormatterForScroll(timestamp);

                iteratePanels.generateItemListPanels(id,name,brand,category,price,quantity,formatedDate);
            }
        } catch(Exception e){
            dialogs.databaseConnectionError();
        }
    }

    public String[] getCategoriesNameColumn(){
        String query = "SELECT NOMBRE_CATEGORIA FROM CATEGORY";
        ArrayList<String> list = new ArrayList<>();
        ResultSet resultSet = null;
        try{
            resultSet = this.databaseCon.getNewStatement().executeQuery(query);
            while(resultSet.next()){
                String row = resultSet.getString("NOMBRE_CATEGORIA");
                list.add(row);
            }
            return list.toArray(new String[0]);
        }
        catch(Exception e){
            dialogs.databaseConnectionError();
            return null;
        }
    }

    public int fetchProductIdByName(String name){
        String query = "SELECT ID_PRODUCTO FROM PRODUCT WHERE NOMBRE_PRODUCTO = '" + name + "'";
        ResultSet rSet = null;
        try {
            rSet = databaseCon.getModifyStatement().executeQuery(query);
            while(rSet.next()){
                return rSet.getInt("ID_PRODUCTO");
            }
        } catch(Exception e){
            dialogs.databaseConnectionError();
        }
        return 0;
    }

    public void editItems(int id, String name, String brand, String category, int price, int quantity){

        String getCategoryQuery = "SELECT ID_CATEGORIA FROM CATEGORY WHERE NOMBRE_CATEGORIA = '" + category + "'";
        ResultSet rSet = null;
        int idCategoria = 0;
        try{
            rSet = databaseCon.getModifyStatement().executeQuery(getCategoryQuery);
            while(rSet.next()){
                idCategoria = rSet.getInt("ID_CATEGORIA");
            }
        } catch (Exception e){
            dialogs.databaseConnectionError();
        }

        String updateQuery = "UPDATE PRODUCT SET NOMBRE_PRODUCTO = " + "'" + name + "', MARCA_PRODUCTO = '" + brand + "', PRECIO_PRODUCTO = " + price + ", CANTIDAD_PRODUCTO = " + quantity + ", CATEGORY_ID_CATEGORIA = " + idCategoria + " WHERE ID_PRODUCTO = " + id;
        
        try{
            databaseCon.getModifyStatement().executeUpdate(updateQuery);
        } catch(Exception e){
            dialogs.databaseConnectionError();
        }
        dialogs.productEditedSucessfully();

    }

    public String[] getProductsNameColumn(){
        String query = "SELECT NOMBRE_PRODUCTO FROM PRODUCT";
        ArrayList<String> list = new ArrayList<>();
        ResultSet resultSet = null;
        try{
            resultSet = this.databaseCon.getNewStatement().executeQuery(query);
            while(resultSet.next()){
                String row = resultSet.getString("NOMBRE_PRODUCTO");
                list.add(row);
            }
            return list.toArray(new String[0]);
        }
        catch(Exception e){
            dialogs.databaseConnectionError();
            return null;
        }
    }

    public void deleteProduct(int id){
        String query = "DELETE FROM PRODUCT WHERE ID_PRODUCTO = " + id;
        try{
            databaseCon.getModifyStatement().executeUpdate(query);
            dialogs.productDeletedSucessfully();
        } catch(Exception e){
            dialogs.databaseConnectionError();
        }
    }

    public int registerNewProduct(String name, String brand, String category, int price, int quantity){
        int categoryid = getCategoryIDByName(category);
        String registerQuery = "INSERT INTO PRODUCT (NOMBRE_PRODUCTO, MARCA_PRODUCTO, PRECIO_PRODUCTO, CANTIDAD_PRODUCTO, FECHA_REGISTRO_PRODUCTO, CATEGORY_ID_CATEGORIA) VALUES ('"+ name +"', '"+ brand +"', " + price + ", " + quantity + ", CONVERT_TZ(NOW(), '+00:00', '-03:00'), "+ categoryid + ")";

        try {
            this.databaseCon.getNewStatement().executeUpdate(registerQuery);
            System.out.println("** Un registro de producto nuevo a la base de datos.");
        } 
        catch (Exception e){
            dialogs.databaseQueryError();
            return 1;
        }
        
        //Para los resultados

        String viewRegisteredProduct = "SELECT P.ID_PRODUCTO, P.NOMBRE_PRODUCTO, P.MARCA_PRODUCTO, P.PRECIO_PRODUCTO, P.CANTIDAD_PRODUCTO, P.FECHA_REGISTRO_PRODUCTO, C.NOMBRE_CATEGORIA FROM PRODUCT P INNER JOIN CATEGORY C ON C.ID_CATEGORIA = P.CATEGORY_ID_CATEGORIA ORDER BY ID_PRODUCTO DESC LIMIT 1;";
        ResultSet resultSet = null;
        int resId = 0, resPrice = 0, resQuantity = 0;
        String resName = null, resBrand = null, resCategory = null;
        Timestamp timestamp = null;

        try {
            resultSet = this.databaseCon.getNewStatement().executeQuery(viewRegisteredProduct);
            while (resultSet.next()){
                resId = resultSet.getInt("ID_PRODUCTO");
                resPrice = resultSet.getInt("PRECIO_PRODUCTO");
                resQuantity = resultSet.getInt("CANTIDAD_PRODUCTO");
                resName = resultSet.getString("NOMBRE_PRODUCTO");
                resBrand = resultSet.getString("MARCA_PRODUCTO");
                resCategory = resultSet.getString("NOMBRE_CATEGORIA");
                timestamp = resultSet.getTimestamp("FECHA_REGISTRO_PRODUCTO");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            dialogs.databaseQueryError();
            return 1;
        }

        String formatedDate = timestampFormatter(timestamp);

        dialogs.productCreatedSucessfully(resId, resName, resBrand, resCategory, resPrice, resQuantity, formatedDate);
        return 0;
    }

    public int registerNewCategory(String name){
        String query = "INSERT INTO CATEGORY (NOMBRE_CATEGORIA) VALUES ('"+ name + "')";
        try{
            this.databaseCon.getNewStatement().executeUpdate(query);
        }
        catch (Exception e){
            dialogs.databaseQueryError();
            return 1;
        }

        String newObjectQuery = "SELECT * FROM CATEGORY ORDER BY ID_CATEGORIA DESC LIMIT 1";
        ResultSet resultSet = null;
        int resId = 0;
        String resName = null;
        try{
            resultSet = databaseCon.getNewStatement().executeQuery(newObjectQuery);
            while(resultSet.next()){
                resId = resultSet.getInt("ID_CATEGORIA");
                resName = resultSet.getString("NOMBRE_CATEGORIA");
            }
        } catch (Exception e) {
            dialogs.databaseQueryError();
            return 1;
        }

        dialogs.categoryCreatedSucessfully(resId, resName);
        return 0;
    }

    public String timestampFormatter(Timestamp timestamp){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy 'a las' hh:mm a");
        String formatedDate = dateFormat.format(new Date(timestamp.getTime()));
        return formatedDate;
    }

    public String timestampFormatterForScroll(Timestamp timestamp){
        SimpleDateFormat dateFormat = new SimpleDateFormat("'<html>'dd 'de' MMMM 'de' yyyy '<br>' 'a las' hh:mm a '</html>'");
        String formatedDate = dateFormat.format(new Date(timestamp.getTime()));
        return formatedDate;
    }


    public int getCategoryQuantity(){
        String query = "SELECT COUNT(ID_CATEGORIA) AS COUNT FROM CATEGORY";
        ResultSet resultSet = null;
        int quantity = 0;
        try{
            resultSet = this.databaseCon.getNewStatement().executeQuery(query);
            while(resultSet.next()){
                quantity = resultSet.getInt("COUNT");
            }
            System.out.println(quantity);
            return quantity;
        }
        catch(Exception e){
            dialogs.databaseConnectionError();
            return 0;
        }
    }

    public int getCategoryIDByName(String name){
        String query = "SELECT ID_CATEGORIA FROM CATEGORY WHERE NOMBRE_CATEGORIA = '" + name + "'";
        ResultSet resultSet = null;
        int row = 0;
        try{
            resultSet = this.databaseCon.getNewStatement().executeQuery(query);
            while(resultSet.next()){
                row = resultSet.getInt("ID_CATEGORIA");
            }
            return row;
        }
        catch(Exception e){
            dialogs.databaseConnectionError();
            return 1;
        }
    }

    public DatabaseCon getDatabaseCon(){
        return this.databaseCon;
    }
}
