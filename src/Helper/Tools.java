/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author afshin
 */
public class Tools {

    public static void SetCenterLocation(JFrame jf) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //jf.setLocation((d.width - jf.getWidth()) / 2, (d.height - jf.getHeight()) / 2);
        jf.setLocationRelativeTo(jf);
    }

    public static void SetCenterLocation(JDialog jf) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        //jf.setLocation((d.width - jf.getWidth()) / 2, (d.height - jf.getHeight()) / 2);
        jf.setLocationRelativeTo(jf);
    }

    public static void SetTheme(JFrame jf) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(jf);
        } catch (Exception exception) {
        }
    }

    public static void SetTheme(JDialog jf) {
        //com.sun.java.swing.plaf.windows.WindowsLookAndFeel
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(jf);
        } catch (Exception exception) {
        }
    }

    public static String currentTime() {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        return currentTime;
    }

    public static void SetIcon(JFrame jf) {
        //System.getProperty("file.separator")
        ImageIcon img = new ImageIcon(System.getProperty("file.separator") + "images" + System.getProperty("file.separator") + "home.png");
        jf.setIconImage(img.getImage());
    }

    public void setIcon(JFrame jf) {

       jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/home.png"))); 
    }
    
    public static void right_to_left(JFrame jf) {
      jf.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      jf.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }


}
