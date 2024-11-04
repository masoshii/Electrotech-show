package com.electrotech.inventorymgr;

public class Main {
    public static void main(String[] args) {
        try{
            ProgramInit programInit = new ProgramInit();
            Controller controller = new Controller();
            IteratePanels iteratePanels = new IteratePanels(controller);
            Model model = new Model();
            controller.setModel(model);
            model.setIteratePanels(iteratePanels);
            programInit.dispose();
            controller.showMainMenu();
        } catch (Exception e){
            Dialogs.UnknownError();
        }
    }
}
