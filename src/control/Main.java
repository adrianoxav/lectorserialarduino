/*
 * This program is a free contribution for the research of the IoT, Internet of the Things
 * these files contains an application of the XBee with Java.
 * and open the template in the editor.
 */
package control;

import GUI.Ventana;
import com.rapplogic.xbee.api.XBeeException;
import data.PacketCollector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.BasicConfigurator;

/**
 * Main Class
 * @author adriano.pinargote
 */
public class Main {
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /*
        *The main contains the logger and the basic configurations
        */
        BasicConfigurator.configure();
        Logger log = Logger.getLogger("Logger de Ejemplo");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ventana().setVisible(true);
                } catch (XBeeException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}

