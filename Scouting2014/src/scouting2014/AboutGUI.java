package scouting2014;

import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;

public class AboutGUI extends JFrame{
    
    JPanel panel;
    JTextPane info;

    public AboutGUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException{
        setTitle("About Scouter 2014");
        setVisible(false);
        setResizable(false);
        setPreferredSize(new Dimension(430,430));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        panel = new JPanel(new MigLayout("fill"));
        info = new JTextPane();
        info.setEditable(false);
        info.setFont(new Font(Font.SERIF, Font.PLAIN, 17));
        info.setText("Scouter 2014 was created by the IMSA Titans. \n \n"
                + "Author: Emma Sloan \n Some code taken from IMSA Titans 2013 \n \n"
                + "For autonomous, only say that it moved if it got the points for moving into its zone. "
                + "Mark that it recieved the ball if it sucessfully took the ball from either another robot or human player. "
                + "Catches are only after a truss shot and count in both the recieved and catch categories. "
                + "Attempted shots are all shots fired, whether in the low or high goal and whether it got in or not. "
                + "To save a file, hit the save button and type in a file name. (Don't worry about extension: it does that for you.)"
                + " It adds to (rather than overwriting) preexisting CSV "
                + "files, so you can save a whole day's scouting in one file.");
        
        panel.add(info, "wrap");
        
        this.add(info);
        this.pack();
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
    }

    
}
