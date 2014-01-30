
package scouting2014;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emma
 */
public class ZonesGUI extends JFrame implements ActionListener{
    
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
    }
    
    final JFileChooser fc = new JFileChooser();
    JButton save = new JButton("Save Results");
    
    JTextField matchNumber = new JTextField(2);
    JLabel matchInfo = new JLabel("Match Number:");
    
    JLabel zone1 = new JLabel("Near (defensive) team: ");
    JTextField team1 = new JTextField(4);
    JLabel zone2 = new JLabel("Middle team: ");
    JTextField team2 = new JTextField(4);
    JLabel zone3 = new JLabel("Far (offensive) team: ");
    JTextField team3 = new JTextField(4);
    
    JLabel teamLabel1 = new JLabel("Team");
    JLabel notesLabel1 = new JLabel("notes:");
    JTextField teamField1 = new JTextField(4);
    JTextField notes1 = new JTextField(10);
    JLabel teamLabel2 = new JLabel("Team");
    JLabel notesLabel2 = new JLabel("notes:");
    JTextField teamField2 = new JTextField(4);
    JTextField notes2 = new JTextField(10);
    JLabel teamLabel3 = new JLabel("Team");
    JLabel notesLabel3 = new JLabel("notes:");
    JTextField teamField3 = new JTextField(4);
    JTextField notes3 = new JTextField(10);
    
    JPanel jp = new JPanel(new MigLayout());

    public ZonesGUI() throws ClassNotFoundException, InstantiationException, 
            IllegalAccessException{
                //Create the window
        setTitle("Zones (subjective) app 2014");
        setVisible(true);
        setSize(300, 400);
        setResizable(true);
        
        this.jp.add(matchInfo,"split 2");
        this.jp.add(matchNumber, "wrap");
        this.jp.add(zone1,"split 2");
        this.jp.add(team1,"wrap");
        this.jp.add(zone2,"split 2");
        this.jp.add(team2,"wrap");
        this.jp.add(zone3,"split 2");
        this.jp.add(team3,"wrap");
        this.jp.add(teamLabel1,"split 4");
        this.jp.add(teamField1);
        this.jp.add(notesLabel1);
        this.jp.add(notes1, "wrap");
        this.jp.add(teamLabel2,"split 4");
        this.jp.add(teamField2);
        this.jp.add(notesLabel2);
        this.jp.add(notes2, "wrap");
        this.jp.add(teamLabel3,"split 4");
        this.jp.add(teamField3);
        this.jp.add(notesLabel3);
        this.jp.add(notes3, "wrap");
        this.jp.add(save);
        
        this.save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int returnVal = fc.showSaveDialog(jp);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    String path = file.getAbsolutePath();
                    try {
                        Scouter.saveZones(path,matchNumber.getText(),
                                team1.getText(), team2.getText(),team3.getText(),
                                teamField1.getText(),notes1.getText(), 
                                teamField2.getText(),notes2.getText(),
                                teamField3.getText(),notes3.getText()); 
                    } catch (IOException ex) {
                        Logger.getLogger(ZonesGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        add(this.jp);
        jp.updateUI();
    }
}
