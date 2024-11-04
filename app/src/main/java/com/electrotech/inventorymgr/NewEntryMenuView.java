package com.electrotech.inventorymgr;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.File;

public class NewEntryMenuView extends JFrame{

    private JButton switchHomeButton;
    private JButton switchItemButton;
    private JButton switchCategoryButton;
    private JButton exitButton;
    private JButton onMainItemButton;
    private JButton onMainCategoryButton;
    private JButton sendNewItemButton;
    private JButton cleanFieldsButton;
    private JButton sendNewCategoryButton;
    private JPanel mainPanel;
    private JPanel mainEntryPanel;
    private JPanel itemEntryPanel;
    private JPanel categoryEntryPanel;
    private JTextField addItemProductNameTextField;
    private JTextField addItemProductBrandTextField;
    private JTextField addItemProductPriceTextField;
    private JTextField addCategoryNameTextField;
    private JComboBox<String> addItemProductCategoryCB;
    private JSpinner addItemProductQuantitySP;

    public NewEntryMenuView(){
        //Variables Generales
        Color backgroundColor = Color.decode("#1f1f1f");

        Border buttonBorderRaw = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(33,33,33));
        Border emptyButtonBorder = new EmptyBorder(0, 0, 0, 0);
        Border buttonBorder = new CompoundBorder(emptyButtonBorder, buttonBorderRaw);

