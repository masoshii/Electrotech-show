package com.electrotech.inventorymgr;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditingView extends JFrame{
    private JButton sendEditedItemButton;
    private JButton cleanFieldsButton;
    private JTextField editItemProductNameTextField;
    private JTextField editItemProductBrandTextField;
    private JTextField editItemProductPriceTextField;
    private JComboBox<String> editItemProductCategoryCB;
    private JSpinner editItemProductQuantitySP;
    private Dialogs dialogs;
    private Model model;

    public EditingView(int id, String name, String brand, String category, int price, int quantity){
        //Por tiempo el controlador va aqui mismo
        this.dialogs = new Dialogs();
        this.model = new Model();

        Color backgroundColor = Color.decode("#1f1f1f");
        String userDir = System.getProperty("user.dir");
        File currentDir = new File(userDir);
        String workingDirectoryPath = "";
        String resourcesPath = "";
        try{
            workingDirectoryPath = currentDir.getCanonicalPath();
        } catch (Exception e){
            e.printStackTrace();
        }
        if(workingDirectoryPath.contains("app")){
            resourcesPath = workingDirectoryPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
        } else {
            resourcesPath = workingDirectoryPath + File.separator + "app" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
        }
        String iconPath = resourcesPath + "edit-file.png";
        ImageIcon icon = new ImageIcon(iconPath);

        //GridBagConstraints
        GridBagConstraints gbcAddItemTitleLabel = new GridBagConstraints();
        gbcAddItemTitleLabel.gridx = 0;
        gbcAddItemTitleLabel.gridy = 0;
        gbcAddItemTitleLabel.gridheight = 1;
        gbcAddItemTitleLabel.gridwidth = GridBagConstraints.REMAINDER;
        gbcAddItemTitleLabel.weightx = 0.3;
        gbcAddItemTitleLabel.weighty = 1.0;
        gbcAddItemTitleLabel.insets = new Insets(0, 30, 0, 0);
        gbcAddItemTitleLabel.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcAddItemSubtitleLabel = new GridBagConstraints();
        gbcAddItemSubtitleLabel.gridx = 0;
        gbcAddItemSubtitleLabel.gridy = 1;
        gbcAddItemSubtitleLabel.gridheight = 1;
        gbcAddItemSubtitleLabel.gridwidth = GridBagConstraints.REMAINDER;
        gbcAddItemSubtitleLabel.weightx = 0.3;
        gbcAddItemSubtitleLabel.weighty = 1.0;
        gbcAddItemSubtitleLabel.insets = new Insets(0, 30, 20, 0);
        gbcAddItemSubtitleLabel.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcEditItemProductNameTitle = new GridBagConstraints();
        gbcEditItemProductNameTitle.gridx = 0;
        gbcEditItemProductNameTitle.gridy = 2;
        gbcEditItemProductNameTitle.gridheight = 1;
        gbcEditItemProductNameTitle.gridwidth = 1;
        gbcEditItemProductNameTitle.weightx = 0.3;
        gbcEditItemProductNameTitle.weighty = 1.0;
        gbcEditItemProductNameTitle.insets = new Insets(0, 25, 0, 0);
        gbcEditItemProductNameTitle.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcEditItemProductNameTextField = new GridBagConstraints();
        gbcEditItemProductNameTextField.gridx = 0;
        gbcEditItemProductNameTextField.gridy = 3;
        gbcEditItemProductNameTextField.gridheight = 1;
        gbcEditItemProductNameTextField.gridwidth = GridBagConstraints.REMAINDER;
        gbcEditItemProductNameTextField.weightx = 0.3;
        gbcEditItemProductNameTextField.weighty = 1.0;
        gbcEditItemProductNameTextField.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcEditItemProductBrandTitle = new GridBagConstraints();
        gbcEditItemProductBrandTitle.gridx = 0;
        gbcEditItemProductBrandTitle.gridy = 4;
        gbcEditItemProductBrandTitle.gridheight = 1;
        gbcEditItemProductBrandTitle.gridwidth = 1;
        gbcEditItemProductBrandTitle.weightx = 0.3;
        gbcEditItemProductBrandTitle.weighty = 1.0;
        gbcEditItemProductBrandTitle.insets = new Insets(0, 25, 0, 0);
        gbcEditItemProductBrandTitle.anchor = GridBagConstraints.NORTHWEST;
        
        GridBagConstraints gbcEditItemProductBrandTextField = new GridBagConstraints();
        gbcEditItemProductBrandTextField.gridx = 0;
        gbcEditItemProductBrandTextField.gridy = 5;
        gbcEditItemProductBrandTextField.gridheight = 1;
        gbcEditItemProductBrandTextField.gridwidth = 1;
        gbcEditItemProductBrandTextField.weightx = 0.3;
        gbcEditItemProductBrandTextField.weighty = 1.0;
        gbcEditItemProductBrandTextField.insets = new Insets(0, 25, 0, 0);
        gbcEditItemProductBrandTextField.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcEditItemProductCategoryTitle = new GridBagConstraints();
        gbcEditItemProductCategoryTitle.gridx = 1;
        gbcEditItemProductCategoryTitle.gridy = 4;
        gbcEditItemProductCategoryTitle.gridheight = 1;
        gbcEditItemProductCategoryTitle.gridwidth = 1;
        gbcEditItemProductCategoryTitle.weightx = 0.3;
        gbcEditItemProductCategoryTitle.weighty = 1.0;
        gbcEditItemProductCategoryTitle.insets = new Insets(0, 0, 0, 227);;
        gbcEditItemProductCategoryTitle.anchor = GridBagConstraints.NORTHEAST;

        GridBagConstraints gbcEditItemProductCategoryCB = new GridBagConstraints();
        gbcEditItemProductCategoryCB.gridx = 1;
        gbcEditItemProductCategoryCB.gridy = 5;
        gbcEditItemProductCategoryCB.gridheight = 1;
        gbcEditItemProductCategoryCB.gridwidth = 1;
        gbcEditItemProductCategoryCB.weightx = 0.3;
        gbcEditItemProductCategoryCB.weighty = 1.0;
        gbcEditItemProductCategoryCB.insets = new Insets(0,0,0,25);
        gbcEditItemProductCategoryCB.anchor = GridBagConstraints.NORTHEAST;

        GridBagConstraints gbcEditItemProductPriceTitle = new GridBagConstraints();
        gbcEditItemProductPriceTitle.gridx = 0;
        gbcEditItemProductPriceTitle.gridy = 6;
        gbcEditItemProductPriceTitle.gridheight = 1;
        gbcEditItemProductPriceTitle.gridwidth = 1;
        gbcEditItemProductPriceTitle.weightx = 0.3;
        gbcEditItemProductPriceTitle.weighty = 1.0;
        gbcEditItemProductPriceTitle.insets = new Insets(0, 25, 0, 0);
        gbcEditItemProductPriceTitle.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcEditItemProductPriceTextField = new GridBagConstraints();
        gbcEditItemProductPriceTextField.gridx = 0;
        gbcEditItemProductPriceTextField.gridy = 7;
        gbcEditItemProductPriceTextField.gridheight = 1;
        gbcEditItemProductPriceTextField.gridwidth = 1;
        gbcEditItemProductPriceTextField.weightx = 0.3;
        gbcEditItemProductPriceTextField.weighty = 1.0;
        gbcEditItemProductPriceTextField.insets = new Insets(0, 25, 0, 0);
        gbcEditItemProductPriceTextField.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcEditItemProductQuantityTitle = new GridBagConstraints();
        gbcEditItemProductQuantityTitle.gridx = 1;
        gbcEditItemProductQuantityTitle.gridy = 6;
        gbcEditItemProductQuantityTitle.gridheight = 1;
        gbcEditItemProductQuantityTitle.gridwidth = 1;
        gbcEditItemProductQuantityTitle.weightx = 0.3;
        gbcEditItemProductQuantityTitle.weighty = 1.0;
        gbcEditItemProductQuantityTitle.insets = new Insets(0, 0, 0, 231);;
        gbcEditItemProductQuantityTitle.anchor = GridBagConstraints.NORTHEAST;

        GridBagConstraints gbcEditItemProductQuantitySP = new GridBagConstraints();
        gbcEditItemProductQuantitySP.gridx = 1;
        gbcEditItemProductQuantitySP.gridy = 7;
        gbcEditItemProductQuantitySP.gridheight = 1;
        gbcEditItemProductQuantitySP.gridwidth = 1;
        gbcEditItemProductQuantitySP.weightx = 0.3;
        gbcEditItemProductQuantitySP.weighty = 1.0;
        gbcEditItemProductQuantitySP.insets = new Insets(0,0,0,175);
        gbcEditItemProductQuantitySP.anchor = GridBagConstraints.NORTHEAST;

        GridBagConstraints gbcsendEditedItemButton = new GridBagConstraints();
        gbcsendEditedItemButton.gridx = 0;
        gbcsendEditedItemButton.gridy = 8;
        gbcsendEditedItemButton.gridheight = 1;
        gbcsendEditedItemButton.gridwidth = 1;
        gbcsendEditedItemButton.insets = new Insets(60, 0, 30, 0);
        gbcsendEditedItemButton.anchor = GridBagConstraints.CENTER;
        
        GridBagConstraints gbcCleanFieldsButton = new GridBagConstraints();
        gbcCleanFieldsButton.gridx = 1;
        gbcCleanFieldsButton.gridy = 8;
        gbcCleanFieldsButton.gridheight = 1;
        gbcCleanFieldsButton.gridwidth = 1;
        gbcCleanFieldsButton.insets = new Insets(60, 0, 30, 0);
        gbcCleanFieldsButton.anchor = GridBagConstraints.CENTER;
        
        //Hovers
        MouseListener hoverSendNewItem = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                sendEditedItemButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                sendEditedItemButton.setBackground(backgroundColor);
            }
        };
        MouseListener hoverCleanFields = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                cleanFieldsButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                cleanFieldsButton.setBackground(backgroundColor);
            }
        };
        
        //Botones y texto
        JLabel addItemTitleLabel = new JLabel("Editar producto");
        addItemTitleLabel.setForeground(Color.WHITE);
        addItemTitleLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        
        JLabel addItemSubtitleLabel = new JLabel("* Todos los campos son obligatorios");
        addItemSubtitleLabel.setForeground(Color.WHITE);
        addItemSubtitleLabel.setFont(new Font("Helvetica", Font.BOLD, 8));
        
        
        JLabel editItemProductNameTitle = new JLabel("Nombre del producto");
        editItemProductNameTitle.setForeground(Color.WHITE);
        editItemProductNameTitle.setFont(new Font("Helvetica", Font.BOLD, 10));
        
        editItemProductNameTextField = new JTextField();
        editItemProductNameTextField.setPreferredSize(new Dimension(585, editItemProductNameTextField.getPreferredSize().height+10));
        editItemProductNameTextField.setDocument(new JTextFieldLimit(250));
        editItemProductNameTextField.setBackground(backgroundColor.brighter());
        editItemProductNameTextField.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
        editItemProductNameTextField.setCaretColor(Color.WHITE.darker());
        editItemProductNameTextField.setForeground(Color.WHITE.darker());
        editItemProductNameTextField.setText(name);
        
        JLabel editItemProductBrandTitle = new JLabel("Marca");
        editItemProductBrandTitle.setForeground(Color.WHITE);
        editItemProductBrandTitle.setFont(new Font("Helvetica", Font.BOLD, 10));
        
        editItemProductBrandTextField = new JTextField();
        editItemProductBrandTextField.setPreferredSize(new Dimension(250, editItemProductBrandTextField.getPreferredSize().height+10));
        editItemProductBrandTextField.setDocument(new JTextFieldLimit(100));
        editItemProductBrandTextField.setBackground(backgroundColor.brighter());
        editItemProductBrandTextField.setForeground(Color.WHITE.darker());
        editItemProductBrandTextField.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
        editItemProductBrandTextField.setCaretColor(Color.WHITE.darker());
        editItemProductBrandTextField.setText(brand);
        
        
        JLabel editItemProductCategoryTitle = new JLabel("Categoría");
        editItemProductCategoryTitle.setForeground(Color.WHITE);
        editItemProductCategoryTitle.setFont(new Font("Helvetica", Font.BOLD, 10));
        
        
        editItemProductCategoryCB = new JComboBox<>();
        editItemProductCategoryCB.setPreferredSize(new Dimension(250, editItemProductBrandTextField.getPreferredSize().height));
        editItemProductCategoryCB.setMaximumRowCount(5);
        editItemProductCategoryCB.setForeground(Color.WHITE.darker());
        editItemProductCategoryCB.setBackground(backgroundColor.brighter());
        editItemProductCategoryCB.setBorder(null);
        editItemProductCategoryCB.setFocusable(false);
        editItemProductCategoryCB.addItem("Seleccione una opción...");
        
        JLabel editItemProductPriceTitle = new JLabel("Precio");
        editItemProductPriceTitle.setForeground(Color.WHITE);
        editItemProductPriceTitle.setFont(new Font("Helvetica", Font.BOLD, 10));
        
        editItemProductPriceTextField = new JTextField();
        editItemProductPriceTextField.setPreferredSize(new Dimension(250, editItemProductPriceTextField.getPreferredSize().height+10));
        editItemProductPriceTextField.setDocument(new JTextFieldLimit(8,true));
        editItemProductPriceTextField.setBackground(backgroundColor.brighter());
        editItemProductPriceTextField.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
        editItemProductPriceTextField.setCaretColor(Color.WHITE.darker());
        editItemProductPriceTextField.setForeground(Color.WHITE.darker());
        editItemProductPriceTextField.setText(Integer.toString(price));
        
        
        JLabel editItemProductQuantityTitle = new JLabel("Cantidad");
        editItemProductQuantityTitle.setForeground(Color.WHITE);
        editItemProductQuantityTitle.setFont(new Font("Helvetica", Font.BOLD, 10));
        
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1,1,1000,1);
        
        editItemProductQuantitySP = new JSpinner();
        editItemProductQuantitySP.setPreferredSize(new Dimension(100, editItemProductPriceTextField.getPreferredSize().height));
        editItemProductQuantitySP.setBorder(null);
        editItemProductQuantitySP.setModel(spinnerModel);
        editItemProductQuantitySP.setValue(quantity);

        JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor)editItemProductQuantitySP.getEditor(); 
        jsEditor.getTextField().setBackground(backgroundColor.brighter());
        jsEditor.getTextField().setForeground(Color.WHITE.darker());
        
        sendEditedItemButton = new JButton("Enviar");
        sendEditedItemButton.setPreferredSize(new Dimension(150,40));
        sendEditedItemButton.setBackground(backgroundColor);
        sendEditedItemButton.setForeground(Color.WHITE);
        sendEditedItemButton.addMouseListener(hoverSendNewItem);
        sendEditedItemButton.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 2));
        sendEditedItemButton.setBorderPainted(true);
        sendEditedItemButton.setFocusPainted(false);  
        
        cleanFieldsButton = new JButton("Limpiar");
        cleanFieldsButton.setPreferredSize(new Dimension(150,40));
        cleanFieldsButton.setBackground(backgroundColor);
        cleanFieldsButton.setForeground(Color.WHITE);
        cleanFieldsButton.addMouseListener(hoverCleanFields);
        cleanFieldsButton.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 2));
        cleanFieldsButton.setBorderPainted(true);
        cleanFieldsButton.setFocusPainted(false);
        

        JPanel itemEntryPanel = new JPanel();
        itemEntryPanel.setLayout(new GridBagLayout());
        itemEntryPanel.setBackground(backgroundColor);
        itemEntryPanel.add(addItemTitleLabel, gbcAddItemTitleLabel);
        itemEntryPanel.add(addItemSubtitleLabel, gbcAddItemSubtitleLabel);
        itemEntryPanel.add(editItemProductNameTitle, gbcEditItemProductNameTitle);
        itemEntryPanel.add(editItemProductNameTextField, gbcEditItemProductNameTextField);
        itemEntryPanel.add(editItemProductBrandTitle, gbcEditItemProductBrandTitle);
        itemEntryPanel.add(editItemProductBrandTextField, gbcEditItemProductBrandTextField);
        itemEntryPanel.add(editItemProductCategoryTitle, gbcEditItemProductCategoryTitle);
        itemEntryPanel.add(editItemProductCategoryCB, gbcEditItemProductCategoryCB);
        itemEntryPanel.add(editItemProductPriceTitle, gbcEditItemProductPriceTitle);
        itemEntryPanel.add(editItemProductPriceTextField, gbcEditItemProductPriceTextField);
        itemEntryPanel.add(editItemProductQuantityTitle, gbcEditItemProductQuantityTitle);
        itemEntryPanel.add(editItemProductQuantitySP, gbcEditItemProductQuantitySP);
        itemEntryPanel.add(sendEditedItemButton,gbcsendEditedItemButton);
        itemEntryPanel.add(cleanFieldsButton, gbcCleanFieldsButton);
        itemEntryPanel.setVisible(true);


        //Actualizar el comboBox
        for (String element : model.getCategoriesNameColumn()){
            editItemProductCategoryCB.addItem(element);
        }

        //Handler de error//
        Border errorBorder = BorderFactory.createLineBorder(Color.RED);
        //Fields y Botón de envio de New > Products
        sendEditedItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<String> errorsFound = new ArrayList<String>();
                //---Asegurarse que los datos son correctos, si no, hacer algo---
                Boolean isGood = true;
                Boolean isQuantityNumber = true;
                Boolean isConfirmed = true;
                Boolean isDuplicated = false;
                String productName = editItemProductNameTextField.getText();
                String brandName = editItemProductBrandTextField.getText();
                String priceName = editItemProductPriceTextField.getText();
                String categoryName = editItemProductCategoryCB.getSelectedItem().toString();
                String quantityName = editItemProductQuantitySP.getValue().toString();
                int intQuantity = 0;

                try{
                    Integer.parseInt(quantityName);
                }
                catch(Exception ex){
                    isQuantityNumber = false;
                }
                
                if (productName.isBlank() || productName.isEmpty()){
                    editItemProductNameTextField.setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso de nombre no puede estar vacío.");
                    isGood = false;
                }

                if (brandName.isBlank() || brandName.isEmpty()){
                    editItemProductBrandTextField.setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso de la marca no puede estar vacío.");
                    isGood = false;
                }

                
                if (priceName.isBlank() || priceName.isEmpty()){
                    editItemProductPriceTextField.setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso del precio no puede estar vacío.");
                    isGood = false;
                }

                if (categoryName.equals("Seleccione una opción...")){
                    editItemProductCategoryCB.setForeground(Color.RED);
                    errorsFound.add("* Debe seleccionar una opción en \"Categoría\".");
                    isGood = false;
                }

                if (!isQuantityNumber){
                    editItemProductQuantitySP.setBorder(errorBorder);
                    errorsFound.add("* El campo de ingreso de cantidad no es un número.");
                    isGood = false;
                }else{
                    intQuantity = Integer.parseInt(quantityName);
                }

                if (intQuantity >= 100 && isGood){
                    if(dialogs.tooMuchValueWarn(12)){

                    }
                    else {
                        isConfirmed = false;
                    }
                }

                String[] productArr = model.getProductsNameColumn();
                for(String element : productArr){
                    if(productName.equals(element)){
                        if(model.fetchProductIdByName(element) == id){
                            continue;
                        } else {
                            isDuplicated = true;
                            isGood = false;
                            break;
                        }
                    }
                }

                if(isGood && isConfirmed){
                    int intPrice = Integer.parseInt(priceName);
                    editItemProductNameTextField.setText("");
                    editItemProductBrandTextField.setText("");
                    editItemProductCategoryCB.setSelectedItem("Seleccione una opción...");
                    editItemProductPriceTextField.setText("");
                    editItemProductQuantitySP.setValue(1);
                    model.editItems(id, productName, brandName, categoryName, intPrice, intQuantity);
                } else if (isConfirmed && !isGood) {
                    if (isDuplicated){
                        editItemProductNameTextField.setBorder(errorBorder);
                        dialogs.duplicatedValueError(productName);
                    } else {
                        dialogs.fieldsErrors(errorsFound);
                    }
                }                
            }
        });


        //Clean button
        cleanFieldsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                editItemProductNameTextField.setText("");
                editItemProductBrandTextField.setText("");
                editItemProductCategoryCB.setSelectedItem("Seleccione una opción...");
                editItemProductPriceTextField.setText("");
                editItemProductQuantitySP.setValue(1);
            }
        });

        setSize(649,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        setTitle("Editar " + name);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(itemEntryPanel);
        setVisible(true);
    }
}
