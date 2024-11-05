package BackendClasses;

import FrontendClasses.MainWindow;
import java.io.FileNotFoundException;


import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lab4 {

    public static void main(String[] args) {
        MainWindow window = null;
        try {
            window = new MainWindow();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lab4.class.getName()).log(Level.SEVERE, null, ex);
        }
        window.setVisible(true);
        
    }
}
