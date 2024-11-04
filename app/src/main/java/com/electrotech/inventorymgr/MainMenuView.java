package com.electrotech.inventorymgr;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MainMenuView extends JFrame {
    private Dialogs exitDialog;
    private JButton newButton;
    private JButton editButton;
    private JButton listButton;
    private JMenuItem newProduct;
    private JMenuItem newCategory;
    private JMenuItem modifyProduct;
    private JMenuItem exitItem;

    public MainMenuView(){
        //Implementaciones
        exitDialog = new Dialogs();

        //Variables generales
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
        
        String iconPath = resourcesPath + "icon.png";//Paths
        String newfileIconPath = resourcesPath + "new-file.png";
        String editfileIconPath = resourcesPath + "edit-file.png";
        String listfileIconPath = resourcesPath + "list-file.png";

        ImageIcon icon = new ImageIcon(iconPath); //Icono del programa

        ImageIcon newfileIcon = new ImageIcon(newfileIconPath); //Icono de newfile
        Image newfileImageRaw = newfileIcon.getImage();
        Image newfileImage = newfileImageRaw.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon finalNewFileIcon = new ImageIcon(newfileImage);

        ImageIcon editfileIcon = new ImageIcon(editfileIconPath);
        Image editfileImageRaw = editfileIcon.getImage();
        Image editfileImage = editfileImageRaw.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon finalEditFileIcon = new ImageIcon(editfileImage);

        ImageIcon listfileIcon = new ImageIcon(listfileIconPath);
        Image listfileImageRaw = listfileIcon.getImage();
        Image listfileImage = listfileImageRaw.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon finalListFileIcon = new ImageIcon(listfileImage);

        Color backgroundColor = Color.decode("#1f1f1f");
        Color menubarColor = Color.decode("#323232");

        //GridBagConstraints
        GridBagConstraints gbcIcon = new GridBagConstraints();
        gbcIcon.gridx = 0;
        gbcIcon.gridy = 0;
        gbcIcon.gridheight = 1;
        gbcIcon.gridwidth = 1;
        gbcIcon.weightx = 0.3;
        gbcIcon.weighty = 1.0;
        gbcIcon.fill = GridBagConstraints.BOTH;

        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.gridx = 1;
        gbcButtons.gridy = 0;
        gbcButtons.gridheight = 1;
        gbcButtons.gridwidth = 3;
        gbcButtons.weightx = 1.0;
        gbcButtons.weighty = 1.0;
        gbcButtons.fill = GridBagConstraints.BOTH;

        GridBagConstraints gbcUppertext = new GridBagConstraints();
        gbcUppertext.gridx = 0;
        gbcUppertext.gridy = 0;
        gbcUppertext.gridheight = 1;
        gbcUppertext.gridwidth = GridBagConstraints.REMAINDER;
        gbcUppertext.weightx = 0.7;
        gbcUppertext.weighty = 1.0;
        gbcUppertext.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcNewButton = new GridBagConstraints();
        gbcNewButton.gridx = 1;
        gbcNewButton.gridy = 1;
        gbcNewButton.gridheight = 1;
        gbcNewButton.gridwidth = 1;
        gbcNewButton.weightx = 0.3;
        gbcNewButton.weighty = 1.0;
        gbcNewButton.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcEditButton = new GridBagConstraints();
        gbcEditButton.gridx = 2;
        gbcEditButton.gridy = 1;
        gbcEditButton.gridheight = 1;
        gbcEditButton.gridwidth = 1;
        gbcEditButton.weightx = 0.3;
        gbcEditButton.weighty = 1.0;
        gbcEditButton.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcListButton = new GridBagConstraints();
        gbcListButton.gridx = 3;
        gbcListButton.gridy = 1;
        gbcListButton.gridheight = 1;
        gbcListButton.gridwidth = 1;
        gbcListButton.weightx = 0.3;
        gbcListButton.weighty = 1.0;
        gbcListButton.anchor = GridBagConstraints.NORTH;

        //Elementos Principales
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(icon);

        //Panel del Icono
        JPanel iconPanel = new JPanel();
        iconPanel.setOpaque(false);
        iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.X_AXIS));
        iconPanel.add(Box.createHorizontalGlue());
        iconPanel.add(iconLabel);
        iconPanel.add(Box.createHorizontalGlue());

        //Botones y textos
        JLabel uppertextLabel = new JLabel();
        uppertextLabel.setText("Gestión de Inventario de Sakurastop");
        uppertextLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        uppertextLabel.setForeground(Color.WHITE);

        newButton = new JButton();
        newButton.setIcon(finalNewFileIcon);
        newButton.setText("<html><h2>Añadir<br>Nuevo...</h2></html>");
        newButton.setFont(new Font("Helvetica", Font.PLAIN, 19));
        newButton.setBackground(backgroundColor);
        newButton.setForeground(Color.WHITE);
        newButton.setFocusPainted(false);
        newButton.setBorder(null);
        newButton.setBorderPainted(false);
        newButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        newButton.setHorizontalTextPosition(SwingConstants.CENTER);
        newButton.setIconTextGap(10);
        newButton.setPreferredSize(new Dimension(150, 190));

        editButton = new JButton();
        editButton.setIcon(finalEditFileIcon);
        editButton.setText("<html><h2>Editar <br> Producto</h2></html>");
        editButton.setFont(new Font("Helvetica", Font.PLAIN, 19));
        editButton.setBackground(backgroundColor);
        editButton.setForeground(Color.WHITE);
        editButton.setFocusPainted(false);
        editButton.setBorder(null);
        editButton.setBorderPainted(false);
        editButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        editButton.setHorizontalTextPosition(SwingConstants.CENTER);
        editButton.setIconTextGap(10);
        editButton.setPreferredSize(new Dimension(150, 190));

        listButton = new JButton();
        listButton.setIcon(finalListFileIcon);
        listButton.setText("<html><h2>Lista de <br> Productos</h2></html>");
        listButton.setFont(new Font("Helvetica", Font.PLAIN, 19));
        listButton.setBackground(backgroundColor);
        listButton.setForeground(Color.WHITE);
        listButton.setFocusPainted(false);
        listButton.setBorder(null);
        listButton.setBorderPainted(false);
        listButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        listButton.setHorizontalTextPosition(SwingConstants.CENTER);
        listButton.setIconTextGap(20);
        listButton.setPreferredSize(new Dimension(150, 190));

        //MouseListeners de la view
        newButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                newButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                newButton.setBackground(backgroundColor);
            }
        });
        editButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                editButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                editButton.setBackground(backgroundColor);
            }
        });
        listButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                listButton.setBackground(backgroundColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                listButton.setBackground(backgroundColor);
            }
        });

        //JPanel de los Botones y Otros Elementos
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.RED);
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new GridBagLayout());
        buttonsPanel.add(uppertextLabel, gbcUppertext);
        buttonsPanel.add(newButton, gbcNewButton);
        buttonsPanel.add(editButton, gbcEditButton);

        //JPanel Principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);
        mainPanel.add(iconPanel, gbcIcon);
        mainPanel.add(buttonsPanel, gbcButtons);

        //UIManager (Es para definir defaults)
        UIManager.put("Button.select", menubarColor.darker());

        UIManager.put("Menu.opaque", true);
        UIManager.put("Menu.background", menubarColor);
        UIManager.put("Menu.foreground", Color.WHITE);
        UIManager.put("Menu.border", null);
        UIManager.put("Menu.borderPainted", false);
        UIManager.put("MenuItem.background", menubarColor);
        UIManager.put("MenuItem.foreground", Color.WHITE);
        UIManager.put("MenuItem.border", null);
        UIManager.put("MenuItem.borderPainted", false);
        
        UIManager.put("MenuItem.selectionBackground", menubarColor.brighter());
        UIManager.put("MenuItem.selectionForeground", Color.WHITE);
        UIManager.put("Menu.selectionBackground", menubarColor.brighter());
        UIManager.put("Menu.selectionForeground", Color.WHITE);

        ///////////////////////////////// BARRA DEL MENU//////////////////////////////////
        //Barra del Menú//
        JMenuBar menuBar = new JMenuBar();

        /////MENUS PRINCIPALES DE LA BARRA/////

        ////ARCHIVO////
        JMenu fileMenu = new JMenu("Archivo");
        ////-----NUEVO-----
        JMenu newMenu = new JMenu("Nuevo");
        newProduct = new JMenuItem("Producto");
        newCategory = new JMenuItem("Categoría");
        ////-----MODIFICAR-----
        JMenu modifyMenu = new JMenu("Modificar");
        modifyProduct = new JMenuItem("Producto");
        fileMenu.add(new JSeparator());
        ////-----SALIR-----
        exitItem = new JMenuItem("Salir");


        ////Personalización
        menuBar.setBackground(menubarColor);
        menuBar.setBorderPainted(false);
        menuBar.setBorder(null);
        
        fileMenu.setFont(new Font("Helvetica", Font.BOLD, 12));

        newMenu.setFont(new Font("Helvetica", Font.PLAIN, 12));
        newMenu.setPreferredSize(new Dimension(200, newMenu.getPreferredSize().height));

        newProduct.setPreferredSize(new Dimension(200, newProduct.getPreferredSize().height));
        newProduct.setFont(new Font("Helvetica", Font.PLAIN, 12));

        newCategory.setFont(new Font("Helvetica", Font.PLAIN, 12));

        modifyMenu.setFont(new Font("Helvetica", Font.PLAIN, 12));

        modifyProduct.setPreferredSize(new Dimension(200, newProduct.getPreferredSize().height));
        modifyProduct.setFont(new Font("Helvetica", Font.PLAIN, 12));
        
        modifyProduct.setPreferredSize(new Dimension(200, modifyProduct.getPreferredSize().height));

        exitItem.setFont(new Font("Helvetica", Font.PLAIN, 12));

        ////Adición
        newMenu.add(newProduct);
        newMenu.add(newCategory);

        modifyMenu.add(modifyProduct);

        fileMenu.add(newMenu);
        fileMenu.add(modifyMenu);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        /////////////////////////////////////////////////////////////////////////////////
        

        //JFrame Principal
        setIconImage(icon.getImage());
        setSize(1200,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Inicio");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setJMenuBar(menuBar);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we)
            { 
                if(exitDialog.exitConfirmation()){
                    System.out.println("** Programa terminado por el cliente.");
                    System.exit(0);
                }
            }
        });
        
        //Adición de elementos al JFrame
        add(mainPanel);
    }
    
    public JButton getNewButton(){
        return newButton;
    }

    public JButton getEditButton(){
        return editButton;
    }

    public JButton getListButton(){
        return listButton;
    }

    public JMenuItem getNewProduct(){
        return newProduct;
    }

    public JMenuItem getNewCategory(){
        return newCategory;
    }

    public JMenuItem getModifyProduct(){
        return modifyProduct;
    }

    public JMenuItem getExitItem(){
        return exitItem;
    }
}