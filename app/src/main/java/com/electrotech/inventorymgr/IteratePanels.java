package com.electrotech.inventorymgr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;


public class IteratePanels {
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel brandLabel;
    private JLabel categoryLabel;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JLabel dateLabel;
    private GridBagConstraints gbcId;
    private GridBagConstraints gbcName;
    private GridBagConstraints gbcBrand;
    private GridBagConstraints gbcCategory;
    private EditEntryMenuView editView;
    private Dialogs dialogs;
    private Model model;


    public IteratePanels(Controller controller){
        this.editView = controller.getEditView();
        this.dialogs = new Dialogs();
        this.model = new Model();
    }


    public void generateItemListPanels(int id, String name, String brand, String category, int price, int quantity, String date){


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

        String editPath = resourcesPath + "edit-file.png";
        String trashPath = resourcesPath + "recycle-bin.png";
    
        ImageIcon edit = new ImageIcon(editPath);
        Image editImageRaw = edit.getImage();
        Image editImage = editImageRaw.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon finalEditIcon = new ImageIcon(editImage);


        ImageIcon trash = new ImageIcon(trashPath);
        Image trashImageRaw = trash.getImage();
        Image trashImage = trashImageRaw.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon finalTrashIcon = new ImageIcon(trashImage);

        StringBuilder nameResult = new StringBuilder();
        StringBuilder brandResult = new StringBuilder();
        StringBuilder categoryResult = new StringBuilder();


        gbcId = new GridBagConstraints();
        gbcId.gridx = 0;
        gbcId.gridy = 0;
        gbcId.gridheight = 1;
        gbcId.gridwidth = 1;
        gbcId.weightx = 0.5;
        gbcId.weighty = 1.0;
        gbcId.insets = new Insets(0, 10, 0, 20);
        gbcId.anchor = GridBagConstraints.NORTH;

        gbcName = new GridBagConstraints();
        gbcName.gridx = 1;
        gbcName.gridy = 0;
        gbcName.gridheight = 1;
        gbcName.gridwidth = 1;
        gbcName.weightx = 0.5;
        gbcName.weighty = 1.0;
        gbcName.insets = new Insets(0, 0, 0, 20);
        gbcName.anchor = GridBagConstraints.NORTH;

        gbcBrand = new GridBagConstraints();
        gbcBrand.gridx = 2;
        gbcBrand.gridy = 0;
        gbcBrand.gridheight = 1;
        gbcBrand.gridwidth = 1;
        gbcBrand.weightx = 0.3;
        gbcBrand.weighty = 1.0;
        gbcBrand.anchor = GridBagConstraints.NORTH;

        gbcCategory = new GridBagConstraints();
        gbcCategory.gridx = 3;
        gbcCategory.gridy = 0;
        gbcCategory.gridheight = 1;
        gbcCategory.gridwidth = 1;
        gbcCategory.weightx = 0.5;
        gbcCategory.weighty = 1.0;
        gbcCategory.insets = new Insets(0, 10, 0, 25);
        gbcCategory.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcPrice = new GridBagConstraints();
        gbcPrice.gridx = 4;
        gbcPrice.gridy = 0;
        gbcPrice.gridheight = 1;
        gbcPrice.gridwidth = 1;
        gbcPrice.weightx = 0.5;
        gbcPrice.weighty = 1.0;
        gbcPrice.insets = new Insets(0, 15, 0, 20);
        gbcPrice.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcQuantity = new GridBagConstraints();
        gbcQuantity.gridx = 5;
        gbcQuantity.gridy = 0;
        gbcQuantity.gridheight = 1;
        gbcQuantity.gridwidth = 1;
        gbcQuantity.weightx = 0.5;
        gbcQuantity.weighty = 1.0;
        gbcQuantity.insets = new Insets(0, 15, 0, 35);
        gbcQuantity.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcDate = new GridBagConstraints();
        gbcDate.gridx = 6;
        gbcDate.gridy = 0;
        gbcDate.gridheight = 1;
        gbcDate.gridwidth = 1;
        gbcDate.weightx = 0.5;
        gbcDate.weighty = 1.0;
        gbcDate.insets = new Insets(0, 0, 0, 5);
        gbcDate.anchor = GridBagConstraints.NORTH;

        GridBagConstraints gbcEdit = new GridBagConstraints();
        gbcEdit.gridx = 1;
        gbcEdit.gridy = 1;
        gbcEdit.gridheight = 1;
        gbcEdit.gridwidth = 1;
        gbcEdit.weightx = 0.1;
        gbcEdit.weighty = 1.0;
        gbcEdit.anchor = GridBagConstraints.WEST;

        GridBagConstraints gbcDelete = new GridBagConstraints();
        gbcDelete.gridx = 2;
        gbcDelete.gridy = 1;
        gbcDelete.gridheight = 1;
        gbcDelete.gridwidth = 1;
        gbcDelete.weightx = 0.9;
        gbcDelete.weighty = 0.5;
        gbcDelete.anchor = GridBagConstraints.EAST;


        Color backgroundColor = Color.decode("#1c1c1c");
        Border itemSeparatorBorderRaw = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(31,31,31).brighter());
        Border emptyItemSeparatorBorder = new EmptyBorder(0, 0, 0, 0);
        Border itemSeparatorBorder = new CompoundBorder(emptyItemSeparatorBorder, itemSeparatorBorderRaw);

        
        idLabel = new JLabel(Integer.toString(id));
        idLabel.setMaximumSize(new Dimension(46, 63));
        idLabel.setMinimumSize(new Dimension(46, 63));
        idLabel.setFont(new Font("Helvetica", Font.BOLD, 9));
        idLabel.setForeground(Color.WHITE);