        Border sideBorderRaw = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.WHITE);
        Border sideButtonBorder = new EmptyBorder(0, 0, 0, 0);
        Border sideBorder = new CompoundBorder(sideButtonBorder, sideBorderRaw);
    


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
        
        String iconPath = resourcesPath + "new-file.png";//Paths
        String newProductPath = resourcesPath + "new-product.png";
        String newCategoryPath = resourcesPath + "new-category.png";
        String homePath = resourcesPath + "home.png";
        String exitIconPath = resourcesPath + "exit.png";

        ImageIcon icon = new ImageIcon(iconPath); //Icono del JFrame secundario

        ImageIcon newProductIcon = new ImageIcon(newProductPath); //Icono de newproduct
        Image newProductImageRaw = newProductIcon.getImage();
        Image newProductImage = newProductImageRaw.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon finalNewProductIcon = new ImageIcon(newProductImage);

        ImageIcon newCategoryIcon = new ImageIcon(newCategoryPath); //Icono de newcategory
        Image newCategoryImageRaw = newCategoryIcon.getImage();
        Image newCategoryImage = newCategoryImageRaw.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon finalNewCategoryIcon = new ImageIcon(newCategoryImage);

        ImageIcon homeIcon = new ImageIcon(homePath); //Icono de home
        Image homeImageRaw = homeIcon.getImage();
        Image homeImage = homeImageRaw.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon finalHomeIcon = new ImageIcon(homeImage);

        ImageIcon exitIcon = new ImageIcon(exitIconPath);
        Image exitImageRaw = exitIcon.getImage();
        Image exitImage = exitImageRaw.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon finalExitFileIcon = new ImageIcon(exitImage);


        //GridBagConstraints
        GridBagConstraints gbcSubmenu = new GridBagConstraints();
        gbcSubmenu.gridx = 0;
        gbcSubmenu.gridy = 0;
        gbcSubmenu.gridheight = 2;
        gbcSubmenu.gridwidth = 1;
        gbcSubmenu.weightx = 0.0;
        gbcSubmenu.weighty = 1.0;
        gbcSubmenu.fill = GridBagConstraints.BOTH;

        GridBagConstraints gbcEntry = new GridBagConstraints();
        gbcEntry.gridx = 1;
        gbcEntry.gridy = 0;
        gbcEntry.gridheight = 2;
        gbcEntry.gridwidth = GridBagConstraints.REMAINDER;
        gbcEntry.weightx = 1.0;
        gbcEntry.weighty = 1.0;
        gbcEntry.fill = GridBagConstraints.BOTH;

        GridBagConstraints gbcDescriptionText = new GridBagConstraints();
        gbcDescriptionText.gridx = 0;
        gbcDescriptionText.gridy = 0;
        gbcDescriptionText.gridheight = 1;
        gbcDescriptionText.gridwidth = GridBagConstraints.REMAINDER;
        gbcDescriptionText.weightx = 0.3;
        gbcDescriptionText.weighty = 1.0;
        gbcDescriptionText.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcOnMainItemButton = new GridBagConstraints();
        gbcOnMainItemButton.gridx = 0;
        gbcOnMainItemButton.gridy = 1;
        gbcOnMainItemButton.gridheight = 1;
        gbcOnMainItemButton.gridwidth = 1;
        gbcOnMainItemButton.weightx = 0.9;
        gbcOnMainItemButton.weighty = 1.0;
        gbcOnMainItemButton.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcOnMainCategoryButton = new GridBagConstraints();
        gbcOnMainCategoryButton.gridx = 1;
        gbcOnMainCategoryButton.gridy = 1;
        gbcOnMainCategoryButton.gridheight = 1;
        gbcOnMainCategoryButton.gridwidth = 1;
        gbcOnMainCategoryButton.weightx = 0.9;
        gbcOnMainCategoryButton.weighty = 1.0;
        gbcOnMainCategoryButton.anchor = GridBagConstraints.NORTH;

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

        GridBagConstraints gbcAddItemProductNameTitle = new GridBagConstraints();
        gbcAddItemProductNameTitle.gridx = 0;
        gbcAddItemProductNameTitle.gridy = 2;
        gbcAddItemProductNameTitle.gridheight = 1;
        gbcAddItemProductNameTitle.gridwidth = 1;
        gbcAddItemProductNameTitle.weightx = 0.3;
        gbcAddItemProductNameTitle.weighty = 1.0;
        gbcAddItemProductNameTitle.insets = new Insets(0, 25, 0, 0);
        gbcAddItemProductNameTitle.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcAddItemProductNameTextField = new GridBagConstraints();
        gbcAddItemProductNameTextField.gridx = 0;
        gbcAddItemProductNameTextField.gridy = 3;
        gbcAddItemProductNameTextField.gridheight = 1;
        gbcAddItemProductNameTextField.gridwidth = GridBagConstraints.REMAINDER;
        gbcAddItemProductNameTextField.weightx = 0.3;
        gbcAddItemProductNameTextField.weighty = 1.0;
        gbcAddItemProductNameTextField.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcAddItemProductBrandTitle = new GridBagConstraints();
        gbcAddItemProductBrandTitle.gridx = 0;
        gbcAddItemProductBrandTitle.gridy = 4;
        gbcAddItemProductBrandTitle.gridheight = 1;
        gbcAddItemProductBrandTitle.gridwidth = 1;
        gbcAddItemProductBrandTitle.weightx = 0.3;
        gbcAddItemProductBrandTitle.weighty = 1.0;
        gbcAddItemProductBrandTitle.insets = new Insets(0, 25, 0, 0);
        gbcAddItemProductBrandTitle.anchor = GridBagConstraints.NORTHWEST;
        
        GridBagConstraints gbcAddItemProductBrandTextField = new GridBagConstraints();
        gbcAddItemProductBrandTextField.gridx = 0;
        gbcAddItemProductBrandTextField.gridy = 5;
        gbcAddItemProductBrandTextField.gridheight = 1;
        gbcAddItemProductBrandTextField.gridwidth = 1;
        gbcAddItemProductBrandTextField.weightx = 0.3;
        gbcAddItemProductBrandTextField.weighty = 1.0;
        gbcAddItemProductBrandTextField.insets = new Insets(0, 25, 0, 0);
        gbcAddItemProductBrandTextField.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcAddItemProductCategoryTitle = new GridBagConstraints();
        gbcAddItemProductCategoryTitle.gridx = 1;
        gbcAddItemProductCategoryTitle.gridy = 4;
        gbcAddItemProductCategoryTitle.gridheight = 1;
        gbcAddItemProductCategoryTitle.gridwidth = 1;
        gbcAddItemProductCategoryTitle.weightx = 0.3;
        gbcAddItemProductCategoryTitle.weighty = 1.0;
        gbcAddItemProductCategoryTitle.insets = new Insets(0, 0, 0, 227);;
        gbcAddItemProductCategoryTitle.anchor = GridBagConstraints.NORTHEAST;

        GridBagConstraints gbcAddItemProductCategoryCB = new GridBagConstraints();
        gbcAddItemProductCategoryCB.gridx = 1;
        gbcAddItemProductCategoryCB.gridy = 5;
        gbcAddItemProductCategoryCB.gridheight = 1;
        gbcAddItemProductCategoryCB.gridwidth = 1;
        gbcAddItemProductCategoryCB.weightx = 0.3;
        gbcAddItemProductCategoryCB.weighty = 1.0;
        gbcAddItemProductCategoryCB.insets = new Insets(0,0,0,25);
        gbcAddItemProductCategoryCB.anchor = GridBagConstraints.NORTHEAST;

        GridBagConstraints gbcAddItemProductPriceTitle = new GridBagConstraints();
        gbcAddItemProductPriceTitle.gridx = 0;
        gbcAddItemProductPriceTitle.gridy = 6;
        gbcAddItemProductPriceTitle.gridheight = 1;
        gbcAddItemProductPriceTitle.gridwidth = 1;
        gbcAddItemProductPriceTitle.weightx = 0.3;
        gbcAddItemProductPriceTitle.weighty = 1.0;
        gbcAddItemProductPriceTitle.insets = new Insets(0, 25, 0, 0);
        gbcAddItemProductPriceTitle.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcAddItemProductPriceTextField = new GridBagConstraints();
        gbcAddItemProductPriceTextField.gridx = 0;
        gbcAddItemProductPriceTextField.gridy = 7;
        gbcAddItemProductPriceTextField.gridheight = 1;
        gbcAddItemProductPriceTextField.gridwidth = 1;
        gbcAddItemProductPriceTextField.weightx = 0.3;
        gbcAddItemProductPriceTextField.weighty = 1.0;
        gbcAddItemProductPriceTextField.insets = new Insets(0, 25, 0, 0);
        gbcAddItemProductPriceTextField.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcAddItemProductQuantityTitle = new GridBagConstraints();
        gbcAddItemProductQuantityTitle.gridx = 1;
        gbcAddItemProductQuantityTitle.gridy = 6;
        gbcAddItemProductQuantityTitle.gridheight = 1;
        gbcAddItemProductQuantityTitle.gridwidth = 1;
        gbcAddItemProductQuantityTitle.weightx = 0.3;
        gbcAddItemProductQuantityTitle.weighty = 1.0;
        gbcAddItemProductQuantityTitle.insets = new Insets(0, 0, 0, 231);;
        gbcAddItemProductQuantityTitle.anchor = GridBagConstraints.NORTHEAST;

        GridBagConstraints gbcAddItemProductQuantitySP = new GridBagConstraints();
        gbcAddItemProductQuantitySP.gridx = 1;
        gbcAddItemProductQuantitySP.gridy = 7;
        gbcAddItemProductQuantitySP.gridheight = 1;
        gbcAddItemProductQuantitySP.gridwidth = 1;
        gbcAddItemProductQuantitySP.weightx = 0.3;
        gbcAddItemProductQuantitySP.weighty = 1.0;
        gbcAddItemProductQuantitySP.insets = new Insets(0,0,0,175);
        gbcAddItemProductQuantitySP.anchor = GridBagConstraints.NORTHEAST;

        GridBagConstraints gbcSendNewItemButton = new GridBagConstraints();
        gbcSendNewItemButton.gridx = 0;
        gbcSendNewItemButton.gridy = 8;
        gbcSendNewItemButton.gridheight = 1;
        gbcSendNewItemButton.gridwidth = 1;
        gbcSendNewItemButton.insets = new Insets(60, 0, 30, 0);
        gbcSendNewItemButton.anchor = GridBagConstraints.CENTER;
        
        GridBagConstraints gbcCleanFieldsButton = new GridBagConstraints();
        gbcCleanFieldsButton.gridx = 1;
        gbcCleanFieldsButton.gridy = 8;
        gbcCleanFieldsButton.gridheight = 1;
        gbcCleanFieldsButton.gridwidth = 1;
        gbcCleanFieldsButton.insets = new Insets(60, 0, 30, 0);
        gbcCleanFieldsButton.anchor = GridBagConstraints.CENTER;

        GridBagConstraints gbcAddCategoryTitleLabel = new GridBagConstraints();
        gbcAddCategoryTitleLabel.gridx = 0;
        gbcAddCategoryTitleLabel.gridy = 0;
        gbcAddCategoryTitleLabel.gridheight = 1;
        gbcAddCategoryTitleLabel.gridwidth = GridBagConstraints.REMAINDER;
        gbcAddCategoryTitleLabel.weightx = 0.3;
        gbcAddCategoryTitleLabel.weighty = 1.0;
        gbcAddCategoryTitleLabel.insets = new Insets(0, 30, 0, 0);
        gbcAddCategoryTitleLabel.anchor = GridBagConstraints.NORTHWEST;
        
        GridBagConstraints gbcAddCategoryNameTitle = new GridBagConstraints();
        gbcAddCategoryNameTitle.gridx = 0;
        gbcAddCategoryNameTitle.gridy = 1;
        gbcAddCategoryNameTitle.gridheight = 1;
        gbcAddCategoryNameTitle.gridwidth = 1;
        gbcAddCategoryNameTitle.weightx = 0.3;
        gbcAddCategoryNameTitle.weighty = 1.0;
        gbcAddCategoryNameTitle.insets = new Insets(5, 0, 0, 0);
        gbcAddCategoryNameTitle.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcAddCategoryNameTextField = new GridBagConstraints();
        gbcAddCategoryNameTextField.gridx = 1;
        gbcAddCategoryNameTextField.gridy = 1;
        gbcAddCategoryNameTextField.gridheight = 1;
        gbcAddCategoryNameTextField.gridwidth = 1;
        gbcAddCategoryNameTextField.weightx = 0.3;
        gbcAddCategoryNameTextField.weighty = 1.0;
        gbcAddCategoryNameTextField.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcSendNewCategoryButton = new GridBagConstraints();
        gbcSendNewCategoryButton.gridx = 2;
        gbcSendNewCategoryButton.gridy = 1;
        gbcSendNewCategoryButton.gridheight = 1;
        gbcSendNewCategoryButton.gridwidth = 1;
        gbcSendNewCategoryButton.weightx = 0.3;
        gbcSendNewCategoryButton.weighty = 1.0;
        gbcSendNewCategoryButton.anchor = GridBagConstraints.NORTH;

        //UIManagers
        UIManager.put("Button.select", backgroundColor.darker());
        UIManager.put("Button.focusPainted", false);
        UIManager.put("Button.background", backgroundColor.brighter());
        UIManager.put("Button.borderPainted", false);
        UIManager.put("Button.foreground", Color.WHITE);

        //MouseListeners
        MouseListener hoverHomeML = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                switchHomeButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                switchHomeButton.setBackground(backgroundColor);
            }
        };
        MouseListener hoverItemML = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                switchItemButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                switchItemButton.setBackground(backgroundColor);
            }
        };
        MouseListener hoverCategoryML = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                switchCategoryButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                switchCategoryButton.setBackground(backgroundColor);
            }
        };
        MouseListener hoverExitML = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                exitButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                exitButton.setBackground(backgroundColor);
            }
        };
        MouseListener hoverOnMenuItem = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                onMainItemButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                onMainItemButton.setBackground(backgroundColor);
            }
        };
        MouseListener hoverOnMenuCategory = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                onMainCategoryButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                onMainCategoryButton.setBackground(backgroundColor);
            }
        };
        MouseListener hoverSendNewItem = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                sendNewItemButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                sendNewItemButton.setBackground(backgroundColor);
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
        MouseListener hoverSendNewCategory = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                sendNewCategoryButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                sendNewCategoryButton.setBackground(backgroundColor);
            }
        };


        //Botones y texto del lateral
        switchHomeButton = new JButton("Inicio");
        switchHomeButton.setIcon(finalHomeIcon);
        switchHomeButton.setPreferredSize(new Dimension(150,30));
        switchHomeButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, switchHomeButton.getPreferredSize().height));
        switchHomeButton.setBackground(backgroundColor);
        switchHomeButton.setForeground(Color.WHITE);
        switchHomeButton.setBorder(buttonBorder);
        switchHomeButton.setBorderPainted(true);
        switchHomeButton.setFocusPainted(false);
        switchHomeButton.addMouseListener(hoverHomeML);
        switchHomeButton.setVerticalTextPosition(SwingConstants.CENTER);
        switchHomeButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        switchHomeButton.setIconTextGap(80);

        switchItemButton = new JButton("Producto");
        switchItemButton.setIcon(finalNewProductIcon);
        switchItemButton.setPreferredSize(new Dimension(150,30));
        switchItemButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, switchItemButton.getPreferredSize().height));
        switchItemButton.setBackground(backgroundColor);
        switchItemButton.setForeground(Color.WHITE);
        switchItemButton.setBorder(buttonBorder);
        switchItemButton.setBorderPainted(true);
        switchItemButton.setFocusPainted(false);
        switchItemButton.addMouseListener(hoverItemML);
        switchItemButton.setVerticalTextPosition(SwingConstants.CENTER);
        switchItemButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        switchItemButton.setIconTextGap(60);

        switchCategoryButton = new JButton("Categoría");
        switchCategoryButton.setIcon(finalNewCategoryIcon);
        switchCategoryButton.setPreferredSize(new Dimension(150,30));
        switchCategoryButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, switchCategoryButton.getPreferredSize().height));
        switchCategoryButton.setBackground(backgroundColor);
        switchCategoryButton.setForeground(Color.WHITE);
        switchCategoryButton.setBorder(null);
        switchCategoryButton.setBorderPainted(false);
        switchCategoryButton.setFocusPainted(false);
        switchCategoryButton.addMouseListener(hoverCategoryML);
        switchCategoryButton.setVerticalTextPosition(SwingConstants.CENTER);
        switchCategoryButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        switchCategoryButton.setIconTextGap(60);

        exitButton = new JButton("Salir");
        exitButton.setIcon(finalExitFileIcon);
        exitButton.setPreferredSize(new Dimension(150,30));
        exitButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, exitButton.getPreferredSize().height));
        exitButton.setBackground(backgroundColor);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBorder(null);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(hoverExitML);
        exitButton.setVerticalTextPosition(SwingConstants.CENTER);
        exitButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        exitButton.setIconTextGap(90);


        //Botones y texto del Main
        JLabel descriptionLabel = new JLabel("¿Qué desea registrar?");
        descriptionLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        descriptionLabel.setForeground(Color.WHITE);

        onMainItemButton = new JButton("<html>  Nuevo<br>Producto</html>");
        onMainItemButton.setBackground(backgroundColor);
        onMainItemButton.setForeground(Color.WHITE);
        onMainItemButton.addMouseListener(hoverOnMenuItem);
        onMainItemButton.setBorder(sideBorder);
        onMainItemButton.setBorderPainted(true);
        onMainItemButton.setFocusPainted(false);
        onMainItemButton.setPreferredSize(new Dimension(150,60));
        onMainItemButton.setIcon(finalNewProductIcon);
        onMainItemButton.setIconTextGap(20);

        onMainCategoryButton = new JButton("<html>  Nueva<br>Categoría</html>");
        onMainCategoryButton.setBackground(backgroundColor);
        onMainCategoryButton.setForeground(Color.WHITE);
        onMainCategoryButton.addMouseListener(hoverOnMenuCategory);
        onMainCategoryButton.setBorder(sideBorder);
        onMainCategoryButton.setBorderPainted(true);
        onMainCategoryButton.setFocusPainted(false);
        onMainCategoryButton.setPreferredSize(new Dimension(150,60));
        onMainCategoryButton.setIcon(finalNewCategoryIcon);
        onMainCategoryButton.setIconTextGap(20);

        
        //Botones y texto del Añadir producto
        JLabel addItemTitleLabel = new JLabel("Agregar nuevo producto");
        addItemTitleLabel.setForeground(Color.WHITE);
        addItemTitleLabel.setFont(new Font("Helvetica", Font.BOLD, 30));

        JLabel addItemSubtitleLabel = new JLabel("* Todos los campos son obligatorios");
        addItemSubtitleLabel.setForeground(Color.WHITE);
        addItemSubtitleLabel.setFont(new Font("Helvetica", Font.BOLD, 8));


        JLabel addItemProductNameTitle = new JLabel("Nombre del producto");
        addItemProductNameTitle.setForeground(Color.WHITE);
        addItemProductNameTitle.setFont(new Font("Helvetica", Font.BOLD, 10));

        addItemProductNameTextField = new JTextField();
        addItemProductNameTextField.setPreferredSize(new Dimension(585, addItemProductNameTextField.getPreferredSize().height+10));
        addItemProductNameTextField.setDocument(new JTextFieldLimit(250));
        addItemProductNameTextField.setBackground(backgroundColor.brighter());
        addItemProductNameTextField.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
        addItemProductNameTextField.setCaretColor(Color.WHITE.darker());
        addItemProductNameTextField.setForeground(Color.WHITE.darker());

        JLabel addItemProductBrandTitle = new JLabel("Marca");
        addItemProductBrandTitle.setForeground(Color.WHITE);
        addItemProductBrandTitle.setFont(new Font("Helvetica", Font.BOLD, 10));

        addItemProductBrandTextField  = new JTextField();
        addItemProductBrandTextField.setPreferredSize(new Dimension(250, addItemProductBrandTextField.getPreferredSize().height+10));
        addItemProductBrandTextField.setDocument(new JTextFieldLimit(100));
        addItemProductBrandTextField.setBackground(backgroundColor.brighter());
        addItemProductBrandTextField.setForeground(Color.WHITE.darker());
        addItemProductBrandTextField.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
        addItemProductBrandTextField.setCaretColor(Color.WHITE.darker());


        JLabel addItemProductCategoryTitle = new JLabel("Categoría");
        addItemProductCategoryTitle.setForeground(Color.WHITE);
        addItemProductCategoryTitle.setFont(new Font("Helvetica", Font.BOLD, 10));

        
        addItemProductCategoryCB = new JComboBox<>();
        addItemProductCategoryCB.setPreferredSize(new Dimension(250, addItemProductBrandTextField.getPreferredSize().height));
        addItemProductCategoryCB.setMaximumRowCount(5);
        addItemProductCategoryCB.setForeground(Color.WHITE.darker());
        addItemProductCategoryCB.setBackground(backgroundColor.brighter());
        addItemProductCategoryCB.setBorder(null);
        addItemProductCategoryCB.setFocusable(false);

        JLabel addItemProductPriceTitle = new JLabel("Precio");
        addItemProductPriceTitle.setForeground(Color.WHITE);
        addItemProductPriceTitle.setFont(new Font("Helvetica", Font.BOLD, 10));

        addItemProductPriceTextField = new JTextField();
        addItemProductPriceTextField.setPreferredSize(new Dimension(250, addItemProductPriceTextField.getPreferredSize().height+10));
        addItemProductPriceTextField.setDocument(new JTextFieldLimit(8,true));
        addItemProductPriceTextField.setBackground(backgroundColor.brighter());
        addItemProductPriceTextField.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
        addItemProductPriceTextField.setCaretColor(Color.WHITE.darker());
        addItemProductPriceTextField.setForeground(Color.WHITE.darker());

        
        JLabel addItemProductQuantityTitle = new JLabel("Cantidad");
        addItemProductQuantityTitle.setForeground(Color.WHITE);
        addItemProductQuantityTitle.setFont(new Font("Helvetica", Font.BOLD, 10));

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1,1,1000,1);

        addItemProductQuantitySP = new JSpinner();
        addItemProductQuantitySP.setPreferredSize(new Dimension(100, addItemProductPriceTextField.getPreferredSize().height));
        addItemProductQuantitySP.setBorder(null);
        addItemProductQuantitySP.setModel(spinnerModel);

        JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor)addItemProductQuantitySP.getEditor(); 
        jsEditor.getTextField().setBackground(backgroundColor.brighter());
        jsEditor.getTextField().setForeground(Color.WHITE.darker());

        sendNewItemButton = new JButton("Enviar");
        sendNewItemButton.setPreferredSize(new Dimension(150,40));
        sendNewItemButton.setBackground(backgroundColor);
        sendNewItemButton.setForeground(Color.WHITE);
        sendNewItemButton.addMouseListener(hoverSendNewItem);
        sendNewItemButton.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 2));
        sendNewItemButton.setBorderPainted(true);
        sendNewItemButton.setFocusPainted(false);  
        
        cleanFieldsButton = new JButton("Limpiar");
        cleanFieldsButton.setPreferredSize(new Dimension(150,40));
        cleanFieldsButton.setBackground(backgroundColor);
        cleanFieldsButton.setForeground(Color.WHITE);
        cleanFieldsButton.addMouseListener(hoverCleanFields);
        cleanFieldsButton.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 2));
        cleanFieldsButton.setBorderPainted(true);
        cleanFieldsButton.setFocusPainted(false);


        //Botones y texto del Añadir Categoría
        JLabel addCategoryTitleLabel = new JLabel("Agregar nueva categoría");
        addCategoryTitleLabel.setForeground(Color.WHITE);
        addCategoryTitleLabel.setFont(new Font("Helvetica", Font.BOLD, 30));

        JLabel addCategoryNameTitle = new JLabel("Nombre de la Categoría");
        addCategoryNameTitle.setForeground(Color.WHITE);
        addCategoryNameTitle.setFont(new Font("Helvetica", Font.BOLD, 10));

        addCategoryNameTextField = new JTextField();
        addCategoryNameTextField.setPreferredSize(new Dimension(250, addCategoryNameTextField.getPreferredSize().height+10));
        addCategoryNameTextField.setDocument(new JTextFieldLimit(100));
        addCategoryNameTextField.setBackground(backgroundColor.brighter());
        addCategoryNameTextField.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
        addCategoryNameTextField.setCaretColor(Color.WHITE.darker());
        addCategoryNameTextField.setForeground(Color.WHITE.darker());

        sendNewCategoryButton = new JButton("Enviar");
        sendNewCategoryButton.setPreferredSize(new Dimension(150,30));
        sendNewCategoryButton.setBackground(backgroundColor);
        sendNewCategoryButton.setForeground(Color.WHITE);
        sendNewCategoryButton.addMouseListener(hoverSendNewCategory);
        sendNewCategoryButton.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 2));
        sendNewCategoryButton.setBorderPainted(true);
        sendNewCategoryButton.setFocusPainted(false);

        //JPanel del SubMenu Lateral
        Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, backgroundColor.brighter());
        Border emptyBorder = new EmptyBorder(0, 0, 0, 0);
        Border compoundBorder = new CompoundBorder(emptyBorder, border);
        
        JPanel submenuPanel = new JPanel();
        submenuPanel.setBorder(compoundBorder);
        submenuPanel.setOpaque(true);
        submenuPanel.setBackground(new Color(28, 28, 28));
        submenuPanel.setLayout(new BoxLayout(submenuPanel, BoxLayout.Y_AXIS));
        submenuPanel.add(switchHomeButton);
        submenuPanel.add(switchItemButton);
        submenuPanel.add(switchCategoryButton);
        submenuPanel.add(Box.createVerticalGlue());
        submenuPanel.add(exitButton);
        
        
        //JPanel del inicio del registro
        mainEntryPanel = new JPanel();
        mainEntryPanel.setVisible(false);
        mainEntryPanel.setLayout(new GridBagLayout());
        mainEntryPanel.add(descriptionLabel, gbcDescriptionText);
        mainEntryPanel.add(onMainItemButton, gbcOnMainItemButton);
        mainEntryPanel.add(onMainCategoryButton, gbcOnMainCategoryButton);


        //JPanel del registro de Items
        itemEntryPanel = new JPanel();
        itemEntryPanel.setLayout(new GridBagLayout());
        itemEntryPanel.setBackground(backgroundColor);
        itemEntryPanel.add(addItemTitleLabel, gbcAddItemTitleLabel);
        itemEntryPanel.add(addItemSubtitleLabel, gbcAddItemSubtitleLabel);
        itemEntryPanel.add(addItemProductNameTitle, gbcAddItemProductNameTitle);
        itemEntryPanel.add(addItemProductNameTextField, gbcAddItemProductNameTextField);
        itemEntryPanel.add(addItemProductBrandTitle, gbcAddItemProductBrandTitle);
        itemEntryPanel.add(addItemProductBrandTextField, gbcAddItemProductBrandTextField);
        itemEntryPanel.add(addItemProductCategoryTitle, gbcAddItemProductCategoryTitle);
        itemEntryPanel.add(addItemProductCategoryCB, gbcAddItemProductCategoryCB);
        itemEntryPanel.add(addItemProductPriceTitle, gbcAddItemProductPriceTitle);
        itemEntryPanel.add(addItemProductPriceTextField, gbcAddItemProductPriceTextField);
        itemEntryPanel.add(addItemProductQuantityTitle, gbcAddItemProductQuantityTitle);
        itemEntryPanel.add(addItemProductQuantitySP, gbcAddItemProductQuantitySP);
        itemEntryPanel.add(sendNewItemButton,gbcSendNewItemButton);
        itemEntryPanel.add(cleanFieldsButton, gbcCleanFieldsButton);
        itemEntryPanel.setVisible(false);


        //JPanel del registro de Categorías
        categoryEntryPanel = new JPanel();
        categoryEntryPanel.setLayout(new GridBagLayout());
        categoryEntryPanel.setBackground(backgroundColor);
        categoryEntryPanel.add(addCategoryTitleLabel, gbcAddCategoryTitleLabel);
        categoryEntryPanel.add(addCategoryNameTitle, gbcAddCategoryNameTitle);
        categoryEntryPanel.add(addCategoryNameTextField, gbcAddCategoryNameTextField);
        categoryEntryPanel.add(sendNewCategoryButton, gbcSendNewCategoryButton);
        categoryEntryPanel.setVisible(false);


        //JPanel Principal
        mainPanel = new JPanel();
        mainPanel.setBackground(backgroundColor);
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.add(submenuPanel, gbcSubmenu);
        mainPanel.add(itemEntryPanel, gbcEntry);
        mainPanel.add(categoryEntryPanel, gbcEntry);
        mainPanel.add(mainEntryPanel, gbcEntry);
        

        //JFrame Principal
        setSize(800,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        setTitle("Nuevo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(mainPanel);
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
    public JPanel getMainEntryPanel(){
        return mainEntryPanel;
    }
    public JPanel getItemPanel(){
        return itemEntryPanel;
    }
    public JPanel getCategoryPanel(){
        return categoryEntryPanel;
    }
    public JButton getSwitchHomeButton(){
        return switchHomeButton;
    }
    public JButton getSwitchItemButton(){
        return switchItemButton;
    }
    public JButton getSwitchCategoryButton(){
        return switchCategoryButton;
    }
    public JButton getExitButton(){
        return exitButton;
    }
    public JButton getOnMainItemButton(){
        return onMainItemButton;
    }
    public JButton getOnMainCategoryButton(){
        return onMainCategoryButton;
    }
    public JComboBox<String> getAddItemProductCategoryCB(){
        return addItemProductCategoryCB;
    }
    public JTextField getAddItemProductNameTextField(){
        return addItemProductNameTextField;
    }
    public JTextField getAddItemProductBrandTextField(){
        return addItemProductBrandTextField;
    }
    public JTextField getAddItemProductPriceTextField(){
        return addItemProductPriceTextField;
    }
    public JTextField getAddCategoryNameTextField(){
        return addCategoryNameTextField;
    }
    public JSpinner getAddItemProductQuantitySP(){
        return addItemProductQuantitySP;
    }
    public JButton getSendNewItemButton(){
        return sendNewItemButton;
    }
    public JButton getCleanFieldsButton(){
        return cleanFieldsButton;
    }
    public JButton getSendNewCategoryButton(){
        return sendNewCategoryButton;
    }
}
