package com.electrotech.inventorymgr;

import java.io.File;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseListener;

public class EditEntryMenuView extends JFrame {
    private JPanel mainPanel;
    private JPanel categoryModifyPanel;
    private JPanel itemModifyPanel;
    private JPanel mainModifyPanel;
    private JPanel itemListPanel;
    private JButton switchHomeButton;
    private JButton switchItemButton;
    private JButton switchCategoryButton;
    private JButton exitButton;
    private JButton onMainItemButton;
    private JButton onMainCategoryButton;
    private JButton refreshItemsButton;
    private JButton searchItemSendButton;
    private JButton idFilter;
    private JButton nameFilter;
    private JButton brandFilter;
    private JButton categoryFilter;
    private JButton priceFilter;
    private JButton quantityFilter;
    private JButton dateFilter;
    private JTextField searchItemTextField;

    public EditEntryMenuView(){

        //Variables
        Color backgroundColor = Color.decode("#1f1f1f");

        Border buttonBorderRaw = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(33,33,33));
        Border emptyButtonBorder = new EmptyBorder(0, 0, 0, 0);
        Border buttonBorder = new CompoundBorder(emptyButtonBorder, buttonBorderRaw);

        Border sideBorderRaw = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.WHITE);
        Border sideButtonBorder = new EmptyBorder(0, 0, 0, 0);
        Border sideBorder = new CompoundBorder(sideButtonBorder, sideBorderRaw);

        Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, backgroundColor.brighter());
        Border emptyBorder = new EmptyBorder(0, 0, 0, 0);
        Border compoundBorder = new CompoundBorder(emptyBorder, border);

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

        String iconPath = resourcesPath + "edit-file.png";//Paths

        ImageIcon icon = new ImageIcon(iconPath); //Icono del JFrame secundario

        String newProductPath = resourcesPath + "new-product.png";
        String newCategoryPath = resourcesPath + "new-category.png";
        String homePath = resourcesPath + "home.png";
        String exitIconPath = resourcesPath + "exit.png";
        String refreshPath = resourcesPath + "refresh.png";
        
        ImageIcon homeIcon = new ImageIcon(homePath); //Icono de home
        Image homeImageRaw = homeIcon.getImage();
        Image homeImage = homeImageRaw.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon finalHomeIcon = new ImageIcon(homeImage);

        ImageIcon newProductIcon = new ImageIcon(newProductPath); //Icono de newproduct
        Image newProductImageRaw = newProductIcon.getImage();
        Image newProductImage = newProductImageRaw.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon finalNewProductIcon = new ImageIcon(newProductImage);

        ImageIcon newCategoryIcon = new ImageIcon(newCategoryPath); //Icono de newcategory
        Image newCategoryImageRaw = newCategoryIcon.getImage();
        Image newCategoryImage = newCategoryImageRaw.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon finalNewCategoryIcon = new ImageIcon(newCategoryImage);

        ImageIcon exitIcon = new ImageIcon(exitIconPath);
        Image exitImageRaw = exitIcon.getImage();
        Image exitImage = exitImageRaw.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon finalExitFileIcon = new ImageIcon(exitImage);

        ImageIcon refreshIcon = new ImageIcon(refreshPath); 
        Image refreshImageRaw = refreshIcon.getImage();
        Image refreshImage = refreshImageRaw.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon finalRefreshIcon = new ImageIcon(refreshImage);

        //GridBagConstraints
        GridBagConstraints gbcSubmenu = new GridBagConstraints();
        gbcSubmenu.gridx = 0;
        gbcSubmenu.gridy = 0;
        gbcSubmenu.gridheight = 2;
        gbcSubmenu.gridwidth = 1;
        gbcSubmenu.weightx = 0.0;
        gbcSubmenu.weighty = 1.0;
        gbcSubmenu.fill = GridBagConstraints.BOTH;

        GridBagConstraints gbcModify = new GridBagConstraints();
        gbcModify.gridx = 1;
        gbcModify.gridy = 0;
        gbcModify.gridheight = 2;
        gbcModify.gridwidth = GridBagConstraints.REMAINDER;
        gbcModify.weightx = 1.0;
        gbcModify.weighty = 1.0;
        gbcModify.fill = GridBagConstraints.BOTH;

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

        GridBagConstraints gbcEditItemTitleLabel = new GridBagConstraints();
        gbcEditItemTitleLabel.gridx = 0;
        gbcEditItemTitleLabel.gridy = 0;
        gbcEditItemTitleLabel.gridheight = 1;
        gbcEditItemTitleLabel.gridwidth = GridBagConstraints.REMAINDER;
        gbcEditItemTitleLabel.weightx = 0.3;
        gbcEditItemTitleLabel.weighty = 1.0;
        gbcEditItemTitleLabel.insets = new Insets(0, 30, 10, 0);
        gbcEditItemTitleLabel.anchor = GridBagConstraints.NORTHWEST;

        GridBagConstraints gbcItemToolbar = new GridBagConstraints();
        gbcItemToolbar.gridx = 0;
        gbcItemToolbar.gridy = 1;
        gbcItemToolbar.gridheight = 1;
        gbcItemToolbar.gridwidth = GridBagConstraints.REMAINDER;
        gbcItemToolbar.weightx = 0.3;
        gbcItemToolbar.weighty = 1.0;
        gbcItemToolbar.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcItemFilterBar = new GridBagConstraints();
        gbcItemFilterBar.gridx = 0;
        gbcItemFilterBar.gridy = 2;
        gbcItemFilterBar.gridheight = 1;
        gbcItemFilterBar.gridwidth = GridBagConstraints.REMAINDER;
        gbcItemFilterBar.weightx = 0.3;
        gbcItemFilterBar.weighty = 1.0;
        gbcItemFilterBar.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcFilters = new GridBagConstraints();
        gbcFilters.fill = GridBagConstraints.BOTH;
        gbcFilters.weighty = 1.5;

        GridBagConstraints gbcItemListScrollPane = new GridBagConstraints();
        gbcItemListScrollPane.gridx = 0;
        gbcItemListScrollPane.gridy = 3;
        gbcItemListScrollPane.gridheight = 1;
        gbcItemListScrollPane.gridwidth = GridBagConstraints.REMAINDER;
        gbcItemListScrollPane.weightx = 0.3;
        gbcItemListScrollPane.weighty = 1.0;
        gbcItemListScrollPane.anchor = GridBagConstraints.NORTH;

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
        MouseListener hoverRefreshItemsButton = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                refreshItemsButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                refreshItemsButton.setBackground(backgroundColor.darker());
            }
        };
        MouseListener hoverSearchItemSendButton = new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                searchItemSendButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                searchItemSendButton.setBackground(backgroundColor.darker());
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
        
        //Botones y texto del edit item
        JLabel editItemTitleLabel = new JLabel("Editar producto");
        editItemTitleLabel.setForeground(Color.WHITE);
        editItemTitleLabel.setFont(new Font("Helvetica", Font.BOLD, 30));

        ///** BARRA DE EDICION DE EDIT ITEM **///

        JLabel searchItemLabel = new JLabel("Buscar Producto");
        searchItemLabel.setForeground(Color.WHITE);
        searchItemLabel.setFont(new Font("Helvetica", Font.BOLD, 8));

        searchItemTextField = new JTextField();
        searchItemTextField.setMinimumSize(new Dimension(130, 20));
        searchItemTextField.setMaximumSize(new Dimension(130, 20));
        searchItemTextField.setPreferredSize(new Dimension(130, 20));
        searchItemTextField.setDocument(new JTextFieldLimit(250));
        searchItemTextField.setBackground(backgroundColor.brighter());
        searchItemTextField.setBorder(BorderFactory.createLineBorder(backgroundColor.brighter(), 3));
        searchItemTextField.setCaretColor(Color.WHITE.darker());
        searchItemTextField.setForeground(Color.WHITE.darker());

        searchItemSendButton = new JButton("Buscar");
        searchItemSendButton.setBorder(BorderFactory.createLineBorder(backgroundColor, 1));
        searchItemSendButton.setFocusPainted(false);
        searchItemSendButton.setBackground(backgroundColor.darker());
        searchItemSendButton.setPreferredSize(new Dimension(searchItemSendButton.getPreferredSize().width,20));
        searchItemSendButton.setFont(new Font("Helvetica", Font.BOLD, 10));
        searchItemSendButton.addMouseListener(hoverSearchItemSendButton);


        refreshItemsButton = new JButton();
        refreshItemsButton.setIcon(finalRefreshIcon);
        refreshItemsButton.setBackground(backgroundColor.darker());
        refreshItemsButton.setPreferredSize(new Dimension(13, refreshItemsButton.getPreferredSize().height));
        refreshItemsButton.addMouseListener(hoverRefreshItemsButton);
        refreshItemsButton.setBorderPainted(false);
        refreshItemsButton.setFocusPainted(false);
        refreshItemsButton.setIconTextGap(0);

        JPanel itemToolBar = new JPanel();
        itemToolBar.setVisible(true);
        itemToolBar.setBackground(backgroundColor.darker());
        itemToolBar.setPreferredSize(new Dimension(585,30));
        itemToolBar.setLayout(new BoxLayout(itemToolBar, BoxLayout.X_AXIS));
        itemToolBar.add(Box.createHorizontalGlue());
        itemToolBar.add(searchItemLabel);
        itemToolBar.add(Box.createRigidArea(new Dimension(10, 1)));
        itemToolBar.add(searchItemTextField);
        itemToolBar.add(Box.createRigidArea(new Dimension(10,1)));
        itemToolBar.add(searchItemSendButton);
        itemToolBar.add(Box.createHorizontalGlue());
        itemToolBar.add(refreshItemsButton);
        itemToolBar.add(Box.createRigidArea(new Dimension(3,1)));
    
        ///** BARRA DE FILTRADO DE EDIT ITEM **///

        idFilter = new JButton("ID");
        idFilter.setBorderPainted(false);
        idFilter.setFocusPainted(false);

        nameFilter = new JButton("Nombre");
        nameFilter.setBorderPainted(false);
        nameFilter.setFocusPainted(false);

        brandFilter = new JButton("Marca");
        brandFilter.setBorderPainted(false);
        brandFilter.setFocusPainted(false);

        categoryFilter = new JButton("Categoría");
        categoryFilter.setBorderPainted(false);
        categoryFilter.setFocusPainted(false);

        priceFilter = new JButton("Precio");
        priceFilter.setBorderPainted(false);
        priceFilter.setFocusPainted(false);

        quantityFilter = new JButton("Cantidad");
        quantityFilter.setBorderPainted(false);
        quantityFilter.setFocusPainted(false);

        dateFilter = new JButton("Fecha de registro");
        dateFilter.setBorderPainted(false);
        dateFilter.setFocusPainted(false);

        JPanel itemFilterBar = new JPanel();
        itemFilterBar.setVisible(true);
        itemFilterBar.setBackground(Color.BLACK);
        itemFilterBar.setPreferredSize(new Dimension(585,30));
        itemFilterBar.setLayout(new GridBagLayout());
        gbcFilters.weightx = 0.5;
        itemFilterBar.add(idFilter, gbcFilters);
        gbcFilters.weightx = 1.0;
        itemFilterBar.add(nameFilter, gbcFilters);
        itemFilterBar.add(brandFilter, gbcFilters);
        itemFilterBar.add(categoryFilter, gbcFilters);
        itemFilterBar.add(priceFilter, gbcFilters);
        itemFilterBar.add(quantityFilter, gbcFilters);
        gbcFilters.weightx = 1.5;
        itemFilterBar.add(dateFilter, gbcFilters);

        
        ///**PANEL DE LISTA DE ITEMS**///
        itemListPanel = new JPanel();
        itemListPanel.setBackground(backgroundColor.brighter());
        itemListPanel.setLayout(new BoxLayout(itemListPanel, BoxLayout.Y_AXIS));

        JScrollPane itemListScrollPane = new JScrollPane(itemListPanel);
        itemListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        itemListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        itemListScrollPane.setBorder(BorderFactory.createEmptyBorder());
        itemListScrollPane.setPreferredSize(new Dimension(585,220));


        //Botones y texto del inicio de edit
        JLabel descriptionLabel = new JLabel("¿Qué desea modificar?");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Helvetica", Font.BOLD, 30));

        onMainItemButton = new JButton("<html> Modificar<br>Producto</html>");
        onMainItemButton.setBackground(backgroundColor);
        onMainItemButton.setForeground(Color.WHITE);
        onMainItemButton.addMouseListener(hoverOnMenuItem);
        onMainItemButton.setBorder(sideBorder);
        onMainItemButton.setBorderPainted(true);
        onMainItemButton.setFocusPainted(false);
        onMainItemButton.setPreferredSize(new Dimension(150,60));
        onMainItemButton.setIcon(finalNewProductIcon);
        onMainItemButton.setIconTextGap(20);

        onMainCategoryButton = new JButton("<html>  Modificar<br>Categoría</html>");
        onMainCategoryButton.setBackground(backgroundColor);
        onMainCategoryButton.setForeground(Color.WHITE);
        onMainCategoryButton.addMouseListener(hoverOnMenuCategory);
        onMainCategoryButton.setBorder(sideBorder);
        onMainCategoryButton.setBorderPainted(true);
        onMainCategoryButton.setFocusPainted(false);
        onMainCategoryButton.setPreferredSize(new Dimension(150,60));
        onMainCategoryButton.setIcon(finalNewCategoryIcon);
        onMainCategoryButton.setIconTextGap(20);


        //JPanel del submenu
        JPanel submenuPanel = new JPanel();
        submenuPanel.setBorder(compoundBorder);
        submenuPanel.setOpaque(true);
        submenuPanel.setBackground(new Color(28, 28, 28));
        submenuPanel.setLayout(new BoxLayout(submenuPanel, BoxLayout.Y_AXIS));
        submenuPanel.add(switchHomeButton);
        submenuPanel.add(switchItemButton);
        submenuPanel.add(Box.createVerticalGlue());
        submenuPanel.add(exitButton);


        //JPanel del inicio del edit
        mainModifyPanel = new JPanel();
        mainModifyPanel.setVisible(false);
        mainModifyPanel.setBackground(backgroundColor);
        mainModifyPanel.setLayout(new GridBagLayout());
        mainModifyPanel.add(descriptionLabel, gbcDescriptionText);
        mainModifyPanel.add(onMainItemButton, gbcOnMainItemButton);

        //JPanel del editar Producto
        itemModifyPanel = new JPanel();
        itemModifyPanel.setVisible(false);
        itemModifyPanel.setLayout(new GridBagLayout());
        itemModifyPanel.setBackground(backgroundColor);
        itemModifyPanel.add(editItemTitleLabel, gbcEditItemTitleLabel);
        itemModifyPanel.add(itemToolBar, gbcItemToolbar);
        itemModifyPanel.add(itemFilterBar, gbcItemFilterBar);
        itemModifyPanel.add(itemListScrollPane, gbcItemListScrollPane);

        //JPanel del registro de Categorías
        categoryModifyPanel = new JPanel();
        categoryModifyPanel.setVisible(false);
        categoryModifyPanel.setLayout(new GridBagLayout());
        categoryModifyPanel.setBackground(Color.BLUE);


        //JPanel principal
        mainPanel = new JPanel();
        mainPanel.setBackground(backgroundColor);
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.add(submenuPanel, gbcSubmenu);
        mainPanel.add(itemModifyPanel, gbcModify);
        mainPanel.add(categoryModifyPanel, gbcModify);
        mainPanel.add(mainModifyPanel, gbcModify);


        //JFrame Principal
        setSize(800,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        setTitle("Editar");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(mainPanel);
    }
    public JPanel getCategoryModifyPanel(){
        return categoryModifyPanel;
    }
    public JPanel getItemModifyPanel(){
        return itemModifyPanel;
    }
    public JPanel getMainModifyPanel(){
        return mainModifyPanel;
    }
    public JPanel getItemListPanel(){
        return itemListPanel;
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
    public JButton getRefreshButton(){
        return refreshItemsButton;
    }
    public JButton getSearchItemSendButton(){
        return searchItemSendButton;
    }
    public JTextField getSearchItemTextField(){
        return searchItemTextField;
    }
    public JButton getIdFilter(){
        return idFilter;
    }
    public JButton getNameFilter(){
        return nameFilter;
    }
    public JButton getCategoryFilter(){
        return categoryFilter;
    }
    public JButton getBrandFilter(){
        return brandFilter;
    }
    public JButton getPriceFilter(){
        return priceFilter;
    }
    public JButton getQuantityFilter(){
        return quantityFilter;
    }
    public JButton getDateFilter(){
        return dateFilter;
    }
}
