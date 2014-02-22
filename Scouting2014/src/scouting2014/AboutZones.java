
package scouting2014;

import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Emma
 */
public class AboutZones extends JFrame{
    
    JPanel panel;
    JTextPane info;

    public AboutZones() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException{
        setTitle("About Scouter 2014");
        setVisible(false);
        setResizable(false);
        setPreferredSize(new Dimension(430,430));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        panel = new JPanel(new MigLayout("fill"));
        info = new JTextPane();
        info.setEditable(false);
        info.setFont(new Font(Font.SERIF, 0, 17));
        info.setText("Scouter 2014 was created by the IMSA Titans. \n \n"
                + "Author: Emma Sloan \n Some code taken from IMSA Titans 2013 \n \n"
                + "Note through the dropdown menu which zone/role each team primarily occupies.\n"
                + "The defensive team is the team near the drivers' station that receives the ball "
                + "from a human player and passes it off another robot. "
                + "This team does not necessarily play defense.\n"
                + "The middle team primarily stays in the middle zone. It takes the ball from one robot and passes it to another. "
                + "It may be involved in truss shots and/or catches.\n"
                + "The offensive team shoots into the high or low goal to score the ball.\n\n"
                + "The notes section can store more text than it looks like. Please note the bots' defensive capabilities (if any), "
                + "if it fills several zones, or if it has something especially good or bad about it, "
                + "such as shooting twice in autonomous or (on the bad side) being unable to move.");
        
        panel.add(info, "wrap");
        
        this.add(info);
        this.pack();
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
    }
    
}
