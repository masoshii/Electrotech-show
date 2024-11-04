package com.electrotech.inventorymgr;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Controller {
    private MainMenuView mainMenu;
    private NewEntryMenuView newView;
    private Dialogs dialogs;
    private Border border;
    private Border emptyBorder;
    private Border compoundBorder;
    private Model model;
    private EditEntryMenuView editView;
    private boolean isListenersAdded = false;

    public Controller(){
        this.mainMenu = new MainMenuView();
        this.newView = new NewEntryMenuView();
        this.dialogs = new Dialogs();
        this.border = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.WHITE);
        this.emptyBorder = new EmptyBorder(0, 0, 0, 0);
        this.compoundBorder = new CompoundBorder(emptyBorder, border);
        this.editView = new EditEntryMenuView();
    }
    
    public void setModel(Model model) {
        this.model = model;
    }

    public void showMainMenu(){
        mainMenu.setVisible(true);
        mainMenuButtonsHandler();
    }
    
    public void showNewView(){
        newView.setVisible(true);
        try {
            model.getDatabaseCon().getNewStatement();
        }
        catch (Exception e){
            dialogs.databaseConnectionError();
        }
        if (!isListenersAdded){
            databaseFormButtonController();
        }
        newEntryButtonsHandler();
        newEntryWindowListeners();
        fieldsListener();
        isListenersAdded = true;
    }

    public void showEditView(){
        editView.setVisible(true);
        try {
            model.getDatabaseCon().getModifyStatement();
        }
        catch(Exception e){
            dialogs.databaseConnectionError();
        }
        editEntryButtonHandler();
        editItemsFilters();
    }

    public void mainMenuButtonsHandler(){
        
        mainMenu.getNewButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showNewView();
                newView.getMainEntryPanel().setVisible(true);
                newView.getItemPanel().setVisible(false);
                newView.getCategoryPanel().setVisible(false);

                newView.getSwitchHomeButton().setBorder(compoundBorder);
                newView.getSwitchHomeButton().setBorderPainted(true);
                newView.getSwitchItemButton().setBorder(null);
                newView.getSwitchCategoryButton().setBorder(null);

            }
        });

        mainMenu.getEditButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showEditView();
                editView.getMainModifyPanel().setVisible(true);
                editView.getItemModifyPanel().setVisible(false);
                editView.getCategoryModifyPanel().setVisible(false);

                editView.getSwitchHomeButton().setBorder(compoundBorder);
                editView.getSwitchHomeButton().setBorderPainted(true);
                editView.getSwitchItemButton().setBorderPainted(false);
                editView.getSwitchCategoryButton().setBorderPainted(false);
            }
        });

        mainMenu.getListButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Se presionó List Item");
            }
        });

        mainMenu.getNewProduct().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showNewView();
                newView.getMainEntryPanel().setVisible(false);
                newView.getItemPanel().setVisible(true);
                newView.getCategoryPanel().setVisible(false);

                newView.getSwitchItemButton().setBorder(compoundBorder);
                newView.getSwitchHomeButton().setBorderPainted(false);
                newView.getSwitchItemButton().setBorderPainted(true);
                newView.getSwitchCategoryButton().setBorderPainted(false);
                newView.getAddItemProductCategoryCB().removeAllItems();
                newView.getAddItemProductCategoryCB().addItem("Seleccione una opción...");   
                for (String element : model.getCategoriesNameColumn()){
                    newView.getAddItemProductCategoryCB().addItem(element);
                }
            }
        });

        mainMenu.getNewCategory().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showNewView();
                newView.getMainEntryPanel().setVisible(false);
                newView.getItemPanel().setVisible(false);
                newView.getCategoryPanel().setVisible(true);

                newView.getSwitchCategoryButton().setBorder(compoundBorder);
                newView.getSwitchHomeButton().setBorderPainted(false);
                newView.getSwitchItemButton().setBorderPainted(false);
                newView.getSwitchCategoryButton().setBorderPainted(true);
            }
        });

        mainMenu.getModifyProduct().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showEditView();
                editView.getMainModifyPanel().setVisible(false);
                editView.getItemModifyPanel().setVisible(true);
                editView.getCategoryModifyPanel().setVisible(false);

                editView.getSwitchItemButton().setBorder(compoundBorder);
                editView.getSwitchHomeButton().setBorderPainted(false);
                editView.getSwitchItemButton().setBorderPainted(true);
                editView.getSwitchCategoryButton().setBorderPainted(false);
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY ID_PRODUCTO ASC");
            }
        });

        mainMenu.getExitItem().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(dialogs.exitConfirmation()){
                    System.out.println("** Programa terminado por el cliente.");
                    System.exit(0);
                }
            }
        });
    }

    // HANDLER DE BOTONES DE AÑADIR
    public void newEntryButtonsHandler(){
        newView.getSwitchHomeButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newView.getMainEntryPanel().setVisible(true);
                newView.getItemPanel().setVisible(false);
                newView.getCategoryPanel().setVisible(false);

                newView.getSwitchHomeButton().setBorder(compoundBorder);
                newView.getSwitchHomeButton().setBorderPainted(true);
                newView.getSwitchItemButton().setBorderPainted(false);
                newView.getSwitchCategoryButton().setBorderPainted(false);
            }
        });

        newView.getSwitchItemButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newView.getMainEntryPanel().setVisible(false);
                newView.getItemPanel().setVisible(true);
                newView.getCategoryPanel().setVisible(false);

                newView.getSwitchItemButton().setBorder(compoundBorder);
                newView.getSwitchHomeButton().setBorderPainted(false);
                newView.getSwitchItemButton().setBorderPainted(true);
                newView.getSwitchCategoryButton().setBorderPainted(false);
                newView.getAddItemProductCategoryCB().removeAllItems();   
                newView.getAddItemProductCategoryCB().addItem("Seleccione una opción...");
                for (String element : model.getCategoriesNameColumn()){
                    newView.getAddItemProductCategoryCB().addItem(element);
                }
            }

        });

        newView.getSwitchCategoryButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newView.getMainEntryPanel().setVisible(false);
                newView.getItemPanel().setVisible(false);
                newView.getCategoryPanel().setVisible(true);

                newView.getSwitchCategoryButton().setBorder(compoundBorder);
                newView.getSwitchHomeButton().setBorderPainted(false);
                newView.getSwitchItemButton().setBorderPainted(false);
                newView.getSwitchCategoryButton().setBorderPainted(true);  
            }
        });

        newView.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newView.dispose();
            }
        });

        // Botones de la pantalla Home de la vista de cosas nuevas
        newView.getOnMainItemButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newView.getMainEntryPanel().setVisible(false);
                newView.getItemPanel().setVisible(true);
                newView.getSwitchItemButton().setBorder(compoundBorder);
                newView.getSwitchHomeButton().setBorderPainted(false);
                newView.getSwitchItemButton().setBorderPainted(true);
                newView.getSwitchCategoryButton().setBorderPainted(false);
                newView.getAddItemProductCategoryCB().removeAllItems(); 
                newView.getAddItemProductCategoryCB().addItem("Seleccione una opción...");  
                for (String element : model.getCategoriesNameColumn()){
                    newView.getAddItemProductCategoryCB().addItem(element);
                }
            }
        });

        newView.getOnMainCategoryButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newView.getMainEntryPanel().setVisible(false);
                newView.getCategoryPanel().setVisible(true);
                newView.getSwitchCategoryButton().setBorder(compoundBorder);
                newView.getSwitchHomeButton().setBorderPainted(false);
                newView.getSwitchItemButton().setBorderPainted(false);
                newView.getSwitchCategoryButton().setBorderPainted(true);
            }
        });
        
        newView.getCleanFieldsButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newView.getAddItemProductNameTextField().setText("");
                newView.getAddItemProductBrandTextField().setText("");
                newView.getAddItemProductCategoryCB().setSelectedItem("Seleccione una opción...");
                newView.getAddItemProductPriceTextField().setText("");
                newView.getAddItemProductQuantitySP().setValue(1);
            }
        });

    }

    // HANDLER DE BOTONES DE EDITAR
    public void editEntryButtonHandler(){
        editView.getSwitchHomeButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                editView.getMainModifyPanel().setVisible(true);
                editView.getItemModifyPanel().setVisible(false);
                editView.getCategoryModifyPanel().setVisible(false);

                editView.getSwitchHomeButton().setBorder(compoundBorder);
                editView.getSwitchHomeButton().setBorderPainted(true);
                editView.getSwitchItemButton().setBorderPainted(false);
                editView.getSwitchCategoryButton().setBorderPainted(false);
            }
            
        });
        editView.getSwitchItemButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                editView.getMainModifyPanel().setVisible(false);
                editView.getItemModifyPanel().setVisible(true);
                editView.getCategoryModifyPanel().setVisible(false);

                editView.getSwitchItemButton().setBorder(compoundBorder);
                editView.getSwitchHomeButton().setBorderPainted(false);
                editView.getSwitchItemButton().setBorderPainted(true);
                editView.getSwitchCategoryButton().setBorderPainted(false);
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY ID_PRODUCTO ASC");
            }
        });
        editView.getSwitchCategoryButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                editView.getMainModifyPanel().setVisible(false);
                editView.getItemModifyPanel().setVisible(false);
                editView.getCategoryModifyPanel().setVisible(true);

                editView.getSwitchCategoryButton().setBorder(compoundBorder);
                editView.getSwitchHomeButton().setBorderPainted(false);
                editView.getSwitchItemButton().setBorderPainted(false);
                editView.getSwitchCategoryButton().setBorderPainted(true);
            }
        });
        editView.getExitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                editView.dispose();
            }
        });
        editView.getOnMainItemButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                editView.getMainModifyPanel().setVisible(false);
                editView.getItemModifyPanel().setVisible(true);
                editView.getCategoryModifyPanel().setVisible(false);

                editView.getSwitchItemButton().setBorder(compoundBorder);
                editView.getSwitchHomeButton().setBorderPainted(false);
                editView.getSwitchItemButton().setBorderPainted(true);
                editView.getSwitchCategoryButton().setBorderPainted(false);
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY ID_PRODUCTO ASC");
            }
        });
        editView.getOnMainCategoryButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                editView.getMainModifyPanel().setVisible(false);
                editView.getItemModifyPanel().setVisible(false);
                editView.getCategoryModifyPanel().setVisible(true);

                editView.getSwitchCategoryButton().setBorder(compoundBorder);
                editView.getSwitchHomeButton().setBorderPainted(false);
                editView.getSwitchItemButton().setBorderPainted(false);
                editView.getSwitchCategoryButton().setBorderPainted(true);
            }
        });
    }

    //Listeners para cambio de color 

    public void fieldsListener(){
        Color backgroundColor = new Color(31, 31, 31);
        newView.getAddItemProductNameTextField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e){
                newView.getAddItemProductNameTextField().setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
            }
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
            }
        });
        newView.getAddItemProductBrandTextField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e){
                newView.getAddItemProductBrandTextField().setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
            }
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
            }
        });
        newView.getAddItemProductPriceTextField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e){
                newView.getAddItemProductPriceTextField().setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
            }
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
            }
        });
        newView.getAddItemProductCategoryCB().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newView.getAddItemProductCategoryCB().setForeground(Color.WHITE.darker());
            }
        });
        newView.getAddItemProductQuantitySP().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                newView.getAddItemProductQuantitySP().setBorder(null);
            }         
        });
        newView.getAddCategoryNameTextField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e){
                newView.getAddCategoryNameTextField().setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
            }
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
            }
        });
    }

    public void databaseFormButtonController(){
        Border errorBorder = BorderFactory.createLineBorder(Color.RED);
        //Fields y Botón de envio de New > Products
        newView.getSendNewItemButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<String> errorsFound = new ArrayList<String>();
                //---Asegurarse que los datos son correctos, si no, hacer algo---
                Boolean isGood = true;
                Boolean isQuantityNumber = true;
                Boolean isConfirmed = true;
                Boolean isDuplicated = false;
                String productName = newView.getAddItemProductNameTextField().getText();
                String brandName = newView.getAddItemProductBrandTextField().getText();
                String price = newView.getAddItemProductPriceTextField().getText();
                String category = newView.getAddItemProductCategoryCB().getSelectedItem().toString();
                String quantity = newView.getAddItemProductQuantitySP().getValue().toString();
                int intQuantity = 0;

                try{
                    Integer.parseInt(quantity);
                }
                catch(Exception ex){
                    isQuantityNumber = false;
                }
                
                if (productName.isBlank() || productName.isEmpty()){
                    newView.getAddItemProductNameTextField().setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso de nombre no puede estar vacío.");
                    isGood = false;
                }

                if (brandName.isBlank() || brandName.isEmpty()){
                    newView.getAddItemProductBrandTextField().setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso de la marca no puede estar vacío.");
                    isGood = false;
                }

                
                if (price.isBlank() || price.isEmpty()){
                    newView.getAddItemProductPriceTextField().setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso del precio no puede estar vacío.");
                    isGood = false;
                }

                if (category.equals("Seleccione una opción...")){
                    newView.getAddItemProductCategoryCB().setForeground(Color.RED);
                    errorsFound.add("* Debe seleccionar una opción en \"Categoría\".");
                    isGood = false;
                }

                if (!isQuantityNumber){
                    newView.getAddItemProductQuantitySP().setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso de cantidad no es un número.");
                    isGood = false;
                }else{
                    intQuantity = Integer.parseInt(quantity);
                }

                if (intQuantity >= 100 && isGood){
                    if(dialogs.tooMuchValueWarn(intQuantity)){

                    }
                    else {
                        isConfirmed = false;
                    }
                }
                //---Verificar si no existe ya, tirar error si es que si.---
                String[] productArr = model.getProductsNameColumn();
                for(String element : productArr){
                    if(productName.equals(element)){
                        isDuplicated = true;
                        isGood = false;
                        break;
                    }
                }

                //---Llevar a la db, tirar msg de exito y limpiar campos---

                if(isGood && isConfirmed){
                    int intPrice = Integer.parseInt(price);
                    newView.getAddItemProductNameTextField().setText("");
                    newView.getAddItemProductBrandTextField().setText("");
                    newView.getAddItemProductCategoryCB().setSelectedItem("Seleccione una opción...");
                    newView.getAddItemProductPriceTextField().setText("");
                    newView.getAddItemProductQuantitySP().setValue(1);
                    model.registerNewProduct(productName, brandName, category, intPrice, intQuantity);
                } else if (isConfirmed && !isGood) {
                    if (isDuplicated){
                        newView.getAddItemProductNameTextField().setBorder(errorBorder);
                        dialogs.duplicatedValueError(productName);
                    } else {
                        dialogs.fieldsErrors(errorsFound);
                    }
                }                
                
            }
        });
        //Fields y Botón de envio de New > Category
        newView.getSendNewCategoryButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String newCategory = newView.getAddCategoryNameTextField().getText();
                ArrayList<String> errorsFound = new ArrayList<String>();
                boolean isGood = true;
                boolean isDuplicated = false;

                if(newCategory.isBlank() || newCategory.isEmpty()){
                    newView.getAddCategoryNameTextField().setBorder(errorBorder);
                    errorsFound.add("* El campo de nombre de categoría no puede estar vacío.");
                    isGood = false;
                }

                String[] categoryArr = model.getCategoriesNameColumn();
                for(String element : categoryArr){
                    if(newCategory.equals(element)){
                        isDuplicated = true;
                        isGood = false;
                        break;
                    }
                }

                if (isGood){
                    newView.getAddCategoryNameTextField().setText("");
                    model.registerNewCategory(newCategory);
                } else {
                    if (isDuplicated){
                        newView.getAddCategoryNameTextField().setBorder(errorBorder);
                        dialogs.duplicatedValueError(newCategory);
                    } else {
                        dialogs.fieldsErrors(errorsFound);
                    }
                }


            }
        });
    }


    //Enviar la edicion de categoría
    public void editForm(){
        Border errorBorder = BorderFactory.createLineBorder(Color.RED);
        //Fields y Botón de envio de New > Products
        newView.getSendNewItemButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<String> errorsFound = new ArrayList<String>();
                //---Asegurarse que los datos son correctos, si no, hacer algo---
                Boolean isGood = true;
                Boolean isQuantityNumber = true;
                Boolean isConfirmed = true;
                Boolean isDuplicated = false;
                String productName = newView.getAddItemProductNameTextField().getText();
                String brandName = newView.getAddItemProductBrandTextField().getText();
                String price = newView.getAddItemProductPriceTextField().getText();
                String category = newView.getAddItemProductCategoryCB().getSelectedItem().toString();
                String quantity = newView.getAddItemProductQuantitySP().getValue().toString();
                int intQuantity = 0;

                try{
                    Integer.parseInt(quantity);
                }
                catch(Exception ex){
                    isQuantityNumber = false;
                }
                
                if (productName.isBlank() || productName.isEmpty()){
                    newView.getAddItemProductNameTextField().setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso de nombre no puede estar vacío.");
                    isGood = false;
                }

                if (brandName.isBlank() || brandName.isEmpty()){
                    newView.getAddItemProductBrandTextField().setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso de la marca no puede estar vacío.");
                    isGood = false;
                }

                
                if (price.isBlank() || price.isEmpty()){
                    newView.getAddItemProductPriceTextField().setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso del precio no puede estar vacío.");
                    isGood = false;
                }

                if (category.equals("Seleccione una opción...")){
                    newView.getAddItemProductCategoryCB().setForeground(Color.RED);
                    errorsFound.add("* Debe seleccionar una opción en \"Categoría\".");
                    isGood = false;
                }

                if (!isQuantityNumber){
                    newView.getAddItemProductQuantitySP().setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso de cantidad no es un número.");
                    isGood = false;
                }else{
                    intQuantity = Integer.parseInt(quantity);
                }

                if (intQuantity >= 100 && isGood){
                    if(dialogs.tooMuchValueWarn(intQuantity)){

                    }
                    else {
                        isConfirmed = false;
                    }
                }
                //---Verificar si no existe ya, tirar error si es que si.---
                String[] productArr = model.getProductsNameColumn();
                for(String element : productArr){
                    if(productName.equals(element)){
                        isDuplicated = true;
                        isGood = false;
                        break;
                    }
                }

                //---Llevar a la db, tirar msg de exito y limpiar campos---

                if(isGood && isConfirmed){
                    int intPrice = Integer.parseInt(price);
                    newView.getAddItemProductNameTextField().setText("");
                    newView.getAddItemProductBrandTextField().setText("");
                    newView.getAddItemProductCategoryCB().setSelectedItem("Seleccione una opción...");
                    newView.getAddItemProductPriceTextField().setText("");
                    newView.getAddItemProductQuantitySP().setValue(1);
                    model.registerNewProduct(productName, brandName, category, intPrice, intQuantity);
                } else if (isConfirmed && !isGood) {
                    if (isDuplicated){
                        newView.getAddItemProductNameTextField().setBorder(errorBorder);
                        dialogs.duplicatedValueError(productName);
                    } else {
                        dialogs.fieldsErrors(errorsFound);
                    }
                }                
                
            }
        });
    }

    ////////// WINDOWS LISTENERS ///////////

    public void newEntryWindowListeners(){
        newView.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    model.getDatabaseCon().getNewStatement().close();
                    newView.getAddItemProductCategoryCB().removeAllItems();
                } catch(Exception ex){
                    dialogs.databaseConnectionError();
                }
            }
        });
    }

    public void editEntryWindowListeners(){
        editView.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    model.getDatabaseCon().getModifyStatement().close();
                    editView.getItemListPanel().removeAll();
                } catch(Exception ex){
                    dialogs.databaseConnectionError();
                }
            }
        });
    }


    //BOTONES DE REFRESH, FILTROS Y BUSCAR
    public void editItemsFilters(){

        editView.getRefreshButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY ID_PRODUCTO ASC");
                dialogs.refreshProductsSucessfully();
                editView.getItemListPanel().revalidate();
                editView.getItemListPanel().repaint();
            }
        });
        
        editView.getSearchItemSendButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(editView.getSearchItemTextField().getText().isBlank()){
                    editView.getItemListPanel().removeAll();
                    model.fetchProductToScrollPane(" ORDER BY ID_PRODUCTO ASC");
                    editView.getItemListPanel().revalidate();
                    editView.getItemListPanel().repaint();
                } else {
                    editView.getItemListPanel().removeAll();
                    model.fetchProductToScrollPane(" WHERE NOMBRE_PRODUCTO LIKE '%" + editView.getSearchItemTextField().getText() +"%'");
                    editView.getItemListPanel().revalidate();
                    editView.getItemListPanel().repaint();
                }
            }
        });

        editView.getNameFilter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY NOMBRE_PRODUCTO ASC");
                editView.getItemListPanel().revalidate();
                editView.getItemListPanel().repaint();
            }
        });
        editView.getBrandFilter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY MARCA_PRODUCTO ASC");
                editView.getItemListPanel().revalidate();
                editView.getItemListPanel().repaint();
            }
        });
        editView.getCategoryFilter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY NOMBRE_CATEGORIA ASC");
                editView.getItemListPanel().revalidate();
                editView.getItemListPanel().repaint();
            }
        });
        editView.getPriceFilter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY PRECIO_PRODUCTO ASC");
                editView.getItemListPanel().revalidate();
                editView.getItemListPanel().repaint();
            }
        });
        editView.getQuantityFilter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY CANTIDAD_PRODUCTO ASC");
                editView.getItemListPanel().revalidate();
                editView.getItemListPanel().repaint();
            }
        });
        editView.getDateFilter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY FECHA_REGISTRO_PRODUCTO ASC");
                editView.getItemListPanel().revalidate();
                editView.getItemListPanel().repaint();
                
            }
        });
        editView.getIdFilter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editView.getItemListPanel().removeAll();
                model.fetchProductToScrollPane(" ORDER BY ID_PRODUCTO ASC");
                editView.getItemListPanel().revalidate();
                editView.getItemListPanel().repaint();
            }
        });
    }

    public EditEntryMenuView getEditView(){
        return editView;
    }
}
