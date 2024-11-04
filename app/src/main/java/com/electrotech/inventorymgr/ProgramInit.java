package com.electrotech.inventorymgr;

import java.io.File;
import java.awt.*;
import javax.swing.*;

public class ProgramInit extends JFrame{
    public ProgramInit(){
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
        String iconPath = resourcesPath + "icon.png";

        ImageIcon imageIcon = new ImageIcon(iconPath);

        setUndecorated(true);
        setBackground(new Color(0,0,0,0));

        JLabel label = new JLabel(imageIcon);

        add(label);
        setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
        setIconImage(imageIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