        nameLabel = new JLabel(name);
        nameLabel.setMaximumSize(new Dimension(81,40));
        nameLabel.setMinimumSize(new Dimension(81,40));
        nameLabel.setFont(new Font("Helvetica", Font.BOLD, 9));
        nameLabel.setForeground(Color.WHITE);

        brandLabel = new JLabel(brand);
        brandLabel.setMaximumSize(new Dimension(72, 40));
        brandLabel.setMinimumSize(new Dimension(72, 40));
        brandLabel.setFont(new Font("Helvetica", Font.BOLD, 9));
        brandLabel.setForeground(Color.WHITE);

        categoryLabel = new JLabel(category);
        categoryLabel.setMaximumSize(new Dimension(91,40));
        categoryLabel.setMinimumSize(new Dimension(91,40));
        categoryLabel.setFont(new Font("Helvetica", Font.BOLD, 9));
        categoryLabel.setForeground(Color.WHITE);

        priceLabel = new JLabel(Integer.toString(price));
        priceLabel.setMaximumSize(new Dimension(73,40));
        priceLabel.setMinimumSize(new Dimension(73,40));
        priceLabel.setFont(new Font("Helvetica", Font.BOLD, 9));
        priceLabel.setForeground(Color.WHITE);

        quantityLabel = new JLabel(Integer.toString(quantity));
        quantityLabel.setMaximumSize(new Dimension(86,40));
        quantityLabel.setMinimumSize(new Dimension(86,40));
        quantityLabel.setFont(new Font("Helvetica", Font.BOLD, 9));
        quantityLabel.setForeground(Color.WHITE);

        dateLabel = new JLabel(date);
        dateLabel.setMaximumSize(new Dimension(136,40));
        dateLabel.setMinimumSize(new Dimension(136,40));
        dateLabel.setFont(new Font("Helvetica", Font.BOLD, 9));
        dateLabel.setForeground(Color.WHITE);

        JPanel listContainer = new JPanel();
        listContainer.setLayout(new GridBagLayout());
        listContainer.setBorder(itemSeparatorBorder);
        listContainer.setBackground(backgroundColor);
        listContainer.setPreferredSize(new Dimension(585, 73));
        listContainer.setMaximumSize(new Dimension(585, 73));
        listContainer.setMinimumSize(new Dimension(585, 73));

    
        if(idLabel.getText().length() > 2){
            idLabel.setFont(new Font("Helvetica", Font.BOLD, 10-(idLabel.getText().length()-2)));
            gbcId.insets = new Insets(0, 30-idLabel.getText().length(), 0, 0);
        }
        if (nameLabel.getText().length() > 12){
            int charCounter = 0;
            char[] nameCharArray = nameLabel.getText().toCharArray();
            for (int i = 0; i<nameLabel.getText().length(); i++){
                nameResult.append(nameCharArray[i]);
                charCounter++;
                if (charCounter == 12){
                    if (nameCharArray[i+1] == ' '){
                        nameResult.append("<br>");
                    } else{
                        nameResult.append("-<br>");
                    }
                }
            }
            nameResult.insert(0,"<html>");
            nameResult.append("</html>");
    
            if (nameLabel.getText().length() > 50){
                nameLabel.setFont(new Font("Helvetica", Font.BOLD, 7));
                gbcId.insets = new Insets(0, 10, 0, 0);
            }
            nameLabel.setText(nameResult.toString());
        }
            
