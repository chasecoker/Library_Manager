package library_management_system;

import jframe.LoginMenu;

public class Library_Management_System {

    public static void main(String[] args) {
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {


               if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
               }
            }
        } catch (Exception ex) {
               ex.printStackTrace();
        }

        new LoginMenu().setVisible(true); 

    }
    
}