        if (brandLabel.getText().length() > 9){
            int charCounter = 0;
            char[] brandCharArray = brandLabel.getText().toCharArray();
            for (int i = 0; i<brandLabel.getText().length(); i++){
                brandResult.append(brandCharArray[i]);
                charCounter++;
                if (charCounter == 9){
                    if (brandCharArray[i+1] == ' '){
                        brandResult.append("<br>");
                    } else{
                        brandResult.append("-<br>");
                    }
                }
            }
            brandResult.insert(0,"<html>");
            brandResult.append("</html>");
    
            if (brandLabel.getText().length() > 40){
                brandLabel.setFont(new Font("Helvetica", Font.BOLD, 6));
                gbcBrand.insets = new Insets(0, 10, 0, 0);
            }
            brandLabel.setText(brandResult.toString());
        }
    
            if (categoryLabel.getText().length() > 9){
                int charCounter = 0;
                char[] categoryCharArray = categoryLabel.getText().toCharArray();
                for (int i = 0; i<categoryLabel.getText().length(); i++){
                    categoryResult.append(categoryCharArray[i]);
                    charCounter++;
                    if (charCounter == 9){
                        if (categoryCharArray[i+1] == ' '){
                            categoryResult.append("<br>");
                        } else{
                            categoryResult.append("-<br>");
                        }
                    }
                }
                categoryResult.insert(0,"<html>");
                categoryResult.append("</html>");
    
                if (categoryLabel.getText().length() > 40){
                    categoryLabel.setFont(new Font("Helvetica", Font.BOLD, 6));
                }
                categoryLabel.setText(categoryResult.toString());
            }

        
        JButton editButton = new JButton();
        editButton.setIcon(finalEditIcon);
        editButton.setPreferredSize(new Dimension(20,20));
        editButton.setFocusPainted(false);
        editButton.setBorderPainted(false);

        JButton deleteButton = new JButton();
        deleteButton.setIcon(finalTrashIcon);
        deleteButton.setPreferredSize(new Dimension(20,20));
        deleteButton.setFocusPainted(false);
        deleteButton.setBorderPainted(false);
        

        editButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new EditingView(id, name, brand, category, price, quantity);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(dialogs.deleteItemWarn(name)){
                    model.deleteProduct(id);
                }
            }
        });

        listContainer.add(idLabel, gbcId);        
        listContainer.add(nameLabel, gbcName);
        listContainer.add(brandLabel, gbcBrand);
        listContainer.add(categoryLabel, gbcCategory);
        listContainer.add(priceLabel, gbcPrice);
        listContainer.add(quantityLabel, gbcQuantity);
        listContainer.add(dateLabel, gbcDate);
        listContainer.add(editButton, gbcEdit);
        listContainer.add(deleteButton, gbcDelete);

        editView.getItemListPanel().add(listContainer);
        editView.revalidate();
        editView.repaint();
    }

    public JLabel getIdLabel(){
        return idLabel;
    }
    public JLabel getNameLabel(){
        return nameLabel;
    }
    public JLabel getBrandLabel(){
        return brandLabel;
    }
    public JLabel getCategoryLabel(){
        return categoryLabel;
    }
    public JLabel getPriceLabel(){
        return priceLabel;
    }
    public JLabel getQuantityLabel(){
        return quantityLabel;
    }
    public JLabel getDateLabel(){
        return dateLabel;
    }
    public GridBagConstraints getGbcId(){
        return gbcId;
    }
    public GridBagConstraints getGbcName(){
        return gbcName;
    }
    public GridBagConstraints getGbcBrand(){
        return gbcBrand;
    }
    public GridBagConstraints getGbcCategory(){
        return gbcCategory;
    }
}
